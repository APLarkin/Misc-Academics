public class Tree
{
	private int data;
	private Tree left;
	private Tree right;
	public static final int LEFT=0, RIGHT=1;
	
	public Tree(int data, Tree left, Tree right)
	{
		this.data = data;
		this.right = right;
		this.left = left;
	}
	
	public String toString()
	{
		return toStringHelper(this);
	}
	
	public String toStringHelper(Tree tree)
	{
		if (tree == null)
			return "";
		
		return tree.data + " " + 
			   toStringHelper(tree.left) + 
			   toStringHelper(tree.right);
	}
	
	public void add(int data, Tree parent, int leftRight)
	{
		if (leftRight == LEFT)
			parent.left = new Tree(data, null, null);
		else
			parent.right = new Tree(data, null, null);
	}
	
	
	public static void main(String[] args)
	{
		Tree tree = new 
				Tree(2, 
					new Tree(5, null, null), 
					new Tree(4, 
							new Tree(7, null, null), 
							new Tree(8, null, null)));
		
		tree.add(3, tree.left, Tree.RIGHT);
		tree.add(13, tree.right.right, Tree.RIGHT);
		
		System.out.println(tree);
	}
}

