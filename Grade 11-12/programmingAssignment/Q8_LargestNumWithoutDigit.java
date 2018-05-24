package programmingAssignment;

import java.util.Scanner;

public class Q8_LargestNumWithoutDigit
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter Max Number");
		int max = s.nextInt();						//to store maximum number
		System.out.println("Enter Number to Exclude");
		int n = s.nextInt();						//to store number to exclude
		
		for(int i = max - 1; i >= 0; i--)			//iterates from max - 1 to 0
		{
			if((i + "").contains(n + ""))			//if i contains n, 
				continue;							//skips current iteration
			else
			{
				System.out.println("The required number is " + i);	//prints number
				break;
			}
		}
		
		s.close();
	}

}
