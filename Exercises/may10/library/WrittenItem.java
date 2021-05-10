package library;
abstract class WrittenItem extends library.Item{
	private String authorName;
	private int authorId;

	WrittenItem(int uid,String title,int numberOfCopies){
		super(uid,title,numberOfCopies);
	}

	int getAuthorId(){
		return this.authorId;
	}

	String getAuthorName(){
		return this.authorName;
	}

	void setAuthorName(String authorName){
		this.authorName = authorName;
	}

	void setAuthorId(int authorId){
		this.authorId = authorId;
	}

	@Override
	void checkIn(){
		System.out.println("Checking in with: WrittenItem");
	}

	@Override
	void checkOut(){
		System.out.println("Checking out with: WrittenItem");
	}

	@Override
	void addItem(){
		System.out.println("AddItem called for WrittenItems");
	}
}

class Book extends library.WrittenItem{
	Book(int uid,String title,int numberOfCopies){
		super(uid,title,numberOfCopies);
	}

	@Override
	void printDetails(){
		System.out.printf("%-20s:%d\n","Item UID",getUid());
		System.out.printf("%-20s:%s\n","Title",getTitle());
		System.out.printf("%-20s:%d\n","Number of copies",getNumberOfCopies());
		System.out.printf("%-20s:%d\n","Author Id",getAuthorId());
		System.out.printf("%-20s:%s\n","Author Name",getAuthorName());
	}
}

class JournalPaper extends library.WrittenItem{
	private int yearPublished;

	JournalPaper(int uid,String title,int numberOfCopies){
		super(uid,title,numberOfCopies);
	}

	@Override
	void printDetails(){
		System.out.printf("%-20s:%d\n","Item UID",getUid());
		System.out.printf("%-20s:%s\n","Title",getTitle());
		System.out.printf("%-20s:%d\n","Number of copies",getNumberOfCopies());
		System.out.printf("%-20s:%d\n","Author Id",getAuthorId());
		System.out.printf("%-20s:%s\n","Author Name",getAuthorName());
		System.out.printf("%-20s:%s\n","yearPublished",this.yearPublished);
	}

}