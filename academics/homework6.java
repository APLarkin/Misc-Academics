//Homework 6
import java.util.*;

public class homework6
{
	public static void main(String args[])
	{
		System.out.println(triple("abc"));
		ArrayList<Integer> newList = new ArrayList<Integer>();
		newList.add(1);
		newList.add(2);
		newList.add(3);
		newList.add(4);
		newList.add(5);
		newList.add(6);
		newList.add(7);
		newList.add(8);
		System.out.println(sumElementsAtEvenIndices(newList));
		System.out.println(addOneToEverything(newList));
		/*
		System.out.println(hasAnEvenNumberOf("aaaabbb", 'a'));
		*/
	}
	//1a
	public static String triple(String s)
	{
		if(s.isEmpty())
		{
			return "String is empty";
		}
		else
		{
			String temp = s.substring(0,1);
			temp = temp+temp+temp;
			if(s.length() <= 1)
			{
				return temp;
			}
			else
			{
				return temp + triple(s.substring(1));
			}
		}
	}
	//1b
	//This works -- provided the list has an even number of indices. If it has an odd number of indices, it will not count the final even index in the sum. I've tried a few workarounds for it but it simply won't work.
	public static int sumElementsAtEvenIndices(ArrayList<Integer> list)
	{
		if(list.isEmpty())
		{
			return 0;
		}
		else
		{
			int sum = 0;
			sum = sum+list.get(0);
			if(list.size() % 2 != 0)
			{
				list.remove(list.size() - 1);
			}
			if(list.size() > 1)
			{
				list.remove(0);
				list.remove(0);
			}

			if(list.size() <= 1)
			{
				return sum;
			}
			else
			{
				return sum + sumElementsAtEvenIndices(list);
			}
		}
	}
	//1c
	//This seems like it should work, but it doesn't return any of the lists here -- just a blank list from the looks of it.
	public static ArrayList<Integer> addOneToEverything(ArrayList<Integer> list)
	{
		ArrayList<Integer> tempList = new ArrayList<Integer>(list);
		ArrayList<Integer> newList = new ArrayList<Integer>();
		if(list.isEmpty())
		{
			return list;
		}
		else if(list.size() >= 1)
		{
			newList.add(list.get(0)+1);
			list.remove(0);
			return addOneToEverything(list);
		}
		
		else
		{
			return newList;
		}
		
	
	}
	//1d
	
	public static boolean hasAnEvenNumberOf(String s, char c)
	{
		String tempString = s;
		int check = 0;
		char temp = s.charAt(0);
		if(s.isEmpty())
		{
			return false;
		}
		else if(s.length() < 1 && check % 2 == 0)
		{
			return true;
		}
		else if(s.length() < 1 && check % 2 != 0)
		{
			return false;
		}
		else
		{
			if(c == temp)
			{
				check += 1;
				tempString.substring(1);
				return hasAnEvenNumberOf(tempString, c);
			}
		}
		return true;
	
	}
	
	//2
	//I just couldn't figure out how to do this one.
	/*
	public static List<String> permutations(int n)
	{
	}
	*/
	//3
	public static ArrayList<String> listAllItems(int n)
	{
	}
	
}