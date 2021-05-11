class CyberSecurity{
    void runScan(){
        class Firewall{
            void startUp(){
                System.out.println("Firewall Started !!!");
            }
        }
        new Firewall().startUp();
    }
}

class MethodLocalInnerClass{
    public static void main(String[] args) {
        new CyberSecurity().runScan();
    }   
}