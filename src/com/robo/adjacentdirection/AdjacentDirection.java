package com.robo.adjacentdirection;

import com.robo.common.enumconstants.Direction;
import com.robo.common.robotinterface.Robo;

public interface AdjacentDirection {
	
	public Direction getRightAdjacentDirection(Robo robo);
	public Direction getLeftAdjacentDirection(Robo robo);
	public Direction getForwardAdjacentDirection(Robo robo);
	public Direction getBackwardAdjacentDirection(Robo robo);

}
