package edu.mit.yfe;

public class Marathon {

    public static int findMinTime(int [] times) throws EmptyInputArrayException, NegativeTimeException{
	int minTimeIndex = 0;
	if (times.length == 0) {
	    throw new EmptyInputArrayException();
	} 
	
	for (int i = 0; i < times.length; ++i) {
	    if (times[i] < times[minTimeIndex]) {
		if (times[i] < 0) {
		    throw new NegativeTimeException();
		}
		minTimeIndex = i;
	    }
	}
	
	return minTimeIndex;
    }

    public static int findSecondMinTime(int [] times) throws EmptyInputArrayException, NegativeTimeException, NotEnoughScoresInInputArrayException{
	int minTimeIndex = findMinTime(times);
	int secondMinTimeIndex = minTimeIndex != 0 ? 0 : 1;
	if (times.length == 1) {
	    throw new NotEnoughScoresInInputArrayException();
	} 
	
	for (int i = 0; i < times.length; ++i) {
	    if ((times[i] < times[secondMinTimeIndex]) && (i != minTimeIndex)) {
		secondMinTimeIndex = i;
	    }
	}
	
	return secondMinTimeIndex;
    }
    
    public static void main(String [] arguments) throws EmptyInputArrayException, NegativeTimeException, NotEnoughScoresInInputArrayException {
	String[] names ={
	    "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex",
	    "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda",
	    "Aaron", "Kate"
	};
	
	int[] times ={
	    341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299,
	    343, 317, 265
	};

	for (int i = 0; i < names.length; i++) {
	    System.out.println(names[i]+ ": " + times[i]);
	}
		
	int bestIndex = findMinTime(times);
	int secondBestIndex = findSecondMinTime(times);
	System.out.println("\n ===== PODIUM =====\n");
	System.out.println("Best: " + names[bestIndex]+ ": " + times[bestIndex]);
	System.out.println("Second Best: " + names[secondBestIndex]+ ": " + times[secondBestIndex]);

    }

}
