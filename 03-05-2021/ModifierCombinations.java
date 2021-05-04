abstract class ModifierCombinationsWithAbstract{
    
    // Illegal combinations
    // private abstract void read(); // private makes the method uninheritable and abstract means it must be inherited and overridden
    // final abstract void check();  // final means method cannot be overridden and abstract means it must be inherited and overridden
    // static abstract void sum();   // static means method cannot be inherited and abstract means it must be inherited and overridden

    abstract void sum();
    protected abstract void check();
    public abstract void pro();

    void exampleofConcreteMethod(){ //Methods declared with a body in abstract class
        System.out.println("Concrete method called");
    }
}

class SubClass extends ModifierCombinationsWithAbstract{

    public void check(){ // access modifiers allowed protected,public
        System.out.println("check");
    }
    void sum(){ // access modifiers allowed package-private,protected,public
        System.out.println("sum");
    }
    public void pro(){ // access modifiers allowed public
        System.out.println("pro");
    }
}

class ModifierCombinations{
    public static void main(String[] args) {
        SubClass obj = new SubClass();
        // obj.read();
        obj.check();
        obj.sum();
        obj.pro();
    }
}