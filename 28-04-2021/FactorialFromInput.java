class FactorialFromInput{
    public static void main(String[] args) {
        System.out.print("Please enter a number followed with ENTER: ");
        int n = new java.util.Scanner(System.in).nextInt();
        int factorial = 1;
        for(;n>0;n--){
            factorial*=n;
        }
        System.out.println("Factorial for number Entered:"+factorial);
    }
}