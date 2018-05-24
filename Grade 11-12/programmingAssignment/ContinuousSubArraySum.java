package programmingAssignment;

import java.util.Scanner;

public class ContinuousSubArraySum
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Number of Elements:");
		int a[] = new int[s.nextInt()];						//Declares array of user input length
		
		System.out.println("Enter Elements");
		for(int i = 0; i < a.length; i++)					//Takes user input of elements
			a[i] = s.nextInt();
		
		System.out.println("Enter sum to find");
		int n = s.nextInt();								//Stores sum to search for
		
		for(int i = 0; i < a.length - 1; i++)				//iterates through array
		{
			for(int j = i + 1; j < a.length; j++)			//iterates through array
			{
				int sum = 0;								//To store sum of sub-array
				for(int k = j; k < a.length; k++)			//Iterates through sub-array and calculates sum
					sum+= a[k];
				
				if(sum == n)								//Prints subarray if sum is equal to user input
				{
					for(int k = j; k < a.length; k++)
						System.out.print(a[k] + " ");
					System.out.println();
					continue;
				}
			}
		
		}
	}

}
