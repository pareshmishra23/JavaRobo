package com.robo.movement;

import com.robo.common.robotinterface.Robo;

public interface Movement 
{
	public boolean moveNorth(Robo robo,int step);  
	public boolean moveSouth(Robo robo,int step);  
	public boolean moveEast(Robo robo,int step);  
	public boolean moveWest(Robo robo,int step);  
}
