package binaryTree;

public class BinaryTree
{
	TreeNode root;
	
	public static void main(String[] args)
	{
		int[] a = {1, 12, 8, 4, 6, 99, 2, 23, 74, 9, 51};	//Sample Data for Tree
		
		BinaryTree bt = new BinaryTree(a);
		
		System.out.println("Number of Nodes: " + bt.countNodes(bt.root));	//Prints Number of Nodes
		bt.preorder(bt.root);	//Traverses the Tree (preorder)
	}
	
	BinaryTree()	//Default Constructor
	{
		root = null;
	}
	
	BinaryTree(int[] a)		//Constructor to create a Tree based on given data
	{
		for(int i = 0; i < a.length; i++)	//Inserts each element in Tree
			insertNode(a[i]);
	}
	
	int countNodes(TreeNode root)	//Function to countNodes (recursive)
	{
		if(root == null)	//End of branch
			return 0;
		return 1 + countNodes(root.getLeftLink()) + countNodes(root.getRightLink());	//Count current Node and call itself on both branches to count them
	}
	
	void preorder(TreeNode root)	//Function for preorder (Root-Left-Right) traversal of Binary Tree (recursive)
	{
		if(root != null)	//Till Node exists
		{
			System.out.print(root.getData() + " "); //Prints Root
			preorder(root.getLeftLink());	//Traverses Left Tree
			preorder(root.getRightLink());	//Traverses Right Tree
		}
	}
	
	void postorder(TreeNode root)	//Function for postorder (Left-Right-Root) traversal of Binary Tree (recursive)
	{
		if(root != null)	//Till Node Exists
		{
			preorder(root.getLeftLink());	//Traverses Left Tree
			preorder(root.getRightLink());	//Traverses Right Tree
			System.out.print(root.getData() + " ");	//Prints Root
		}
	}
	
	void inorder(TreeNode root)	//Function for inorder (Left-Root-Right) traversal of Binary Tree (recursive)
	{
		if(root != null)	//Till Node Exists
		{
			inorder(root.getLeftLink());	//Traverses Left Tree
			System.out.print(root.getData() + " ");	//Prints Root
			inorder(root.getRightLink());	//Traverses Right Tree
		}
	}
	
	boolean search(TreeNode root, int n)	//Function to search for a given value in Tree
	{
		if(root == null)	//Node does not exist
			return false;
		if(root.getData() == n)	//Data exists in current Node
			return true;
		if(search(root.getLeftLink(), n) || search(root.getRightLink(), n))	//Recursive call on both branches of Tree
			return true;
		return false;	//Default value
	}
	
	
	public void insertNode(int key) //Recursive function to insertNode in Tree
	{
	    root = insertNode(root, new TreeNode(key));	//Calls private recursive function with the root and a new Node
	}

	// private recursive call to prevent unintended additions at the wrong place

	private TreeNode insertNode(TreeNode currentParent, TreeNode newNode) {

	    if (currentParent == null) //Node does not exist
	        return newNode;	//Sets new Node here
	    else if (newNode.data >= currentParent.data) //Data >= Data of Parent
	        currentParent.right = insertNode(currentParent.right, newNode);	//Recursive call on Right branch
	    else if (newNode.data < currentParent.data) //Data < Data of Parent
	        currentParent.left = insertNode(currentParent.left, newNode);	//Recursive call on Left Branch

	    return currentParent;
	}
	
	
}
