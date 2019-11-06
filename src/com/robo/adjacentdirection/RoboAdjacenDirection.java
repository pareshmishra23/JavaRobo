package com.robo.adjacentdirection;

import com.robo.common.enumconstants.Direction;
import com.robo.common.robotinterface.Robo;

public class RoboAdjacenDirection implements AdjacentDirection
{
	@Override
	public Direction getRightAdjacentDirection(Robo mRobo) 
	{
		Direction direction=null;
		;
		if(Direction.NORTH.equals(mRobo.getFacingTowards()))
		{
			direction=Direction.EAST;
		}
		else if(Direction.EAST.equals(mRobo.getFacingTowards()))
		{
			direction=Direction.SOUTH;
		}
		else if(Direction.SOUTH.equals(mRobo.getFacingTowards()))
		{
			direction=Direction.WEST;
		}
		else if(Direction.WEST.equals(mRobo.getFacingTowards()))
		{
			direction=Direction.NORTH;
		}
		return direction;
	}

	@Override
	public Direction getLeftAdjacentDirection(Robo mRobo) 
	{
		Direction direction=null;
		
		if(Direction.NORTH.equals(mRobo.getFacingTowards()))
		{
			direction=Direction.WEST;
		}
		else if(Direction.EAST.equals(mRobo.getFacingTowards()))
		{
			direction=Direction.NORTH;
		}
		else if(Direction.SOUTH.equals(mRobo.getFacingTowards()))
		{
			direction=Direction.EAST;
		}
		else if(Direction.WEST.equals(mRobo.getFacingTowards()))
		{
			direction=Direction.SOUTH;
		}
		return direction;
	}

	@Override
	public Direction getForwardAdjacentDirection(Robo mRobo) 
	{
		return mRobo.getFacingTowards();
	}

	@Override
	public Direction getBackwardAdjacentDirection(Robo mRobo) 
	{
		Direction direction=null;
		if(Direction.NORTH.equals(mRobo.getFacingTowards()))
		{
			direction=Direction.SOUTH;
		}
		else if(Direction.EAST.equals(mRobo.getFacingTowards()))
		{
			direction=Direction.WEST;
		}
		else if(Direction.SOUTH.equals(mRobo.getFacingTowards()))
		{
			direction=Direction.NORTH;
		}
		else if(Direction.WEST.equals(mRobo.getFacingTowards()))
		{
			direction=Direction.EAST;
		}
		return direction;
	}
}