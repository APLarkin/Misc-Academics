<<<<<<< HEAD
import java.util.List;

//this is fucking annoying
//add and to-string works if only one item is added
//then it goes to shit with null pointer exceptions and blackscreens everywhere
//after three days of being frustrated i've given up

public class CicularLinkedList
{
	private class Node
	{
		public int data;
		public Node next;
		public boolean isFront;
		
		public Node(int data, Node next, boolean isFront)
		{
			this.data = data;
			this.next = next;
			this.isFront = false;
			//extra var to keep track of which node is the original front
		}
		
	}
	
	private Node front;

	public CicularLinkedList()
	{
		front  = null;
	}
	
	public void add(int value) // add a value to end of list
	{
		Node newNode = new Node(value, front, false);
		//all new nodes start out with isFront == false
		if (front==null)
		{
			front = new Node(value, front, true);//altered for unique front var
			return;
		}
		
		Node node = front.next;
		
		while(node.next.isFront == false)
		{
			node = node.next;
		}
		
		node.next = newNode;
	} 
	
	//no matter what i do, the program either throws a null pointer exception
	//or displays a blank console forever.
	
	public String toString()
	{
		// [3, 7, 8, 6]
		String s = "[";
		Node node = front;
		
		while (node.next != null)
		{
			s += node.data;
			if (node.next != front)
			{
				s += ", ";
			}
			node = node.next;
		}
		return s + "]";
	}
	
	public static void main(String[] args)
	{
		CicularLinkedList list = new CicularLinkedList();
		
		list.add(5);
		list.add(6);
		list.add(7);
		String out = list.toString();
		
		System.out.println(out);
	}
	
=======
import java.util.List;

//this is fucking annoying
//add and to-string works if only one item is added
//then it goes to shit with null pointer exceptions and blackscreens everywhere
//after three days of being frustrated i've given up

public class CicularLinkedList
{
	private class Node
	{
		public int data;
		public Node next;
		public boolean isFront;
		
		public Node(int data, Node next, boolean isFront)
		{
			this.data = data;
			this.next = next;
			this.isFront = false;
			//extra var to keep track of which node is the original front
		}
		
	}
	
	private Node front;

	public CicularLinkedList()
	{
		front  = null;
	}
	
	public void add(int value) // add a value to end of list
	{
		Node newNode = new Node(value, front, false);
		//all new nodes start out with isFront == false
		if (front==null)
		{
			front = new Node(value, front, true);//altered for unique front var
			return;
		}
		
		Node node = front.next;
		
		while(node.next.isFront == false)
		{
			node = node.next;
		}
		
		node.next = newNode;
	} 
	
	//no matter what i do, the program either throws a null pointer exception
	//or displays a blank console forever.
	
	public String toString()
	{
		// [3, 7, 8, 6]
		String s = "[";
		Node node = front;
		
		while (node.next != null)
		{
			s += node.data;
			if (node.next != front)
			{
				s += ", ";
			}
			node = node.next;
		}
		return s + "]";
	}
	
	public static void main(String[] args)
	{
		CicularLinkedList list = new CicularLinkedList();
		
		list.add(5);
		list.add(6);
		list.add(7);
		String out = list.toString();
		
		System.out.println(out);
	}
	
>>>>>>> origin/master
}