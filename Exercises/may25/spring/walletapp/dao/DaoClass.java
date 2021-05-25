package may25.spring.walletapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
			tracker.writeFile(wallet, amount, isWithdrawal);
			result.updateDouble("walletBalance", wallet);
			result.updateRow();
			return true;
		}
		throw new InvalidInputException("accountNumber not found in Database !");
	}
}
