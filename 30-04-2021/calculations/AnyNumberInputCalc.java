package calculations;
import java.util.Scanner;
class AnyNumberInputCalc{
    static char operation;
    static double[] inputs;

    public static void main(String[] args) {
        AnyNumberInputCalc.scannerInput();
        calculations.myutils.Calculate calc = new calculations.myutils.Calculate();

        //Because the function recognizeOperation accepts varargs it can take any number of arguments or even arrays
        AnyNumberInputCalc.display(calc.recognizeOperation(AnyNumberInputCalc.operation,AnyNumberInputCalc.inputs));
        AnyNumberInputCalc.display(calc.recognizeOperation('*',5,4,3,2,1));//5.0 * 4.0 * 3.0 * 2.0 * 1.0 = 120.0
        AnyNumberInputCalc.display(calc.recognizeOperation('+',new double[]{5.0,6.0,7.0}));//5.0 + 6.0 + 7.0 = 18.0
        AnyNumberInputCalc.display(calc.recognizeOperation('-',new double[]{4.0,8.0,-5.0}));//4.0 - 8.0 - (-5.0) = 1.0

    }
    static void scannerInput(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter operation to be performed as +,- or * followed by enter:");
        AnyNumberInputCalc.operation = sc.nextLine().charAt(0);

        System.out.print("Enter numbers separated by spaces followed by enter:");
        String[] inpStrings = sc.nextLine().split(" ");
        AnyNumberInputCalc.inputs = AnyNumberInputCalc.parser(inpStrings);
    }
    static double[] parser(String[] inputs){
        double temp[]=new double[inputs.length];
        if(inputs[0].length()==0){
            return new double[0];
        }
        for(int i=0;i<inputs.length;i++){
            temp[i] = Double.parseDouble(inputs[i]);
        }
        return temp;
    }
    static void display(double result){
        System.out.println("Result = "+result);
    }
}