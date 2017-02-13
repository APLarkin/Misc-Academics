<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

public class cmsci254hw5
{

	//I honestly have next to no idea what I'm doing. I understand what recursion is for -- solving problems where the answer relies on previous iterations of itself -- but I don't understand how it is any better for either of these. I could write a simple FOR loop for problem 1 in fewer lines, and for problem 2 it might as well be a FOR loop considering it's functionally supposed to iterate through the list.
	public static int count(String s, char c)
	{
		if (s.length() == 0)
		{
			return 0;
		}
		else if (s.charAt(0) == c)
		{
			return 1 + count(s.substring(1, s.length()), c);
		}
		else
		{
			return count(s.substring(1, s.length()), c);
		}
	}
	

	/*
	public static boolean allEven(ArrayList<Integer> list)
	{
		int i = 0;
		int temp = 0;
		while(i < list.size())
		{
			temp = list.get(i);
			if(temp % 2 != 0)
			{
				return false;
			}
			else if (temp % 2 == 0)
			{
				i++;
				allEven(list);
			}
		}
		return true;
	
	}
	*/
	public static void main(String[] args)
	{
		System.out.println(count("aaa", 'a'));
		/*
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(4);
		list.add(6);
		System.out.println(allEven(list));
		*/
	}
=======
import java.util.ArrayList;
import java.util.List;

public class cmsci254hw5
{

	//I honestly have next to no idea what I'm doing. I understand what recursion is for -- solving problems where the answer relies on previous iterations of itself -- but I don't understand how it is any better for either of these. I could write a simple FOR loop for problem 1 in fewer lines, and for problem 2 it might as well be a FOR loop considering it's functionally supposed to iterate through the list.
	public static int count(String s, char c)
	{
		if (s.length() == 0)
		{
			return 0;
		}
		else if (s.charAt(0) == c)
		{
			return 1 + count(s.substring(1, s.length()), c);
		}
		else
		{
			return count(s.substring(1, s.length()), c);
		}
	}
	

	/*
	public static boolean allEven(ArrayList<Integer> list)
	{
		int i = 0;
		int temp = 0;
		while(i < list.size())
		{
			temp = list.get(i);
			if(temp % 2 != 0)
			{
				return false;
			}
			else if (temp % 2 == 0)
			{
				i++;
				allEven(list);
			}
		}
		return true;
	
	}
	*/
	public static void main(String[] args)
	{
		System.out.println(count("aaa", 'a'));
		/*
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(4);
		list.add(6);
		System.out.println(allEven(list));
		*/
	}
>>>>>>> origin/master
}