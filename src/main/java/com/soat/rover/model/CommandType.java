package com.soat.rover.model;

import com.soat.rover.command.MoveCommand;
import com.soat.rover.command.TurnLeftCommand;
import com.soat.rover.command.TurnRightCommand;

/**
 * 	Represente les types de commandes du robot
 * 
 * @author Julien
 *
 */
public enum CommandType 
{
	MOVE ('M') { 
		@Override 
		public void execute(Rover rover) { 
			(new MoveCommand()).execute(rover); 
		} 
	},
	
	LEFT ('L') {
		@Override
		public void execute(Rover rover) {
			(new TurnLeftCommand()).execute(rover);
		}
	},
	
	RIGHT('R') {
		@Override
		public void execute(Rover rover) {
			(new TurnRightCommand()).execute(rover);
		}
	};
	
	// fields
	private char letter;
	
	/**
	 * Constructeur priv�
	 * 
	 * @param letter <strong>String</strong> lettre associ�e au type de commande
	 * @param command <strong>ICommand</strong> commande
	 */
	private CommandType(char letter)
	{
		this.letter  = letter;
	}
	
	/**
	 * Retourne la lettre associ� � la type de commande
	 * 
	 * @return <strong>String</strong> lettre associ� � la type de commande
	 */
	public char getLetter()
	{
		return this.letter;
	}
	
	/**
	 * Retourne le type de commande � partir de la lettre
	 * de la commande
	 * 
	 * @param letter <strong>String</strong> lettre associ�e au type de commande
	 * @return <strong>CommandType</strong> type de commande
	 */
	public static CommandType valueOf(char letter)
	{
		for (CommandType command : CommandType.values())
		{
			if (command.getLetter() == letter) {
				return command;
			}
		}
		
		throw new IllegalArgumentException("command unknown");
	}
	
	/**
	 * Execute la commande associée à la commande type
	 * 
	 * @param rover
	 */
	public abstract void execute(Rover rover);
}
