interface SecureServer{
    void runScan();
}

class ThreatAnalysis{
    void analyse(SecureServer scan){
        System.out.println("Please provide a scan ref");
        scan.runScan();
    }
}

class ServerSecurity{
    public static void main(String[] args) {
        SecureServer secure = new SecureServer(){       //Anonymous Sub-class of SecureServer
            @Override
            public void runScan(){
                System.out.println("Scan started for server threats !");
            }
        };
        secure.runScan();
        
        System.out.println();

        new ThreatAnalysis().analyse(new SecureServer(){    //Anonymous Sub-Class reference of SecureServer sent as argument
            @Override
            public void runScan(){
                System.out.println("Scanning for threats !");
            }
        });

    }
}