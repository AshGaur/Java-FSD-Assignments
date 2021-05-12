package may12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Runner {
	public static void main(String[] args) {
		
		Map map = new HashMap();
		
		Scanner sc = new Scanner(System.in);
		SolutionMethods sol = new SolutionMethods();
		int input = -1;
		
		do {
			System.out.println("-------------------------------------------");
			System.out.println("1 - to enter details for a new participant");
			System.out.println("2 - to view details for all participants");
			System.out.println("3 - to update a participant details");
			System.out.println("4 - to delete a participant");
			System.out.println("5 - to exit");
			System.out.println("-------------------------------------------");
			System.out.print("Enter a choice :");
			try {
				input = sol.getIntInput(sc);
			}catch(InvalidInputException e) {
				System.out.println("Invalid choice\n");
				continue;
			}
			
			switch(input) {
				case 1:	sol.addParticipant(sc, map);break;
				case 2:	sol.viewAll(map);break;
				case 3: sol.updateParticipant(sc, map);break;
				case 4: sol.deleteParticipant(sc, map);break;
				case 5: System.out.println("Thank you !");break;
				default: System.out.println("Invalid choice\n");break;
			}
		}while(input!=5);
	}

}
