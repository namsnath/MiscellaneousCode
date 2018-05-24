package wks2_Strings;
import java.util.Scanner;

public class Wks2_Q9_3LetterPermutations
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter a three letter word:");
		String inp = s.next().trim().toUpperCase();
		
		if(inp.length() > 3)
		{
			System.out.println("Please input three letter word only");
			System.exit(0);
		}
		
		char c[] = inp.toCharArray();
		
		if(c[0] == c[1] || c[1] == c[2] || c[0] == c[2])
		{
			System.out.println("No three letter permutations are possible without repeating letters");
			System.exit(0);
		}
		
		System.out.println("\n\nPossible Permutations:");
		
		Wks2_Q9_3LetterPermutations obj = new Wks2_Q9_3LetterPermutations();
		obj.permutation("", inp);
		
		
	}
	
	public void permutation(String prefix, String str) 
	{
	    int n = str.length();
	    if (n == 0) System.out.println(prefix);
	    else 
	    {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}

}
