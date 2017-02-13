//Hw11
//The way I was trying to do this wasnt quite what was requested -- since the parsing was done directly insteaad of asking for user input, I just decided to roll with it not having much user input.

import java.io.*;
import java.util.*;

public class mapThing
{
	private static List<String> list;
	
	public List<String> ParseFile() throws FileNotFoundException
	{
		
		Scanner FileList = new Scanner(new File("cmscitxt.txt"));
		
		while(FileList.hasNext())
		{
			list.add(FileList.nextLine());
		}
		return list;
	}
	public static HashMap<String, String> createMap()
	{
		HashMap<String, String> tempMap = new HashMap<String, String>();
		String tempString = "";
		ArrayList<String> tempList = new ArrayList<String>();
		int count = 0;
		String no1 = "";
		for(int i = 0; i < list.size(); i++)
		{
			count = 0;
			tempString = list.get(i);
			for(int j = 0; j < tempString.length(); j++)
			{
				if(tempString.substring(j) == "-")
				{
					tempMap.put((tempString.substring(count, j)), "");
					count = j;
					no1 = tempString.substring(count, j);
				}
				if(tempString.substring(j) == ",")
				{
					tempList.add(tempString.substring(count, j));
					count = j;
				}
			}
			for(int k = 0; k < tempList.size(); k++)
			{
				tempMap.put(no1, tempList.get(k));
			}
		
		}
		
		return tempMap;
		
	}
	//I honestly have no idea how to go from the created map to this part.
	public static ArrayList<String> getStudents(String course)
	{
		HashMap<String, String> map = createMap();
		ArrayList<String> students = new ArrayList<String>();
		
		return students;
	}
	
	public static void main(String[] args)
	{
		System.out.println(getStudents("120"));
	}
}