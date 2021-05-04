interface SuperType{
    void method1();
    void method3();
}

interface SubType1 extends SuperType{
    void method2();
}

interface SubType2 extends SuperType{
    void method4();
}

class SubClassToType1 implements SubType1{
    @Override
    public void method1(){
        System.out.println("method1 from SubClassToType1");
    }

    @Override
    public void method2(){
        System.out.println("method2 from SubClassToType2");
    }

    @Override
    public void method3(){
        System.out.println("method3 from SubClassToType2");
    }
}

class SubClassToType2 implements SubType2{
    @Override
    public void method1(){
        System.out.println("method1 from SubType2");
    }

    @Override
    public void method3(){
        System.out.println("method3 from SubType2");
    }

    @Override
    public void method4(){
        System.out.println("method4 from SubType2");
    }
}

class RunTimePolymorphism{
    public static void main(String[] args) {
        SuperType superRef[] = new SuperType[2];
        SubType1 sub1Ref = new SubClassToType1();
        SubType2 sub2Ref = null;

        superRef[0] = new SubClassToType1();
        superRef[1] = new SubClassToType2();

        for(SuperType temp:superRef){
            temp.method1();
            temp.method3();
            if(temp instanceof SubClassToType2){
                // temp.method2(); // Doesn't work as method2() not in SuperType
                ((SubClassToType2)temp).method4(); // Appropriate TypeCasting to convert temp ref to SubClassToType2 and this now works
            }
        }

        System.out.println(superRef[0] instanceof SubType1);    //referenceVariable instanceof ClassName/InterfaceName
        System.out.println(superRef[1] instanceof SubType1);
        System.out.println(sub1Ref instanceof SubClassToType1);
        System.out.println(sub2Ref instanceof SubClassToType2);
    }
}