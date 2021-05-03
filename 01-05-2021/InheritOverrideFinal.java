class One{
    void first(){
        System.out.println("first from One");
    }
}

class Two extends One{
    @Override
    void first(){
        System.out.println("first from Two");
    }

    final void second(){
        System.out.println("second from Two should not be inherited");
    }
}

class Three extends Two{
    // @Override
    // void second(){
    //  System.out.println("This won't run as this is defined as final in clas Two");
    // }
}

class InheritOverrideFinal{
    public static void main(String[] args) {
        new One().first();
        new Two().first();
        new Two().second();
        // new Three().second();    
    }
}