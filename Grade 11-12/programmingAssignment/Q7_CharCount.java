package programmingAssignment;

import java.util.Scanner;

public class Q7_CharCount
{
	public static void main(String args[])
	 {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter String");
		String inp = s.nextLine();				//Stores input String
		
		char[] chars = new char[inp.length()];	//char array of length = length of input to store each character
		int[] freq = new int[inp.length()];		//int array of length = length of input to store frequency of each character
		
		for(int i = 0; i < inp.length(); i++)	//iterates through characters in string
		{
			for(int j = 0; j < chars.length; j++)	//iterates through character array (chars)
			{
				if(chars[j] == Character.MIN_VALUE)	//if chars[j] is null
				{
					chars[j] = inp.charAt(i);		//sets chars[j] to current character
					freq[j] = 1;					//increases frequency of that character to 1
					break;
				}
				if(chars[j] == inp.charAt(i))		//if character present in array
				{
					freq[j]++;						//increases frequency of character by 1
					break;
				}
			}
		}
		
		for(int i = 0; i < chars.length; i++)		//Prints characters and their frequency
		{
			if(chars[i] != Character.MIN_VALUE)
				System.out.println(chars[i] + " : " + freq[i]);
		}
		
		s.close();
	 }
}
