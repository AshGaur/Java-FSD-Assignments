class ThreadJoin extends Thread{
	public static void main(String[] args) throws InterruptedException{
		ThreadJoin newThread = new ThreadJoin();		
		newThread.start();	//Thread-0
		newThread.join();		//This line is read by main thread so main is added to the tail of newThread i.e. Thread-0
		System.out.println(Thread.currentThread().getName());
	}
	public void run(){	//run method for Thread-0
		AnotherThread anotherThread = new AnotherThread();
		anotherThread.start();		//Thread-1
		try{
			anotherThread.join();			//this line is read by Thread-0 so Thread-0 is added to the tail of anotherThread i.e. Thread-1
		}catch(InterruptedException e){
			System.out.println("Join Exception");
		}
		
		System.out.println(Thread.currentThread().getName());
	}
}

class AnotherThread extends Thread{
	public void run(){		//run method for thread-1 as it gets created later the name changes according to time of creation
		System.out.println(Thread.currentThread().getName());
	}
}