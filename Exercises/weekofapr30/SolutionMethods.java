package weekofapr30;
import java.util.Scanner;
import java.util.Date;
class SolutionMethods extends weekofapr30.Exercises678{
    Object result;

    //Exercise 1
    void trafficSimulator(Scanner sc){
        System.out.print("Enter a color from traffic light:");
        String color = sc.nextLine().toLowerCase();
        switch(color){
            case "red"      :   System.out.println("stop");break;
            case "yellow"   :   System.out.println("ready");break;
            case "green"    :   System.out.println("go");break;
            default         :   System.out.println("Invalid input !");break;
        }

        //To make user interface work properly
        System.out.println();
    }

    //Exercise 2
    void nthFibonacci(Scanner sc){
        System.out.print("Enter n to find nth term:");
        int n = sc.nextInt();
        System.out.println("By Recursion: "+this.recursiveFibonacci(1,1,n));//first and second terms given as 1 and 1 in problem statement
        System.out.println("By Non-recursive method: "+this.iterativeFibonacci(n));
        
        //To make user interface work properly
        System.out.println();
        sc.nextLine();//So that while loop works correctly
    }

    int recursiveFibonacci(int first,int second,int terms){
        if(terms == 1){
            return first;
        }
        return recursiveFibonacci(second,first+second,terms-1);
    }

    int iterativeFibonacci(int terms){
        int first = 1;
        int second = 1;
        for(int i=0;i<terms-1;i++){
            int temp = first;
            first = second;
            second = temp+second;
        }
        return first;
    }

    //Exercise 3
    void primesPrinter(Scanner sc){
        System.out.print("Enter a number upto which primes have to be printed:");
        int upto = sc.nextInt();
        for(int i=2;i<upto;i++){
            if(isPrime(i)){
                System.out.print(i+" ");
            }
        }

        //To make user interface work properly
        System.out.println("\n");
        sc.nextLine();//So that while loop works correctly
    }

    boolean isPrime(int n){
        boolean status = true;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                status = false;
                break;
            }
        }
        return status;
    }

    //Exercise 4
    void durationForInputDate(Scanner sc){
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

        //To make user interface work properly
        System.out.println();
    }

    //Exercise 5
    void sumOfCubesOfDigits(Scanner sc){
        System.out.print("Enter a number:");
        long n = sc.nextLong();
        long sum = 0;
        while(n>0){
            sum+=Math.pow(n%10,3);
            n/=10;
        }
        System.out.println("Sum of cube of digits: "+sum);

        //To make user interface work properly
        System.out.println("\n");
        sc.nextLine();//So that while loop works correctly
    }

    //Exercise 6
    void numReverseArraySort(Scanner sc){
        System.out.print("Enter array length:");
        int n = sc.nextInt();
        int ar[] = new int[n];
        System.out.println("Enter "+n+" integers");
        for(int i=0;i<n;i++){
            ar[i] = sc.nextInt();
        }

        ar = getSorted(ar);

        System.out.print("\nOutput Array:");
        for(int i:ar){
            System.out.print(i+" ");
        }

        //To make user interface work properly
        System.out.println("\n");
        sc.nextLine();//So that while loop works correctly
    }

    //Exercise 7
    void secondSmallest(Scanner sc){
        System.out.print("Enter number of elements in array:");
        int n = sc.nextInt();
        int ar[] = new int[n];
        System.out.println("Enter "+n+" integers:");
        for(int i=0;i<n;i++){
            ar[i] = sc.nextInt();
        }
        System.out.println("Second Smallest: "+getSecondSmallest(ar));

        //To make user interface work properly
        System.out.println();
        sc.nextLine();//So that while loop works correctly
    }

    //Exercise 8
    void sumOfDivBy3Or5(Scanner sc){
        System.out.print("Enter number of terms:");
        int n = sc.nextInt();
        System.out.println("Sum: "+calculateSum(n));

        //To make user interface work properly
        System.out.println();
        sc.nextLine();//So that while loop works correctly
    }

}