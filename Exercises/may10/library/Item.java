package library;
public abstract class Item{
	private int uid;
	private String title;
	private int numberOfCopies;
	abstract void addItem();
	abstract void printDetails();
	abstract void checkIn();
	abstract void checkOut();
	int getUid(){
		return this.uid;
	}
	String getTitle(){
		return this.title;
	}
	int getNumberOfCopies(){
		return this.numberOfCopies;
	}
	void setUid(int uid){
		this.uid = uid;
	}
	void setTitle(String title){
		this.title = title;
	}
	void setNumberOfCopies(int numberOfCopies){
		this.numberOfCopies = numberOfCopies;
	}

	Item(int uid,String title,int numberOfCopies){
		this.uid = uid;
		this.title = title;
		this.numberOfCopies = numberOfCopies;
	}
}