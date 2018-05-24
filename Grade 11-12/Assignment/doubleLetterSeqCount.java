import java.util.Scanner;
public class doubleLetterSeqCount
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		String input = "";
		int count = 0;
		char letter1, letter2;
		
		System.out.println("Enter A String");
		input = s.nextLine().trim();
		input.toUpperCase();
		
		for(int i = 0; i < input.length() - 1; i++)
		{
			letter1 = input.charAt(i);
			letter2 = input.charAt(i + 1);
			
			if(letter1 == letter2)
				count++;
		}
		
		System.out.println("Double Letter Sequences Found: " + count);
	}

}
