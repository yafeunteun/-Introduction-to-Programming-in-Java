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
    
}
