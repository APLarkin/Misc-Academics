import java.util.*;

public class ListReversal
{
	public static ArrayList<Integer> reverse(ArrayList<Integer> list)
	{
		int ListSize = list.size();
		ArrayList<Integer> ReversedList = new ArrayList<Integer>();
		ArrayDeque<Integer> Temp = new ArrayDeque<Integer>();
		
		int var = 0; 
		for(int i = 0; i < ListSize; i++)
		{
			var = list.get(i);
			Temp.addFirst(var);
			
		}
		
		for(int i = 0; i < ListSize; i++)
		{
			var = Temp.getFirst();
			ReversedList.add(var);
			Temp.pop();
		}
		
		return ReversedList;
	}
	public static void main(String[] args)
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		list.add(5);
		list.add(4);
		list.add(3);
		list.add(2);
		
		ArrayList<Integer> NewList = reverse(list);
		
		String out = NewList.toString();
		System.out.print(out);
		
	}
	
}