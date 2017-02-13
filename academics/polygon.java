import java.io.*;
import java.util.*;

public class polygon
{
	private List<Coordinate> vertices = new ArrayList<Coordinate>();
	
	public void PolyConstructor(List<Coordinate> vertices)
	{
		List<Coordinate> vertices2 = new ArrayList<Coordinate>(vertices);
		Collections.copy(this.vertices, vertices2);
	}
	
	public  int numberOfVertices()
	{
		int NoOfVertices = vertices.size();
		return NoOfVertices;
	}
	public boolean overlaps(polygon Poly2)
	{
		boolean truefalse = false;
		for(int i = 0; i < Poly2.vertices.size(); i++)
		{	
			Coordinate Temp1 = Poly2.vertices.get(i);
			
			for(int j = 0; j < vertices.size(); j++)
			{
				Coordinate Temp2 = vertices.get(j);
				if(Temp1 == Temp2)
				{
					truefalse = true;
				}
			}
		
		}
		
		return truefalse;
	}
}