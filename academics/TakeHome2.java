import java.util.List;
import java.util.ArrayList;

public class TakeHome2
{
	public static String swap(String s)
	{
		if(s.equals("1"))
		{
			return "0";
		}
		if(s.equals("0"))
		{
			return "1";
		}
		String No1 = "";
		String No2 = s.substring(0,1);
		if(No2.equals("1"))
		{
			No1 = "0";
		}
		if(No2.equals("0"))
		{
			No1 = "1";
		}
		
		return No1 + swap(s.substring(1,s.length()));
	}
	
	public static String stringOfSquares(int n)
	{
		
		int No1 = n*n;
		String No2 = Integer.toString(No1);
		if(n < 2)
		{
			return No2;
		}
		return stringOfSquares(n-1) + " " + No2;
	}
	
	public static boolean containsNegativePair(ArrayList<Integer> list)
	{
		
		if(list.size() < 2)
		{
			return false;
		}
		
		int no1 = list.get(0);
		int no2 = list.get(1);
		if(no1 + no2 == 0)
		{
			return true;
		}
		ArrayList<Integer> list2 = new ArrayList<Integer>(list.subList(2,list.size()));
		return containsNegativePair(list2);
	}
	
	
	public static void main(String[] args)
	{
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		System.out.println(swap("111000"));
		System.out.println(stringOfSquares(5));
		System.out.println(containsNegativePair(list1));
	}
	
}