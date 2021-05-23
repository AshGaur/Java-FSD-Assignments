package may21.layeredarchitecture.service;

import java.sql.SQLException;
import java.util.List;

import may21.layeredarchitecture.bean.Employee;

public interface EmployeeService {
	String NAMEPATTERN = "[A-Z][a-z]{2,14}(\\W[A-Z][a-z]{0,14})?";
	String INTPATTERN = "[1-9][0-9]{0,5}";
	String DOUBLEPATTERN = "[0-9]{1,10}(\\.[0-9]{1,3})?";
	String getScheme(Employee emp);
	String addEmployee(String empName, double empSalary, String designation) throws SQLException;
	List<Employee> getEmployees() throws SQLException;
	String deleteEmployee(int empID) throws SQLException;
	String updateEmployee(int empID, String empName, String empSalary, String empDesignation)
			throws SQLException, InvalidInputException;
	String getScheme(int empID) throws SQLException;
	String validateName(String empName) throws InvalidInputException;
	int validateID(String empID) throws InvalidInputException;
	double validateSalary(String empSalary) throws InvalidInputException;
}
