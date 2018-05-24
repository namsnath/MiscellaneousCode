import java.util.Scanner;
public class CaseAlter
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter String");
		String Input = s.nextLine().trim();
		
		char InputChar[] = Input.toCharArray();
		
		for(int i = 0; i < InputChar.length; i++)
		{
			if(Character.isUpperCase(InputChar[i]))
				InputChar[i] = Character.toLowerCase(InputChar[i]);
			else if(Character.isLowerCase(InputChar[i]))
				InputChar[i] = Character.toUpperCase(InputChar[i]);
			
			System.out.print(InputChar[i]);
		}
		
	}

}
