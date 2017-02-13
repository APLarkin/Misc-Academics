<<<<<<< HEAD
import java.io.*;
import java.util.*;

public class AlmostAnagrams
{
	
	public static void main(String[] args)
	{
		//Scanner for user input
		Scanner user_input = new Scanner(System.in);
		//Vars
		String String1 = "";
		String String2 = "";
		ArrayList<String> String1Array = new ArrayList<String>();
		ArrayList<String> String2Array = new ArrayList<String>();
		//Get strings
		System.out.println("String 1: ");
		String1 = user_input.next();
		System.out.println("String 2: ");
		String2 = user_input.next();
		if(String1.length() != String2.length())
		{
			System.out.println("Not anagrams");
			System.exit(0);
		}
		//Convert into arrays
		for(int i = 0; i < String1.length(); i++)
		{
			String1Array.add(String1.substring(i, i+1));
			String2Array.add(String2.substring(i, i+1));
		}
		for(int i = 0; i < String1.length(); i++)
		{
			for(int j = 0; j < String1.length(); j++)
			{
			
			}
		}
	}

}
=======
import java.io.*;
import java.util.*;

public class AlmostAnagrams
{
	
	public static void main(String[] args)
	{
		//Scanner for user input
		Scanner user_input = new Scanner(System.in);
		//Vars
		String String1 = "";
		String String2 = "";
		ArrayList<String> String1Array = new ArrayList<String>();
		ArrayList<String> String2Array = new ArrayList<String>();
		//Get strings
		System.out.println("String 1: ");
		String1 = user_input.next();
		System.out.println("String 2: ");
		String2 = user_input.next();
		if(String1.length() != String2.length())
		{
			System.out.println("Not anagrams");
			System.exit(0);
		}
		//Convert into arrays
		for(int i = 0; i < String1.length(); i++)
		{
			String1Array.add(String1.substring(i, i+1));
			String2Array.add(String2.substring(i, i+1));
		}
		for(int i = 0; i < String1.length(); i++)
		{
			for(int j = 0; j < String1.length(); j++)
			{
			
			}
		}
	}

}
>>>>>>> origin/master
