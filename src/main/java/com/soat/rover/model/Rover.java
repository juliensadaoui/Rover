package com.soat.rover.model;

/**
 * 
 * 
 * @author Julien
 *
 */
public class Rover
{
	private static final String separator = " ";
	
	// fields --------------------------
	private Point point;
	private CardinalPoint direction;
	private Plateau plateau;

	/**
	 * Constructor
	 * 
	 * @param plateau
	 */
	public Rover(Plateau plateau)
	{
		this.point = new Point(0,0);
		this.direction = CardinalPoint.NORTH;
		this.plateau = plateau;
	}
	
	/**
	 * Return the position of rover
	 * 
	 * @return <strong>Point</strong> position of rover
	 */
	public Point getPoint() 
	{
		return point;
	}

	/**
	 * Sets the position of rover
	 * 
	 * @param point <strong>Point</strong> position of rover
	 */
	public void setPoint(Point point) 
	{
		this.point = point;
	}
	
	/**
	 * 	Return the direction (cardinal point) of rover
	 * 
	 * @return <strong>CardinalPoint</strong> direction of rover
	 */
	public CardinalPoint getDirection() 
	{
		return direction;
	}

	/**
	 * 	Sets the direction (cardinal point) of rover
	 * 
	 * @param direction <strong>CardinalPoint</strong> direction of rover
	 */
	public void setDirection(CardinalPoint direction) 
	{
		this.direction = direction;
	}
	
	
	/**
	 * Return the plateau on Mars
	 * 
	 * @return <strong>Plateau</strong> plateau on Mars
	 */
	public Plateau getPlateau() 
	{
		return plateau;
	}

	/**
	 * Sets the plateau on Mars
	 * 
	 * @param plateau <strong>Plateau</strong> plateau on Mars
	 */
	public void setPlateau(Plateau plateau)
	{
		this.plateau = plateau;
	}
	
	/**
	 *	Deploy the rover
	 * A rover's position and location is represented by a combination of x and y
	 * co-ordinates and a letter representing one of the four cardinal compass
	 * points
	 * 
	 * @param position <strong>String</strong> position and location
	 */
	public void deploy(String position)
	{
		String [] positionTmp = position.split(separator);
		
		if (positionTmp.length < 3) {
			throw new IllegalArgumentException("Cannot deploy Rover !");
		}
		
		// position of rover
		int x = Integer.parseInt(positionTmp[0]);
		int y = Integer.parseInt(positionTmp[1]);
		this.point = new Point(x, y);
		
		if (!plateau.check(point)) {
			throw new IllegalArgumentException("Cannot deploy Rover !");
		}
		
		// facing Cardinal Point
		this.direction = CardinalPoint.valueOf(positionTmp[2].charAt(0));
	}

	/**
	 * Execute une sequence de commandes sur le robot
	 * 
	 * @param commands <strong>String</strong> series of instructions 
	 * 	telling the rover how to explore the plateau.
	 */
	public void execute(String commands)
	{
		for (char commandLetter : commands.toCharArray())
		{
			CommandType commandType = CommandType.valueOf(commandLetter);
			commandType.execute(this);
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		return point.getX() + " " + point.getY() + " " + this.direction.getLetter();
	}
}
