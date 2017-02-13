import java.util.*;

public class BinaryTree<Integer>
{
	private class Node
	{
		public int data;
		public Node left;
		public Node right;
		public Node parent;
		
		public Node(int data, Node parent, Node left, Node right)
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
	
	public void add(int data, String location)
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
	public boolean contains(int data)
	{
		return containsHelper(root, data);
	}
	
	private boolean containsHelper(Node node, int data)
	{
		if (node == null)
			return false;
		
		if (node.data == data) // comparing generic data need .equals()
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
	
	public int count(int x)
	{
		return countHelper(root, x);
	}
	
	private int countHelper(Node node, int x)
	{
		if(node.data == x && node.left != null && node.right != null)
		{
			return 1 + countHelper(node.right, x) + countHelper(node.left, x);
		}
		if(node.data == x && node.left != null && node.right == null)
		{
			return 1 + countHelper(node.left, x);
		}
		if(node.data== x && node.right != null && node.left == null)
		{
			return 1 + countHelper(node.right, x);
		}
		if(node.data== x && node.left == null && node.right == null)
		{
			return 1;
		}
		if(node.left != null && node.right != null)
		{
			return countHelper(node.right, x) + countHelper(node.left, x);
		}
		if(node.left != null && node.right == null)
		{
			return countHelper(node.left, x);
		}
		if(node.right != null && node.left == null)
		{
			return countHelper(node.right, x);
		}
		if(node.left == null && node.right == null)
		{
			return 0;
		}
		return 0;
	}
	
	public int numOfDescendants(String location)
	{
		root = getToLocation(location, root);
		return numOfDescendantsHelper(root);
	}
	private int numOfDescendantsHelper(Node node)
	{
		if(node.left != null && node.right != null)
		{
			return 2 + numOfDescendantsHelper(node.left) + numOfDescendantsHelper(node.right);
		}
		if(node.left != null && node.right == null)
		{
			return 1 + numOfDescendantsHelper(node.left);
		}
		if(node.right != null && node.left == null)
		{
			return 1 + numOfDescendantsHelper(node.right);
		}
		if(node.left == null || node.right == null)
		{
			return 0;
		}
		return 0;
	}
	
	public Node getToLocation(String location, Node node)
	{
		if(location.substring(0,1) == "L" && location.length() > 1)
		{
			node = node.left;
			return getToLocation(location.substring(1,location.length()), node);
		}
		if(location.substring(0,1) == "R" && location.length() > 1)
		{
			node = node.right;
			return getToLocation(location.substring(1,location.length()), node);
		}
	
		return node;
	}
	
	public boolean isUnbalanced()
	{
		return isUnbalancedHelper(root);
	}
	
	private boolean isUnbalancedHelper(Node node)
	{
		if(node.left != null && node.right != null)
		{
			return isUnbalancedHelper(node.left) && isUnbalancedHelper(node.right);
		}
		if((node.left == null && node.right !=null) || (node.right == null && node.left !=null))
		{
			return true;
		}
		return false;
	}
	
	public String printLevel(int k)
	{
		return printLevelHelper(k, root, 0);
	}
	private String printLevelHelper(int k, Node node, int x)
	{
		int counter = x;
		int temp1 = node.data;
		String temp2 = String.valueOf(temp1);
		if(k == x)
		{
			return temp2 + " ";
		}
		return printLevelHelper(k, node.left, x+1) + printLevelHelper(k, node.right, x+1);
		
	}
	
	public static void main(String[] args)
	{
		BinaryTree tree = new BinaryTree();
		
		tree.add(4, "");
		tree.add(3, "L");
		tree.add(3, "R");
		tree.add(3, "LR");
		tree.add(10,  "RR");
		tree.add(12,  "RRR");
		tree.add(12,  "RRL");
		tree.add(12,  "RL");
		System.out.println(tree.height());
		System.out.println(tree);
		System.out.println(tree.count(3));
		System.out.println(tree.numOfDescendants("R"));
		System.out.println(tree.isUnbalanced());
		System.out.println(tree.printLevel(1));
	}
}

