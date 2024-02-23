public class Book {
	String title;
	String id;
	String author;
	int available;
	
	public Book(String id, String author, String title, int available) {
		super();
		this.title = title;
		this.id = id;
		this.author = author;
		this.available = available;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getAvailable() {
		return available;
	}
	public void setAvailable(int available) {
		this.available = available;
	}
	
	@Override
	

	public String toString() {
	    return String.format("\n| %-5s | %-30s | %-50s | %-4d |", id, author, title, available);
	}
}
