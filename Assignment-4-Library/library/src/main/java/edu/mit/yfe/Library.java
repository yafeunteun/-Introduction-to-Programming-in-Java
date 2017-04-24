package edu.mit.yfe;

import java.util.LinkedList;

public class Library {

    String address;
    LinkedList<Book> books;

    
    public Library(String address) {
	this.address = address;
	this.books = new LinkedList<Book>();
    }

    public void addBook(Book aBook){
	books.add(aBook);
    }

    public String printAddress() {
	return this.address;
    }

    public boolean isAvailable(String bookTitle) {
	for(Book book : this.books) {
	    if (book.getTitle().equals(bookTitle)) {
		if (!book.isBorrowed()) {
		    return true;
		}
	    }
	
	}
	return false;
    }
    public void borrowBook(String bookTitle) throws BookAlreadyBorrowedException, BookNotFoundException {
	for(Book book : this.books) {
	    if (book.getTitle().equals(bookTitle)) {
		if (book.isBorrowed()) {
		    throw new BookAlreadyBorrowedException();
		}
		book.rented();
		return;
	    }
	}
	throw new BookNotFoundException();
    }

    public void returnBook(String bookTitle) {
	for(Book book : this.books) {
	    if (book.getTitle().equals(bookTitle)) {
		book.returned();
	    }
	}
    }

    public static void printOpeningHours() {
	System.out.println("Libraries are open daily from 9am to 5pm.");
    }

    public void printAvailableBooks() {
	if (this.books.size() == 0) {
	    System.out.println("No book in catalog.");
	}
	for(Book book : this.books) {
	    System.out.println(book.getTitle());
	}
    }

    public static void main(String [] args) throws BookAlreadyBorrowedException, BookNotFoundException {

	// Create two libraries
	Library firstLibrary = new Library("10 Main St.");
	Library secondLibrary = new Library("228 Liberty St.");
	
	// Add four books to the first library
	firstLibrary.addBook(new Book("The Da Vinci Code"));
	firstLibrary.addBook(new Book("Le Petit Prince"));
	firstLibrary.addBook(new Book("A Tale of Two Cities"));
	firstLibrary.addBook(new Book("The Lord of the Rings"));
	
	// Print opening hours and the addresses
	System.out.println("Library hours:");
	printOpeningHours();
	System.out.println();
	System.out.println("Library addresses:");
	System.out.println(firstLibrary.printAddress());
	System.out.println(secondLibrary.printAddress());
	System.out.println();
	
	// Try to borrow The Lords of the Rings from both libraries
	System.out.println("Borrowing The Lord of the Rings:");
	firstLibrary.borrowBook("The Lord of the Rings");
	System.out.println("You successfully borrowed The Lord of the Rings");

	try {
	    firstLibrary.borrowBook("The Lord of the Rings");
	} catch (BookAlreadyBorrowedException e) {
	    System.out.println("Sorry, this book is already borrowed.");
	}
	try {
	    secondLibrary.borrowBook("The Lord of the Rings");
	} catch (BookNotFoundException e) {
	    System.out.println("Sorry, this book is not in our catalog.");
	}
	System.out.println();
	
	// Print the titles of all available books from both libraries
	System.out.println("Books available in the first library:");
	firstLibrary.printAvailableBooks();
	System.out.println();
	
	System.out.println("Books available in the second library:");
	secondLibrary.printAvailableBooks();
	System.out.println();
	
	// Return The Lords of the Rings to the first library
	System.out.println("Returning The Lord of the Rings:");
	firstLibrary.returnBook("The Lord of the Rings");
	System.out.println("You successfully returned The Lord of the Rings.");
	System.out.println();
	
	// Print the titles of available from the first library
	System.out.println("Books available in the first library:");
	firstLibrary.printAvailableBooks();
	
    }
    
}
