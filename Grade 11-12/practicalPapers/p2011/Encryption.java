package practicalPapers.p2011;

import java.util.Scanner;

public class Encryption
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		String[] sents;
		int n;
		
		System.out.println("Enter Number of Sentences:");
		n = s.nextInt();
		
		if(n <= 1 || n >= 10)
		{
			System.out.println("Invalid Entry");
			System.exit(0);
		}
		
		sents = new String[n];
		
		System.out.println("Enter Sentences");
		for(int i = 0; i < n; i++)
		{
			String inp = s.nextLine();
			if(inp.charAt(inp.length() - 1) != '.')
				System.out.println("Sentence has to end with fullstop, adding it");
			inp = inp + ".";
			sents[i] = inp;
		}
		
		
	}

}
