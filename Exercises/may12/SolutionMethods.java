package may12;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class SolutionMethods {
	static int id;
	void addParticipant(Scanner sc,Map map) {
		//Name input
		System.out.print("Please enter name of the participant :");
		String name = "";
		try {
			name = this.getStringInput(sc);
		}catch(InvalidInputException e) {
			System.out.println(e.getMessage());
			return;
		}
		
		//Skills input
		System.out.print("Please enter skills of the participant :");
		String skills = "";
		try {
			skills = this.getStringInput(sc);
		}catch(InvalidInputException e) {
			System.out.println(e.getMessage());
			return;
		}
		
		//Adding to map
		map.put(++SolutionMethods.id, new Participant(name,skills));
		System.out.println("Participant successfully added !");
		System.out.println();
	}
	
	void viewAll(Map map) {
		Set set = map.entrySet();
		if (map.size()<1) {
			System.out.println("No members present in the database.");
			return;
		}
		System.out.println("Participants available in the database:");
		for(Object temp:set) {
			Map.Entry participant = (Map.Entry)temp;
			System.out.println("ID: "+participant.getKey()+"  "+participant.getValue());
		}
		System.out.println();
	}
	void updateParticipant(Scanner sc,Map map) {
		//ID input
		System.out.print("Please enter id for the participant whose details are to be updated:");
		int idToUpdate = -1;
		try {
			idToUpdate = this.getIntInput(sc);
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
		System.out.print("Name :");
		String newName = "";
		try {
			newName = this.getStringInput(sc);
		}catch(InvalidInputException e) {
			System.out.println(e.getMessage());
			return;
		}
		
		//New Skills Input
		System.out.print("Skills :");
		String newSkills = "";
		try {
			newSkills = this.getStringInput(sc);
		}catch(InvalidInputException e) {
			System.out.println(e.getMessage());
			return;
		}
		
		Participant current = (Participant)map.get(idToUpdate);
		//Setting new values
		current.setName(newName);
		current.setSkills(newSkills);
		System.out.println("Participant Details Updated successfully !");
		System.out.println();
	}
	
	void deleteParticipant(Scanner sc,Map map) {
		//ID input
		System.out.print("Enter participant ID to delete: ");
		int idToDelete = -1;
		try {
			idToDelete = this.getIntInput(sc);
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
	
	public String getStringInput(Scanner sc) throws InvalidInputException{
		String str = sc.nextLine();
		if(str.length()<3) {
			throw new InvalidInputException("Please Enter a String with atleast 3 chararacters !");
		}
		return str;
	}
	
	public int getIntInput(Scanner sc) throws InvalidInputException{
		String input = sc.nextLine();
		int num = -1;
		if(input.length()==0) {
			throw new InvalidInputException("Please enter a number !");
		}
		try {
			num = Integer.parseInt(input);
		}catch(NumberFormatException e) {
			throw new InvalidInputException("Only numbers allowed !");
		}
		return num;
	}
}
