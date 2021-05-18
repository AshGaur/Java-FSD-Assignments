
public class CoVariantTrial {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal animal = new Cow().eat();
		System.out.println(animal);
	}
}

interface Animal{
	Animal eat();
}

class Cow implements Animal{
	@Override
	public Cow eat() {
		System.out.println("Cows eat !");
		return new Cow();
	}
}