package com.soat.rover.move;

import com.soat.rover.model.CardinalPoint;
import com.soat.rover.model.Point;

public interface IMove 
{
	/**
	 * Move forward the rover of one grid point.
	 * 
	 * @param point <strong>Point</strong>
	 * @return <strong>Point</strong>
	 */
	public Point move(Point point);
	
	/**
	 * The rover spin 90 degrees left, without moving from its current spot.
	 * 
	 * @return <strong>CardinalPoint</strong> new cardinal point
	 */
	public CardinalPoint turnLeft();
	
	/**
	 * The rover spin 90 degrees right, without moving from its current spot.
	 * 
	 * @return <strong>CardinalPoint</strong> new cardinal point
	 */
	public CardinalPoint turnRight();
}
