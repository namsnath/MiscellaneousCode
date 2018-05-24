import java.util.Scanner;

public class LoopTry
{

	public static void main(String args[])
	{
		char ch;
		Scanner s = new Scanner(System.in);
		boolean choice=false;
		
		System.out.println("Enter your character");
		ch = s.nextLine().charAt(0);
		
		do
		{
			System.out.println("You entered "+ch);
			if(Character.isDigit(ch))
			{
				System.out.println("You entered a digit");
				choice=true;
			}
			else if(Character.isUpperCase(ch))
			{
				System.out.println("You entered a upper case letter");
				choice=true;
			}
			else if(Character.isLowerCase(ch)) 
			{
				System.out.println("You entered a lower case letter");
				choice=true;
			}
			else if(Character.isSpaceChar(ch))
			{
				System.out.println("You entered a space character");
				choice=true;
			}
			else if(Character.isWhitespace(ch))
			{
				System.out.println("You entered a white space");
			}
			else 
			{
				System.out.println("Wrong input..Please try again");
			}
		}while(!choice);
		}

	

}