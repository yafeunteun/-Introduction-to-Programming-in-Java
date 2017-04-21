package edu.mit.yfe;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for GravityCalculator
 */
public class GravityCalculatorTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public GravityCalculatorTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( GravityCalculatorTest.class );
    }


    public void testGravityCalculator()
    {
	GravityCalculator GC = new GravityCalculator(-9.81);
	
	double initialPosition = 0.0;
	double initialVelocity = 0.0;
	
	double finalPosition = GC.positionInMetersAfterFallingFor(10, initialPosition, initialVelocity);
	
        assertTrue( finalPosition > -491.0 && finalPosition < -490.0 );
    }
}
