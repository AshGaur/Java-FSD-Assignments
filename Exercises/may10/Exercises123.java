import java.util.Scanner;
class Exercises123{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Exercises123 obj = new Exercises123();

		//Exercise 1
		obj.trafficSimulator(sc);

		System.out.println();

		//Exercise 2
		obj.nthFibonacci(sc);

		System.out.println();

		//Exercise 3
		obj.primesPrinter(sc);


	}

	//Exercise 1 Solution
	void trafficSimulator(Scanner sc){
		System.out.print("Enter a color from traffic light:");
		String color = sc.nextLine().toLowerCase();
		switch(color){
			case "red"      :   System.out.println("stop");break;
			case "yellow"   :   System.out.println("ready");break;
			case "green"    :   System.out.println("go");break;
			default         :   System.out.println("Invalid input !");break;
		}
	}

	//Exercise 2 Solution
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

    //Exercise 3 Solution
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
}