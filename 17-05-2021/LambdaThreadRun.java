
public class LambdaThreadRun {

	public static void main(String[] args) {
		//Using Anonymous Classes
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName()+" Running...!");
			}
		}).start();

		//Works as Runnable is a functional interface
		
		//Using Lambda to Shorten the code
		Runnable ref = () -> System.out.println(Thread.currentThread().getName()+" Running...!");
		new Thread(ref).start();
		
		//Shortening it further
		new Thread((Runnable)() -> System.out.println(Thread.currentThread().getName()+" Running...!")).start();
	}

}
