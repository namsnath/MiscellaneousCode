package linkedList;

import java.util.Scanner;

public class Queue
{

	int size;
	Node start, end;
	
	public void QueueRun()	//For Menu-Driven usage
	{
		int choice = 0;
		int val;
		Scanner s = new Scanner(System.in);
		
		do
		{
			System.out.println("1 - Insertion");
			System.out.println("2 - Deletion");
			System.out.println("3 - Display Queue");
			System.out.println("9 - Exit");
			choice = s.nextInt();
			
			switch(choice)
			{
				case 1:		System.out.println("Enter value");	//Takes input for data
							val = s.nextInt();
							insertAtEnd(val);	//Inserts at end of List
							break;
							
				case 2:		System.out.println(start.getData());	//Prints data of first node and removes it
							deleteFromStart();
							break;
							
				case 3:		display();	//To Display queue
							break;
							
				case 9:		System.exit(0);
				
				default:	System.out.println("\nEnter valid Choice");	
			}
		}while(choice != 9);
		s.close();
	}
	
	public void display()
	{
		if(size == 0)
		{
			System.out.println("Empty Queue");
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
	
	public void deleteFromStart()
	{
		if(size == 0)
		{
			System.out.println("Queue Empty");
			return;
		}
		
		start = start.getLink();	//Deletes first node, sets start to next Node in list
		size--;
	}
	
	public void insertAtEnd(int val)	//Function to insert Node at end of List
	{
		Node nptr = new Node(val, null);
		size++;
		
		if(start == null)	//Empty List
		{
			start = nptr;
			end = start;
		}
		else
		{
			end.setLink(nptr);
			end = nptr;	//Sets end to new Node
		}
	}
	
}
