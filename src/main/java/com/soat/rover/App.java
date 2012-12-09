package com.soat.rover;

import com.soat.rover.model.IPlateau;
import com.soat.rover.model.Plateau;
import com.soat.rover.model.Rover;

/**
 * Cette classe permet de tester le déplacements des robots
 * 
 * @author Julien
 *
 */
public class App 
{
	/**
	 * Method main
	 * 
	 * @param args
	 */
	public static void main(String [] args)
	{
		Rover roverOne, roverTwo;
		System.out.println("Test Input:");
		
		// initialisation du plateau
		IPlateau plateau = new Plateau(5, 5);
		System.out.println("5 5 ");
		
		// D�ploiement du premier robot
		roverOne = new Rover(plateau);
		roverOne.deploy("1 2 N");
		System.out.println("1 2 N");		
		
		// D�placement du premier robot
		roverOne.execute("LMLMLMLMM");
		System.out.println("LMLMLMLMM");
		
		// D�ploiement du deuxi�me robot
		roverTwo = new Rover(plateau);
		roverTwo.deploy("3 3 E");
		System.out.println(roverTwo.toString());
		
		// D�placement du deuxi�me robot
		roverTwo.execute("MMRMMRMRRM");
		System.out.println("MMRMMRMRRM");
		
		
		// affiche la position finale des robots
		System.out.println("Expected Output:");
		System.out.println(roverOne.toString());
		System.out.println(roverTwo.toString());
	}
}
