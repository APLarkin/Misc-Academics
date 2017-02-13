<<<<<<< HEAD
import java.util.ArrayList;

public class LList
{
	private class Node
	{
		public int data;
		public Node next;
		
		public Node(int data, Node next)
		{
			this.data = data;
			this.next = next;
		}
	}
	
	private Node front;
	
	public LList()
	{
		front = null;
	}
	
	public boolean isEmpty()
	{
		/*
		if (front == null)
			return true;
		else
			return false;
		*/
		return front == null;
	}
	
	public int size()
	{
		// start at front of list, 
		// visit each element in turn, counting how many we visit
		// stop at the end, when next is null
		
		int count = 0;
		Node node = front;
		
		while (node != null)
		{
			count++;
			node = node.next;
		}
		return count;
	}
	
	public boolean contains(int value)
	{
		Node node = front;
		
		while (node != null)
		{
			if (node.data == value)
				return true;
			node = node.next;
		}
		return false;
	}
	
	public int get(int index)
	{
		int count = 0;
		Node node = front;
		
		while (count != index)
		{
			count++;
			node = node.next;
		}
		return node.data;
	}
	
	public void set(int index, int value)
	{
		int count = 0;
		Node node = front;
		
		while (count != index)
		{
			count++;
			node = node.next;
		}
		node.data = value;
	}
	
	public String toString()
	{
		// [3, 7, 8, 6]
		String s = "[";
		Node node = front;
		
		while (node != null)
		{
			s += node.data;
			if (node.next != null)
				s += ", ";
			node = node.next;
		}
		return s + "]";
	}
	
	public void addToFront(int value) // add a value to the front of list
	{
		front = new Node(value, front);
	}
	
	public void add(int value) // add a value to end of list
	{
		Node newNode = new Node(value, null);
		
		if (front==null)
		{
			front = newNode;
			return; // a return statement like this jumps out of the function early
		}
		
		Node node = front;
		while (node.next != null)
		{
			node = node.next;
		}
		node.next = newNode;
	}
	
	public void delete(int index)
	{
		if (front == null)
			return;  // better choice would be to throw an exception
		
		if (index == 0)
		{
			front = front.next;
			return;
		}
		
		Node node = front;
		int count = 0;
		while (count < index - 1)
		{
			node = node.next;
			count++;
		}
		node.next = node.next.next;
	}
	
	public void insert(int index, int value)
	{
		// didn't do, but should throw an exception if index > size of list
		
		if (index == 0)
		{
			addToFront(value);
			return;
		}
		
		Node node = front;
		int count = 0;
		
		while (count < index-1)
		{
			node = node.next;
			count++;
		}
		
		Node newNode = new Node(value, node.next);
		node.next = newNode;
	}
	public void removeZeroes()
	{
		Node node = front;
		ArrayList<Integer> newList = new ArrayList<Integer>();
		for(int i = 0; i < size(); i++)
		{
			if(node.data != 0)
			{
				newList.add(node.data);
			}
			node = node.next;
		}
		node = front;
		for(int j = 0; j <= newList.size(); j++)
		{
			
			if(j >= newList.size())
			{
				node.next = front;
				break;
			}
			if(j < newList.size())
			{
				node.data = newList.get(j);
			}
			node = node.next;
		}
		System.out.println(newList);
	}
	
	public static void main(String[] args)
	{
		// All of the code below is for testing the class.  
		/*
		LList list = new LList();
		System.out.println(list);
		list.add(3);
		list.add(7);
		list.add(8);
		list.add(6);
		System.out.println(list);
		System.out.println(list.get(3));
		list.set(0,  1000);
		System.out.println(list);
		System.out.println(list.contains(7));
		System.out.println(list.contains(17));
		list.addToFront(19);
		System.out.println(list);
		
		list = new LList();
		System.out.println("Empty? " + list.isEmpty());
		System.out.println(list.size());
		System.out.println(list.contains(7));
		list.addToFront(19);
		System.out.println(list);
		System.out.println("Empty? " + list.isEmpty());
		System.out.println(list.size());
		*/
		
		/*
		 * LList list = new LList();
		 
		list.add(11);
		list.add(22);
		System.out.println(list);
		list.delete(1);
		list.add(55);
		list.addToFront(66);
		System.out.println(list);
		
		for (int i=0; i<3; i++)
			list.delete(0);
		System.out.println(list);
		*/
		
		 LList list = new LList();
		
		list.add(0);
		list.add(0);
		list.add(1);
		list.add(3);
		list.add(0);
		list.add(4);
		list.add(0);
		list.add(0);
		list.add(5);
		list.add(3);
		list.add(0);
		list.add(0);
		list.add(0);
		list.removeZeroes();
		System.out.println(list);
			
	}
}

=======
import java.util.ArrayList;

public class LList
{
	private class Node
	{
		public int data;
		public Node next;
		
		public Node(int data, Node next)
		{
			this.data = data;
			this.next = next;
		}
	}
	
	private Node front;
	
	public LList()
	{
		front = null;
	}
	
	public boolean isEmpty()
	{
		/*
		if (front == null)
			return true;
		else
			return false;
		*/
		return front == null;
	}
	
	public int size()
	{
		// start at front of list, 
		// visit each element in turn, counting how many we visit
		// stop at the end, when next is null
		
		int count = 0;
		Node node = front;
		
		while (node != null)
		{
			count++;
			node = node.next;
		}
		return count;
	}
	
	public boolean contains(int value)
	{
		Node node = front;
		
		while (node != null)
		{
			if (node.data == value)
				return true;
			node = node.next;
		}
		return false;
	}
	
	public int get(int index)
	{
		int count = 0;
		Node node = front;
		
		while (count != index)
		{
			count++;
			node = node.next;
		}
		return node.data;
	}
	
	public void set(int index, int value)
	{
		int count = 0;
		Node node = front;
		
		while (count != index)
		{
			count++;
			node = node.next;
		}
		node.data = value;
	}
	
	public String toString()
	{
		// [3, 7, 8, 6]
		String s = "[";
		Node node = front;
		
		while (node != null)
		{
			s += node.data;
			if (node.next != null)
				s += ", ";
			node = node.next;
		}
		return s + "]";
	}
	
	public void addToFront(int value) // add a value to the front of list
	{
		front = new Node(value, front);
	}
	
	public void add(int value) // add a value to end of list
	{
		Node newNode = new Node(value, null);
		
		if (front==null)
		{
			front = newNode;
			return; // a return statement like this jumps out of the function early
		}
		
		Node node = front;
		while (node.next != null)
		{
			node = node.next;
		}
		node.next = newNode;
	}
	
	public void delete(int index)
	{
		if (front == null)
			return;  // better choice would be to throw an exception
		
		if (index == 0)
		{
			front = front.next;
			return;
		}
		
		Node node = front;
		int count = 0;
		while (count < index - 1)
		{
			node = node.next;
			count++;
		}
		node.next = node.next.next;
	}
	
	public void insert(int index, int value)
	{
		// didn't do, but should throw an exception if index > size of list
		
		if (index == 0)
		{
			addToFront(value);
			return;
		}
		
		Node node = front;
		int count = 0;
		
		while (count < index-1)
		{
			node = node.next;
			count++;
		}
		
		Node newNode = new Node(value, node.next);
		node.next = newNode;
	}
	public void removeZeroes()
	{
		Node node = front;
		ArrayList<Integer> newList = new ArrayList<Integer>();
		for(int i = 0; i < size(); i++)
		{
			if(node.data != 0)
			{
				newList.add(node.data);
			}
			node = node.next;
		}
		node = front;
		for(int j = 0; j <= newList.size(); j++)
		{
			
			if(j >= newList.size())
			{
				node.next = front;
				break;
			}
			if(j < newList.size())
			{
				node.data = newList.get(j);
			}
			node = node.next;
		}
		System.out.println(newList);
	}
	
	public static void main(String[] args)
	{
		// All of the code below is for testing the class.  
		/*
		LList list = new LList();
		System.out.println(list);
		list.add(3);
		list.add(7);
		list.add(8);
		list.add(6);
		System.out.println(list);
		System.out.println(list.get(3));
		list.set(0,  1000);
		System.out.println(list);
		System.out.println(list.contains(7));
		System.out.println(list.contains(17));
		list.addToFront(19);
		System.out.println(list);
		
		list = new LList();
		System.out.println("Empty? " + list.isEmpty());
		System.out.println(list.size());
		System.out.println(list.contains(7));
		list.addToFront(19);
		System.out.println(list);
		System.out.println("Empty? " + list.isEmpty());
		System.out.println(list.size());
		*/
		
		/*
		 * LList list = new LList();
		 
		list.add(11);
		list.add(22);
		System.out.println(list);
		list.delete(1);
		list.add(55);
		list.addToFront(66);
		System.out.println(list);
		
		for (int i=0; i<3; i++)
			list.delete(0);
		System.out.println(list);
		*/
		
		 LList list = new LList();
		
		list.add(0);
		list.add(0);
		list.add(1);
		list.add(3);
		list.add(0);
		list.add(4);
		list.add(0);
		list.add(0);
		list.add(5);
		list.add(3);
		list.add(0);
		list.add(0);
		list.add(0);
		list.removeZeroes();
		System.out.println(list);
			
	}
}

>>>>>>> origin/master
