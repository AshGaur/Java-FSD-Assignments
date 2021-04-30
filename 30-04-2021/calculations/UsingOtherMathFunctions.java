package calculations;
import calculations.myutils.Calculate;
import java.util.Scanner;
class UsingOtherMathFunctions{
	public static void main(String[] args) {
		Calculate calc = new Calculate();
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter first term of AP:");
		
		double firstTerm = sc.nextDouble();

		System.out.print("Enter common difference in the terms:");
		double commonDiff = sc.nextDouble();
		
		System.out.print("Enter number of terms required:");
		int numberOfTerms = sc.nextInt();
		
		calc.printAP(firstTerm,commonDiff,numberOfTerms);
	}
}