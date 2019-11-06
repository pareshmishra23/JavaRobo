package com.robo.movingrobo.actions;

import com.robo.common.enumconstants.Direction;
import com.robo.common.enumconstants.Move;
import com.robo.common.grid.Grid;
import com.robo.common.robotinterface.Robo;
import com.robo.movingrobo.service.RoboMovementService;

public class MovingRoboAction 
{
	final RoboMovementService service=RoboMovementService.getInstance();
	private static MovingRoboAction action=null;
	
	private MovingRoboAction() {
		super();
	}
	public synchronized static MovingRoboAction getInstance(){
		if(action==null){
			action=new MovingRoboAction();
		}
		return action;
	}
	 public boolean moveForward(Grid grid,Robo robo)  {
	  return moveForward(grid, robo, 1);
	 }
	 
	 public boolean moveLeft(Grid grid,Robo robo)  {
	  return moveLeft(grid, robo, 0);
	 }
	 
	 public boolean moveRight(Grid grid,Robo robo)  {
	  return moveRight(grid, robo, 0);
	 }
	 
	 public boolean moveBackward(Grid grid,Robo robo)  {
	  return moveBackward(grid, robo, 0);
	 }
	 
	 public boolean moveForward(Grid grid,Robo robo,int noOfSteps)  {
	  
	  return service.move(grid, robo, Move.F, noOfSteps);  
	 }
	 
	 public boolean moveLeft(Grid grid,Robo robo,int noOfSteps)  {
	  return service.move(grid, robo, Move.L, noOfSteps);  
	 }
	 
	 public boolean moveRight(Grid grid,Robo robo,int noOfSteps)  {
	  return service.move(grid, robo, Move.R, noOfSteps);  
	 }
	 
	 public boolean moveBackward(Grid grid,Robo robo ,int noOfSteps)  {
	  return service.move(grid, robo, Move.B, noOfSteps);  
	 }
	 
	 public boolean moveToPoint(Grid grid,Robo robo,int x,int y,Direction direction)  {
	  return service.moveToPoint(grid, robo, direction, x, y);  
	 } 
	 
	 public boolean report(Grid grid, Robo mRobo) {
		 System.out.println("robo at ("+mRobo.getxCoordinate()+","+mRobo.getyCoordinate()+") and facing towards "+mRobo.getFacingTowards());
		 return true;
	 } 
}