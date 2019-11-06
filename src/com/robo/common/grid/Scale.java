package com.robo.common.grid;

import com.robo.common.gridinterface.BaseScale;

public class Scale implements BaseScale
{
	private int highPoint;
	private int lowerPoint;
	
	public Scale()
	{
		
	}
	
	/** Getter
	 * @return the highPoint
	 */
	public int getHighPoint() {
		return highPoint;
	}
	/** Setter
	 * @param highPoint the highPoint to set
	 */
	public void setHighPoint(int highPoint) {
		this.highPoint = highPoint;
	}
	/** Getter
	 * @return the lowerPoing
	 */
	public int getLowerPoint() {
		return lowerPoint;
	}
	/** Setter
	 * @param lowerPoing the lowerPoing to set
	 */
	public void setLowerPoint(int lowerPoint) {
		this.lowerPoint = lowerPoint;
	}
}