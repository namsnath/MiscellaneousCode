package cse2003.binaryTree;

public class TreeNode 
{
    TreeNode left, right;	//Links
    String data;	//Data

    TreeNode()		//Default Contructor
    {
        left = right = null;
        data = "";
    }

    TreeNode(String d)		//Node with data
    {
        left = null;
        right = null;
        data = d;
    }

    void setData(String d)	//Function to change data
    {
        data = d;
    }

    void setLeftLink(TreeNode n)	//Function to change Left Link
    {
        left = n;
    }

    void setRightLink(TreeNode n)	//Function to change Right Node
    {
        right = n;
    }

    String getData()	//Function to return data in a Node
    {
        return data;
    }

    TreeNode getLeftLink()	//Function to return Left Link of Node
    {
        return left;
    }

    TreeNode getRightLink()	//Function to return Right Link of Node
    {
        return right;
    }
}
