package wks2_Strings;
import java.util.Scanner;

public class Wks2_Q10_AnagramCheck
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter First Word:");
		String orig = s.next().trim().toUpperCase();
		
		System.out.println("Enter Word to Check:");
		String check = s.next().trim().toUpperCase();
		
		if(check.length() != orig.length())
		{
			System.out.println("Not Anagram");
			System.exit(0);
		}
		if(orig.equals(check))
		{
			System.out.println("It is an Anagram");
			System.exit(0);
		}
		
		char[] origC = orig.toCharArray(), checkC = check.toCharArray();
		
		
		for(int i = 0; i < origC.length - 1; i++)
		{
			for(int j = i + 1; j < origC.length; j++)
			{
				if(origC[j] < origC [i]) //Change this to "Array[j] > Array [j]" to sort in descending order
				{
					char temp = origC[j];
					origC[j] = origC[i];
					origC[i] = temp;
				}
			}
		}
		
		for(int i = 0; i < checkC.length - 1; i++)
		{
			for(int j = i + 1; j < checkC.length; j++)
			{
				if(checkC[j] < checkC [i]) //Change this to "Array[j] > Array [j]" to sort in descending order
				{
					char temp = checkC[j];
					checkC[j] = checkC[i];
					checkC[i] = temp;
				}
			}
		}
		
		String origS = new String(origC);
		String checkS = new String(checkC);
		
		if(origS.equals(checkS))
			System.out.println("Anagram");
		else
			System.out.println("not Anagram");
	}

}
