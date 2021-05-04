interface Manufacturer{
    void sell();
}

class Wholesaler implements Manufacturer{
    private double discount;

    Wholesaler(double discount){
        this.discount = discount;
    }

    @Override
    public void sell(){
        System.out.println("Wholesaler sells at "+discount+"% discount");
    }
}

class Retailer implements Manufacturer{
    private double discount;

    Retailer(double discount){
        this.discount = discount;
    }

    @Override
    public void sell(){
        System.out.println("Retailer sells at "+discount+"% discount");
    }

    public void transport(){
        System.out.println("Retailer adds transportation charges too");
    }
}

class OwnExampleRunTypePolyMorphism{
    public static void main(String[] args) {
        Manufacturer seller[] = new Manufacturer[2];
        seller[0] = new Wholesaler(40.0);
        seller[1] = new Retailer(10.0);

        for(Manufacturer temp:seller){
            temp.sell();
            if(temp instanceof Retailer){
                ((Retailer)temp).transport();       
            }
        }
        
    }
}