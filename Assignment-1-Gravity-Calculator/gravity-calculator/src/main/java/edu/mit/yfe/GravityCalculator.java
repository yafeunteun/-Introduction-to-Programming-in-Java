package edu.mit.yfe;


public class GravityCalculator
{

    double gravity = 0.0;

    public double positionInMetersAfterFallingFor(double fallingTimeInSeconds, 	double initialPosition, double initialVelocity) {

	double finalPosition = 0.0;

	finalPosition = 0.5*this.gravity*fallingTimeInSeconds*fallingTimeInSeconds;
	finalPosition = finalPosition + fallingTimeInSeconds*initialVelocity;
	finalPosition = finalPosition + initialPosition;
	
	return finalPosition;
    }

    public GravityCalculator(double gravity) {
	this.gravity = -9.81;
    }
    
    public static void main(String [] args) {
	
	GravityCalculator GC = new GravityCalculator(-9.81);
	double initialPosition = 0.0;
	double initialVelocity = 0.0;
	double fallingTime = 10.0;
	
	double finalPosition = GC.positionInMetersAfterFallingFor(fallingTime, initialPosition, initialVelocity);

	System.out.println("The object's position after " + fallingTime + " seconds is " + finalPosition + "m.");
    }
}
