package com.soat.rover.move;

import com.soat.rover.model.CardinalPoint;
import com.soat.rover.model.Point;

public class MoveSouth implements IMove
{
	/*
	 * (non-Javadoc)
	 * @see com.soat.rover.direction.IMovingDirection#move(com.soat.rover.Point)
	 */
	@Override
	public Point move(Point point) 
	{
		int y = point.getY() - 1;
		return new Point(point.getX(), y);
	}

	/*
	 * (non-Javadoc)
	 * @see com.soat.rover.direction.IMovingDirection#turnLeft()
	 */
	@Override
	public CardinalPoint turnLeft() 
	{
		return CardinalPoint.EAST;
	}

	/*
	 * (non-Javadoc)
	 * @see com.soat.rover.direction.IMovingDirection#turnRight()
	 */
	@Override
	public CardinalPoint turnRight() 
	{
		return CardinalPoint.WEST;
	}
}
