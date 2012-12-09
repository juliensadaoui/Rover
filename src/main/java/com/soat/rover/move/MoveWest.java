package com.soat.rover.move;

import com.soat.rover.model.CardinalPoint;
import com.soat.rover.model.Point;

public class MoveWest implements IMove 
{
	/*
	 * (non-Javadoc)
	 * @see com.soat.rover.direction.IMovingDirection#move(com.soat.rover.Point)
	 */
	@Override
	public Point move(Point point) 
	{
		int x = point.getX() - 1;
		return new Point(x, point.getY());
	}

	/*
	 * (non-Javadoc)
	 * @see com.soat.rover.direction.IMovingDirection#turnLeft()
	 */
	@Override
	public CardinalPoint turnLeft()
	{
		return CardinalPoint.SOUTH;
	}

	/*
	 * (non-Javadoc)
	 * @see com.soat.rover.direction.IMovingDirection#turnRight()
	 */
	@Override
	public CardinalPoint turnRight()
	{
		return CardinalPoint.NORTH;
	}
}
