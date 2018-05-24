import linkedList.*;	//To use the Node class

public class QuickSortLinkedList	
{

	public static void main(String[] args)
	{
		int[] A = {11, 9, 7, 3, 63, 74, 11, 66, 78};	//Sample Data
		
		LinkedList LL = new LinkedList(A);	//Creates a Linked List with the sample data
		
		
		QuickSortLinkedList qs = new QuickSortLinkedList();	//Class Object
		qs.quicksort(LL, LL.start, LL.end);	//Call for Quicksort Method
		
		LL.display();	//Print Sorted List
	}
	
	public void quicksort(LinkedList LL, Node left, Node right)	//Function to sort the List
	{
		Node q;	//Pivot Node
		boolean flag = false;	
		
		for(Node ptr = left; ptr != null; ptr = ptr.getLink()) //Loop to iterate from left through right to make sure right lies after left
			if(ptr == right)
				flag = true;	//Indicates that the Node right has been found
		
		if(flag)
		{	
			q = partition(LL, left, right);	//Passes Nodes to partition and assigns pivot Node to q
			Node temp;	//Temporary node
			for(temp = LL.start; temp != q; temp = temp.getLink()) //Loop to iterate to Node before q
			{}
			quicksort(LL, left, temp); //Passes first half to Sort
			quicksort(LL, q.getLink(), right);	//Passes second half to sort
		}
	}

	public Node partition(LinkedList LL, Node left, Node right)	//Function to split array into 3 parts, left block, pivot, right block
	{
		Node P = left;	//Set pivot to first element in the List
		Node ptr = LL.start;	//Node for iteration
		Node l = left;	//First Node in the List
		Node r = right;	//Last node in the part of List passed
		int i, j;	//Iteration variables
		
		for(i = 0; ptr != left; ptr = ptr.getLink(), i++) {} //Gets numerical position of left
		
		ptr = LL.start;	//Resets pointer to start of List
		for(j = 0; ptr != right.getLink(); ptr = ptr.getLink(), j++) {}	//Gets numerical position of right
		//j++;
		Node temp;	//Temporary Node
		
		for(;;)
		{
			while(l.getLink().getData() < P.getData())	//Finds last node in the List in line which is smaller than Pivot
			{
				l = l.getLink();	//Gets next Node in List
				i++;	//Position
				if(l == right)	//Out of bounds of part passed
					break;
			}
			
			
			for(temp = LL.start; temp != r; temp = temp.getLink())	//Sets temp to Node before right
			{}
			
			while(temp.getData() > P.getData())	//Finds last Node in line (from the rear) which is larger than Pivot
			{
				Node temp2;
				for(temp2 = LL.start; temp2 != temp; temp2 = temp2.getLink())
				{}
				temp = temp2;
				j--;
				
				if(temp2 == left)	//Breaks if Node is at/before left
					break;
			}
			
			if(i >= j)	//Breaks if i and j are same, or i is larger
				break;
			else
				swap(l, temp);	//Swaps temp and l to sort them
		}
		
		if(temp == left)	//if Reverse iteration reaches left, returns left-most Node
			return temp;
		
		swap(left, temp);	//Swap left-most Node and current Node in temp
		return temp;	//Returns temp
	}	
	
	public void swap(Node a, Node b)	//Function to Swap Nodes
	{
		int temp = a.getData();
		a.setData(b.getData());
		b.setData(temp);
	}
	
}
