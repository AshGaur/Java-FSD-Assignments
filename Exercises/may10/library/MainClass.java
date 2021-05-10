package library;
class MainClass{
	public static void main(String[] args) {
		//Book
		WrittenItem book1 = new Book(123,"Wings of Fire",20);
		book1.checkIn();
		book1.setAuthorName("Dr A.P.J Abdul Kalam");
		book1.setAuthorId(9);
		book1.printDetails();
		book1.checkOut();

		System.out.println();

		//MediaItem
		MediaItem video1 = new Video(124,"The Eighth Dimension",10);
		video1.checkIn();
		video1.setRunTime(10);
		video1.setGenre("Sci-Fi");
		video1.setDirector("Ashutosh Gaur");
		video1.setYearReleased(2021);
		video1.printDetails();
		video1.checkOut();
	}
}