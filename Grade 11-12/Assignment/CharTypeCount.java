import java.util.Scanner;
public class CharTypeCount
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter A String");
		String Input = s.nextLine().trim();
		
		char InputChars[] = Input.toCharArray();
		
		int upper = 0, lower = 0, digit = 0, special = 0, whitespace = 0;
		
		for(int i = 0; i < InputChars.length; i++)
		{
			if(Character.isUpperCase(InputChars[i]))
				upper++;
			else if(Character.isLowerCase(InputChars[i]))
				lower++;
			else if(Character.isDigit(InputChars[i]))
				digit++;
			else if(Character.isWhitespace(InputChars[i]))
				whitespace++;
			else
				special++;
		}
		
		System.out.println("Upper Case: " + upper);
		System.out.println("Lower Case: " + lower);
		System.out.println("Digits: " + digit);
		System.out.println("Special: " + special);
		System.out.println("WhiteSpaces: " + whitespace);
	}

}
