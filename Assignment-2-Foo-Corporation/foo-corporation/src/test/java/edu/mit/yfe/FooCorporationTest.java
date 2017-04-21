package edu.mit.yfe;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for FooCorporation
 */
public class FooCorporationTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public FooCorporationTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( FooCorporationTest.class );
    }


    public void testFooCorporationLessThan40HoursWorkWeek() throws YouWorkTooMuchException 
    {
	double salary = FooCorporation.computeTotalPay(7.50, 35);
	assertTrue( salary < 263 && salary > 262);
    }

    public void testFooCorporationMoreThan40HoursWorkWeekButLessThan60HoursWorkWeek() throws YouWorkTooMuchException 
    {
	double salary = FooCorporation.computeTotalPay(8.20, 47);
	assertTrue( salary < 415 && salary > 414);
    }

    public void testFooCorporationMoreThan60HoursWorkWeek()
    {
	try {
	    double salary = FooCorporation.computeTotalPay(10.00, 73);
	    fail("Exception not thrown!");
	} catch(YouWorkTooMuchException crazyGuy){}
    }
}
