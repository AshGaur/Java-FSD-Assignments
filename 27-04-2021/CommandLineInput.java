class CommandLineInput{
	public static void main(String[] args) {
		int marks1 = Integer.parseInt(args[0]);
		int marks2 = Integer.parseInt(args[1]);
		int marks3 = Integer.parseInt(args[2]);
		int sum = marks1+marks2+marks3;

		//Use only if and else statements without nesting and using logical operators and display result as passed or failed
		//marks1,marks2,marks3>=40 and sum>=125 is the passing criteria
		boolean hasPassed = true;
		if(marks1<40){
			hasPassed = false;
		}
		if(marks2<40){
			hasPassed = false;
		}
		if(marks3<40){
			hasPassed = false;
		}
		if(sum<125){
			hasPassed = false;
		}

		if(hasPassed){
			System.out.println("Student has passed");
		}else{
			System.out.println("Student has failed");
		}
	}
}