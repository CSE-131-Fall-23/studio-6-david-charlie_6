package studio6;

import java.lang.reflect.Array;

import edu.princeton.cs.introcs.StdDraw;

public class RecursiveMethods {

	/**
	 * Computes the geometric sum for the first n terms in the series
	 * 
	 * @param n the number of terms to include in the sum
	 * @return the sum of the first n terms of the geometric series (1/2 + 1/4 + 1/8
	 *         ...)
	 */
	public static double geometricSum(int n) {
		if (n==0) return 0;
		else return Math.pow(0.5, n)+geometricSum(n-1);
	}

	/**
	 * This method uses recursion to compute the greatest common divisor
	 * for the two input values
	 * 
	 * @param p first operand
	 * @param q second operand
	 * @return greatest common divisor of p and q
	 */
	public static int gcd(int p, int q) {
		if (p<q) return gcd(q,p);
		if (p%q==0) return q;
		return gcd(q,p%q);
	}

	

	/**
	 * This method uses recursion to create a reverse of the given array
	 * 
	 * @param array the array to create a reverse of, not to be mutated
	 * @return an array with the same data as the input but it reverse order
	 */
	public static int[] reverse(int[] array,int[] newArray,int index,int upperbound)
	{
		if (index>upperbound) return newArray;
		newArray[index]=array[upperbound-index];
		return reverse(array,newArray,index+1,upperbound);
	}
	
	public static int[] toReversed(int[] array) {
		int[] newArray = new int[array.length];
		if (newArray.length<=0) return newArray;
		else newArray=reverse(array,newArray,0,array.length-1);
		return newArray;
	}

	/**
	 * @param xCenter                       x-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param yCenter                       y-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param radius                        radius of the circle at the current
	 *                                      depth
	 * @param radiusMinimumDrawingThreshold radius above which drawing should occur
	 */
	public static void circlesUponCircles(double xCenter, double yCenter, double radius,
			double radiusMinimumDrawingThreshold) {
		if (radius<=radiusMinimumDrawingThreshold) return;
		StdDraw.circle(xCenter, yCenter, radius);
		circlesUponCircles(xCenter-radius,yCenter,radius/3.0,radiusMinimumDrawingThreshold);
		circlesUponCircles(xCenter,yCenter+radius,radius/3.0,radiusMinimumDrawingThreshold);
		circlesUponCircles(xCenter+radius,yCenter,radius/3.0,radiusMinimumDrawingThreshold);
		circlesUponCircles(xCenter,yCenter-radius,radius/3.0,radiusMinimumDrawingThreshold);
		// FIXME
	}
	
	public static void main(String args[])
	{
		int[] array= {7,7,7,93,11};
		int[] array1 = toReversed(array);
		for (int i=0; i<=array1.length-1; i++)
		{
			System.out.println(array1[i]);
		}
	}

}
