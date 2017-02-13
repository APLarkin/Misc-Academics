//HW9 pt2

import java.io.*;
import java.util.*;

public class item
{
	private String name;
	private double price;
	
	public item(String name, double price)
	{
		this.name = name;
		this.price = price;
	}
	
	public String getName()
	{
		return name;
	}
	public double getPrice()
	{
		return price;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setPrice(double price)
	{
		this.price = price;
	}
	
	public String getDetails()
	{
		String Details = "";
		String temp = Double.toString(price);
		
		Details = "Item name: " + name + "\n" + "Price: " + temp;
		
		return Details;
		
	}

}