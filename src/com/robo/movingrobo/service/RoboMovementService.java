package com.robo.movingrobo.service;

import com.robo.adjacentdirection.AdjacentDirection;
import com.robo.adjacentdirection.RoboAdjacenDirection;
import com.robo.common.enumconstants.Direction;
import com.robo.common.enumconstants.Move;
import com.robo.common.grid.Grid;
import com.robo.common.grid.Scale;
import com.robo.common.gridinterface.BaseScale;
import com.robo.common.robotinterface.Robo;
import com.robo.movement.Movement;
import com.robo.movement.RoboMovement;

public class RoboMovementService 
{
	private static RoboMovementService service=null;
	private RoboMovementService() {
		// TODO Auto-generated constructor stub
	}
	public synchronized static RoboMovementService getInstance(){
		if(service==null){
			service=new RoboMovementService();
		}
		return service;
	}
	public boolean move(Grid grid,Robo robo,Move move,int noOfSteps)
	{
		Direction direction=getMovementDirection(robo, move);
		boolean success=false;
		if(isMovementInsideGrid(grid, robo, direction, noOfSteps))
		{
			success=move(robo, direction, noOfSteps);
			robo.setFacingTowards(direction);
			
		}
		return success;
	}
	
	public Direction getMovementDirection(Robo robo,Move move)
	{
		Direction direction=null;
		AdjacentDirection rDirection=new RoboAdjacenDirection();
		if(Move.F.equals(move))
		{
			direction=rDirection.getForwardAdjacentDirection(robo);
		}
		else if(Move.L.equals(move))
		{
			direction=rDirection.getLeftAdjacentDirection(robo);
		}
		else if(Move.B.equals(move))
		{
			direction=rDirection.getBackwardAdjacentDirection(robo);
		}
		else if(Move.R.equals(move))
		{
			direction=rDirection.getRightAdjacentDirection(robo);	
		}
		return direction;
	}
	
	public boolean isMovementInsideGrid(Grid grid,Robo mRobo,Direction direction,int noOfSteps)
	{
		boolean isValidMove=false;
		BaseScale scaleX=grid.getCoordinates().getxScale();
		BaseScale scaleY=grid.getCoordinates().getyScale();
		if((Direction.NORTH.equals(direction) || Direction.SOUTH.equals(direction))
		&& (mRobo.getyCoordinate()+noOfSteps<=scaleY.getHighPoint() && mRobo.getyCoordinate()-noOfSteps>=scaleY.getLowerPoint()))
		{
			isValidMove=true;
		} else if((Direction.EAST.equals(direction) || Direction.WEST.equals(direction))
		&& (mRobo.getxCoordinate()+noOfSteps<=scaleX.getHighPoint() && mRobo.getxCoordinate()-noOfSteps>=scaleY.getLowerPoint()))
		{
			isValidMove=true;
		}
		return isValidMove;
	}
	
	public boolean move(Robo robo,Direction direction,int noOfSteps)
	{
		Movement move=new RoboMovement();
		boolean success=false;
		if(Direction.NORTH.equals(direction))
		{
			success=move.moveNorth(robo, noOfSteps);
		}
		else if(Direction.EAST.equals(direction))
		{
			success=move.moveEast(robo, noOfSteps);
		}
		else if(Direction.SOUTH.equals(direction))
		{
			success=move.moveSouth(robo, noOfSteps);
		}
		else if(Direction.WEST.equals(direction))
		{
			success=move.moveWest(robo, noOfSteps);
		}
		return success;
	}
	
	 public boolean moveToPoint(Grid grid,Robo mRobo,Direction facetowards,int x,int y)
	 {
		  boolean success=false;
		  BaseScale xScale=grid.getCoordinates().getxScale();
		  BaseScale yScale=grid.getCoordinates().getyScale();
		  if(x<=xScale.getHighPoint() && x>=xScale.getLowerPoint()
		  && y<=yScale.getHighPoint() && y>=yScale.getLowerPoint())
		  {
			  mRobo.setxCoordinate(x);
			  mRobo.setyCoordinate(y);
			  mRobo.setFacingTowards(facetowards);
			  success=true;
		  }
		  return success;
	 }
}
