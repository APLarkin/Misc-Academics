import java.util.*;
import java.io.*;

public class Course
{
	private String name;
	private int capacity;
	private List<String> studentIDs;
	
	public void Constructor(String name, int capacity)
	{
		this.name = name;
		this.capacity = capacity;
		this.studentIDs = new ArrayList<String>();
	}
	public boolean isFull()
	{
		int temp = studentIDs.size();
		if(this.capacity == temp)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public void addStudent(String id)
	{
		boolean TrueFalse = false;
		for(int i = 0; i < studentIDs.size(); i++)
		{
			String temp = studentIDs.get(i);
			if(temp == id)
			{
				TrueFalse = true;
			}
		}
		if(TrueFalse == true)
		{
			System.out.println("Already in.");
		}
		else
		{
			this.studentIDs.add(id);
		}
		
	}

}