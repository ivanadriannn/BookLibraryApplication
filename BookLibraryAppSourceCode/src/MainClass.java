// Class LE01
// Member:
// 2602190085 - HardiKusuma
// 2602076323 - IvanAdrian
// 2602187815 - WairanathaHalim

// Import Library that will be used
import java.util.Scanner;
import java.util.Vector;

public class MainClass {
	// Making vector for our operations
    static Vector<Book> bookList = new Vector<>();
    static Vector<Book> addedBooks = new Vector<>();
    static Vector<Customer> customerList = new Vector<>();
    static Vector<Customer> addedCustomers = new Vector<>();
    static Vector<Admin> adminList = new Vector<>();
    static Admin loggedInUser = null;

    public static void main(String[] args) {
    	
        // Add admin account
        adminList.add(new Admin("A001", "admin", "hardi.kusuma@library.com", "password"));

        // Add some sample book data
        bookList.add(new Book("B001", "Jane Austen", "Pride and Prejudice", 5));
        bookList.add(new Book("B002", "F. Scott Fitzgerald", "The Great Gatsby", 7));
        bookList.add(new Book("B003", "Gabriel Garcia Marquez", "One Hundred Years of Solitude", 3));
        bookList.add(new Book("B004", "J.K. Rowling", "Harry Potter and the Sorcerer's Stone", 8));
        bookList.add(new Book("B005", "George Orwell", "1984", 2));
        bookList.add(new Book("B006", "Mark Twain", "The Adventures of Tom Sawyer", 10));
        bookList.add(new Book("B007", "Agatha Christie", "Murder on the Orient Express", 4));
        bookList.add(new Book("B008", "Harper Lee", "To Kill a Mockingbird", 6));
        bookList.add(new Book("B009", "Leo Tolstoy", "War and Peace", 9));
        bookList.add(new Book("B010", "J.R.R. Tolkien", "The Hobbit", 1));
        
        // Add some sample customer data
        customerList.add(new Customer("C001", "AliceJohnson", "alice.j@binus.ac.id", "pass1"));
        customerList.add(new Customer("C002", "BobSmith", "bob.smith@binus.ac.id", "pass2"));
        customerList.add(new Customer("C003", "CharlieBrown", "charlie.brown@binus.ac.id", "pass3"));
        customerList.add(new Customer("C004", "DavidMiller", "david.miller@binus.ac.id", "pass4"));
        customerList.add(new Customer("C005", "EmilyDavis", "emily.davis@binus.ac.id", "pass5"));
        customerList.add(new Customer("C006", "FrankWhite", "frank.white@binus.ac.id", "pass6"));
        customerList.add(new Customer("C007", "GraceWilson", "grace.wilson@binus.ac.id", "pass7"));
        customerList.add(new Customer("C008", "HenryTaylor", "henry.taylor@binus.ac.id", "pass8"));
        customerList.add(new Customer("C009", "IsabellaBrown", "isabella.b@binus.ac.id", "pass9"));
        customerList.add(new Customer("C010", "JackDavis", "jack.davis@binus.ac.id", "pass10"));
        
        // Menu 
	    int option = -1;
	    while (option != 11) {
            addedCustomers.clear();
            addedBooks.clear();
            System.out.println("Book Library Admin");
            System.out.println("==================");
            if (loggedInUser == null) {
                System.out.println("1. Login");
            } else {
                System.out.println("1. Logout");
                System.out.println("2. Book Borrowing");
                System.out.println("3. View Book List");
                System.out.println("4. View Customer List");
                System.out.println("5. Add Book");
                System.out.println("6. Add Customer");
                System.out.println("7. Return Book");
                System.out.println("8. Delete Book");
                System.out.println("9. Delete Customer");
                System.out.println("10. View Borrowed Books");
            }
            System.out.println("11. Exit");

            Scanner scanner = new Scanner(System.in);

            try {
                option = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Something went wrong.");
            }

            if (loggedInUser == null) {
                switch (option) {
                    case 1:
                        login();
                        break;
                    case 11:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }
            } else {
                switch (option) {
                    case 1:
                        logout();
                        break;
                    case 2:
                        borrowBook();
                        break;
                    case 3:
                        viewBookList();
                        break;
                    case 4:
                        viewCustomerList();
                        break;
                    case 5:
                        addBook();
                        break;
                    case 6:
                        addCustomer();
                        break;
                    case 7:
                        returnBook();
                        break;
                    case 8:
                        deleteBook();
                        break;
                    case 9:
                        deleteCustomer();
                        break;
                    case 10:
                        viewBorrowedBooks();
                        break;
                    case 11:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }
            }
        }
	    }
    
    static void pressAnyKeyToContinue() {
        System.out.println("Press Enter key to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
            System.out.println("Error reading input. Continue anyway.");
        }
    }
    
    static void viewBorrowedBooks() {
        // View the list of all borrowed books
        System.out.println("List of Borrowed Books:");
        System.out.printf("| %-5s | %-30s | %-50s | %-30s |%n", "ID", "Author", "Title", "Borrower");
        for (Customer customer : customerList) {
            for (Book book : customer.getBorrowedBooks()) {
                System.out.printf("| %-5s | %-30s | %-50s | %-30s |%n",
                        book.getId(), book.getAuthor(), book.getTitle(), customer.getUsername());
            }
        }
        System.out.println("");
        pressAnyKeyToContinue();
        
    }

    static void viewBookList() {
        // View the book list
        System.out.println("Book List:");
        System.out.printf("| %-5s | %-30s | %-50s | %-4s |%n", "ID", "Author", "Title", "Qty");
        for (Book book : bookList) {
            System.out.print(book);
        }
        System.out.println("");
        pressAnyKeyToContinue();
    }

    static void viewCustomerList() {
    	// view the customer list
        System.out.println("Customer List:");
        System.out.printf("| %-5s | %-30s | %-30s |%n", "ID", "Username", "Email");

        for (Customer customer : customerList) {
            System.out.print(customer);
        }
        System.out.println("");
        pressAnyKeyToContinue();
    }

    static void login() {
    	// Login to the application
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username [default username: admin]: ");
        String username = scanner.next();
        System.out.print("Enter password [default password: password]: ");
        String password = scanner.next();
        
        for (Admin admin : adminList) {
            if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                loggedInUser = admin;
                System.out.println("Login successful.");
                return;
            }
        }
        
        System.out.println("Login failed.");
    }

    static void logout() {
        // When logout sucessfully
        loggedInUser = null;
        System.out.println("Logout successful.");
    }

    static void borrowBook() {
    	// When customer wants to borrow book
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter customer ID: ");
        String searchCustomerId = scanner.next();
        System.out.print("Enter book ID: ");
        String searchBookId = scanner.next();
        boolean customerFound = false;
        boolean bookFound = false;
        
        for (Customer customer : customerList) {
            if (customer.getId().equals(searchCustomerId)) {
                customerFound = true;
                break;
            } 
        }

        if (customerFound) {
            for (Book book : bookList) {
                if (book.getId().equals(searchBookId) && book.getAvailable() > 0) {
                    bookFound = true;
                    book.setAvailable(book.getAvailable() - 1);
                    for (Customer customer : customerList) {
                        if (customer.getId().equals(searchCustomerId)) {
                            customer.addBorrowedBook(book);
                            System.out.println("Book successfully borrowed.");
                            pressAnyKeyToContinue();
                            return;
                        }
                    }
                } else if (book.getId().equals(searchBookId) && book.getAvailable() == 0) {
                    System.out.println("Sorry, the book is not available for borrowing.");
                    pressAnyKeyToContinue();
                    return;
                }
            }
        } 
        
        if (!customerFound) {
            System.out.println("Customer not found.");
            pressAnyKeyToContinue();
        } else if (!bookFound) {
            System.out.println("Book not found or not available for borrowing.");
            pressAnyKeyToContinue();
        }
    }

    static void addBook() {
    	// When admin wants to add book on book list
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of books to add: ");
        int numberOfBooks = 0;

        while (true) {
            try {
                numberOfBooks = scanner.nextInt();
                scanner.nextLine();
                break; 
            } catch (Exception e) {
                System.out.println("Invalid input for the number of books. Please enter a valid integer.");
                scanner.nextLine(); 
            }
        }

        boolean booksAdded = false;

        for (int i = 0; i < numberOfBooks; i++) {
            System.out.print("Enter book ID: ");
            String id = scanner.nextLine();

            if (!isBookIdUnique(id)) {
                System.out.println("Book ID must be unique!");
                i--; 
                continue; 
            }

            System.out.print("Enter title: ");
            String title = scanner.nextLine();
            System.out.print("Enter author: ");
            String author = scanner.nextLine();

            int available = 0;

            do {
                System.out.print("Enter quantity [Quantity must > 0]: ");

                try {
                    available = scanner.nextInt();
                    scanner.nextLine();

                    if (available <= 0) {
                        System.out.println("Quantity must be greater than 0.");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input for quantity. Please enter a valid integer.");
                    scanner.nextLine(); 
                    continue;
                }
            } while (available <= 0);

            addedBooks.add(new Book(id, author, title, available));
            booksAdded = true;
        }

        for (Book book : addedBooks) {
            Thread addBookThread = new Thread(() -> {
                synchronized (bookList) {
                    try {
                        bookList.add(book);
                    } catch (Exception e) {
                        System.out.println("Error adding book: " + e.getMessage());
                    }
                }
            });

            addBookThread.start();
        }

        if (booksAdded) {
            System.out.println("All books successfully added.");
            pressAnyKeyToContinue(scanner);
        } else {
            System.out.println("No books were added.");
            pressAnyKeyToContinue(scanner);
        }
    }

    static void pressAnyKeyToContinue(Scanner scanner) {
        System.out.println("Press Enter key to continue...");
        scanner.nextLine();
    }

    
    static boolean isBookIdUnique(String id) {
        for (Book book : bookList) {
            if (book.getId().equals(id)) {
                return false; // ID is not unique
            }
        }
        return true; // ID is unique
    }
    
    static void addCustomer() {
        // When admin wants to add a new customer to the customer list
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of customers to add: ");
        int numberOfCustomers = 0;

        try {
            numberOfCustomers = scanner.nextInt();
            scanner.nextLine();  
        } catch (Exception e) {
            System.out.println("Invalid input for the number of customers. Please enter a valid integer.");
            scanner.nextLine(); 
            addCustomer();
            return;
        }

        boolean customersAdded = false;

        for (int i = 0; i < numberOfCustomers; i++) {
            String id;

            do {
                try {
                    System.out.print("Enter customer ID [Must be Unique, Ex: C011]: ");
                    id = scanner.nextLine();
                    if (!isCustomerIdUnique(id)) {
                        System.out.println("Customer ID must be unique!");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input for customer ID. Please try again.");
                    id = "";  // Set id to an empty string to avoid infinite loop
                }
            } while (!isCustomerIdUnique(id));

            String username;

            do {
                System.out.print("Enter username [Not contain space]: ");
                username = scanner.nextLine();
            } while (username.contains(" "));

            String email;

            do {
                System.out.print("Enter email [Must end with @binus.ac.id]: ");
                email = scanner.nextLine();
            } while (!isValidEmail(email));

            String password;

            do {
                System.out.print("Enter password [Must be 6 Characters Length]: ");
                password = scanner.nextLine();
            } while (password.length() != 6);

            addedCustomers.add(new Customer(id, username, email, password));
            customersAdded = true;
            pressAnyKeyToContinue(scanner);
        }

        // multi-threading concept
        for (Customer customer : addedCustomers) {
            Thread addCustomerThread = new Thread(() -> {
                synchronized (customerList) {
                    try {
                        customerList.add(customer);
                    } catch (Exception e) {
                        System.out.println("Error adding customer: " + e.getMessage());
                    }
                }
            });

            addCustomerThread.start();
        }

        if (customersAdded) {
            System.out.println("All customers successfully added.");
            pressAnyKeyToContinue(scanner);
        } else {
            System.out.println("No customers were added.");
            pressAnyKeyToContinue(scanner);
        }
    }
    
    static boolean isValidEmail(String email) {
        // the email must end with @binus.ac.id
        return email.endsWith("@binus.ac.id");
    }

    static boolean isCustomerIdUnique(String id) {
        for (Customer customer : customerList) {
            if (customer.getId().equals(id)) {
                return false; // ID is not unique
            }
        }
        return true; // ID is unique
    }

    static void returnBook() {
    	// return the book which had borrowed
    	viewBorrowedBooks();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter customer ID: ");
        String customerId = scanner.next();
        System.out.print("Enter book ID to return: ");
        String returnBookId = scanner.next();
        boolean customerFound = false;
        
        for (Customer customer : customerList) {
            if (customer.getId().equals(customerId)) {
                customerFound = true;
                break;
            }
        }
        
        if (customerFound) {
            for (Customer customer : customerList) {
                if (customer.getId().equals(customerId)) {
                    for (Book book : customer.getBorrowedBooks()) {
                        if (book.getId().equals(returnBookId)) {
                            customer.returnBook(book);
                            for (Book b : bookList) {
                                if (b.getId().equals(returnBookId)) {
                                    b.setAvailable(b.getAvailable() + 1);
                                    System.out.println("Book successfully returned.");
                                    pressAnyKeyToContinue();
                                    return;
                                }
                            }
                        }
                    }
                    System.out.println("Book not found in the customer's borrowed books.");
                    pressAnyKeyToContinue();
                    return;
                }
            }
        } else {
            System.out.println("Customer not found.");
            pressAnyKeyToContinue();
        }
    }

    static void deleteBook() {
    	// Delete book from the book list
    	viewBookList();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter book ID to delete: ");
        String deleteBookId = scanner.next();
        
        for (Book book : bookList) {
            if (book.getId().equals(deleteBookId)) {
                bookList.remove(book);
                System.out.println("Book successfully deleted.");
                pressAnyKeyToContinue();
               
                return;
            }
        }
       
        System.out.println("Book not found.");
        pressAnyKeyToContinue();
    }

    static void deleteCustomer() {
    	// Delete customer from the customer list
    	viewCustomerList();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter customer ID to delete: ");
        String deleteCustomerId = scanner.next();

        for (Customer customer : customerList) {
            if (customer.getId().equals(deleteCustomerId)) {
                customerList.remove(customer);
                System.out.println("Customer successfully deleted.");
                pressAnyKeyToContinue();
                return;
            }
        }
      
        System.out.println("Customer not found.");
        pressAnyKeyToContinue();
    }
}