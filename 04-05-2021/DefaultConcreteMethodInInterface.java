interface MovieTicket{
    String company = "INOX";
    void popcorn();

    default void oneFreeTicket(){
        System.out.println("One Ticket of same class free with purchase of 3 tickets of same class");
    }

}

class PlatinumTicket implements MovieTicket{
    @Override
    public void popcorn(){
        System.out.println("Full Bucket Popcorn free with PlatinumTicket");
    }
}

class GoldTicket implements MovieTicket{
    @Override
    public void popcorn(){
        System.out.println("Half Bucket Popcorn free with GoldTicket");
    }
}

class DefaultConcreteMethodInInterface{
    public static void main(String[] args) {
        PlatinumTicket pt = new PlatinumTicket();
        pt.popcorn();
        pt.oneFreeTicket();

        GoldTicket gt = new GoldTicket();
        gt.popcorn();
        gt.oneFreeTicket();
    }
}