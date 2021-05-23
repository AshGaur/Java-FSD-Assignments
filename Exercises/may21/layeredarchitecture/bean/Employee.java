package may21.layeredarchitecture.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Employee {
	Integer id;
	String name;
	double salary;
	String designation;
	
	public Employee(String name,double salary,String designation){
		this.name = name;
		this.salary = salary;
		this.designation = designation;
	}
	
	public String toString() {
		return String.format("id:%d Name: %-15s Salary: %.2f %14s: %-10s", this.id,this.getName(),this.getSalary(),"Designation",this.getDesignation());
	}
}
