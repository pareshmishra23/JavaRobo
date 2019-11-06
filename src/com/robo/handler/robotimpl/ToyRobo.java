package com.robo.handler.robotimpl;

import com.robo.common.enumconstants.Direction;
import com.robo.common.robotinterface.Robo;

public class ToyRobo implements Robo
{
	private int xCoordinate;
	private int yCoordinate;
	private boolean roboOn;
	private Direction facingTowards;
	
	public ToyRobo()
	{
		
	}
	public ToyRobo(int xCoordinate,int yCoordinate, Direction direction)
	{
		this.xCoordinate=xCoordinate;
		this.yCoordinate=yCoordinate;
		this.facingTowards=direction;
	}
	
	/** Getter
	 * @return the xCoordinate
	 */
	public int getxCoordinate() {
		return xCoordinate;
	}
	/** Setter
	 * @param xCoordinate the xCoordinate to set
	 */
	public void setxCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}
	/** Getter
	 * @return the yCoordinate
	 */
	public int getyCoordinate() {
		return yCoordinate;
	}
	/** Setter
	 * @param yCoordinate the yCoordinate to set
	 */
	public void setyCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}
	/** Setter
	 * @param facingTowards the facingTowards to set
	 */
	public void setFacingTowards(Direction facingTowards) {
		this.facingTowards = facingTowards;
	}
	/** Getter
	 * @return the facingTowards
	 */
	public Direction getFacingTowards() {
		if(facingTowards==null)
			return Direction.NORTH;
		return facingTowards;
	}
	@Override
	public void setScalesDirection(int highPoint, int lowerPoint, Direction dir) {
		this.xCoordinate=highPoint;
		this.yCoordinate=lowerPoint;
		this.facingTowards=dir;
		
	}
	@Override
	public void setRoboOn(boolean roboOn) {
		this.roboOn = roboOn;
	}
	@Override
	public boolean isRoboOn() {
		return roboOn;
	}
}