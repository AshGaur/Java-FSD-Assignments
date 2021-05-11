class OverloadingTypes{
	public static void main(String[] args) {
		
		separator();
		short var = 25;
		new OverloadedMethods1().work(var);			//calls work(short) type exact match
		new OverloadedMethods1().work((short)25);	//calls work(short) type exact match
		new OverloadedMethods1().work(25);			//calls work(int) as numbers are by-default treated as int so exact match
		
		separator();

		new OverloadedMethods2().test(var);			//calls test(int) goes for widening of scope but to the nearest one which is int
													//Also because why keep value in a variable which takes 8bytes(double) when 4bytes(int) is available

		separator();
		new OverloadingTypes(){
			void job(double val){
				System.out.println("job(double) called");
			}

			void job(Short val){
				System.out.println("job(Short) called");
			}
		}.job(var);									//Calls job(double) as Short is a wrapper class added in later versions so in order to keep older version codes remain intact.

		separator();

		new OverloadingTypes(){
			void run(short val){
				System.out.println("run(short) called");
			}

			void run(Short val){
				System.out.println("run(Short) called");
			}
		}.run(var);									//Calls run(short) as exact match and reason defined in previous example

		new OverloadingTypes(){
			void perform(Double val){
				System.out.println("perform(Double) called");
			}

			void perform(Integer val){
				System.out.println("perform(Integer) called");
			}
		}.perform(var);								//Gives Error as while boxing operation into wrapper class short -> Short but Short -/> Integer or Short -/> Double as they dont have a IS-A Relationship or no relatonship.

		separator();

		new OverloadingTypes(){
			void scan(Integer val){
				System.out.println("scan(Integer) called");
			}
			void scan(Object val){
				System.out.println("scan(Object) called");
			}
		}.scan(var);								//Calls scan(Object) as boxing operation of short -> Short -> Object  and Object can hold a reference of Short due to IS-A relationship(run-time polymorphism)

		separator();

		new OverloadedMethods1().start(var);		//Calls start(Short) as varargs can handle more than one parameters so boxing operation to a single Wrapper class is more relevant to a single parameter call.

		separator();

	}
	static void separator(){
		for(int i=0;i<20;i++){ System.out.print("-"); }
		System.out.println();
	}
}


class OverloadedMethods1{
	void work(short val){
		System.out.println("work(short) called");
	}
	void work(int val){
		System.out.println("work(int) called");
	}

	void start(short... var){
		System.out.println("start(varargs) called");
	}

	void start(Short var){
		System.out.println("start(Short) called");
	}
}

class OverloadedMethods2{
	void test(int val){
		System.out.println("test(int) called");
	}

	void test(double val){
		System.out.println("test(double) called");
	}
}