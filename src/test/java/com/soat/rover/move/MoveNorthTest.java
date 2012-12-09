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
 * Test de la classe MoveNorth
 * 
 * @author Julien
 *
 */
public class MoveNorthTest 
{

	private IMove move;
	
	@Before
	public void setUp() throws Exception 
	{
		move = new MoveNorth();
	}

	/**
	 *  Test la méthode move()
	 *  
	 *  Parameters: point(2,3)
	 */
	@Test
	public void testMove_Success()
	{
		// parameter
		Point point, newPoint;
		point = new Point(2,3);
		
		newPoint = move.move(point);
		
		// Tests that values are correct.
		assertThat(newPoint, notNullValue());
		assertThat(newPoint, not(sameInstance(point)));
		assertThat(newPoint.getX(), equalTo(2));
		assertThat(newPoint.getY(), equalTo(4));
	}

	/**
	 *  Test la méthode turnLeft()
	 */
	@Test
	public void testTurnLeft_Success() 
	{
		CardinalPoint cardinalPoint = move.turnLeft();
		
		// Tests that values are correct.
		assertThat(cardinalPoint, notNullValue());
		assertThat(cardinalPoint, equalTo(CardinalPoint.WEST));
	}

	/**
	 *  Test la méthode turnRight()
	 */
	@Test
	public void testTurnRight_Success() 
	{
		CardinalPoint cardinalPoint = move.turnRight();
		
		// Tests that values are correct.
		assertThat(cardinalPoint, notNullValue());
		assertThat(cardinalPoint, equalTo(CardinalPoint.EAST));
	}

}
