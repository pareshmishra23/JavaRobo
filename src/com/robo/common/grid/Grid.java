package com.robo.common.grid;

public class Grid 
{
	private Coordinates coordinates;
	private String[][] grid;
	/** Getter
	 * @return the coordinates
	 */
	public Coordinates getCoordinates() {
		return coordinates;
	}
	/** Setter
	 * @param coordinates the coordinates to set
	 */
	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}
	/** Getter
	 * @return the grid
	 */
	public String[][] getGrid() {
		return grid;
	}
	/** Setter
	 * @param grid the grid to set
	 */
	public void setGrid(String[][] grid) {
		this.grid = grid;
	}
	public Grid(Coordinates coordinates)
	{
		this.coordinates=coordinates;
		buildGrid();
	}
	private void buildGrid() 
	{
		int xCoordinateLength=0;
		int yCoordinateLength=0;
		if((coordinates.getxScale().getHighPoint()<0 && coordinates.getxScale().getLowerPoint()<0) 
		|| (coordinates.getxScale().getHighPoint()>=0 && coordinates.getxScale().getLowerPoint()>=0))
		{
			xCoordinateLength=coordinates.getxScale().getHighPoint()-coordinates.getxScale().getLowerPoint()+1;
		} else {
			xCoordinateLength=coordinates.getxScale().getHighPoint()-coordinates.getxScale().getLowerPoint()+1;
		}
		
		if((coordinates.getyScale().getHighPoint()<0 && coordinates.getyScale().getLowerPoint()<0) 
		|| (coordinates.getyScale().getHighPoint()>=0 && coordinates.getyScale().getLowerPoint()>=0))
		{
			yCoordinateLength=coordinates.getyScale().getHighPoint()-coordinates.getyScale().getLowerPoint()+1;
		} else {
			yCoordinateLength=coordinates.getyScale().getHighPoint()-coordinates.getyScale().getLowerPoint()+1;
		}
		grid=new String[xCoordinateLength][yCoordinateLength];
		int xLower=coordinates.getxScale().getLowerPoint();

		int yHigher=coordinates.getyScale().getHighPoint();
		for(int i=0, chacheXLower=xLower;i<yCoordinateLength;i++)
		{
			for(int j=0;j<xCoordinateLength;j++)
			{
				grid[j][i]="("+chacheXLower+","+yHigher+")";
				chacheXLower++;
			}
			chacheXLower=xLower;
			yHigher--;
		}	
	}
	
	public void displayGrid()
	{
		int xCoordinateLength=0;
		int yCoordinateLength=0;
		if((coordinates.getxScale().getHighPoint()<0 && coordinates.getxScale().getLowerPoint()<0) 
		|| (coordinates.getxScale().getHighPoint()>=0 && coordinates.getxScale().getLowerPoint()>=0))
		{
			xCoordinateLength=coordinates.getxScale().getHighPoint()-coordinates.getxScale().getLowerPoint()+1;
		} else {
			xCoordinateLength=coordinates.getxScale().getHighPoint()-coordinates.getxScale().getLowerPoint()+1;
		}
		
		if((coordinates.getyScale().getHighPoint()<0 && coordinates.getyScale().getLowerPoint()<0) 
		|| (coordinates.getyScale().getHighPoint()>=0 && coordinates.getyScale().getLowerPoint()>=0))
		{
			yCoordinateLength=coordinates.getyScale().getHighPoint()-coordinates.getyScale().getLowerPoint()+1;
		} else {
			yCoordinateLength=coordinates.getyScale().getHighPoint()-coordinates.getyScale().getLowerPoint()+1;
		}
		for(int i=0;i<yCoordinateLength;i++)
		{
			for(int j=0;j<xCoordinateLength;j++)
			{
				System.out.print(grid[j][i]);
			}
			System.out.println();
		}	
	}
}
