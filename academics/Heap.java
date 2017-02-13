<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.math.*;

public class Heap
{
	private List<Integer> data;
	
	public Heap()
	{
		data = new ArrayList<Integer>();
	}
	
	public void add(int value)
	{
		// start by adding the value at the end of the heap
		data.add(value);
		
		// get the locations of the child and its parent
		int c = data.size()-1; 
		int p = (c-1) / 2;
		
		// keep going as long as the value is not in the right place and we haven't reached the tree's top 
		while (p >= 0 && data.get(p) > data.get(c))
		{
			// swap the parent's value w/ child's value
			int hold = data.get(p);
			data.set(p, data.get(c));
			data.set(c, hold);
			// parent becomes new child and then compute its parent's index
			c = p;
			p = (c-1) / 2;
		}	
	}
	
	public int peek()
	{
		return data.get(0);
	}
	
	// return and remove the top of the heap
	public int pop()
	{
		// save the current value of the top of the tree
		int saveTop = data.get(0);
		
		// promote the last thing in the tree to the top
		data.set(0, data.get(data.size()-1));
		data.remove(data.size()-1);

		// now move down through the tree and swap stuff as needed
		int p = 0;
		int c1 = 1, c2 = 2;
		
		while (c2 < data.size() && (data.get(p) > data.get(c1) || data.get(p) > data.get(c2)))
		{
			// always swap with the smaller child
			if (data.get(c1) <= data.get(c2))
			{
				int hold = data.get(c1);
				data.set(c1, data.get(p));
				data.set(p, hold);
				p = c1;
			}
			else
			{
				int hold = data.get(c2);
				data.set(c2, data.get(p));
				data.set(p, hold);
				p = c2;
			}
			// move down the tree
			c1 = 2*p+1;
			c2 = 2*p+2;
		}
		
		// Special case if at end of tree w/ a left child and no right child
		if (c2 >= data.size() && c1 < data.size() && data.get(p) > data.get(c1))
		{
			int hold = data.get(c1);
			data.set(c1, data.get(p));
			data.set(p, hold);
		}
		return saveTop;
	}
	public void delete(int x)
	{
		for(int i = 0; i < data.size(); i++)
		{
			if(data.get(i) == x)
			{
				data.set(i, data.get(data.size()-1));
				data.remove(data.size()-1);
				int p = 0;
				int c1 = 1, c2 = 2;
		
				while (c2 < data.size() && (data.get(p) > data.get(c1) || data.get(p) > data.get(c2)))
				{
					// always swap with the smaller child
					if (data.get(c1) <= data.get(c2))
					{
						int hold = data.get(c1);
						data.set(c1, data.get(p));
						data.set(p, hold);
						p = c1;
					}
					else
					{
						int hold = data.get(c2);
						data.set(c2, data.get(p));
						data.set(p, hold);
						p = c2;
					}
					// move down the tree
					c1 = 2*p+1;
					c2 = 2*p+2;
				}
				break;
			}
		}
	}
	
	public int max()
	{
		int maximum = 0;
		int start = (int)Math.pow(2,(Math.floor(Math.log(data.size() + 1))) - 1);
		for(int i = start; i < data.size(); i++)
		{
			if(data.get(i) > maximum)
			{
				maximum = data.get(i);
			}
		}
		return maximum;
	}
	
	
	public static void main(String[] args)
	{
		/*
		Heap heap = new Heap();
		heap.add(2);
		heap.add(5);
		heap.add(1);
		heap.add(3);
		heap.add(6);
		System.out.println(heap.data);
		heap.pop();
		System.out.println(heap.data);
		heap.pop();
		System.out.println(heap.data);
		heap.pop();
		System.out.println(heap.data);
		heap.pop();
		System.out.println(heap.data);
		heap.pop();
		System.out.println(heap.data);
		*/
		
		// Test the heap by adding in 100 random numbers and then popping them all off, one-by-one
		Heap heap = new Heap();
		
		
		
		
	}
}

=======
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.math.*;

public class Heap
{
	private List<Integer> data;
	
	public Heap()
	{
		data = new ArrayList<Integer>();
	}
	
	public void add(int value)
	{
		// start by adding the value at the end of the heap
		data.add(value);
		
		// get the locations of the child and its parent
		int c = data.size()-1; 
		int p = (c-1) / 2;
		
		// keep going as long as the value is not in the right place and we haven't reached the tree's top 
		while (p >= 0 && data.get(p) > data.get(c))
		{
			// swap the parent's value w/ child's value
			int hold = data.get(p);
			data.set(p, data.get(c));
			data.set(c, hold);
			// parent becomes new child and then compute its parent's index
			c = p;
			p = (c-1) / 2;
		}	
	}
	
	public int peek()
	{
		return data.get(0);
	}
	
	// return and remove the top of the heap
	public int pop()
	{
		// save the current value of the top of the tree
		int saveTop = data.get(0);
		
		// promote the last thing in the tree to the top
		data.set(0, data.get(data.size()-1));
		data.remove(data.size()-1);

		// now move down through the tree and swap stuff as needed
		int p = 0;
		int c1 = 1, c2 = 2;
		
		while (c2 < data.size() && (data.get(p) > data.get(c1) || data.get(p) > data.get(c2)))
		{
			// always swap with the smaller child
			if (data.get(c1) <= data.get(c2))
			{
				int hold = data.get(c1);
				data.set(c1, data.get(p));
				data.set(p, hold);
				p = c1;
			}
			else
			{
				int hold = data.get(c2);
				data.set(c2, data.get(p));
				data.set(p, hold);
				p = c2;
			}
			// move down the tree
			c1 = 2*p+1;
			c2 = 2*p+2;
		}
		
		// Special case if at end of tree w/ a left child and no right child
		if (c2 >= data.size() && c1 < data.size() && data.get(p) > data.get(c1))
		{
			int hold = data.get(c1);
			data.set(c1, data.get(p));
			data.set(p, hold);
		}
		return saveTop;
	}
	public void delete(int x)
	{
		for(int i = 0; i < data.size(); i++)
		{
			if(data.get(i) == x)
			{
				data.set(i, data.get(data.size()-1));
				data.remove(data.size()-1);
				int p = 0;
				int c1 = 1, c2 = 2;
		
				while (c2 < data.size() && (data.get(p) > data.get(c1) || data.get(p) > data.get(c2)))
				{
					// always swap with the smaller child
					if (data.get(c1) <= data.get(c2))
					{
						int hold = data.get(c1);
						data.set(c1, data.get(p));
						data.set(p, hold);
						p = c1;
					}
					else
					{
						int hold = data.get(c2);
						data.set(c2, data.get(p));
						data.set(p, hold);
						p = c2;
					}
					// move down the tree
					c1 = 2*p+1;
					c2 = 2*p+2;
				}
				break;
			}
		}
	}
	
	public int max()
	{
		int maximum = 0;
		int start = (int)Math.pow(2,(Math.floor(Math.log(data.size() + 1))) - 1);
		for(int i = start; i < data.size(); i++)
		{
			if(data.get(i) > maximum)
			{
				maximum = data.get(i);
			}
		}
		return maximum;
	}
	
	
	public static void main(String[] args)
	{
		/*
		Heap heap = new Heap();
		heap.add(2);
		heap.add(5);
		heap.add(1);
		heap.add(3);
		heap.add(6);
		System.out.println(heap.data);
		heap.pop();
		System.out.println(heap.data);
		heap.pop();
		System.out.println(heap.data);
		heap.pop();
		System.out.println(heap.data);
		heap.pop();
		System.out.println(heap.data);
		heap.pop();
		System.out.println(heap.data);
		*/
		
		// Test the heap by adding in 100 random numbers and then popping them all off, one-by-one
		Heap heap = new Heap();
		
		
		
		
	}
}

>>>>>>> origin/master
