package may05;
class StringReverseAndPalindrome{
    public static void main(String[] args) {
        System.out.print("Enter a string to reverse :");
        String inputString = new java.util.Scanner(System.in).nextLine();
        System.out.println("Reverse of entered string :"+strRev(inputString));
        System.out.println("Is the String Palindrome :"+isPalindrome(inputString));
    }
    public static String strRev(String s){
        char temp[] = s.toCharArray();
        for(int i=0;i<temp.length/2;i++){
            char c = temp[i];
            temp[i] = temp[temp.length-1-i];
            temp[temp.length-1-i] = c;
        }
        return String.valueOf(temp);
    }
    public static boolean isPalindrome(String s){
        return s.contentEquals(strRev(s));
    }
}