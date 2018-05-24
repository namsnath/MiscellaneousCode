/* LARGEST WORD
Write a program to print largest word in a given string. Also print the length of the word.
Eg. Input String: India is my country
Output: Largest Word is “country”.
Length: 7 */

import java.util.Scanner;

public class AssgnQ9
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		String Input;
		
		System.out.println("Enter String");
		Input = s.nextLine().trim();
		
		int i = 0, Temp;
		String Temp2;
		
		
		String[] Words = Input.split(" ");
		int WordLength[] = new int[Words.length];
	
		for(i = 0; i < Words.length; i++)
			WordLength[i] = Words[i].length();
		
		for(i = 0; i < Words.length; i++)
			for(int j = 0; j < Words.length - 1; j++)
				if(WordLength[j + 1] < WordLength[j])
				{
					Temp = WordLength[j + 1];
					WordLength[j + 1] = WordLength[j];
					WordLength[j] = Temp;
					
					Temp2 = Words[j + 1];
					Words[j + 1] = Words[j];
					Words[j] = Temp2;
				}
		
		System.out.println("Largest Word: " + Words[Words.length - 1]);
		System.out.println("Length: " + WordLength[WordLength.length - 1]);
		
	}

}
