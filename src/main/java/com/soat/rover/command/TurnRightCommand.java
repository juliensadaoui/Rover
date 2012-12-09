package com.soat.rover.command;

import com.soat.rover.model.CardinalPoint;
import com.soat.rover.model.Rover;

/**
 * Cette classe execute la commande pour touner le robot
 * � droite.
 * 
 * @author Julien
 *
 */
public class TurnRightCommand implements ICommand
{
	/*
	 * (non-Javadoc)
	 * @see com.soat.rover.command.ICommand#execute(com.soat.rover.Rover)
	 */
	@Override
	public void execute(Rover rover)
	{
		// execute la commande
		CardinalPoint currentDirection = rover.getDirection();
		CardinalPoint futureDirection  = currentDirection.turnRight();
		rover.setDirection(futureDirection);
	}
}
