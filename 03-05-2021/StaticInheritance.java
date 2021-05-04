class SuperClass{
    public static void check() {
        System.out.println("check");
    }
}

class StaticInheritance extends SuperClass{
    public static void main(String[] args) {
        check();//works perfetly as static methods can be inherited but these cannot be overridden
    }
}