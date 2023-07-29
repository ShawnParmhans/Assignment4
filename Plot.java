/*
 Class: CMSC203 CRN 40398
 Program: Assignment 4
 Instructor: Farnaz Eivazi
 Summary of Description: Property Management
 Due Date: 07/17/2023 
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
Shawn Parmhans
*/

package application;

public class Plot{
	//upper left corner
	private int x;
	private int y;
	//vertical/horizontal
	private int depth;
	private int width;
	
	public Plot() 
	{
		x = 0;
		y = 0;
		width = 1;
		depth = 1;
	}
	public Plot(int xNum, int yNum, int widthNum, int depthNum)
	{
		x = xNum;
		y = yNum;
		width = widthNum;
		depth = depthNum;
	}
	public Plot(Plot otherPlot)
	{
		this.x = otherPlot.x;
		this.y = otherPlot.y;
		this.depth = otherPlot.depth;
		this.width = otherPlot.width;
	}
	//getter methods
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public int getDepth()
	{
		return depth;
	}
	public int getWidth()
	{
		return width;
	}
	//setter methods
	public void setX(int xNum)
	{
		x = xNum;
	}
	public void setY(int yNum)
	{
		y = yNum;
	}
	public void setDepth(int depthNum)
	{
		depth = depthNum;
	}
	public void setWidth(int widthNum)
	{
		width = widthNum;
	}
	//boolean methods
	//return TRUE if overlap
	public boolean overlaps(Plot plot)
	{
        //Check left
        if (plot.getX() + plot.getWidth() <= x)
            return false;

        //Check right
        if (plot.getX() >= x + width)
            return false;

        //Check above
        if (plot.getY() + plot.getDepth() <= y)
            return false;

        //Check below
        if (plot.getY() >= y + depth)
            return false;

        // If none, plot overlaps
        return true;
	}
	//return TRUE if encompasses
	public boolean encompasses(Plot plot)
	{
        //Check left edge
        if (plot.getX() < x)
            return false;

        //Check right edge
        if (plot.getX() + plot.getWidth() > x + width)
            return false;

        //Check above edge
        if (plot.getY() < y)
            return false;

        //Check below edge
        if (plot.getY() + plot.getDepth() > y + depth)
            return false;

        //If plot encompasses
        return true;
	}
	//toString
	public String toString()
	{
		String str = "" + getX() + "," + getY() + "," + getWidth() + "," + getDepth();
		
		return str;
	}
}




