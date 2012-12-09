package com.soat.rover.model;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Test la classe Rover
 * 
 * @author Julien
 *
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(CommandType.class)
public class RoverTest
{
	private Rover   rover;
	private Plateau plateau;
	
	@Before
	public void setUp() throws Exception 
	{
		plateau = new Plateau(5, 5);
		rover   = new Rover(plateau);
	}

	/**
	 * Test la méthode setDirection()
	 */
	@Test
	public void testSetDirection_Success()
	{
		CardinalPoint cardinalPoint = CardinalPoint.NORTH;
		rover.setDirection(cardinalPoint);
		
		// tests that the values is correct
		CardinalPoint resCardinalPoint = rover.getDirection();
		assertThat(resCardinalPoint, notNullValue());
		assertThat(resCardinalPoint, sameInstance(cardinalPoint));
		assertThat(resCardinalPoint, equalTo(CardinalPoint.NORTH));
	}
	
	/**
	 * Test la méthode setPoint()
	 */
	@Test
	public void testSetPoint_Success()
	{
		Point point = new Point(5, 2);
		rover.setPoint(point);
		
		// tests that the values is correct
		Point resPoint = rover.getPoint();
		assertThat(resPoint, notNullValue());
		assertThat(resPoint, sameInstance(point));
		assertThat(resPoint.getX(), equalTo(5));
		assertThat(resPoint.getY(), equalTo(2));
	}

	/**
	 * Test la méthode setPlateau()
	 */
	@Test
	public void testSetPlateau_Success()
	{
		Plateau plateau = new Plateau(10, 10);
		rover.setPlateau(plateau);
		
		// tests that the values is correct
		Plateau resPlateau = rover.getPlateau();
		assertThat(resPlateau, notNullValue());
		assertThat(resPlateau, sameInstance(plateau));
		assertThat(resPlateau.getWidth(), equalTo(10));
		assertThat(resPlateau.getHeigth(), equalTo(10));
	}
	
	/**
	 * Test la méthode deploy()
	 */
	@Test
	public void testDeploy_Success() 
	{
		rover.deploy("1 2 N");
		
		// tests that the values are correct
		Point point = rover.getPoint();
		assertThat(point, notNullValue());
		assertThat(point.getX(), equalTo(1));
		assertThat(point.getY(), equalTo(2));
		
		CardinalPoint cardinalPoint = rover.getDirection();
		assertThat(cardinalPoint, notNullValue());
		assertThat(cardinalPoint, equalTo(CardinalPoint.NORTH));
	}

	/**
	 * Test la méthode deploy()
	 * Pas assez de parametres
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDeploy_Fail1() 
	{
		rover.deploy("1 2");
	}

	/**
	 * Test la méthode deploy()
	 * Paramètre du point y incorrect
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDeploy_Fail2() 
	{
		rover.deploy("1 A S");
	}
	
	/**
	 * Test la méthode deploy()
	 * Paramètre du point cardinal incorrect
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDeploy_Fail3() 
	{
		rover.deploy("1 2 A");
	}
	
	/**
	 * Test de la méthode execute()
	 * Pas d'utilisation de mocks
	 */
	@Test
	public void testExecute_SuccessWithoutMock() 
	{
		rover.deploy("3 4 S");
		rover.execute("LMLMRMRMM");
		
		// tests that the values are correct
		Point point = rover.getPoint();
		assertThat(point, notNullValue());
		assertThat(point.getX(), equalTo(5));
		assertThat(point.getY(), equalTo(3));
		
		CardinalPoint cardinalPoint = rover.getDirection();
		assertThat(cardinalPoint, notNullValue());
		assertThat(cardinalPoint, equalTo(CardinalPoint.SOUTH));
	}
	
	/**
	 * Test de la méthode execute()
	 * Utilisation des mocks pour vérifier que les méthodes
	 * sont bien appelées.
	 */
	@Test
	public void testExecute_SuccessWithMock()
	{
		// mock
		CommandType moveCommandType  = PowerMockito.mock(CommandType.class),
		            leftCommandType  = PowerMockito.mock(CommandType.class),
		            rightCommandType = PowerMockito.mock(CommandType.class);
		
		// when
		PowerMockito.mockStatic(CommandType.class);
        PowerMockito.when(CommandType.valueOf('M')).thenReturn(moveCommandType);
        PowerMockito.when(CommandType.valueOf('L')).thenReturn(leftCommandType);
        PowerMockito.when(CommandType.valueOf('R')).thenReturn(rightCommandType);
        
        doNothing().when(moveCommandType).execute(rover);
        doNothing().when(leftCommandType).execute(rover);
        
        // execute
		rover.deploy("1 2 N");
		rover.execute("LMLMLMLMM");

        // then
        PowerMockito.verifyZeroInteractions(CommandType.valueOf('R'));
        verify(moveCommandType, Mockito.times(5)).execute(rover);
        verify(leftCommandType, Mockito.times(4)).execute(rover);        
	}
	
	/**
	 * Test de la méthode execute()
	 * Exception levée suite au mauvais déplacement
	 * du robot
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testExecute_Fail() 
	{
		rover.deploy("3 4 S");
		rover.execute("LMLMRMMLM");
	}
}
