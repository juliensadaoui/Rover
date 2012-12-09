package com.soat.rover.command;


import com.soat.rover.model.CardinalPoint;
import com.soat.rover.model.Plateau;
import com.soat.rover.model.Point;
import com.soat.rover.model.Rover;

/**
 * Cette classe execute la commande pour d�placer le 
 * robot d'une case sur le plateau
 * 
 * @author Julien
 *
 */
public class MoveCommand implements ICommand 
{
	/*
	 * (non-Javadoc)
	 * @see com.soat.rover.command.ICommand#execute(com.soat.rover.Rover)
	 */
	@Override
	public void execute(Rover rover) 
	{
		Plateau plateau = rover.getPlateau();
		Point point = rover.getPoint();
		CardinalPoint direction = rover.getDirection();
		
		// execute la commande
		Point newPoint = direction.move(point);
		
		// verifie la position du robot
		if (!plateau.check(newPoint)) {
			throw new IllegalArgumentException("Cannot move rover !");
		}
		
		rover.setPoint(newPoint);
	}
}
