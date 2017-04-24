package edu.mit.yfe;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for Book
 */
public class BookTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public BookTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( BookTest.class );
    }

    public void testCanGetTitle()
    {
	Book example = new Book("The Da Vinci Code");
	assertEquals("The Da Vinci Code", example.getTitle());
    }

    public void testANewBookIsNotBorrowed()
    {
	Book example = new Book("The Da Vinci Code");
	assertFalse(example.isBorrowed()); 
    }

    public void testARentedBookIsMarkedAsBorrowed() {
	Book example = new Book("The Da Vinci Code");
	example.rented();
	assertTrue(example.isBorrowed());
    }

    public void testAReturnedBookIsNotMarkedAsBorrowed() {
	Book example = new Book("The Da Vinci Code");
	example.rented();
	example.returned();
	assertFalse(example.isBorrowed()); 
    }
}
