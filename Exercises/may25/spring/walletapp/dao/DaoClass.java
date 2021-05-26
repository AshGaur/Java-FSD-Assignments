package may25.spring.walletapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Getter;
import may25.spring.walletapp.bean.Customer;
import may25.spring.walletapp.service.InvalidInputException;

@Getter
@Component("dao")
@PropertySource("classpath:dbDetails.properties")
public class DaoClass {
	Connection con;
	PreparedStatement pstmt;
	String query;
	
	@Resource
	Customer customer;
	
	@Resource(name="otherBean")
	Customer customerSecond;
	
	@Autowired
	TransactionTracker tracker;
	
	@Value("${dbUser}")
	String dbUser;
	
	@Value("${dbPassword}")
	String dbPassword;
	
	@Value("${dbName}")
	String dbName;
	
	@Value("${tableName}")
	String tableName;
	
	@PostConstruct
	public void makeConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+this.dbName, this.dbUser, this.dbPassword);
		} catch (ClassNotFoundException e) {
			System.out.println("Issues loading Driver:"+e.getMessage());
		} catch(SQLException e) {
			System.out.println("SQL Error:"+e.getMessage());
		}
	}

	public boolean addCustomer() throws SQLException {
		this.query = String.format("insert into %s(customerName,walletBalance) values(?,?)",this.tableName);
		this.pstmt = con.prepareStatement(this.query);
		this.pstmt.setString(1, this.getCustomer().getCustomerName());
		this.pstmt.setDouble(2, this.getCustomer().getWalletBalance());
		if(this.pstmt.executeUpdate()>0) {
			return true;
		}
		return false;
	}
	
	public Double accountExists() throws SQLException{
		this.query = String.format("select * from %s where accountNumber=?", this.getTableName());
		this.pstmt = this.con.prepareStatement(this.query);
		this.pstmt.setInt(1, this.getCustomer().getAccountNumber());
		ResultSet result = this.pstmt.executeQuery();
		if(result.next()) {
			return result.getDouble("walletBalance");
		}
		return null;
	}
	
	@PreDestroy
	public void closeConnection() throws SQLException {
		this.con.close();
	}

	public boolean makeTransaction(Double amount, boolean isWithdrawal) throws SQLException, InvalidInputException {
		this.query = String.format("select * from %s where accountNumber=?", this.getTableName());
		this.pstmt = this.con.prepareStatement(this.query,ResultSet.TYPE_SCROLL_SENSITIVE ,ResultSet.CONCUR_UPDATABLE );
		this.pstmt.setInt(1, this.getCustomer().getAccountNumber());
		ResultSet result = this.pstmt.executeQuery();
		if(result.next()) {
			Double wallet = result.getDouble("walletBalance");
			wallet = isWithdrawal?wallet-amount:wallet+amount;
			if(wallet<0) {
				throw new InvalidInputException("Insufficient Funds !");
			}
			this.writeTransaction(isWithdrawal?0-amount:amount);
//			tracker.writeTransaction(wallet, amount, isWithdrawal);
			result.updateDouble("walletBalance", wallet);
			result.updateRow();
			return true;
		}
		throw new InvalidInputException("accountNumber not found in Database !");
	}
	
	public boolean fundsTransfer(Double amount) throws SQLException {
		Statement stmt = this.con.createStatement();
		stmt.addBatch(String.format("UPDATE %s set walletBalance=walletBalance-%.2f where accountNumber=%d",
				this.getTableName(),amount,this.customer.getAccountNumber()));
		stmt.addBatch(String.format("UPDATE %s set walletBalance=walletBalance+%.2f where accountNumber=%d",
				this.getTableName(),amount,this.customerSecond.getAccountNumber()));
		int[] changes = stmt.executeBatch(); 
		boolean isSuccessful = true;
		for(int t:changes) {
			if(t==0) {
				isSuccessful = false;
			}
		}
		if(isSuccessful) {
			this.writeFundsTransfer(amount);
		}
		return isSuccessful;
	}
	
	public String readTransactionHistory(String orderBy,String order) throws SQLException, InvalidInputException {
		order = order.length()>0?order:"ASC";
		if(! (order.toLowerCase().equals("asc") || order.toLowerCase().equals("desc"))) {
			throw new InvalidInputException("Order unknown !");
		}
		orderBy = orderBy.length()>0?orderBy:"accountNumber";
		this.query = "select * from transactions order by "+orderBy+" "+order;
		this.pstmt = this.con.prepareStatement(this.query);
		StringBuffer buffer = new StringBuffer("");
		ResultSet result = this.pstmt.executeQuery();
		ResultSetMetaData rsmd = this.pstmt.getMetaData();
		int noOfColumns = rsmd.getColumnCount();
		while(result.next()) {
			for(int i=1;i<=noOfColumns;i++) {
				buffer.append(String.format("%s :%-10s ", rsmd.getColumnName(i),result.getString(i)));
			}
			buffer.append("\n");
		}
		return new String(buffer);
	}
	
	void writeTransaction(Double amount) throws SQLException{
		this.query = "insert into transactions(accountNumber,amount) values(?,?)";
		this.pstmt = this.con.prepareStatement(this.query);
		this.pstmt.setInt(1, this.getCustomer().getAccountNumber());
		this.pstmt.setDouble(2, amount);
		this.pstmt.executeUpdate();
	}
	
	void writeFundsTransfer(Double amount) throws SQLException{
		this.query = "insert into transactions(accountNumber,amount,source) values(?,?,?)";
		this.pstmt = this.con.prepareStatement(this.query);
		this.pstmt.setInt(1, this.getCustomerSecond().getAccountNumber());
		this.pstmt.setDouble(2, amount);
		this.pstmt.setInt(3, this.getCustomer().getAccountNumber());
		this.pstmt.executeUpdate();
	}
}
