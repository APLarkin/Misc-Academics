//HW10 pt 1
import java.util.*;
import java.io.*;

public class IntegerListUtilities
{
	public static double average(ArrayList<Integer> TempList)
	{
		double average = 0;
		for(int i = 0; i < TempList.size(); i++)
		{
			average += TempList.get(i);
		}
		average = (average / TempList.size());
		return average;
	}
	
	public static List<Integer> sample(ArrayList<Integer> TempList, int No1)
	{
		List<Integer> ReturnedList = new ArrayList<Integer>();
		List<Integer> TrackerList = new ArrayList<Integer>();
		int RandomNo;
		int Temp1;
		int Temp2;
		int TrackerVar = 0;
		for(int i = 0; i < No1; i++)
		{
			TrackerVar = 0;
			RandomNo = 0 + (int)(Math.random() * ((TempList.size() - 0) + 0));
			TrackerList.add(TempList.get(i));
			//Checks each entry in the tracker list
			for(int j = 0; j < TrackerList.size(); j++)
			{
				Temp1 = TrackerList.get(j);
				//checks in the templist
				for(int k = 0; k < TempList.size(); k++)
				{
					Temp2 = TempList.get(i);
					if(Temp1 == Temp2)
					{
						TrackerVar += 1;
					}
				}
			}
			if(TrackerVar <= 1)
			{
				ReturnedList.add(TempList.get(RandomNo));
			}
			else
			{
				//Sets program back a step so it can reacquire
				i = i -1;
			}
		}
		return ReturnedList;
	}

}