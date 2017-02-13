import java.util.*;
//I can't track down where the errors in this are occuring. Some stuff half-works, some other stuff doesn't work at all, even though I've spent the last few hours working on this.
//I get the sense that it has something to do with array bounds.
public class BitSet
{
	private ArrayList<Boolean> someSet;
	public BitSet(int n)
	{
		someSet = new ArrayList<Boolean>();
		for(int i = 0; i < n; i++)
		{
			if(n == i)
			{
				someSet.add(true);
			}
			if(n != i)
			{
				someSet.add(false);
			}
		}
		
	}
	public BitSet(ArrayList<Integer> list)
	{
		someSet = new ArrayList<Boolean>();
		for(int i = 0; i < list.size();i++)
		{
			if(list.contains(i))
			{
				someSet.add(true);
			}
			if(!list.contains(i))
			{
				someSet.add(false);
			}
		}
	}
	public String toString()
	{
		String tempString = "[ ";
		for(int i = 0; i < someSet.size(); i++)
		{
			if(someSet.get(i) == true && i <= someSet.size())
			{
				tempString += "true, ";
			}
			if(someSet.get(i) == false && i <= someSet.size())
			{
				tempString += "false, ";
			}
			if(someSet.get(i) == true && i == someSet.size())
			{
				tempString += "true";
			}
			if(someSet.get(i) == false && i == someSet.size())
			{
				tempString += "false";
			}
		}
		return tempString+"]";
	}
	public ArrayList<Integer> toArrayList()
	{
		ArrayList<Integer> tempList = new ArrayList<Integer>();
		for(int i = 0; i < someSet.size(); i++)
		{
			if(someSet.get(i) == true)
			{
				tempList.add(i);
			}
		}
		return tempList;
	}
	public boolean contains(int x)
	{
		if(someSet.size() < x)
		{
			return false;
		}
		return someSet.get(x);
	}
	public void add(int x)
	{
		if(someSet.size() < x)
		{
			for(int i = 0; i < x; i++)
			{
				if(i < x)
				{
					someSet.add(false);
				}
				if(i == x)
				{
					someSet.add(true);
				}
			}
		}
		else
		{
			someSet.set(x, true);
		}
	}
	public void remove(int x)
	{
		someSet.set(x, false);
	}
	public int size()
	{
		int count = 0;
		for(int i = 0; i < someSet.size(); i++)
		{
			if(someSet.get(i) == true)
			{
				count++;
			}
		}
		return count;
	}
	public boolean isEmpty()
	{
		if(someSet.contains(true))
		{
			return false;
		}
		return true;
	}
	public int getMaxPossibleElement()
	{
		return someSet.size();
	}
	public ArrayList<Boolean> union(ArrayList<Boolean> s2)
	{
		ArrayList<Boolean> tempList = new ArrayList<Boolean>();
		for(int i = 0; i < s2.size(); i++)
		{
			if(s2.get(i) == true)
			{
				tempList.set(i, true);
			}
			else
			{
				tempList.set(i, false);
			}
		}
		for(int j = 0; j < someSet.size(); j++)
		{
			if(someSet.get(j) == true)
			{
				tempList.set(j, true);
			}
		}
		return tempList;
	}
	public ArrayList<Boolean> intersection(ArrayList<Boolean> s2)
	{
		ArrayList<Boolean> tempList = new ArrayList<Boolean>();
		if(s2.size() <= someSet.size())
		{
			for(int i = 0; i < s2.size();i++)
			{
				if(s2.get(i) == true && someSet.get(i) == true)
				{
					tempList.set(i, true);
				}
				if(s2.get(i) != someSet.get(i))
				{
					tempList.set(i, false);
				}
			}
		}
		if(s2.size() > someSet.size())
		{
			for(int i = 0; i < someSet.size();i++)
			{
				if(s2.get(i) == true && someSet.get(i) == true)
				{
					tempList.set(i, true);
				}
				if(s2.get(i) != someSet.get(i))
				{
					tempList.set(i, false);
				}
			}
		}
		return tempList;
	}
	public ArrayList<Boolean> difference(ArrayList<Boolean> s2)
	{
		ArrayList<Boolean> tempList = new ArrayList<Boolean>();
		if(s2.size() <= someSet.size())
		{
			for(int i = 0; i < s2.size();i++)
			{
				if(s2.get(i) != someSet.get(i))
				{
					tempList.set(i, true);
				}
				if(s2.get(i) == true && someSet.get(i) == true)
				{
					tempList.set(i, false);
				}
			}
		}
		if(s2.size() > someSet.size())
		{
			for(int i = 0; i < someSet.size();i++)
			{
				if(s2.get(i) != someSet.get(i))
				{
					tempList.set(i, true);
				}
				if(s2.get(i) == true && someSet.get(i) == true)
				{
					tempList.set(i, false);
				}
			}
		}
		return tempList;
	}
	public static void main(String[] args)
	{
		
		BitSet set1 = new BitSet(0);
		set1.add(5);
		System.out.println(set1.isEmpty());
		System.out.println(set1.toString());
		System.out.println(set1.contains(5));
	}
	
}