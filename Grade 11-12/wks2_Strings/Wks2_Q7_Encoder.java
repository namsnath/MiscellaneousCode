package wks2_Strings;
import java.util.Scanner;

public class Wks2_Q7_Encoder
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter Word to Encode");
		String input = s.next().toUpperCase();
		
		System.out.println("Enter Encoding value:");
		int n = s.nextInt();
		
		StringBuffer str = new StringBuffer(input.trim());
		
		int x, i;
		
		for(i = 0; i < str.length(); i++)
		{
			x = (int)str.charAt(i);
			x = x + n;
			
			if(x > 91)
			{
				x = x - 91;
				str.setCharAt(i, (char)((int)'A'+x));
			}
			else
			{
				str.setCharAt(i, (char)((int)str.charAt(i)+n));
			}
		}
		
		System.out.println("Encoded Word: " + str.toString());
	}

}
