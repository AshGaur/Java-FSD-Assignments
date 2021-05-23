package may21.layeredarchitecture.dao;

import java.sql.SQLException;
import java.util.List;

import may21.layeredarchitecture.bean.Employee;

public interface DaoInterface {

	boolean insertEmployee(Employee emp) throws SQLException;

	List<Employee> getEmployees() throws SQLException;

	boolean updateData(int empID, String what) throws SQLException;

	Employee getEmployeeByID(int empID) throws SQLException;

	boolean deleteEmployee(int empID) throws SQLException;
}
