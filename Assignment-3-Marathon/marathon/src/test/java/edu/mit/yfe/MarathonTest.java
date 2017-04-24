package edu.mit.yfe;

import static org.junit.Assert.*;
import org.junit.Test;

public class MarathonTest {
    

    public void testFindMinTime1() throws EmptyInputArrayException, NegativeTimeException {
	int input [] = {0,0,0,0};
	assertEquals(Marathon.findMinTime(input), 0);
    }
    
    
    public void testFindMinTime2() throws EmptyInputArrayException, NegativeTimeException {
	int input [] = {12};
	assertEquals(Marathon.findMinTime(input), 0);
    }


    public void testFindMinTime3() throws EmptyInputArrayException, NegativeTimeException {
	int input [] = {5,7,0};
	assertEquals(Marathon.findMinTime(input), 2);
    }


    public void testFindMinTime4() throws EmptyInputArrayException, NegativeTimeException {
	int input [] = {3,2,4};
	assertEquals(Marathon.findMinTime(input), 1);
    }
    
    
    public void testFindMinTime5() throws NegativeTimeException {
	int input [] = {};
	try {
	    Marathon.findMinTime(input);
	    fail("Failed to throw correct exception");
	} catch (EmptyInputArrayException e) {}
    }
    
    public void testFindMinTime6() throws EmptyInputArrayException {
	int input [] = {0,6,-6,8};
	try {
	    Marathon.findMinTime(input);
	    fail("Failed to throw correct exception");
	} catch (NegativeTimeException e) {}
    }
    
    public void testFindSecondMinTime1() throws EmptyInputArrayException, NegativeTimeException, NotEnoughScoresInInputArrayException {
	int input [] = {0,0,0,0};
	assertEquals(Marathon.findSecondMinTime(input), 1);
    }
    
    public void testFindSecondMinTime2() throws EmptyInputArrayException, NegativeTimeException, NotEnoughScoresInInputArrayException {
	int input [] = {5, 7, 0};
	assertEquals(Marathon.findSecondMinTime(input), 0);
    }

    public void testFindSecondMinTime3() throws EmptyInputArrayException, NegativeTimeException, NotEnoughScoresInInputArrayException {
	int input [] = {3, 2, 4};
	assertEquals(Marathon.findSecondMinTime(input), 0);
    }
    
    public void testFindSecondMinTime4() throws EmptyInputArrayException, NotEnoughScoresInInputArrayException {
	int input [] = {0, 6, -6, 8};
	try {
	    Marathon.findSecondMinTime(input);
	    fail("Failed to throw correct exception");
	} catch (NegativeTimeException e) {}
    }
	
    
    public void testFindSecondMinTime5() throws NotEnoughScoresInInputArrayException, NegativeTimeException {
	int input [] = {};
	try {
	    Marathon.findSecondMinTime(input);
	    fail("Failed to throw correct exception");
	} catch (EmptyInputArrayException e) {}
    }

    public void testFindSecondMinTime6() throws NegativeTimeException, EmptyInputArrayException {
	int input [] = {12};
	try {
	    Marathon.findSecondMinTime(input);
	    fail("Failed to throw correct exception");
	} catch (NotEnoughScoresInInputArrayException e) {}
    }
    
}
