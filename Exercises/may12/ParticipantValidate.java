package may12;

import java.util.Scanner;

public class ParticipantValidate {
	public String getStringInput(Scanner sc) throws InvalidInputException {
		String str = sc.nextLine();
		if (str.length() < 1) {
			throw new InvalidInputException("String required !");
		}
		return str;
	}

	public String getNameInput(Scanner sc) throws InvalidInputException {
		//Handling Blank String inputs
		String name = sc.nextLine();
		if (name.length() < 1) {
			throw new InvalidInputException("String required !");
		}
		if(name.contains(" ")) {
			//To handle name entered with multiple spaces
			if (name.indexOf(" ") != name.lastIndexOf(" ")){
				throw new InvalidInputException("Only one space allowed between first and lastname !");
			}
			//To handle "Firstname<space>"
			if(name.split(" ").length<2) {
				throw new InvalidInputException("Invalid Input: Please enter name as FirstName<space>LastName !");
			}
			//To handle "<space>LastName"
			else if(name.split(" ")[0].length()<1) {
				throw new InvalidInputException("Firstname required !");
			}
		}
		return name;
	}
	
	public int getIntInput(Scanner sc) throws InvalidInputException {
		String input = sc.nextLine();
		int num = -1;
		if (input.length() == 0) {
			throw new InvalidInputException("Please enter a number !");
		}
		try {
			num = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new InvalidInputException("Only numbers allowed !");
		}
		return num;
	}
}
