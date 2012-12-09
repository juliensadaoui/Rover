package com.soat.rover.model;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Test de l'enumeration CardinalPoint
 * 
 * @author Julien
 *
 */
public class CardinalPointTest
{
	@Test
	public void testValueOf_NorthInstance() 
	{
		CardinalPoint cardinalPoint = CardinalPoint.valueOf('N');
		assertThat(cardinalPoint, notNullValue());
		assertThat(cardinalPoint, equalTo(CardinalPoint.NORTH));
		//assertThat(cardinalPoint.getMove(), is(MoveNorth.class));
	}

	@Test
	public void testValueOf_EastInstance() 
	{
		CardinalPoint cardinalPoint = CardinalPoint.valueOf('E');
		assertThat(cardinalPoint, notNullValue());
		assertThat(cardinalPoint, equalTo(CardinalPoint.EAST));
		//assertThat(cardinalPoint.getMove(), is(MoveEast.class));
	}
	
	@Test
	public void testValueOf_SouthInstance() 
	{
		CardinalPoint cardinalPoint = CardinalPoint.valueOf('S');
		assertThat(cardinalPoint, notNullValue());
		assertThat(cardinalPoint, equalTo(CardinalPoint.SOUTH));
		//assertThat(cardinalPoint.getMove(), is(MoveSouth.class));
	}
	
	@Test
	public void testValueOf_WestInstance() 
	{
		CardinalPoint cardinalPoint = CardinalPoint.valueOf('W');
		assertThat(cardinalPoint, notNullValue());
		assertThat(cardinalPoint, equalTo(CardinalPoint.WEST));
		//assertThat(cardinalPoint.getMove(), is(MoveWest.class));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testValueOf_UnknownInstance()
	{
		CardinalPoint.valueOf('A');
	}
}
