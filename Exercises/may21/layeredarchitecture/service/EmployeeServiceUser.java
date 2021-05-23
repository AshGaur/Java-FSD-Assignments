package may21.layeredarchitecture.service;

import java.sql.SQLException;
import java.util.List;

import may21.layeredarchitecture.bean.Employee;
import may21.layeredarchitecture.dao.DaoClass;

public class EmployeeServiceUser implements EmployeeService{
	DaoClass dao = new DaoClass("emp_db","emp_table");
	
	@Override
	public String getScheme(Employee emp) {
		double salary = emp.getSalary();
		String designation = emp.getDesignation().toLowerCase();
		if(salary<5000 && designation.equals("clerk")) {
			return "No Scheme Available";
		}else if((salary>5000 && salary<20000) && (designation.equals("system associate"))){
			return "Scheme C";
		}else if((salary>20000 && salary<40000) && (designation.equals("programmer"))) {
			return "Scheme B";
		}else if(salary>=40000 && designation.equals("manager")){
			return "Scheme A";
		}else {
			return "Not eligible for any available schemes !";
		}
	}

	@Override
	public String addEmployee(String empName,double empSalary,String designation) throws SQLException{
		return dao.insertEmployee(new Employee(empName,empSalary,designation))?"Employee Added !":"Unable to add employee !";
	}
	
	@Override
	public List<Employee> getEmployees() throws SQLException{
		return dao.getEmployees();
	}
	
	@Override
	public String updateEmployee(int empID,String empName,String empSalary,String empDesignation) throws SQLException,InvalidInputException{
		StringBuilder what = new StringBuilder("");
		int count = 0;
		String errorMessage = "Employee ID not found !";

		//No values entered by user
		if(empName.length()==0 && empSalary.length()==0 && empDesignation.length()==0) {
			throw new InvalidInputException("No update made !");
		}
		//Name to be updated
		if(empName.length()>0) {
			what.append(String.format("empName='%s'", empName));
			count++;
		}
		//Salary to be updated
		if(empSalary.length()>0) {
			String query = String.format("empSalary=%s", empSalary);
			what.append(count==0?query:","+query);
			count++;
		}
		//Designation to be updated
		if(empDesignation.length()>0) {
			String query = String.format("empDesignation='%s'",empDesignation);
			what.append(count==0?query:","+query);
			count++;
		}
		return dao.updateData(empID,new String(what))?"Employee Updated Successfully !":errorMessage;
	}
	
	@Override
	public String getScheme(int empID) throws SQLException{
		Employee emp = dao.getEmployeeByID(empID);
		if(emp == null) {
			return "Employee ID not found";
		}
		return this.getScheme(emp);
	}
	
	@Override
	public String deleteEmployee(int empID) throws SQLException{
		return dao.deleteEmployee(empID)?"Employee Deleted !":"Employee ID not found !";
	}
	
	//-------------------------- Validators -------------------------------
	@Override
	public String validateName(String empName) throws InvalidInputException {
		if(!empName.matches(NAMEPATTERN)) {
			throw new InvalidInputException("Please enter name in format matching case: Firstname<space>Lastname !");
		}
		return empName;
	}
	
	@Override
	public int validateID(String empID) throws InvalidInputException{
		if(!empID.matches(INTPATTERN)) {
			throw new InvalidInputException("Invalid Number Entered !");
		}
		return Integer.parseInt(empID);
	}
	
	@Override
	public double validateSalary(String empSalary) throws InvalidInputException{
		if(!empSalary.matches(DOUBLEPATTERN)) {
			throw new InvalidInputException("Invalid Salary !");
		}
		return Double.parseDouble(empSalary);
	}
}
