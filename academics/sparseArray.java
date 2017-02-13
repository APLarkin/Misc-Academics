import java.util.*;

public class sparseArray
{
	private HashMap<Integer, Integer> someArray;
	public sparseArray()
	{
		someArray = new HashMap<Integer, Integer>();
	}
		
	//get the value at index x
	public int get(int x)
	{
		if(!someArray.containsKey(x))
		{
			return 0;
		}
		if(someArray.containsKey(x))
		{
			return someArray.get(x);
		}
		return 0;
	}
	//set the value of index x to y
	public void set(int x, int y)
	{
		someArray.put(x, y);
	}
	//check if it contains the value of x
	public boolean contains(int x)
	{
		
		if(someArray.containsValue(x))
		{
			return true;
		}
		return false;
	}
	public static void main(String[] args)
	{
		sparseArray list1 = new sparseArray();
		list1.set(1, 5);
		list1.set(27, 4);
		list1.set(1000, 500);
		System.out.println(list1.contains(5));
		System.out.println(list1.contains(60));
		System.out.println(list1.get(100));
		System.out.println(list1.get(27));
	}
}