package edu.mit.yfe;


public class FooCorporation
{

    static double computeTotalPay(double basePay, double hoursWorked) throws YouWorkTooMuchException {
	if (hoursWorked > 60.0){
	    throw new YouWorkTooMuchException();
	}

	double overtime = hoursWorked - 40 > 0 ? hoursWorked - 40 : 0;
	double regular = hoursWorked <= 40 ? hoursWorked : 40; 
	double salary = (basePay * regular) + (1.5*basePay * overtime);
	
	return salary;
    }
    
    public static void main( String[] args ) throws YouWorkTooMuchException
    {
	System.out.println( "\t\tBase Pay\tHours Worked\tSalary" );
        System.out.println( "----------------------------------------------------------" );
	System.out.println( "Employee 1\t\t$7.50\t\t35\t" + computeTotalPay(7.50,35) );
	System.out.println( "Employee 2\t\t$8.20\t\t47\t" + computeTotalPay(8.20,47) );
    }
}

/*
	    System..println("Error: Foo Corp requires that an employee not work more than 60 hours in a week");	
 */
