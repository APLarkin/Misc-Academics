<<<<<<< HEAD
public class BinaryTree<T>
{
	private class Node
	{
		public T data;
		public Node left;
		public Node right;
		public Node parent;
		
		public Node(T data, Node parent, Node left, Node right)
		{
			this.data = data;
			this.parent = parent;
			this.left = left; 
			this.right = right;
		}
	}
	
	private Node root;
	
	public BinaryTree()
	{
		root = null;
	}
	
	public void add(T data, String location)
	{
		if (location.equals(""))
		{
			root = new Node(data, null, null, null);
			return;
		}
		
		Node node = root;
		for (int i=0; i<location.length()-1; i++)
			node = (location.charAt(i)=='L') ? node.left : node.right;
		
		if (location.charAt(location.length()-1) == 'L')
			node.left = new Node(data, node, null, null);
		else
			node.right = new Node(data, node, null, null);
	}
	
	public String toString()
	{
		return toStringHelperNicer(root, "");
	}
	
	private String toStringHelper(Node n)
	{
		if (n == null)
			return "";
		return toStringHelper(n.left) + 
				" " + n.data + " " + 
				toStringHelper(n.right);
	}
	
	private String toStringHelperNicer(Node n, String location)
	{
		if (n == null)
			return "";
		return (location=="" ? "root" : location) + ":" + n.data + "\n" +
				toStringHelperNicer(n.left, location+"L") +  
				toStringHelperNicer(n.right, location+"R");		
	}
	
	// returns how many nodes are in the tree
	public int size()
	{
		return sizeHelper(root);
	}
	
	private int sizeHelper(Node node)
	{
		if (node == null)
			return 0;
		return sizeHelper(node.left) + sizeHelper(node.right) + 1;
	}
	
	// returns the number of leaves in the tree
	public int numLeaves()
	{
		return numLeavesHelper(root);
	}
	
	private int numLeavesHelper(Node node)
	{
		if (node == null)
			return 0;
		if (node.left == null && node.right == null)
			return 1;
			
		return numLeavesHelper(node.left) + numLeavesHelper(node.right);
	}
	
	// returns whether the tree contains a certain data value
	public boolean contains(T data)
	{
		return containsHelper(root, data);
	}
	
	private boolean containsHelper(Node node, T data)
	{
		if (node == null)
			return false;
		
		if (node.data.equals(data)) // comparing generic data need .equals()
			return true;
		
		if (containsHelper(node.left, data) || containsHelper(node.right, data))
			return true;
		else 
			return false;
	}
	
	// returns how many levels deep the tree is
	public int height()
	{
		return heightHelper(root);
	}
	
	private int heightHelper(Node node)
	{
		if (node == null)
			return 0;
		return Math.max(heightHelper(node.left), heightHelper(node.right)) + 1;
	}
	
	public int numberOfFullNodes()
	{
		return numOfFullNodesHelp(root);
	}
	
	private int numOfFullNodesHelp(Node node)
	{
		if(node == null)
		{
			return 0;
		}
		if(node.left != null && node.right != null)
		{
			return 1 + numOfFullNodesHelp(node.right) + numOfFullNodesHelp(node.left);
		}
		return 0;
	}
	
	public static void main(String[] args)
	{
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		
		tree.add(3, "");
		tree.add(5, "L");
		tree.add(6, "R");
		tree.add(8, "LR");
		tree.add(10,  "LL");
		tree.add(12,  "RR");
		tree.add(12,  "RL");
		System.out.println(tree.height());
		System.out.println(tree);
		System.out.println(tree.numberOfFullNodes());
	}
=======
public class BinaryTree<T>
{
	private class Node
	{
		public T data;
		public Node left;
		public Node right;
		public Node parent;
		
		public Node(T data, Node parent, Node left, Node right)
		{
			this.data = data;
			this.parent = parent;
			this.left = left; 
			this.right = right;
		}
	}
	
	private Node root;
	
	public BinaryTree()
	{
		root = null;
	}
	
	public void add(T data, String location)
	{
		if (location.equals(""))
		{
			root = new Node(data, null, null, null);
			return;
		}
		
		Node node = root;
		for (int i=0; i<location.length()-1; i++)
			node = (location.charAt(i)=='L') ? node.left : node.right;
		
		if (location.charAt(location.length()-1) == 'L')
			node.left = new Node(data, node, null, null);
		else
			node.right = new Node(data, node, null, null);
	}
	
	public String toString()
	{
		return toStringHelperNicer(root, "");
	}
	
	private String toStringHelper(Node n)
	{
		if (n == null)
			return "";
		return toStringHelper(n.left) + 
				" " + n.data + " " + 
				toStringHelper(n.right);
	}
	
	private String toStringHelperNicer(Node n, String location)
	{
		if (n == null)
			return "";
		return (location=="" ? "root" : location) + ":" + n.data + "\n" +
				toStringHelperNicer(n.left, location+"L") +  
				toStringHelperNicer(n.right, location+"R");		
	}
	
	// returns how many nodes are in the tree
	public int size()
	{
		return sizeHelper(root);
	}
	
	private int sizeHelper(Node node)
	{
		if (node == null)
			return 0;
		return sizeHelper(node.left) + sizeHelper(node.right) + 1;
	}
	
	// returns the number of leaves in the tree
	public int numLeaves()
	{
		return numLeavesHelper(root);
	}
	
	private int numLeavesHelper(Node node)
	{
		if (node == null)
			return 0;
		if (node.left == null && node.right == null)
			return 1;
			
		return numLeavesHelper(node.left) + numLeavesHelper(node.right);
	}
	
	// returns whether the tree contains a certain data value
	public boolean contains(T data)
	{
		return containsHelper(root, data);
	}
	
	private boolean containsHelper(Node node, T data)
	{
		if (node == null)
			return false;
		
		if (node.data.equals(data)) // comparing generic data need .equals()
			return true;
		
		if (containsHelper(node.left, data) || containsHelper(node.right, data))
			return true;
		else 
			return false;
	}
	
	// returns how many levels deep the tree is
	public int height()
	{
		return heightHelper(root);
	}
	
	private int heightHelper(Node node)
	{
		if (node == null)
			return 0;
		return Math.max(heightHelper(node.left), heightHelper(node.right)) + 1;
	}
	
	public int numberOfFullNodes()
	{
		return numOfFullNodesHelp(root);
	}
	
	private int numOfFullNodesHelp(Node node)
	{
		if(node == null)
		{
			return 0;
		}
		if(node.left != null && node.right != null)
		{
			return 1 + numOfFullNodesHelp(node.right) + numOfFullNodesHelp(node.left);
		}
		return 0;
	}
	
	public static void main(String[] args)
	{
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		
		tree.add(3, "");
		tree.add(5, "L");
		tree.add(6, "R");
		tree.add(8, "LR");
		tree.add(10,  "LL");
		tree.add(12,  "RR");
		tree.add(12,  "RL");
		System.out.println(tree.height());
		System.out.println(tree);
		System.out.println(tree.numberOfFullNodes());
	}
>>>>>>> origin/master
}