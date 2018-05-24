
 /*Write a program in java to accept a string and find
i. number of blank spaces in the string
ii.number of words in the string
iii.number of character present in the string.
*/

import java.util.Scanner;

public class AssgnQ8
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		String Input;
		int Blanks = 0, Words = 0, Chars  = 0, i;
		
		System.out.println("Enter A String");
		Input = s.nextLine();
		
		for(i = 0; i < Input.length(); i++)
			if(Input.charAt(i) == ' ')
				Blanks++;
		
		Words = Blanks + 1;
		Chars = Input.length();
		
		System.out.println("Words: " + Words);
		System.out.println("Blanks: " + Blanks);
		System.out.println("Characters: " + Chars);
	}

}
