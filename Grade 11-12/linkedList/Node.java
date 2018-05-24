package linkedList;

public class Node
{
	int d;	//Data
	Node link;	//Link
	
	public Node(int val, Node l)	//Initializes the Node
	{
		d = val;
		link = l;
	}
	
	public void setLink(Node n)		//Modifies the Link of Node
	{
		link = n;
	}
	
	public void setData(int val)	//Modifies the Data in Node
	{
		d = val;
	}
	
	public Node getLink()			//Returns the Link of the Node
	{
		return link;
	}
	
	public int getData()			//Returns the Data in the Node
	{
		return d;
	}
	
}