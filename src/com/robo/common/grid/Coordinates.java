package com.robo.common.grid;

import com.robo.common.gridinterface.BaseScale;

public class Coordinates 
{
	private BaseScale xScale;
	private BaseScale yScale;
	private BaseScale zScale;
	
	public Coordinates(BaseScale xScale,BaseScale yScale)
	{
		this.xScale=xScale;
		this.yScale=yScale;
	}
	/** Getter
	 * @return the xScale
	 */
	public BaseScale getxScale() {
		return xScale;
	}
	/** Setter
	 * @param xScale the xScale to set
	 */
	public void setxScale(Scale xScale) {
		this.xScale = xScale;
	}
	/** Getter
	 * @return the yScale
	 */
	public BaseScale getyScale() {
		return yScale;
	}
	/** Setter
	 * @param yScale the yScale to set
	 */
	public void setyScale(Scale yScale) {
		this.yScale = yScale;
	}
	/** Getter
	 * @return the zScale
	 */
	public BaseScale getzScale() {
		return zScale;
	}
	/** Setter
	 * @param zScale the zScale to set
	 */
	public void setzScale(Scale zScale) {
		this.zScale = zScale;
	}
	
}