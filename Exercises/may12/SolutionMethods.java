package may12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class SolutionMethods {
	static int id;
	void addParticipant(Scanner sc,Map map) {
		ParticipantValidate validator = new ParticipantValidate();
		//Name input
		System.out.print("Please enter Name of the participant :");
		String name = "";
		try {
			name = validator.getNameInput(sc);
		}catch(InvalidInputException e) {
			System.out.println(e.getMessage());
			return;
		}
		
		//Skills input
		System.out.print("Please enter skills of the participant :");
		String skills = "";
		try {
			skills = validator.getStringInput(sc);
		}catch(InvalidInputException e) {
			System.out.println(e.getMessage());
			return;
		}
		
		String firstName = name.split(" ")[0];
		String lastName = name.split(" ").length>1?name.split(" ")[1]:"";
		
		if(new HashSet(map.values()).add(new Participant(firstName,lastName,skills))) {
			//Adding to map
			map.put(++SolutionMethods.id, new Participant(firstName,lastName,skills));
		}else {
			System.out.println("Participant already exists so not added !");
			return;
		}
		
		System.out.println("Participant successfully added !");
		System.out.println();
	}
	
	void viewAll(Map map) {
		if (map.size()<1) {
			System.out.println("No members present in the database.");
			return;
		}
		System.out.println("Participants available in the database:");
		for(Object temp:map.entrySet()) {
			Map.Entry participant = (Map.Entry)temp;
			System.out.println("ID: "+participant.getKey()+"  "+participant.getValue());
		}
		System.out.println();
	}
	void updateParticipant(Scanner sc,Map map) {
		ParticipantValidate validator = new ParticipantValidate();
		//ID input
		System.out.print("Please enter id for the participant whose details are to be updated:");
		int idToUpdate = -1;
		try {
			idToUpdate = validator.getIntInput(sc);
		}catch(InvalidInputException e){
			System.out.println(e.getMessage());
			return;
		}
		//Check if ID exists in the database
		if(map.get(idToUpdate)==null) {
			System.out.println("Participant ID not found !");
			return;
		}
		
		System.out.println("Please enter new name and skills for the participant");
		//New Name Input
		System.out.print("New Name :");
		String name = "";
		try {
			name = validator.getNameInput(sc);
		}catch(InvalidInputException e) {
			System.out.println(e.getMessage());
			return;
		}
		
		//New Skills Input
		System.out.print("Skills :");
		String newSkills = "";
		try {
			newSkills = validator.getStringInput(sc);
		}catch(InvalidInputException e) {
			System.out.println(e.getMessage());
			return;
		}
		
		String newFirstName = name.split(" ")[0];
		String newLastName = name.split(" ").length>1?name.split(" ")[1]:"";
		
		//Get reference for the object to be updated
		Participant current = (Participant)map.get(idToUpdate);
		if(new HashSet(map.values()).add(new Participant(newFirstName,newLastName,newSkills))) {
			//Setting new values
			current.setFirstName(newFirstName);
			current.setLastName(newLastName);
			current.setSkills(newSkills);
		}else {
			System.out.println("Participant Already Exists not updated !");
			return;
		}
		
		
		System.out.println("Participant Details Updated successfully !");
		System.out.println();
	}
	
	void deleteParticipant(Scanner sc,Map map) {
		ParticipantValidate validator = new ParticipantValidate();
		//ID input
		System.out.print("Enter participant ID to delete: ");
		int idToDelete = -1;
		try {
			idToDelete = validator.getIntInput(sc);
		}catch(InvalidInputException e) {
			System.out.println(e.getMessage());
			return;
		}
		
		//Check and delete if ID exists in database
		if(map.remove(idToDelete)!=null) {
			System.out.println("Participant deleted successfully !");
		}else {
			System.out.println("Participant ID not found !");
		}
		System.out.println();
	}
	
	public void sortBy(Scanner sc,Map map) {
		System.out.print("Do you want sorted data:");
		String confirmSort = sc.nextLine();
		switch(confirmSort.toLowerCase()) {
			case "y": 
				System.out.println("a - Sort by Id");
				System.out.println("b - Sort by Skills");
				System.out.println("c - Sort by FirstName");
				System.out.println("d - Sort by LastName");
				System.out.print("Please enter choice to sort by:");
				mySorter(map,sc.nextLine());
				break;
			default:
				System.out.println("Going to main menu !\n");
				return;
		}
	}
	public void mySorter(Map map,String option) {
		List listContents = new ArrayList(map.values());
		switch(option.toLowerCase()) {
			case "a":
				System.out.println("\nData Sorted by ID:");
				Map temp = new TreeMap();
				temp.putAll(map);
				for(Object t:temp.entrySet()) {
					System.out.println(((Map.Entry)t).getValue());
				}
				System.out.println();
				break;
			
			case "b":
				System.out.println("\nData Sorted by Skills:");
				Collections.sort(listContents,new SortBySkills());
				this.listDisplay(listContents);
				break;
			
			case "c":
				System.out.println("\nData Sorted by First Name:");
				Collections.sort(listContents,new SortByFirstName());
				this.listDisplay(listContents);
				break;
				
			case "d":
				System.out.println("\nData Sorted by Last Name:");
				Collections.sort(listContents,new SortByLastName());
				this.listDisplay(listContents);
				break;
				
			default:
				System.out.println("Unknown Operation");
				break;
		}
	}
	public void listDisplay(List list) {
		for(Object temp:list) {
			System.out.println((Participant)temp);
		}
		System.out.println();
	}
}

class SortBySkills implements Comparator{
	@Override
	public int compare(Object o1, Object o2) {
		return ((Participant)o1).getSkills().compareTo(((Participant)o2).getSkills());
	}
}

class SortByFirstName implements Comparator{
	@Override
	public int compare(Object o1, Object o2) {
		return ((Participant)o1).getFirstName().compareTo(((Participant)o2).getFirstName());
	}
}

class SortByLastName implements Comparator{
	@Override
	public int compare(Object o1, Object o2) {
		return ((Participant)o1).getLastName().compareTo(((Participant)o2).getLastName());
	}
}