package com.soat.rover.move;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.soat.rover.model.CardinalPoint;
import com.soat.rover.model.Point;

/**
 * Test la classe MoveEast
 * 
 * @author Julien
 *
 */
public class MoveEastTest 
{
	private IMove move;
	
	@Before
	public void setUp() throws Exception 
	{
		move = new MoveEast();
	}

	/**
	 *  Test la méthode move()
	 *  
	 *  Parameters: point(4,1)
	 */
	@Test
	public void testMove_Success()
	{
		Point point, newPoint;
		point = new Point(4,1);
		
		newPoint = move.move(point);
		
		// tests that values are correct
		assertThat(newPoint, notNullValue());
		assertThat(newPoint, not(sameInstance(point)));
		assertThat(newPoint.getX(), equalTo(5));
		assertThat(newPoint.getY(), equalTo(1));
	}

	/**
	 *  Test la méthode turnLeft()
	 */
	@Test
	public void testTurnLeft_Success() 
	{
		CardinalPoint cardinalPoint = move.turnLeft();
		
		// tests that values are correct
		assertThat(cardinalPoint, notNullValue());
		assertThat(cardinalPoint, equalTo(CardinalPoint.NORTH));
	}

	/**
	 *  Test la méthode turnRight()
	 */
	@Test
	public void testTurnRight_Success() 
	{
		CardinalPoint cardinalPoint = move.turnRight();
		
		// tests that values are correct
		assertThat(cardinalPoint, notNullValue());
		assertThat(cardinalPoint, equalTo(CardinalPoint.SOUTH));
	}
}
