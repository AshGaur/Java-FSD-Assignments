import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class AnonymousClassCustomSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Participant> list = new ArrayList<>();
		list.add(new Participant(41,"Music Prod.","Post","Malone"));
		list.add(new Participant(10,"Java,Node,MySQL","Ashutosh","Gaur"));
		list.add(new Participant(25,"Wrestling","Dwayne","Johnson"));
		list.add(new Participant(60,"Business & Management","Satya","Nadella"));
		list.add(new Participant(45,"Missile Production","A.P.J. Abdul","Kalam"));
	
		//Sorting by ID
		System.out.println("Data sorted by ID:");
		Collections.sort(list,new Comparator<Participant>() {
			@Override
			public int compare(Participant o1, Participant o2) {
				return o1.getId().compareTo(o2.getId());
			}			
		});
		displayList(list);
		System.out.println();
		
		//Sorting by FirstName
		System.out.println("Data sorted by FirstName");
		Collections.sort(list,new Comparator<Participant>() {
			@Override
			public int compare(Participant o1, Participant o2) {
				return o1.getFirstName().compareTo(o2.getFirstName());
			}			
		});
		displayList(list);
		System.out.println();
		
		//Sorting by LastName
		System.out.println("Data sorted by LastName");
		Collections.sort(list,new Comparator<Participant>() {
			@Override
			public int compare(Participant o1, Participant o2) {
				return o1.getLastName().compareTo(o2.getLastName());
			}			
		});
		displayList(list);
	}
	public static void displayList(List<Participant> list) {
		for(Participant temp:list) {
			System.out.println(temp);
		}
	}
}

@AllArgsConstructor
@Getter
class Participant{
	Integer id;
	String skills;
	String firstName;
	String lastName;
	
	@Override
	public String toString() {
		return String.format("ID:%-5d Name: %-20s Skills: %-22s",this.getId(),this.getFirstName()+" "+this.getLastName(),this.getSkills());
	}
}