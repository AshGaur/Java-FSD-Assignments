enum Ticket{
    PLATINUM(450),GOLD(350),SILVER(250);
    private double price;
    Ticket(double price){
        this.price = price;
    }
    double getPrice(){
        return this.price;
    }
}

class MovieTicketsEnum{
    public static void main(String[] args) {
        System.out.println("Available Ticket types:");
        for(Ticket temp:Ticket.values()){
            System.out.printf("%-10s%s\n",temp,"Price:"+temp.getPrice());
        }
    }
}