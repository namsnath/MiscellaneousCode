package programmingAssignment;

import java.util.Scanner;

public class Q17_CharCountWithoutLoop
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter String");
		String inp = s.nextLine();				//String to store input
		System.out.println("Enter character to find occurrence of");
		char c = s.next().charAt(0);			//character to search for
		
		String[] words = inp.split("" + c);		//splits String at each occurrence of character
		System.out.println("Frequency of " + c + " is " + (words.length - 1));	//Prints frequency of the character
		
		s.close();
	}

}
