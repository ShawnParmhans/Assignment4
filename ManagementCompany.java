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

public class ManagementCompany {
	private String managementCompanyName;
	private String taxID;
	private double managementFeePercentage;
	static final int MAX_PROPERTY = 5;
	static final int MGMT_WIDTH = 10;
	static final int MGMT_DEPTH = 10;
	private Property[] properties;
	private Plot plot;
	private int numberOfProperties;
	
	/**
	 * method ManagementCompany Assigns values of the company
	 */
	public ManagementCompany()
	{
		managementCompanyName = " ";
		taxID = " ";
		managementFeePercentage = 0.0;
		plot = new Plot(0,0,1,1);
		properties = new Property[MAX_PROPERTY];
		numberOfProperties = 0;
	}
	/**
	 * method ManagementCompany Assigns values of the company
	 * @param name The name of company
	 * @param taxID The tax ID
	 * @param mgmFee The fee of management
	 */
	public ManagementCompany(String name, String taxID, 
			double mgmFee)
	{
		managementCompanyName = name;
		this.taxID = taxID;
		managementFeePercentage = mgmFee;
		plot = new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH);
		properties = new Property[MAX_PROPERTY];
	}
	/**
	 * method ManagementCompany Assigns values of the company
	 * @param name The name of company
	 * @param taxID The tax ID
	 * @param mgmFee The fee of management
	 * @param x The x value of property
	 * @param y The y value of property
	 * @param width The width of property
	 * @param depth The depth of property
	 */
	public ManagementCompany(String name, String taxID, 
			double mgmFee, int x, int y, int width, int depth)
	{
		managementCompanyName = name;
		this.taxID = taxID;
		managementFeePercentage = mgmFee;
		plot = new Plot(x,y,width,depth);
		properties = new Property[MAX_PROPERTY];
	}
	/**
	 * method ManagementCompany Assigns values of the company
	 * @param otherCompany Parameter used to take in another company
	 */
	public ManagementCompany(ManagementCompany otherCompany)
	{
		managementCompanyName = otherCompany.managementCompanyName;
		taxID = otherCompany.taxID;
		managementFeePercentage = otherCompany.managementFeePercentage;
		properties = otherCompany.properties;
		plot = otherCompany.plot;
		numberOfProperties = otherCompany.numberOfProperties;
	}
	//getter methods
	public double getMgmFeePer()
	{
		return managementFeePercentage;
	}
	public String getName()
	{
		return managementCompanyName;
	}
	public Plot getPlot()
	{
		return plot;
	}
	public Property[] getProperties()
	{
	    Property[] copyProperties = new Property[numberOfProperties];
	    
	    for (int i = 0; i < numberOfProperties; i++) 
	        copyProperties[i] = properties[i];
	    
	    return copyProperties;
	}
	public int getPropertiesCount()
	{
		return numberOfProperties;
	}
	public String getTaxID()
	{
		return taxID;
	}
	//setter methods
	public void setMgmFeePer(double fee)
	{
		managementFeePercentage = fee;
	}
	public void setName(String s)
	{
		managementCompanyName = s;
	}
	public void setPlot(Plot p)
	{
		plot = new Plot(p);
	}
	public void setPropertiesCount(int pC)
	{
		numberOfProperties = pC;
	}
	public void setTaxID(String t)
	{
		taxID = t;
	}
	/**
	 * Method used to add a property
	 * @param property The property to add
	 * @return Return the status of property
	 */
	public int addProperty(Property property)
	{
		int failure = 0;
		if(numberOfProperties >= MAX_PROPERTY)
			failure = -1;
		if(property == null)
			failure = -2;
		if(!plot.encompasses(property.getPlot()))
			failure = -3;
		
		for(int i = 0; i < numberOfProperties; i++)
		{
			if (property.getPlot().overlaps(properties[i].getPlot()))
				failure = -4;
		}
		
		properties[(int)numberOfProperties] = property;
		numberOfProperties++;
		
		return (numberOfProperties - 1);
	}
	/**
	 * Method used to add a property
	 * @param name The Name of property
	 * @param city The City of property
	 * @param rent The rent of property
	 * @param owner The owner of property
	 * @return Return the status of property
	 */
	public int addProperty(String name, String city, double rent, String owner)
	{
		Property apartment = new Property(name, city, rent, owner);
		if (numberOfProperties >= MAX_PROPERTY)
			return -1;
		
		return (addProperty(apartment));
		
	}
	/**
	 * Method used to add a property
	 * @param name The Name of property
	 * @param city The City of property
	 * @param rent The rent of property
	 * @param owner The owner of property
	 * @param x The x value of property
	 * @param y The y value of property
	 * @param width The width of property
	 * @param depth The depth of property
	 * @return Return the status of property
	 */
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth)
	{
		Property apartment = new Property(name, city, rent, owner, x, y, width, depth);
		if (numberOfProperties >= MAX_PROPERTY)
			return -1;
		
		return (addProperty(apartment));
	}
	/**
	 * Method used to get total rent
	 * @return Return the total rent
	 */
	public double getTotalRent()
	{
		double total = 0.0;
		for(int i = 0; i < numberOfProperties; i++)
			total += properties[i].getRentAmount();
		
		return total;
	}
	/**
	 * Method used to Receive the highest rent property
	 * @return the highest rented property
	 */
	public Property getHighestRentProperty()
	{
		Property highestProp = properties[0];
		for(int i = 0; i < numberOfProperties; i++)
		{
			if (properties[i].getRentAmount() > highestProp.getRentAmount())
				highestProp = properties[i];
		}
		return highestProp;
	}
	/**
	 * Method used to remove last property
	 */
	public void removeLastProperty()
	{	
		if(numberOfProperties > 0)
		{
			properties[numberOfProperties - 1] = null;
			numberOfProperties -= 1;
		}
	}
	/**
	 * Method used to check if properties is full
	 * @return Return status of properties
	 */
	public boolean isPropertiesFull()
	{
		if(numberOfProperties == MAX_PROPERTY)
			return true;
		else
			return false;
	}
	/**
	 * Method used to check if management fee is valid
	 * @return Return validity of management fee
	 */
	public boolean isManagementFeeValid()
	{
		if(managementFeePercentage >= 0 && managementFeePercentage <= 100)
			return true;
		else
			return false;
	}
	//toString method
	@Override
	public String toString()
	{
		StringBuilder str = new StringBuilder();
			str.append("List of the properties for ").append(managementCompanyName).append(", taxID: ");
			str.append(taxID).append("\n");
			str.append("_____________________________________________\n");
		//calculate total fee
		for(int i = 0; i < numberOfProperties; i++)
		{
			str.append(properties[i].toString()).append("\n");
		}
			str.append("_____________________________________________\n");
			str.append("\ntotal management Fee: ");
			
			double totalFeePrice = 0.0;
			for(int i = 0; i < numberOfProperties; i++)
			{
				totalFeePrice += ((managementFeePercentage));
			}
			
			str.append(totalFeePrice);
			
			return str.toString();
	}
	
}




