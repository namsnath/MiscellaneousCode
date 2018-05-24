package programmingAssignment;

import java.util.Scanner;

public class Q19_CharTypePercentage
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter String");
		String inp = s.nextLine();				//String to store input
		
		double upper = 0, lower = 0, num = 0, other = 0;	//variables to store number of occurrences of characters of each type
		
		for(int i = 0; i < inp.length(); i++)			//Loop to iterate through string
		{
			char c = inp.charAt(i);						//Character to store each character of String
			
			if(Character.isUpperCase(c))				//Checks if Character is Uppercase
				upper++;
			else if(Character.isLowerCase(c))			//Checks if Character is Lowercase
				lower++;
			else if(Character.isDigit(c))				//Checks if Character is Digit
				num++;
			else
				other++;								//else it is Other Character
		}
		

		
		double total = upper + lower + num + other;		//Stores total number of characters
		System.out.println("Total Characters - " + total);
		
		double upperp = upper / total * 100;			//Percentage of Uppercase
		double lowerp = lower / total * 100;			//Percentage of Lowercase
		double nump = num / total * 100;				//Percentage of digits
		double otherp = other / total * 100;			//Percentage of Other Characters
		
		
		System.out.println("Uppercase Characters are " + (int)upper + " so, percentage = " + upperp + "%");
		System.out.println("Lowercase Characters are " + (int)lower + " so, percentage = " + lowerp + "%");
		System.out.println("Numeric Characters are " + (int)num + " so, percentage = " + nump + "%");
		System.out.println("Other Characters are " + (int)other + " so, percentage = " + otherp + "%");
		
		s.close();
	}
}
