class MathCalc{
    void square(int n){
        System.out.println("Square of number entered: "+ (int)Math.pow(n,2));
    }
}

class AreaCalc extends MathCalc{
    void square(int edge){
        System.out.println("Area of square for edge "+edge+" is: "+edge*edge);
    }

    void rectangle(int length,int breadth){
        System.out.printf("Area of rectangle with length %d and breadth %d = %d\n",length,breadth,length*breadth);
    }
}

class InheritOverride{
    public static void main(String[] args) {
        MathCalc mc = new MathCalc();
        AreaCalc ac = new AreaCalc();

        mc.square(4);
        ac.square(4);
        ac.rectangle(12,4);

    }
}