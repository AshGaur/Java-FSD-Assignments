import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UltraHD8K {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		new Thread().start();		//To call a method with the thread
		//Lambda converts the ref automatically to the type required as per my understanding
		
		List<String> list = new ArrayList<>();
		list.add("Range Rover");
		list.add("Kobe Bryant");
		list.add("DJ Khaled");
		list.add("Eminem");
		
		//Using lambdas to create Comparator<String subclass and return its object ref by overriding method compare having arguments String o1,String o2 and returns int by comparing o1 and o2 using compareTo method
		Collections.sort(list,(o1,o2)->o1.compareTo(o2));
		list.forEach(value->System.out.println(value));
		
		//Calling a static method
		new Thread(UltraHD8K::doSomething).start();
		//Breaking down
		//doSomething is the method to call
		//UltraHD8K is the ref to call the method doSomething
		//:: creates subclass of Runnable and overrides run method to contain a body that calls doSomething using UltraHD8K ref
		//This subclass object reference is then returned to be sent to the Thread constructor and then .start() starts the thread
		
		//calling a non static method
		new Thread(new UltraHD8K()::doAnotherThing).start();
	}
	public static void doSomething() {
		System.out.println("Displaying a message from doSomething Thread:"+Thread.currentThread().getName());
	}
	public void doAnotherThing() {
		System.out.println("Another thing !");
	}
}
