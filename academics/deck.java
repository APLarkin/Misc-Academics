import java.util.List;

public class deck
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
	
	public deck()
	{
		front = null;
	}
	
	public void addFront(int value)
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
	public void addBack(int value)
	{
		Node newNode = new Node(value, null, null);
		
		if (front==null)
		{
			front = newNode;
			return; // a return statement like this jumps out of the function early
		}
		
		Node node = front;
		while (node.prev != null)
		{
			node = node.prev;
		}
		newNode.next = node;
		node.prev = newNode;
	}
	
	public void removeFront(int index)
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
	public void removeBack(int index)
	{
		if (front == null)
			return;  // better choice would be to throw an exception
		
		if (index == 0)
		{
			front = front.prev;
			return;
		}
		
		Node node = front;
		int count = 0;
		while (count < index - 1)
		{
			node = node.prev;
			count++;
		}
		node.prev = node.prev.prev;
		node.prev.prev.next = node.prev.prev.next.next;
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
		deck list = new deck();
	}
	
}