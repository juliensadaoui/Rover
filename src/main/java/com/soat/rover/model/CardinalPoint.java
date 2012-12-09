package com.soat.rover.model;

import com.soat.rover.move.IMove;
import com.soat.rover.move.MoveEast;
import com.soat.rover.move.MoveNorth;
import com.soat.rover.move.MoveSouth;
import com.soat.rover.move.MoveWest;

/**
 * This class represents one of the four cardinal compass points.
 * 
 * @author Julien
 *
 */
public enum CardinalPoint
{
	NORTH('N', new MoveNorth()),
	EAST ('E', new MoveEast()),
	SOUTH('S', new MoveSouth()),
	WEST ('W', new MoveWest());
	
	// fields
	private char letter;
	protected IMove move;
	
	/*
	 * Constructor
	 */
	private CardinalPoint(char letter, IMove move)
	{
		this.letter = letter;
		this.move   = move;
	}
	
	/**
	 * Return the letter representing one of the four cardinal compass points.
	 * 
	 * @return <strong>String</strong> letter 
	 */
	public char getLetter()
	{
		return this.letter;
	}
	
	/**
	 * Return the cardinal point based on the based on the cardinal point letter
	 * 
	 * @param letter <strong> character of a cardinal point
	 * @return <strong>CardinalPoint</strong> cardinal point
	 */
	public static CardinalPoint valueOf(char letter)
	{
		for (CardinalPoint cardinalPoint : CardinalPoint.values())
		{
			if (cardinalPoint.getLetter() == letter) {
				return cardinalPoint;
			}
		}
		
		throw new IllegalArgumentException("Cardinal point unknown");
	}

	public Point move(Point point)   { return move.move(point); }
	public CardinalPoint turnLeft()  { return move.turnLeft();  }
	public CardinalPoint turnRight() { return move.turnRight(); }
}
