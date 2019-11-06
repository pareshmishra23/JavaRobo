package com.robo.common.robotinterface;

import com.robo.common.enumconstants.Direction;



public interface Robo {

	public boolean isRoboOn();
	public void setRoboOn(boolean roboOn);
	public int getxCoordinate();
	public int getyCoordinate();
	public void setxCoordinate(int x);
	public void setyCoordinate(int y);
	public Direction getFacingTowards();
	public void setFacingTowards(Direction direction);
	public void setScalesDirection(int highPoint, int lowerPoint,
			Direction dir);


}
 