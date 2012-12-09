package com.soat.rover.model;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Before;
import org.junit.Test;

public class PlateauTest 
{
	private Plateau plateau;
	
	@Before
	public void setUp() throws Exception
	{
		plateau = new Plateau(8, 8);
	}

	/**
	 * Test la méthode setWidth() 
	 */
	@Test
	public void testSetWidth_Success()
	{
		plateau.setWidth(6);
		assertThat(plateau.getWidth(), equalTo(6));
	}

	/**
	 * Test la méthode setHeigth() 
	 */
	@Test
	public void testSetHeigth_Success() 
	{
		plateau.setHeigth(4);
		assertThat(plateau.getHeigth(), equalTo(4));
	}

	@Test
	public void testCheck_Success() 
	{
		Point point = new Point(7,0);
		boolean res = plateau.check(point);
		assertThat(res, equalTo(true));
	}

	/**
	 * Test la méthode check()
	 * Erreur suite à une valeur de y inferieure au min
	 */
	@Test
	public void testCheck_FailXMin() 
	{
		Point point = new Point(-1,4);
		boolean res = plateau.check(point);
		assertThat(res, equalTo(false));
	}

	/**
	 * Test la méthode check()
	 * Erreur suite à une valeur de y superieure au max
	 */
	@Test
	public void testCheck_FailXMax() 
	{
		Point point = new Point(11,4);
		boolean res = plateau.check(point);
		assertThat(res, equalTo(false));
	}
	
	/**
	 * Test la méthode check()
	 * Erreur suite à une valeur de y inferieure au min
	 */
	@Test
	public void testCheck_FailYMin() 
	{
		Point point = new Point(5,-1);
		boolean res = plateau.check(point);
		assertThat(res, equalTo(false));
	}
	
	/**
	 * Test la méthode check()
	 * Erreur suite à une valeur de y superieure au max
	 */
	@Test
	public void testCheck_FailYMax() 
	{
		Point point = new Point(8,11);
		boolean res = plateau.check(point);
		assertThat(res, equalTo(false));
	}
}
