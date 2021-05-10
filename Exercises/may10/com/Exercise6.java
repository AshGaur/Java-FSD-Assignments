package com;
import com.cg.eis.exception.EmployeeException;
import java.util.Scanner;
class Exercise6{
	public static void main(String[] args) throws EmployeeException{
		System.out.print("Enter Salary of the employee :");
		int salary = new Scanner(System.in).nextInt();
		validateSalary(salary);
	}
	public static void validateSalary(int salary) throws EmployeeException{
		if(salary<3000){
			throw new EmployeeException("Salary cannot be below 3000");
		}
	}
}