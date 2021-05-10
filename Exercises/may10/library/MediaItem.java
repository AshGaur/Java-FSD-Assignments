package library;
abstract class MediaItem extends library.Item{
	private int runtime;

	MediaItem(int uid,String title,int numberOfCopies){
		super(uid,title,numberOfCopies);
	}

	abstract void setGenre(String genre);
	abstract void setDirector(String director);

	void setYearReleased(int yearReleased){
		System.out.println("Not defined for CDs");
	}

	@Override
	void checkIn(){
		System.out.println("Checking in with: MediaItem");
	}

	void setRunTime(int runtime){
		this.runtime = runtime;
	}

	@Override
	void checkOut(){
		System.out.println("Checking out with: MediaItems");
	}

	@Override
	void addItem(){
		System.out.println("AddItem called for MediaItems");
	}

	int getRunTime(){
		return this.runtime;
	}
}

class Video extends library.MediaItem{
	private String director;
	private String genre;
	private int yearReleased;

	Video(int uid,String title,int numberOfCopies){
		super(uid,title,numberOfCopies);
	}

	@Override
	void printDetails(){
		System.out.printf("%-20s:%d\n","Item UID",getUid());
		System.out.printf("%-20s:%s\n","Title",getTitle());
		System.out.printf("%-20s:%d\n","Number of copies",getNumberOfCopies());
		System.out.printf("%-20s:%d\n","Runtime",getRunTime());
		System.out.printf("%-20s:%s\n","Director",this.director);
		System.out.printf("%-20s:%s\n","Genre",this.genre);
		System.out.printf("%-20s:%s\n","yearReleased",this.yearReleased);
	}

	@Override
	void setGenre(String genre){
		this.genre = genre;
	}

	@Override
	void setDirector(String director){
		this.director = director;
	}

	@Override
	void setYearReleased(int yearReleased){
		this.yearReleased = yearReleased;
	}

}

class CD extends library.MediaItem{
	private String artist,genre;

	CD(int uid,String title,int numberOfCopies){
		super(uid,title,numberOfCopies);
	}

	@Override
	void printDetails(){
		System.out.printf("%-20s:%d\n","Item UID",getUid());
		System.out.printf("%-20s:%s\n","Title",getTitle());
		System.out.printf("%-20s:%d\n","Number of copies",getNumberOfCopies());
		System.out.printf("%-20s:%d\n","Runtime",getRunTime());
		System.out.printf("%-20s:%s\n","Artist",this.artist);
		System.out.printf("%-20s:%s\n","Genre",this.genre);
	}

	void setGenre(String genre){
		this.genre = genre;
	}

	void setDirector(String artist){
		this.artist = artist;
	}

}