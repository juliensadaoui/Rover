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
 * Test de la classe MoveCommand permettant de lancer
 * la commande pour déplacer le robot.
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
public class MoveCommandTest
{
	private ICommand command;
	private CardinalPoint cardinalPoint;
	
	@Before
	public void setUp() throws Exception {
		command = new MoveCommand();
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

		// given
		Plateau plateau  = mock(Plateau.class);
		Point   point    = new Point(3,1),
				newPoint = new Point(3,0),
				resPoint = null;		
		Rover rover = new Rover(plateau);
		rover.setPoint(point);
		rover.setDirection(cardinalPoint);
			
		// when
		when(cardinalPoint.move(point)).thenReturn(newPoint);
		when(plateau.check(newPoint)).thenReturn(true);
		command.execute(rover);
		
		// then
		verify(cardinalPoint).move(point);
		verify(plateau).check(newPoint);
		
		resPoint = rover.getPoint();
		assertThat(resPoint, notNullValue());
		assertThat(resPoint, not(sameInstance(point)));
		assertThat(resPoint.getX(), equalTo(3));
		assertThat(resPoint.getY(), equalTo(0));
	}

	/**
	 * Test de la méthode execute()
	 * Une exception est levée suite au mauvais déplacement
	 * du robot sur le plateau.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testExecute_Exception()
	{
		// mock
		cardinalPoint = PowerMockito.mock(CardinalPoint.class);
		
		// given
		Plateau plateau  = mock(Plateau.class);
		Point   point    = new Point(0,4),
				newPoint = new Point(-1,4);		
		Rover rover = new Rover(plateau);
		rover.setPoint(point);
		rover.setDirection(cardinalPoint);
			
		// when
		when(cardinalPoint.move(point)).thenReturn(newPoint);
		when(plateau.check(newPoint)).thenReturn(false);
		
		try {
			command.execute(rover);
		}
		// utilisation du mot-clé finally pour vérifier
		// que les méthodes sont bien appelées
		finally {
			// then
			verify(cardinalPoint).move(point);
			verify(plateau).check(newPoint);
		}
	}
}
