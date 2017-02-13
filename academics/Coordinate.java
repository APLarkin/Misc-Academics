<<<<<<< HEAD
import java.io.*;
import java.util.*;

public class Coordinate
{
	private int x;
	private int y;
	
	public void ConstructorXY(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public int GetX()
	{
		return x;
	}
	public int GetY()
	{
		return y;
	}
	public void SetX(int x)
	{
		this.x = x;
	}
	public void SetY(int y)
	{
		this.y = y;
	}
	
	public String toString()
	{
		String X = Integer.toString(x);
		String Y = Integer.toString(y);
		String Returned = "(" + X + "," + " " + Y + ")";
		
		return Returned;
	}
	
=======
import java.io.*;
import java.util.*;

public class Coordinate
{
	private int x;
	private int y;
	
	public void ConstructorXY(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public int GetX()
	{
		return x;
	}
	public int GetY()
	{
		return y;
	}
	public void SetX(int x)
	{
		this.x = x;
	}
	public void SetY(int y)
	{
		this.y = y;
	}
	
	public String toString()
	{
		String X = Integer.toString(x);
		String Y = Integer.toString(y);
		String Returned = "(" + X + "," + " " + Y + ")";
		
		return Returned;
	}
	
>>>>>>> origin/master
}