	package linkedList;

import java.util.Scanner;

public class LinkedList
{
	public Node start;	//First Node
	public Node end;	//Last Node
	public int size;	//Size of LinkedList
	
	public LinkedList()	//Default Constructor
	{
		start = end = null;
		size = 0;
	}
	
	public LinkedList(int[] a)	//To initialize LinkedList with given data
	{
		for(int i = 0; i < a.length; i++)	//Adds each data element to List
			insertAtEnd(a[i]);
	}
	
	public LinkedList(Node start, int nodes)	//Adds data from new LinkedList to Current one, given the number of nodes in the other List
	{
		for(int i = 0; i < nodes; i++)	
		{
			insertAtEnd(start.getData());	//Inserts First node of new List at the end of the current one
			start = start.getLink();	//Sets to next Node in list
		}
	}
	
	public boolean isEmpty()	//To check if List is empty
	{
		return start == null;
	}
	
	public int getSize()	//Returns size of List
	{
		return size;
	}
	
	public void insertAtStart(int val)	//Function to insert Node at start of the List
	{
		Node nptr = new Node(val, null);	//Node to be inserted
		size++;	
			
		if(start == null)	//For empty list
		{
			start = nptr;
			end = start;
		}
		else	//Non-empty List
		{
			nptr.setLink(start);
			start = nptr;
		}
	}
	
	public void insertAtEnd(int val)	//Function to insert Node at the end of the List
	{
		Node nptr = new Node(val, null);	//Node to be inserted
		size++;
		
		if(start == null)	//Empty List
		{
			start = nptr;
			end = start;
		}
		else
		{
			end.setLink(nptr);
			end = nptr;
		}
	}
	
	public void insertAtIndex(int index, int val)	//Function to insert Node at a given index
	{
		if(index > size + 1 || index < 1)	//Checks if index is in range of List
		{
			System.out.println("Index does not exist");
			return;
		}
		else if(index == 1)	
			insertAtStart(val);
		else if(index == size + 1)
			insertAtEnd(val);
		else
		{
			Node nptr = new Node(val, null);
			Node ptr = start;
			
			for(int i = 1; i < size; i++, ptr = ptr.getLink())	//To find Node before index to insert at
				if(i == index - 1)
				{
					nptr.setLink(ptr.getLink());
					ptr.setLink(nptr);
					size++;
					break;
				}
		}
	}
	
	public void deleteFromStart()	//Function to delete Node from the front
	{
		if(size == 0)
		{
			System.out.println("List Empty");
			return;
		}
		
		start = start.getLink();
		size--;
	}
	
	public void deleteFromEnd()		//Function to delete Node from the end	
	{
		if(size == 0)
		{
			System.out.println("List Empty");
			return;
		}
		if(size == 1)
		{
			System.out.println(start.getData());
			start = end = null;
			size = 0;
			return;
		}
		Node ptr = start;
		
		for(; ptr.getLink() != end;)	//Iterates through list to Node before last Node
			ptr = ptr.getLink();
		System.out.println(ptr.getLink().getData());
		end = ptr;	//Sets last Node as end
		end.setLink(null);
		size--;
	}
	
	public void deleteFromIndex(int index)	//Function to delete Node at a certain Index
	{
		if(index == 1)
			deleteFromStart();
		if(index == size)
			deleteFromEnd();
		else
		{
			Node ptr = start;
			Node temp = start;
				for(int i = 1; i < size; ptr = ptr.getLink())	//Iterates to Node before required Node
					if(i == index - 1)
					{
						temp = ptr.getLink();
						temp = temp.getLink();
						ptr.setLink(temp);
						size--;
						break;
					}
		}
	}
	
	public void display()	//Function to print the List
	{
		if(size == 0)
		{
			System.out.println("Empty List");
			return;
		}
		else
		{
			System.out.println("\n\n\n");
			Node pointer = start;
			for(int i = 0; i < size; i++)
			{
				System.out.print(pointer.getData() + "\t");
				pointer = pointer.getLink();
			}
			System.out.println();
		}
	}
	
	
	public int inpData()	//To take input of data for Node
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter data for Node");
		int x = s.nextInt();
		s.close();
		return x;
	}
	
	public void reverse()	//Function to reverse the List by swapping
	{	
		for(int i = 1; i <= size / 2; i++)
		{
			int temp;
			Node ptr1 = start;
			Node ptr2 = start;
			for(int j = 1; j < i; j++)
				ptr1 = ptr1.getLink();
			for(int k = 1; k <= size - i; k++)
				ptr2 = ptr2.getLink();
			
			temp = ptr1.getData();
			ptr1.setData(ptr2.getData());
			ptr2.setData(temp);
		}
	}
	
	public void LLRun()	//Function for menu-driven Usage
	{
		int choice, val, pos;
		Scanner s = new Scanner(System.in);
		
		do
		{
			System.out.println("\n\n");
			System.out.println("1 - Insert At Beginning");
			System.out.println("2 - Insert At End");
			System.out.println("3 - Insert At Position");
			System.out.println("4 - Delete From Beginning");
			System.out.println("5 - Delete From End");
			System.out.println("6 - Delete From Position");
			System.out.println("7 - Display List");
			System.out.println("8 - Return to Linked List type selection");
			System.out.println("10 - Reverse Linked List");
			System.out.println("9 - Exit");
			choice = s.nextInt();
			
			switch(choice)
			{
				case 1:		System.out.println("\nEnter value");
							val = s.nextInt();
							insertAtStart(val);
							break;
				
				case 2:		System.out.println("\nEnter value");
							val = s.nextInt();
							insertAtEnd(val);
							break;		
							
				case 3:		System.out.println("\nEnter Position and value");
							pos = s.nextInt();
							val = s.nextInt();
							insertAtIndex(pos, val);
							break;
						
				case 4:		deleteFromStart();
							break;
							
				case 5:		deleteFromEnd();
							break;
							
				case 6:		System.out.println("\nEnter Position");
							pos = s.nextInt();
							deleteFromIndex(pos);
							break;
							
							
				case 7:		display();
							break;
							
				case 8:		return;		
				
				case 10:	reverse();
							break;
							
				case 9:		System.exit(0);
				
				
				
				default:	System.out.println("\nEnter valid Choice");
							break;
			}
		}while(choice != 9);
		s.close();
	}
	
	
	public static void main(String args[])	//Menu to choose between Linked List, Stack or Queue (All usind LinkedLists)
	{
		int choice = 0;
		Scanner s = new Scanner(System.in);
		LinkedList l = new LinkedList();
		Stack st = new Stack();
		Queue q = new Queue();
		
		do
		{
			System.out.println("1 - Linked List");
			System.out.println("2 - Stack");
			System.out.println("3 - Queue");
			System.out.println("9 - Exit");
			choice = s.nextInt();
			
			switch(choice)
			{
				case 1:		l.LLRun();
							break;
							
				case 2:		st.StackRun();
							break;
							
				case 3:		q.QueueRun();
							break;
							
				case 9:		System.exit(0);
				
				default:	System.out.println("\nEnter valid Choice");	
			}
		}while(choice != 9);
		s.close();
	}
}