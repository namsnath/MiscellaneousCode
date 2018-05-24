import java.util.Scanner;

public class Weird_Decryption
{
	/*
	 * String containing numbers is entered (has to be encoded)
	 * String is reversed
	 * Ascii values are obtained and converted to char values
	 * 
	 * Sample Input: 2312179862310199501872379231018117927
	 * O/P: Have A Nice Day
	 */

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter Encoded String:");
		String inp = s.next();	//Takes input String
		
		StringBuffer str = new StringBuffer(inp);	//Parses to StringBuffer for ease in editing
		String rev = str.reverse().toString();		//Reverses the String
		
		
		char revChar[] = rev.toCharArray();			//Converts to a Character Array
		for(int i = 0; i < revChar.length - 3;)		//Runs till 3 characters left in string
		{
			String x = "" + revChar[i] + revChar[i + 1] + revChar[i + 2];	//Extracts 3 characters
			if(Integer.parseInt(x) > 122)	//Parses to Integer, Checks if it is more than 122
			{
				x = "" + revChar[i] + revChar[i + 1];	//Takes only 2 characters
				System.out.print((char)Integer.parseInt(x));	//Prints character from ASCII Value
				i += 2;
			}
			else
			{
				System.out.print((char)Integer.parseInt(x));	//Prints character from ASCII Value
				i += 3;
			}
		}
	}

}
