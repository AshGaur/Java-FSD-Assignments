import java.util.Scanner;
class IPSecurity{
    String ipmask;
    IPSecurity(String ipmask){
        this.ipmask = ipmask;
    }
    class Firewall{ //inner class
        String accessControl;
        Firewall(String accessControl){
            this.accessControl = accessControl;
        }
        void changeAccess(String accessControl){
            this.accessControl = accessControl;
        }
    }
    void displayIP(){
        System.out.println("IP :"+this.ipmask);
    }
}

class InternetSecurity{
    public static void main(String[] args) {
        IPSecurity ipsecure = new IPSecurity("162.60.43.84");
        IPSecurity.Firewall firewall = ipsecure.new Firewall("Limited");    //**Syntax
        firewall.changeAccess("Public");
        System.out.println(firewall.accessControl);
        ipsecure.displayIP();
    }
}