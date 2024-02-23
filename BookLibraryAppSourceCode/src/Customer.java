import java.util.Vector;

class Customer extends User{
    private Vector<Book> borrowedBooks;

    public Customer(String id, String username, String email, String password) {
    	super(id, username, email, password);
        this.borrowedBooks = new Vector<>();
    }

    public Vector<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void addBorrowedBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    public void printBooks() {
        System.out.println("Borrowed Books:");
        for (Book book : borrowedBooks) {
            System.out.println(book);
        }
    }

    @Override
    public String toString() {
	    return String.format("\n| %-5s | %-30s | %-30s |", id, username, email);
	    

    }
}