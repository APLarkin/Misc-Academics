// class representing a list 
// list is implemented using a dynamic array

import java.util.*;

public class AList
{
	private int numElements; 
	private int capacity;
	private int[] a;
	
	public AList()
	{
		capacity = 10;  // initially allocate enough room for 10 items
		numElements = 0; 
		a = new int[capacity];
	}
	
	public void add(int item)
	{
		if (numElements < capacity)
		{
			a[numElements] = item;
			numElements++;
		}
		else // create a new array, copy everything over, add new item
		{
			enlarge();
			a[numElements] = item;
			numElements++;
		}
	}
	
	private void enlarge()
	{
		//create a new array, copy everything over
		int[] newArray = new int[capacity*2];
		
		for (int i=0; i<capacity; i++)
			newArray[i] = a[i];
		
		a = newArray;	
		capacity *= 2;		
	}
	
	public int size()
	{
		return numElements;
	}

	public int getCapacity()
	{
		return capacity;
	}

	public boolean isEmpty()  // tells if list is empty or not
	{	
		/*
		if (numElements == 0)
			return true;
		else
			return false;
		*/
		return numElements == 0;  // this line replaces the 4 lines commented out above
	}
	
	public int get(int index)
	{
		// The two lines commented out below are how we might add some error-checking to our class.  Similar code should go elsewhere in the class.  
		// if (index < 0 || index >= numElements)
		//	 throw new IndexOutOfBoundsException("You tried to access an index that doesn't exist. The index was " + index + " and the list only has " + numElements + " elements.");
		return a[index];
	}
	
	public void set(int index, int value)
	{
		a[index] = value;
	}
	
	public String toString()
	{
		// We want the output to look something like this: [1, 2, 3]
		String s = "[";
		for (int i=0; i<numElements; i++)
		{
			s += a[i];
			if (i != numElements-1)
				s += ", ";
		}
		return s + "]";
	}
	
	public void delete(int index)
	{
		// Here is an example of deleting index 2
		// [11, 22, 33, 44, 55]  
		// list.delete(2) 
		// [11, 22, 44, 55]
		
		for (int i=index; i<numElements-1; i++)
			a[i] = a[i+1];
		
		if (numElements > 0)
			numElements--;
	}
	
	public void insert(int index, int value)
	{
		// Here is an example of inserting 999 at index 2
		// [11, 22, 33, 44, 55]
		// list.insert(2, 999);
		// [11, 22, 999, 33, 44, 55]
		
		if (numElements == capacity)
			enlarge();
		
		// save a copy of the last element in the list
		int save = 0; 
		if (numElements != 0)
			save = a[numElements-1];
		
		// Shift everything over to the right to make room for the new element.  Note that the last element's value is lost this way (that's why we saved a copy).
		for (int i=numElements-1; i>index; i--)
			a[i] = a[i-1];
		
		// Copy the last element at the new end of the list
		if (numElements != 0)
			a[numElements] = save;
		
		// insert the desired value at the index, now that we've made room for it
		a[index] = value;
		numElements++;
	}
	
	// not done during lecture
	public boolean contains(int value)
	{
		for (int i=0; i<numElements; i++)
			if (a[i] == value)
				return true;
		return false;
	}
	
	//getrandomitem
	
	public int getRandomItem()
	{
		int randomNum = (int)(Math.random() * (((size()-1) - 0) + 1));
		
		return get(randomNum);
	}
	
	//Count
	public int count(int x)
	{
		int counter = 0;
		int no1 = get(x);
		for(int i = 0; i<numElements;i++)
		{
			int no2 = get(i);
			if(no1 == no2)
			{
				counter++;
			}
		}
		
		return counter;
	}
	
	//clear
	public void clear()
	{
		int[] newArray = new int[capacity];
		a = newArray;
	}
	//reverse
	public void reverse()
	{
		int[] newArray = new int[capacity];
		int j = numElements-1;
		for(int i = 0;i<numElements;i++)
		{
			
			newArray[i] = get(j);
			j--;
		}
		a = newArray;
	}
	//equals
	public boolean equals(AList a)
	{
		for(int i = 0; i<numElements;i++)
		{
			if(a.get(i) != get(i))
			{
				return false;
			}
		}
		return true;
	}
	//remove
	public void remove(int x)
	{
		for(int i = 0; i<numElements;i++)
		{
			if(get(i) == x)
			{
				insert(i, 0);
			}
		}
	}
	
	//to array list
	public ArrayList toArrayList()
	{
		ArrayList newArrayList = new ArrayList();
		for(int i = 0; i < numElements; i++)
		{
			newArrayList.add(get(i));
		}
		return newArrayList;
	}
	
	//Copy
	public AList copy()
	{
		AList newList = new AList();
		newList.capacity = capacity;
		for(int i = 0; i< numElements;i++)
		{
			newList.insert(i, get(i));
		}
		return newList;
	}

	public static void main(String[] args)
	{
		AList list = new AList();
		
		list.add(11);
		list.add(11);
		list.add(11);
		list.add(44);
		list.add(55);
		
		System.out.println(list);
		System.out.println(list.size());
		System.out.println(list.get(0));
		
		list.set(0, 111);
		list.insert(2, 999);
		list.delete(4);
		System.out.println(list);
		
		System.out.println(list.contains(22));
		System.out.println(list.getCapacity());
		/*
		System.out.println(list.count(11));
		*/
		for (int i=0; i<8; i++)
			list.add(i);
		System.out.println(list);
		list.reverse();
		System.out.println(list);
		AList list2 = list;
		System.out.println(list.equals(list2));
		System.out.println(list.getCapacity());
		System.out.println(list.getRandomItem());
		list.clear();
		System.out.println(list);
	}
}
