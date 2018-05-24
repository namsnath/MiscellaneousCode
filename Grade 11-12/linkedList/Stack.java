package linkedList;

import java.util.Scanner;

public class Stack
{
	int size; 
	Node top;
	
	
	public void StackRun()	//For Menu-Driven Usage
	{
		int choice = 0;
		int val;
		Scanner s = new Scanner(System.in);
		
		do
		{
			System.out.println("1 - Push");
			System.out.println("2 - Pop");
			System.out.println("3 - Display Stack");
			System.out.println("9 - Exit");
			choice = s.nextInt();
			
			switch(choice)
			{
				case 1:		System.out.println("Enter value");
							val = s.nextInt();
							insertAtStart(val);
							break;
							
				case 2:		System.out.println(top.getData());
							deleteFromStart();
							break;
							
				case 3:		display();
							break;
							
				case 9:		System.exit(0);
				
				default:	System.out.println("\nEnter valid Choice");	
			}
		}while(choice != 9);
		s.close();
	}

	public void insertAtStart(int val)	//Function to add new Node at top of Stack
	{
		Node nptr = new Node(val, null);	//new Node
		size++;
		
			nptr.setLink(top);	//Attaches Node to List
			top = nptr;
	}
	
	public void deleteFromStart()	//Function to remove Node from Stack
	{
		if(size == 0)
		{
			System.out.println("Stack Empty");
			return;
		}
		
		top = top.getLink();	//sets top to next Node
		size--;
	}
	
	public void display()	//Function to display Stack
	{
		if(size == 0)
		{
			System.out.println("Empty Stack");
			return;
		}
		else
		{
			System.out.println("\n\n\n");
			Node pointer = top;
			for(int i = 0; i < size; i++)	//Traversal
			{
				System.out.print(pointer.getData() + "\t");
				pointer = pointer.getLink();
			}
			System.out.println();
		}
	}
	
}
