import java.util.Scanner;
class BestMultiplyProgram{
    //From the segment on learning Function creation
    //Previous version told in class had all code written in main
    //Best as it has separate methods for taking inputs and multiplication
    int num1,num2;
    public static void main(String[] args) {
        BestMultiplyProgram obj = new BestMultiplyProgram();
        obj.getNumbers();
        System.out.println("Product="+obj.multiply(obj.num1,obj.num2));
    }
    void getNumbers(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two numbers");
        this.num1 = sc.nextInt();
        this.num2 = sc.nextInt();
    }
    int multiply(int a,int b){
        return a*b;
    }
}