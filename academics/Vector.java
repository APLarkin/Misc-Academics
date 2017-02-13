import java.util.*;
import java.io.*;

public class Vector
{
	private int x;
	private int y;
	private int z;
	
	public void SetX(int x)
	{
		this.x = x;
	}
	public void SetY(int y)
	{
		this.y = y;
	}
	public void SetZ(int z)
	{
		this.z = z;
	}
	public int GetX()
	{
		return x;
	}
	public int GetY()
	{
		return y;
	}
	public int GetZ()
	{
		return z;
	}

	public String toString()
	{
		String Details = "";
		String tempX = Integer.toString(this.x);
		String tempY = Integer.toString(this.y);
		String tempZ = Integer.toString(this.z);
		
		Details = "("+tempX+","+tempY+","+tempZ+","+")";
		
		return Details;
	
	}
	
	public double length()
	{
		double temp1 = Math.pow(this.GetX(), 2);
		double temp2 = Math.pow(this.GetY(), 2);
		double temp3 = Math.pow(this.GetZ(), 2);
		
		double temp4 = Math.sqrt(temp1+temp2+temp3);
		return temp4;
	}
	public Vector add(Vector v1)
	{
		int temp1 = this.GetX();
		int temp2 = this.GetY();
		int temp3 = this.GetZ();
		
		int temp4 = v1.GetX();
		int temp5 = v1.GetY();
		int temp6 = v1.GetZ();
		
		int temp7 = temp1 + temp4;
		int temp8 = temp2 + temp5;
		int temp9 = temp3 + temp6;
		
		Vector v2 = new Vector();
		
		v2.SetX(temp7);
		v2.SetY(temp8);
		v2.SetZ(temp9);
		
		return v2;
		
	}
	
	@Override public boolean equals(Object v1)
	{
		if(v1.equals(this))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
}