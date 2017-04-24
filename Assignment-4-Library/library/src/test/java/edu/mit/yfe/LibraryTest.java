package edu.mit.yfe;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for Library
 */
public class LibraryTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public LibraryTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( LibraryTest.class );
    }

    public void testCanCreateLibrary()
    {
	Library firstLibrary = new Library("10 Main St.");
	Library secondLibrary = new Library("228 Liberty St.");
    }

    public void testCanAddBooksToLibrary()
    {
	Library firstLibrary = new Library("10 Main St.");
	Library secondLibrary = new Library("228 Liberty St.");
	
	firstLibrary.addBook(new Book("The Da Vinci Code"));
	firstLibrary.addBook(new Book("Le Petit Prince"));
	firstLibrary.addBook(new Book("A Tale of Two Cities"));
	firstLibrary.addBook(new Book("The Lord of the Rings"));
    }

    public void testCanPrintTheAddresse()
    {
	Library firstLibrary = new Library("10 Main St.");
	Library secondLibrary = new Library("228 Liberty St.");
	assertEquals("10 Main St.", firstLibrary.printAddress());
	assertEquals("228 Liberty St.", secondLibrary.printAddress());
    }

    public void testCanBorrowTheLordOfTheRingsFromTheTwoLibraries() throws BookAlreadyBorrowedException, BookNotFoundException {
	Library firstLibrary = new Library("10 Main St.");
	Library secondLibrary = new Library("228 Liberty St.");

	firstLibrary.addBook(new Book("The Da Vinci Code"));
	firstLibrary.addBook(new Book("Le Petit Prince"));
	firstLibrary.addBook(new Book("A Tale of Two Cities"));
	firstLibrary.addBook(new Book("The Lord of the Rings"));

	assertTrue(firstLibrary.isAvailable("The Lord of the Rings"));
	firstLibrary.borrowBook("The Lord of the Rings");
	assertFalse(firstLibrary.isAvailable("The Lord of the Rings"));

	try {
	    firstLibrary.borrowBook("The Lord of the Rings");
	    fail("Failed to throw exception when trying to borrow a book already borrowed");
	} catch (BookAlreadyBorrowedException e) {
	}

	try {
	    secondLibrary.borrowBook("The Lord of the Rings");
	    fail("Failed to throw exception when trying to borrow a book that is not available in the library (even among borrowed books)");
	} catch (BookNotFoundException e) {
	}
    }

    public void testCanReturnBook() throws BookAlreadyBorrowedException, BookNotFoundException {

	Library firstLibrary = new Library("10 Main St.");

	firstLibrary.addBook(new Book("The Da Vinci Code"));
	firstLibrary.addBook(new Book("Le Petit Prince"));
	firstLibrary.addBook(new Book("A Tale of Two Cities"));
	firstLibrary.addBook(new Book("The Lord of the Rings"));

	firstLibrary.borrowBook("The Lord of the Rings");
	assertFalse(firstLibrary.isAvailable("The Lord of the Rings"));
	firstLibrary.returnBook("The Lord of the Rings");
	assertTrue(firstLibrary.isAvailable("The Lord of the Rings"));

    }
}
