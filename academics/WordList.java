//Homework 9 Pt1
//The only error I get is regarding a lack of the filenotfound exception.
//I can't seem to get the driver to work correctly with this, though.

import java.io.*;
import java.util.*;

public class WordList
{
	private static String filename;
	private static String wordstart;
	private static String AllTheWords;
	private static List<String> list;
	private static List<String> palindromes;
	private static List<String> MatchWordsList;
	
	public List<String> Wordlist(String filename)
	{
		Scanner FileList = new Scanner(new File(filename));
		while(FileList.hasNext())
		{
			list.add(FileList.nextLine());
		}
		return list;
	}
	
	public static List<String> Palindromes()
	{
		String temp1;
		String temp2;

		for(int i = 0; i < list.size(); i++)
		{
			temp1 = list.get(i);
			temp2 = list.get(i);
			
			temp2 = new StringBuilder(temp2).reverse().toString();
			
			if(temp1 == temp2);
			{
				palindromes.add(temp1);
			}
			
		}
		return palindromes;
	}
	
	public static List<String> WordsStartingWith(String wordstart)
	{
		int stringsize = wordstart.length();
		String temp3;
		
		for(int i = 0; i < list.size(); i++)
		{
			temp3 = list.get(i);
			
			temp3 = temp3.substring(0, stringsize);
			if(temp3 == wordstart)
			{
				MatchWordsList.add(list.get(i));
			}
		}
		
		return MatchWordsList;
	}
	
	public static String AllWords()
	{
		for(int i = 0; i < list.size(); i++)
		{
			AllTheWords = AllTheWords + list.get(i).toString();
		}
		return AllTheWords;
	}
	
}