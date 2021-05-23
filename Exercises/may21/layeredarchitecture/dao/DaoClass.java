package may21.layeredarchitecture.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import may21.layeredarchitecture.bean.Employee;

public class DaoClass implements DaoInterface{
	Connection con;
	PreparedStatement pstmt;
	String query;
	String tableName;
	
	public DaoClass(String dbName,String tableName){
		this.tableName = tableName;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName, "ashutosh", "ashutosh");
		} catch (ClassNotFoundException e) {
			System.out.println("Issues loading Driver:"+e.getMessage());
		} catch(SQLException e) {
			System.out.println("SQL Error:"+e.getMessage());
		}
	}
	
	@Override
	public boolean insertEmployee(Employee emp) throws SQLException {
		this.query = String.format("insert into %s(empName,empSalary,empDesignation) values(?,?,?)",this.tableName);
		this.pstmt = con.prepareStatement(this.query);
		this.pstmt.setString(1, emp.getName());
		this.pstmt.setDouble(2, emp.getSalary());
		this.pstmt.setString(3, emp.getDesignation());
		if(this.pstmt.executeUpdate()>0) {
			return true;
		}
		return false;
	}
	
	@Override
	public List<Employee> getEmployees() throws SQLException{
		List<Employee> list = new ArrayList<>();
		this.query = String.format("select * from %s",this.tableName);
		this.pstmt = con.prepareStatement(this.query);
		ResultSet result = this.pstmt.executeQuery();
		while(result.next()) {
			list.add(new Employee(result.getInt("empID"),result.getString("empName"),result.getDouble("empSalary"),result.getString("empDesignation")));
		}
		return list;
	}

	@Override
	public boolean updateData(int empID,String what) throws SQLException {
		this.query = String.format("update %s set %s where empID=?",this.tableName,what);
		this.pstmt = con.prepareStatement(this.query);
		this.pstmt.setInt(1, empID);
		if(this.pstmt.executeUpdate()>0) {
			return true;
		}
		return false;
	}
	
	@Override
	public Employee getEmployeeByID(int empID) throws SQLException {
		this.query = String.format("select * from %s where empID=?", this.tableName);
		this.pstmt = con.prepareStatement(this.query);
		this.pstmt.setInt(1, empID);
		ResultSet result = this.pstmt.executeQuery();
		if(result.next()) {
			return new Employee(result.getInt("empID"),result.getString("empName"),result.getDouble("empSalary"),result.getString("empDesignation"));
		}
		return null;
	}
	
	@Override
	public boolean deleteEmployee(int empID) throws SQLException {
		this.query = String.format("delete from %s where empID=?",this.tableName);
		this.pstmt = con.prepareStatement(this.query);
		this.pstmt.setInt(1, empID);
		if(this.pstmt.executeUpdate()>0) {
			return true;
		}
		return false;
	}
}