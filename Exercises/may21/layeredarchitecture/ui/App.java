package may21.layeredarchitecture.ui;

import java.sql.SQLException;
import java.util.Scanner;
import may21.layeredarchitecture.service.EmployeeService;
import may21.layeredarchitecture.service.EmployeeServiceUser;
import may21.layeredarchitecture.service.InvalidInputException;

public class App
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        EmployeeService empService = new EmployeeServiceUser();
        int input = -1;
		do {
			try {
				System.out.println("--------------------------------");
	        	System.out.println("1 -> Add a new Employee");
	        	System.out.println("2 -> Get Existing Employees");
	        	System.out.println("3 -> Update Employee Details");
	        	System.out.println("4 -> Get Scheme for an Employee");
	        	System.out.println("5 -> Delete Employee");
	        	System.out.println("6 -> Exit");
	        	System.out.println("--------------------------------");
	        	System.out.print("Enter a choice :");
	        	input = empService.validateID(sc.nextLine());
	        	switch(input) {
		        	case 1: {
		        		System.out.println("Enter Employee Details");
		                System.out.print("Name :");String empName = empService.validateName(sc.nextLine());
		                System.out.print("Salary :");double empSalary = empService.validateSalary(sc.nextLine());
		                System.out.print("Designation :");String designation = sc.nextLine();
		                System.out.println(empService.addEmployee(empName,empSalary,designation));
		        		break;
		        	}
		        	case 2: {
		        		System.out.println("__________________________________________________________________________________");
		        		System.out.println("Employees Available:");
		        		empService.getEmployees().forEach(value->System.out.println(value));
		        		System.out.println("__________________________________________________________________________________");
		        		break;
		        	}
		        	case 3: {
		        		System.out.print("Enter employee id to update:");int empID = empService.validateID(sc.nextLine());
		        		System.out.println("Enter values to update otherwise press Enter !");
		        		
		        		System.out.print("Enter new Name :");String empName = sc.nextLine();
		        		if(empName.length()>0) {empService.validateName(empName);}
		        		
		        		System.out.print("Enter new Salary :");String empSalary = sc.nextLine();
		        		if(empSalary.length()>0) {empService.validateSalary(empSalary);}
		        		
		        		System.out.print("Enter new Designation :");String empDesignation = sc.nextLine();
		        		
		        		System.out.println(empService.updateEmployee(empID, empName, empSalary, empDesignation));
		        		break;
		        	}
		        	case 4: {
		        		System.out.print("Enter employee id to get scheme for :");
		        		int empID = empService.validateID(sc.nextLine());
		        		System.out.println(empService.getScheme(empID));
		        		break;
		        	}
		        	case 5: {
		        		System.out.print("Enter Employee ID to delete :");
		        		int empID = empService.validateID(sc.nextLine());
		        		System.out.println(empService.deleteEmployee(empID));
		        		break;
		        	}
		        	default: System.out.println("ThankYou !");break;
	        	}
			}catch(SQLException e) {
				System.out.println("SQL Error :"+e.getMessage());
			}catch(InvalidInputException e) {
				System.out.println("Invalid Input :"+e.getMessage());
			}
        }while(input !=6);
		sc.close();
    }
}
