package com.soat.rover.move;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.soat.rover.model.CardinalPoint;
import com.soat.rover.model.Point;

/**
 * Test la classe MoveSouth
 * 
 * @author Julien
 *
 */
public class MoveSouthTest
{
	private IMove move;
	
	@Before
	public void setUp() throws Exception 
	{
		move = new MoveSouth();
	}

	/**
	 *  Test la méthode move()
	 *  
	 *  Parameters: point(1,1)
	 */
	@Test
	public void testMove_Success()
	{
		Point point, newPoint;
		point = new Point(1,1);
		
		newPoint = move.move(point);
		
		// tests that values are correct
		assertThat(newPoint, notNullValue());
		assertThat(newPoint, not(sameInstance(point)));
		assertThat(newPoint.getX(), equalTo(1));
		assertThat(newPoint.getY(), equalTo(0));
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
		assertThat(cardinalPoint, equalTo(CardinalPoint.EAST));
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
		assertThat(cardinalPoint, equalTo(CardinalPoint.WEST));
	}
}
