package cse2003.binaryTree;

import java.util.Scanner;

public class BinarySearchTree 
{   
    TreeNode root;
    
    public static void main(String[] args) 
    {
        Scanner s = new Scanner(System.in);
        
        //String[] a = {"12", "8", "1", "4", "6", "99", "2", "23", "74", "9", "51"};
        //BinarySearchTree b = new BinarySearchTree(a);
        String a[];
        int n;
        BinarySearchTree b = new BinarySearchTree();
        
        System.out.println("Enter number of nodes: ");
        n = s.nextInt();
        
        s.nextLine();
        
        a = new String[n];
        
        System.out.println("Enter elements: ");
        for(int i = 0; i < a.length; i++)
        {
            a[i] = s.nextLine();
            b.insertNode(a[i]);
        }
        
        System.out.println("Preorder = ");
        b.preorder(b.root);
        System.out.println();
        
        System.out.println("Postorder = ");
        b.postorder(b.root);
        System.out.println();
        
        System.out.println("Inorder = ");
        b.inorder(b.root);
        System.out.println();
    }
    
    BinarySearchTree()
    {
        root = null;
    }
    
    BinarySearchTree(String s[])
    {
        for(int i = 0; i < s.length; i++)	//Inserts each element in Tree
            insertNode(s[i]);
    }
    
    public void insertNode(String s)
    {
        root = insertNode(root, new TreeNode(s));
    }
    
    private TreeNode insertNode(TreeNode parent, TreeNode newNode)
    {
        if (parent == null) //Node does not exist
            return newNode;	//Sets new Node here
        else if (newNode.data.compareTo(parent.data) >= 0) //Data >= Data of Parent
            parent.right = insertNode(parent.right, newNode);	//Recursive call on Right branch
        else if (newNode.data.compareTo(parent.data) < 0) //Data < Data of Parent
            parent.left = insertNode(parent.left, newNode);	//Recursive call on Left Branch

        return parent;
    }
    
    void preorder(TreeNode ptr)
    {
        if(ptr != null)
        {
            System.out.print(ptr.data + "\t");
            preorder(ptr.left);
            preorder(ptr.right);
        }
    }
    void inorder(TreeNode ptr)
    {
        if(ptr != null)
        {
            inorder(ptr.left);
            System.out.print(ptr.data + "\t");
            inorder(ptr.right);
        }
    }
    void postorder(TreeNode ptr)
    {
        if(ptr != null)
        {
            postorder(ptr.left);
            postorder(ptr.right);
            System.out.print(ptr.data + "\t");
        }
    }
    
    int countNodes()
    {
        return countNodes(root);
    }
    
    private int countNodes(TreeNode ptr)
    {
        if(ptr == null)
            return 0;
        else
            return 1 + countNodes(ptr.left) + countNodes(ptr.right);
    }
    
    int countLeafNodes()
    {
        return countLeafNodes(root);
    }
    
    private int countLeafNodes(TreeNode ptr)
    {
        if(ptr == null)
            return 0;
        else if(ptr.left == null && ptr.right == null)
            return 1;
        else
            return countLeafNodes(ptr.left) + countLeafNodes(ptr.right);
    }
    
}
