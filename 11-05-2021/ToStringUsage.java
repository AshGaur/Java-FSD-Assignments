class Car{
    int ccEngine;
    String carName;
    int seatingCapacity;
    
    Car(String carName,int ccEngine,int seatingCapacity){
        this.ccEngine = ccEngine;
        this.carName = carName;
        this.seatingCapacity = seatingCapacity;
    }

    @Override
    public String toString(){
        return String.format("------------------------------\n%-20s:%s\n%-20s:%d\n%-20s:%d\n------------------------------\n",
            "Name",
            this.carName,
            "CCs",
            this.ccEngine,
            "Seating Capacity",
            this.seatingCapacity
        );
    }

}


class ToStringUsage{
    public static void main(String[] args) {
        System.out.println(new Car("Porsche 911",2981,4));
        System.out.println(new Car("Audi R8",5204,2));
        System.out.println(new Car("Lamborghini Aventador",6498,2));
    }
}