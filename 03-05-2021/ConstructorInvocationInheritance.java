class A{
    A(int v){
        System.out.println("A(int) from class A");
    }
}

class B extends A{
    B(){
        this(1);
        System.out.println("B() from class B");
    }
    B(int d){
        super(0);
        System.out.println("B(int) from class B");
    }
}

class C extends B{
    C(){
        super(1);
        System.out.println("C()");
    }
    C(int b){
        super();
        System.out.println("C(int)");
    }
}

class ConstructorInvocationInheritance{
    public static void main(String[] args) {
        // new C();
        new C(1);
    }
}