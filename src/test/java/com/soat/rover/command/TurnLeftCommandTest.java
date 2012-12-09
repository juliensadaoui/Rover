package com.soat.rover.command;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.soat.rover.model.CardinalPoint;
import com.soat.rover.model.Plateau;
import com.soat.rover.model.Point;
import com.soat.rover.model.Rover;

/**
 * Test de la classe TurnLeftCommand permettant de lancer
 * la commande pour tourner le robot de 90° à gauche
 * 
 * Utilisation des mocks pour isoler le test unitaire.
 * Powermock API permet de créer des mocks sur les méthodes
 * statiques et les enums.
 * 
 * @author Julien
 *
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(CardinalPoint.class)
public class TurnLeftCommandTest 
{
	private ICommand command;
	private CardinalPoint cardinalPoint;
	
	@Before
	public void setUp() throws Exception {
		command = new TurnLeftCommand();
		cardinalPoint = PowerMockito.mock(CardinalPoint.class);
	}

	/**
	 * Test de la méthode execute()
	 */
	@Test
	public void testExecute_Success()
	{
		// mock
		cardinalPoint = PowerMockito.mock(CardinalPoint.class);
		Plateau plateau  = mock(Plateau.class);
		Point   point    = mock(Point.class);		

		// given
		CardinalPoint resCardinalPoint = null;
		Rover rover = new Rover(plateau);
		rover.setPoint(point);
		rover.setDirection(cardinalPoint);
			
		// when
		when(cardinalPoint.turnLeft()).thenReturn(CardinalPoint.SOUTH);
		command.execute(rover);
		
		// then
		verify(cardinalPoint).turnLeft();
		
		resCardinalPoint = rover.getDirection();
		assertThat(resCardinalPoint, notNullValue());
		assertThat(resCardinalPoint, not(sameInstance(cardinalPoint)));
		assertThat(resCardinalPoint, equalTo(CardinalPoint.SOUTH));
	}
}
