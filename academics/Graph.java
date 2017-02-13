import java.util.*;

public class Graph<T> implements Iterable<T>
{
	protected Map<T, List<T>> neighbors;
	
	public Graph()
	{
		 neighbors = new LinkedHashMap<T, List<T>>();
	}
	
	public void add(T v)
	{
		if (!neighbors.containsKey(v)) 
			neighbors.put(v, new ArrayList<T>());
	}
	
	public void addEdge(T u, T v)
	{
		neighbors.get(u).add(v);
		neighbors.get(v).add(u);
	}
	
	// return a list of the neighbors of vertex u
	public List<T> neighbors(T u)
	{
		// return a copy of the list of u's neighbors
		return new ArrayList<T>(neighbors.get(u)); 
	}
	
	// number of vertices
	public int size()
	{
		return neighbors.size();
	}
	
	// the method below makes it so that we can loop over our graph with a loop like for (String x : graph)
	//@Override
	public Iterator<T> iterator()
	{
		return neighbors.keySet().iterator();
	}
	//hw12 #1
	public String toString()
	{
		
		String finalString = "";
		List<T> tempArray = new ArrayList<T>();
		for(T x : this)
		{
			tempArray = this.neighbors(x);
			finalString += x + " : ";
			for(int i = 0; i < tempArray.size(); i++)
			{
				finalString += tempArray.get(i) + " ";
			}
			finalString += "\n";
		}
		
		return finalString;
	}
	//breadth-first search
	public List<T> bfs(T start, T end)
	{
		Deque<T> queue = new ArrayDeque<T>();
		HashMap<T, T> parentMap = new HashMap<T, T>();
		queue.add(start);
		parentMap.put(start, null);
		while (!queue.isEmpty())
		{
			T v = queue.remove();
			for (T n:neighbors(v))
			{
				if (!parentMap.containsKey(n))
				{
					queue.add(n);
					parentMap.put(n, v);
				}
				if (n.equals(end))
				{
					List<T> returnList = new ArrayList<T>();
					T u = end;
					while (u!=null)
					{
						returnList.add(u);
						u = parentMap.get(u);
					}
					Collections.reverse(returnList);
					return returnList;
				}
			}
		}
		return new ArrayList<T>();
	}
	
	public static void main(String[] args)
	{
		Graph<String> graph = new Graph<String>();
		Graph<String> riddle = new Graph<String>();
		//goat -> cabbage -> goat -> wolf -> goat
		riddle.add("goatWolfCabbageWest");
		riddle.add("goatWolfCabbageEast");
		riddle.add("WolfCabbageWest");
		riddle.add("goatEast");
		riddle.add("WolfEast");
		riddle.add("WolfCabbageEast");
		riddle.add("goatWestCabbageEast");
		
		riddle.addEdge("goatWolfCabbageWest", "goatEast");
		riddle.addEdge("goatEast", "goatWestCabbageEast");
		riddle.addEdge("goatWestCabbageEast", "WolfEast");
		riddle.addEdge("WolfEast", "goatWolfCabbageEast");
		
		graph.add("a");
		graph.add("b");
		graph.add("c");
		graph.add("d");
		graph.add("e");
		graph.add("f");
		
		graph.addEdge("a", "b");
		graph.addEdge("a", "c");
		graph.addEdge("a", "d");
		graph.addEdge("e", "f");
		graph.addEdge("e", "d");
		System.out.println(graph.toString());
		System.out.println(graph.bfs("a", "f"));
		System.out.println(riddle.bfs("goatWolfCabbageWest", "goatWolfCabbageEast"));
	}
}
