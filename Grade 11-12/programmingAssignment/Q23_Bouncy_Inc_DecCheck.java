package programmingAssignment;

import java.util.Scanner;

public class Q23_Bouncy_Inc_DecCheck
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter Number to Check");
		int n = s.nextInt();							//Variable to store number
		
		if(isIncreasing(n))								//Checks if number is increasing
			System.out.println("Increasing");
		else if(isDecreasing(n))						//Checks if number is decreasing
			System.out.println("Decreasing");
		else
			System.out.println("Bouncy");				//Else number is bouncy Number
		
		s.close();
	}

	
	public static boolean isIncreasing(int n)		//Function to check if number is increasing
	{
		String st = Integer.toString(n);			//Converts integer to String
		
		boolean inc = true;							//Flag to indicate Increasing Number
		
		for(int i = 1; i < st.length(); i++)		//Loop to iterate through string
		{
			if(st.charAt(i) >= st.charAt(i - 1))	//Checks if character is more than or equal to preceding number
				continue;
			else
				inc = false;
		}
		
		return inc;		//returns boolean flag
	}
	
	public static boolean isDecreasing(int n)		//Function to check if number is decreasing
	{
		String st = Integer.toString(n);			//Converts integer to String
		
		boolean dec = true;							//Flag to indicate Increasing Number
		
		for(int i = 1; i < st.length(); i++)		//Loop to iterate through string
		{
			if(st.charAt(i) <= st.charAt(i - 1))	//Checks if character is more than or equal to preceding number
				continue;
			else
				dec = false;
		}
		
		return dec;		//returns boolean flag
	}
}
