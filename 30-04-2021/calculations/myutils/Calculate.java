package calculations.myutils;
public class Calculate extends OtherMathProtectedFunctions{
    double result;
    public double recognizeOperation(char c,double... values){
        switch(c){
            case '+':this.result = sum(values);break;
            case '*':this.result = pro(values);break;
            case '-':this.result = sub(values);break;
            default:
                System.out.println("Operation unknown !");
                break;
        }
        return this.result;
    }
    double sum(double[] values){
        double total = 0;
        for(double n:values){
            total+=n;
        }
        return total;
    }
    double pro(double[] values){
        double product = 1;
        for(double n:values){
            product*=n;
        }
        return product;
    }
    double sub(double[] values){
        if(values.length<1){
            System.out.println("Improper operands given for subtraction !");
            return -1234567.0;
        }
        double diff = values[0];
        for(int i=1;i<values.length;i++){
            diff-=values[i];
        }
        return diff;
    }

    public void printAP(double firstTerm,double commonDiff,int numberOfTerms){
        System.out.print("\nRequired AP with "+numberOfTerms+" terms:");
        for(int i=1;i<=numberOfTerms;i++){
            System.out.print(this.nthTermOfAP(firstTerm,commonDiff,i));
            System.out.print(i<numberOfTerms?",":"");
        }
        System.out.println("\nSum of the terms for this AP = "+this.sumOfNTermsAP(firstTerm,commonDiff,numberOfTerms));
    }
}