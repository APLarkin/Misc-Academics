import java.util.*;
import java.io.*;

public class VectorDriver
{
	public static void main(String[] args)
	{
		Vector u = new Vector();
		u.SetX(1);
		u.SetY(2);
		u.SetZ(3);
		
		List<Vector> list = new ArrayList<Vector>();
		for(int i = 0; i < 100; i++)
		{
			Vector V = new Vector();
			int temp1 = 0 + (int)(Math.random() * ((100 - 0) + 1));
			int temp2 = 0 + (int)(Math.random() * ((100 - 0) + 1));
			int temp3 = 0 + (int)(Math.random() * ((100 - 0) + 1));
			V.SetX(temp1);
			V.SetY(temp2);
			V.SetZ(temp3);
			
			list.add(V);
			
		}
		String listString = list.toString();
		System.out.println(listString);
		/*
		This part gives me something weird, I assume relating to the equals method (which I had a lot of trouble with)
		boolean TrueFalse = false;
		for(int i = 0; i < 100; i++)
		{
			Vector temp1 = new Vector();
			Vector temp2 = list.get(i);
			if(temp1.equals(temp2))
			{
				TrueFalse = true;
			}
		}
		System.out.println(TrueFalse);
		*/
	}
}