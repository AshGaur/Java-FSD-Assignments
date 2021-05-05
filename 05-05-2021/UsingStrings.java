class UsingStrings{
	public static void main(String[] args) {
		String str = "First Value";
		String secRef = "First Value";
		System.out.println(str==secRef);	//true as str and secRef point to same String Object
		
		str.concat(" is this");	//creates new object with value concatenated and returns the reference

		System.out.println(str);	//First Value

		str = str.concat(" is this"); //new object with concatenated string ref is now assigned to str

		System.out.println(str);	//Output -> First Value is this

		str.toUpperCase();	//new object with value in upper case and ref is returns

		System.out.println(str); //Output -> First Value is this

		str = str.toUpperCase(); //new object with uppercase and ref is assigned to str

		System.out.println(str); //Output -> FIRST VALUE IS THIS
	}
}