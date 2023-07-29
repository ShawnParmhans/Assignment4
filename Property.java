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

public class Property {
	private String propertyName;
	private String city;
	private double rentalAmount;
	private String owner;
	private Plot propertyPlot;
	
	public Property()
	{
		propertyName = " ";
		city = " ";
		rentalAmount = 0.0;
		owner = " ";
		propertyPlot = new Plot(0,0,1,1);
	}
	public Property(String propN, String cityN, double rAmnt, String ownerN)
	{
		propertyName = propN;
		city = cityN;
		rentalAmount = rAmnt;
		owner = ownerN;
		propertyPlot = new Plot(0,0,1,1); //fixed from previous
	}
	public Property(String propN, String cityN, double rAmnt, String ownerN,
			int xN, int yN, int widthN, int depthN)
	{
		propertyName = propN;
		city = cityN;
		rentalAmount = rAmnt;
		owner = ownerN;
		propertyPlot = new Plot(xN,yN,widthN,depthN);
	}
	Property(Property otherProperty)
	{
		propertyName = otherProperty.propertyName;
		city = otherProperty.city;
		rentalAmount = otherProperty.rentalAmount;
		owner = otherProperty.owner;
		propertyPlot = otherProperty.propertyPlot;
	}
	//getter methods
	public String getCity()
	{
		return city;
	}
	public String getOwner()
	{
		return owner;
	}
	public Plot getPlot()
	{
		return propertyPlot;
	}
	public String getPropertyName()
	{
		return propertyName;
	}
	public double getRentAmount()
	{
		return rentalAmount;
	}
	//setter methods
	public void setCity(String sC)
	{
		city = sC;
	}
	public void setOwner(String o)
	{
		owner = o;
	}
	public void setPlot(int x, int y, int w, int d)
	{
		propertyPlot = new Plot(x,y,w,d);
	}
	public void setPropertyName(String pN)
	{
		propertyName = pN;
	}
	public void setRentAmount(double rA)
	{
		rentalAmount = rA;
	}
	//toString
	public String toString()
	{
		String str =  getPropertyName() + "," + getCity() 
		+ "," + getOwner() + "," + getRentAmount();
		
		return str;
	}
}
