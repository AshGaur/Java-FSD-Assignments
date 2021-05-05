package may05;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Date;
class Assignments2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        //Exercise 1
        sumOfIntegersStringTokenizer(sc);

        System.out.println();

        //Exercise 2
        System.out.print("Enter a string to check if it is positive:");
        String str = sc.nextLine();
        System.out.println("Is String positive:"+isPositiveString(str));

        System.out.println();

        //Exercise 3
        durationForInputDate(sc);

        System.out.println();

        //Exercise 4
        System.out.println("Enter a username string");
        System.out.println("The username validation result is:"+isUsernameValid(sc.nextLine()));

        System.out.println();

        //Exercise 5
        System.out.print("Enter a number:");
        System.out.println("Sum of cubes of digits for the enterd number = "+sumOfCubesOfDigits(sc.nextInt()));

        System.out.println();

        //Exercise 6
        System.out.print("How many strings to enter:");
        int n = sc.nextInt();
        sc.nextLine();//to remove \n from nextInt()

        String[] ar = new String[n];
        for(int i=0;i<n;i++){
            ar[i] = sc.nextLine();
        }

        System.out.println();

        System.out.println("Required Operation completed with following results:");
        for(String s:sortUpperLowerStrings(ar)){
            System.out.println(s);
        }
        System.out.println();
    }

    //Exercise 1
    static void sumOfIntegersStringTokenizer(Scanner sc){
        System.out.println("Enter a string of integers separated by a delimiter string:");
        String inputString = sc.nextLine();
        System.out.println("Enter a delimiter string:");
        String delimiterStr = sc.nextLine();
        StringTokenizer input = new StringTokenizer(inputString,delimiterStr);
        int sum = 0;
        System.out.println("Integers present in the string:");
        while(input.hasMoreTokens()){
            String temp = input.nextToken();
            System.out.println(temp);
            sum+=Integer.parseInt(temp);
        }
        System.out.println("Sum of entered numbers = "+sum);
    }

    //Exercise 2
    static boolean isPositiveString(String str){
        str = str.toUpperCase();
        boolean flag = true;
        for(int i=0; i<str.length()-1;i++){
            if(str.charAt(i)>str.charAt(i+1)){
                flag = false;
                break;
            }
        }
        return flag;
    }

    //Exercise 3
    static void durationForInputDate(Scanner sc){
        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("dd-MM-yyyy");
        System.out.print("Enter a future date in dd-mm-yyyy format:");
        String dateStr = sc.nextLine();

        long milliSecDiff = 0;
        Date inpDate = null;        
        try{
            inpDate = formatter.parse(dateStr);
        }catch(java.text.ParseException e){
            System.out.println("Date couldn't be parsed invalid format !");
            inpDate = new Date();
        }
        
        Date currentDate = new Date();

        milliSecDiff = inpDate.getTime() - currentDate.getTime();
        milliSecDiff/=1000;
        long years = milliSecDiff/(60*60*24*365);
        milliSecDiff%=(60*60*24*365);
        long months = milliSecDiff/(60*60*24*30);
        milliSecDiff%=(60*60*24*30);
        long days = milliSecDiff/(60*60*24);

        System.out.println(days+" days,"+months+" months and "+years+" years remaining to input date");

    }

    //Exercise 4
    static boolean isUsernameValid(String s){
        return s.replace("_job","").length()>=8;
    }

    //Exercise 5
    static int sumOfCubesOfDigits(int num){
        double sum = 0;
        while(num>0){
            sum+=Math.pow(num%10,3);
            num/=10;
        }

        return (int)sum;
    }

    //Exercise 6
    static String[] sortUpperLowerStrings(String[] s){
        java.util.Arrays.sort(s);
        int len = s.length%2==0?s.length/2:(s.length/2)+1;
        for(int i=0;i<s.length;i++){
            s[i] = i<len?s[i].toUpperCase():s[i].toLowerCase();
        }
        return s;
    }
}