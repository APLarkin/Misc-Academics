import java.util.ArrayList;
import java.util.List;



public class SomeClass
{
	private int x;
	private String name;
	private List<Integer> list;
	
	public SomeClass(int x, String name)
	{
		this.x = x;
		this.name = name;
		list = new ArrayList<Integer>();
	}
	
	public int getX()
	{
		return x;
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void addStuffToList(int z)
	{
		list.add(z);
	}
	
	public List<Integer> getList()
	{
		return list;
	}
	
	public String toString()
	{
		return "SomeClass object x = " + x + " name = " + name;
	}


	public boolean equals(Object obj)
	{
		return ((SomeClass) obj).name.equals(name);
	}
	
	
	
	
}
