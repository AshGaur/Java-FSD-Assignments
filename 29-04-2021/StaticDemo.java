// Using the keyword static in java

class StaticDemo{

	static int var; //Don't share a relationship with objects of this class
	int value;
	public static void main(String[] args) {
		StaticDemo demo = new StaticDemo();
		StaticDemo other = new StaticDemo();

		demo.var = 643; //Works -> StaticDemo.var = 643;
		StaticDemo.var = 452;
		System.out.println(other.var); //452 as it means StaticDemo.var and therefore has just one copy 


		// StaticDemo.var = 742;
		demo.func(); //StaticDemo.doSomething(); //Because doSomething() is static
		
	}

	static void func(){
		System.out.println("inside func()..., var = " + StaticDemo.var);
		// System.out.println(this.var); Gives error this not available in static context
	}
}