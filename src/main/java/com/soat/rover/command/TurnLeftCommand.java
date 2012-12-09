package com.soat.rover.command;

import com.soat.rover.model.CardinalPoint;
import com.soat.rover.model.Rover;

/**
 * Cette classe execute la commande pour touner le robot
 * � gauche.
 * 
 * @author Julien
 *
 */
public class TurnLeftCommand implements ICommand 
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
		CardinalPoint futureDirection = currentDirection.turnLeft();
		rover.setDirection(futureDirection);
	}
}
