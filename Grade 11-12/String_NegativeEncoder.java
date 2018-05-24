import java.util.Scanner;

public class String_NegativeEncoder
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter Word to Encode");
		String input = s.nextLine().toUpperCase();		//Convert input to UpperCase
		
		System.out.println("Enter Encoding value:");
		int n = s.nextInt();							//Value to encode by
		
		StringBuffer str = new StringBuffer(input.trim());	//To perform edits
		
		int x, i;	//Temporary variables for operations
		
		
		for(i = 0; i < str.length(); i++)
		{
			if(str.charAt(i) == ' ')	//Skips if it is a space
				continue;
			
			x = (int)str.charAt(i);	//Storing int value of a character
			x = x - n;	//Subtracts encoding value
			
			if(x < 65)	//Cyclic shift for characters before 'A'
			{
				x = 64 - x;	//Converts it to x characters before 'X'
				str.setCharAt(i, (char)((int)'Z'- x));	//Replaces character in String
			}
			else
			{
				str.setCharAt(i, (char)((int)str.charAt(i) - n));	//Replaces character in String
			}
		}
		
		System.out.println("Encoded Word: " + str.toString());	//Printing
	}

}
