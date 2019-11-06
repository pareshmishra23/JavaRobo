package com.robo.userinterface;

import com.robo.common.enumconstants.Command;
import com.robo.common.enumconstants.Direction;
import com.robo.common.grid.Grid;
import com.robo.common.robotinterface.Robo;

public class UserRequest 
{
	private Grid grid=null;
	private Robo robo=null;
	private Direction direction=null;
	private Command command=null;
	private int noOfStep;
	private int x;
	private int y;
	
	public Grid getGrid() {
		return grid;
	}
	public void setGrid(Grid grid) {
		this.grid = grid;
	}
	public Robo getRobo() {
		return robo;
	}
	public void setRobo(Robo robo) {
		this.robo = robo;
	}
	public Direction getDirection() {
		return direction;
	}
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	public Command getCommand() {
		return command;
	}
	public void setCommand(Command command) {
		this.command = command;
	}
	public int getNoOfStep() {
		return noOfStep;
	}
	public void setNoOfStep(int noOfStep) {
		this.noOfStep = noOfStep;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}
