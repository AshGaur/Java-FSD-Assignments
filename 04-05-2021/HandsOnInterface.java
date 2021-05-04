class A{
    void check(){
        System.out.println("check");
    }
}

class B{
    void eat(){
        System.out.println("eat");
    }
}


interface first{
    void eat();
}

interface second{
    void eat();
}

interface third extends first,second{
    void eat(int n);
    void eat();
}

class Implementer implements third{
    @Override
    public void eat(){
        System.out.println("eat()");
    }

    public void eat(int n){
        System.out.println("eat(int)");
    }

    public void sleep(){
        System.out.println("sleep");
    }
}

class C extends A implements first{
    @Override
    public void eat(){
        System.out.println("eat from C");
    }
}

class HandsOnInterface{
    public static void main(String[] args) {
        // new C().eat();
        new Implementer().eat();
        new Implementer().eat(1);
        new Implementer().sleep();
        new C().eat();
    }
}