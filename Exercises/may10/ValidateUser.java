import java.util.Scanner;
class ValidateUser{
	public static void main(String[] args) throws InvalidUserException{
		Scanner sc = new Scanner(System.in);
		
		//Exercise 4
		System.out.println("Enter your firstName and lastName:");
		String firstName = sc.nextLine();
		String lastName = sc.nextLine();
		validateName(firstName,lastName);

		//Exercise 5
		System.out.print("Enter User's age:");
		validateAge(sc.nextInt());

	}

	public static void validateName(String firstName,String lastName) throws InvalidUserException{
		if(firstName.length()==0 || lastName.length()==0){
			throw new InvalidUserException("firstName and lastName are blank");
		}
	}

	public static void validateAge(int age) throws InvalidUserException{
		if(age<=15){
			throw new InvalidUserException("User's age of only above 15 allowed");
		}
	}
}

class InvalidUserException extends Exception{
	InvalidUserException(String message){
		super(message);
	}
}