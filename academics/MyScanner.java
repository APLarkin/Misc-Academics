import java.io.*;
import java.util.*;

public class MyScanner
{
	private String data;
	private int counter;
	
	public void ScannerConstructor(String data)
	{
		this.data = data;
		counter = 0;
	}
	//Your wording here was strange.
	public String Next()
	{
		char temp = 'm';
		String returnedString = "";
		while(temp != ' ')
		{
			temp = data.charAt(counter);
			returnedString = returnedString + temp;
			counter++;
		}
		counter = 0;
		return returnedString;
	}
	public int NextInt()
	{
		char temp = 'm';
		int temp2;
		int returnedInt = 0;
		while(temp != ' ')
		{
			temp = data.charAt(counter);
			temp2 = Character.getNumericValue(temp);
			counter++;
			returnedInt += temp2;
		}
		counter = 0;
		return returnedInt;
	}
	public boolean hasNext()
	{
		boolean truefalse = true;
		int StringSize = data.length();
		if(counter >= StringSize)
		{
			truefalse = false;
		}
		
		return truefalse;
	}
	
}