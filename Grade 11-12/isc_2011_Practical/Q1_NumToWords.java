package isc_2011_Practical;

import java.util.Scanner;

public class Q1_NumToWords
{

	public static void main(String[] args)
	{
		String[] s_units = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};	//For storing number names of digits in the units place excluding those for 10-19
		String[] s_Tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};	//For storing number names of digits in the tens place excluding those for 10-19
		String[] s_Teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};	//For storing number names of numbers in the range 10-19
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter Number between 0 and 1000 (Exclusive)");
		int n = s.nextInt();
		if(n <= 0 || n >= 1000)		//Checks validity of input
		{
			System.out.println("Value out of Range");
			System.exit(0);
		}
		
		StringBuffer st = new StringBuffer(Integer.toString(n));	//Converts Integer to a StringBuffer
		st.reverse();	//Reverses the String
		int l = st.length();	//Stores length of the String
		
		if(l < 3)	//If the length is less than maximum allowed, appends zeroes till length is at maximum
			for(int i = 0; i < 3 - l; i++)
				st.append(0);
		
		st.reverse();	//Reverses String again
		
		char digits[] = st.toString().toCharArray();	//Converts String to Character Array
		
		if(Character.getNumericValue(digits[1]) != 1 && Character.getNumericValue(digits[0]) != 0) //Contains Hundreds Digits and does not belong to 10-19
			System.out.println(s_units[Character.getNumericValue(digits[0])] + " Hundred " + s_Tens[Character.getNumericValue(digits[1])] + " " + s_units[Character.getNumericValue(digits[2])]);
		
		if(Character.getNumericValue(digits[1]) == 1 && Character.getNumericValue(digits[0]) != 0) // Contains Hundreds Digits and belongs to 10-19
			System.out.println(s_units[Character.getNumericValue(digits[0])] + " Hundred " + s_Teens[Character.getNumericValue(digits[2])]);
		
		if(Character.getNumericValue(digits[1]) != 1 && Character.getNumericValue(digits[0]) == 0) // Does not Contain Hundred's Digit and does not Belong to 10-19
			System.out.println(s_Tens[Character.getNumericValue(digits[1])] + " " +  s_units[Character.getNumericValue(digits[2])]);
		
		if(Character.getNumericValue(digits[1]) == 1 && Character.getNumericValue(digits[0]) == 0) //Does Not Contain Hundred's Digit and Belongs to 10-19
			System.out.println(s_Teens[Character.getNumericValue(digits[2])]);
	}

}
