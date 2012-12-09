package com.soat.rover.model;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CommandTypeTest
{
	@Test
	public void testValueOf_MoveInstance() 
	{
		CommandType commandType = CommandType.valueOf('M');
		assertThat(commandType, notNullValue());
		assertThat(commandType, equalTo(CommandType.MOVE));
		//assertThat(commandType.getCommand(), is(MoveCommand.class));
	}

	@Test
	public void testValueOf_LeftInstance() 
	{
		CommandType commandType = CommandType.valueOf('L');
		assertThat(commandType, notNullValue());
		assertThat(commandType, equalTo(CommandType.LEFT));
		//assertThat(commandType.getCommand(), is(TurnLeftCommand.class));
	}
	
	@Test
	public void testValueOf_RightInstance() 
	{
		CommandType commandType = CommandType.valueOf('R');
		assertThat(commandType, notNullValue());
		assertThat(commandType, equalTo(CommandType.RIGHT));
		//assertThat(commandType.getCommand(), is(TurnRightCommand.class));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testValueOf_UnknownInstance() 
	{
		CommandType.valueOf('E');
	}
}
