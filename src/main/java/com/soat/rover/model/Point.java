package com.soat.rover.model;

/**
 * A point is represented by a combination of x and y co-ordinates
 * 
 * @author Julien
 *
 */
public class Point 
{
	private int x;
	private int y;
	
	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	/**
	 * Return the x-coordinate of a point 
	 * 
	 * @return <strong>int</strong> the x-coordinate of a point 
	 */
	public int getX() {
		return x;
	}

	/**
	 * Return the y-coordinate of a point 
	 * 
	 * @return <strong>String</strong> y-coordinate of a point 
	 */
	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
}
