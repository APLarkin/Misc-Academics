<<<<<<< HEAD
import java.util.List;

public class DoublyLinkedList
{
	private class Node
	{
		public int data;
		public Node next;
		public Node prev;
		
		public Node(int data, Node next, Node prev)
		{
			this.data = data;
			this.next = next;
			this.prev = prev;
			
		}
		
	}
	
	private Node front;
	
	public DoublyLinkedList()
	{
		front = null;
	}
	
	public void add(int value)
	{
		Node newNode = new Node(value, null, null);
		
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
		newNode.prev = node;
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
		node.next.next.prev = node.next.next.prev.prev;
	}
	
	public String toString()
	{
		// [3, 7, 8, 6]
		String s = "[";
		Node node = front;
		
		while (node.next != null)
		{
			s += node.data;
			if (node.next != null)
			{
				s += ", ";
			}
			node = node.next;
		}
		return s + "]";
	}
	
	public static void main(String[] args)
	{
		DoublyLinkedList list = new DoublyLinkedList();
		
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(10);
		list.delete(1);
		
		String out = list.toString();
		System.out.print(out);
	}
	
=======
import java.util.List;

public class DoublyLinkedList
{
	private class Node
	{
		public int data;
		public Node next;
		public Node prev;
		
		public Node(int data, Node next, Node prev)
		{
			this.data = data;
			this.next = next;
			this.prev = prev;
			
		}
		
	}
	
	private Node front;
	
	public DoublyLinkedList()
	{
		front = null;
	}
	
	public void add(int value)
	{
		Node newNode = new Node(value, null, null);
		
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
		newNode.prev = node;
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
		node.next.next.prev = node.next.next.prev.prev;
	}
	
	public String toString()
	{
		// [3, 7, 8, 6]
		String s = "[";
		Node node = front;
		
		while (node.next != null)
		{
			s += node.data;
			if (node.next != null)
			{
				s += ", ";
			}
			node = node.next;
		}
		return s + "]";
	}
	
	public static void main(String[] args)
	{
		DoublyLinkedList list = new DoublyLinkedList();
		
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(10);
		list.delete(1);
		
		String out = list.toString();
		System.out.print(out);
	}
	
>>>>>>> origin/master
}