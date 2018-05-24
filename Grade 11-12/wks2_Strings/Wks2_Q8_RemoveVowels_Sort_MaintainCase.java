package wks2_Strings;
import java.util.Scanner;

public class Wks2_Q8_RemoveVowels_Sort_MaintainCase
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter Word in Mixed Case:");
		String inp = s.next().trim();
		
		StringBuffer str = new StringBuffer(inp);
		
		for(int i = 0; i < str.length(); i++)
			if(str.charAt(i) == 'A' || str.charAt(i) == 'a' || str.charAt(i) == 'I' || str.charAt(i) == 'i' || str.charAt(i) == 'E' || str.charAt(i) == 'e' || 
					str.charAt(i) == 'O' || str.charAt(i) == 'o' || str.charAt(i) == 'U' || str.charAt(i) == 'u')
				str.deleteCharAt(i);
		
		System.out.println("After Vowel Deletion:" + str.toString());
		
		char[] orig = str.toString().toCharArray(), upper = str.toString().toUpperCase().toCharArray();
		
		for(int i = 0; i < upper.length - 1; i++)
		{
			for(int j = i + 1; j < upper.length; j++)
			{
				if(upper[j] < upper [i]) //Change this to "Array[j] > Array [j]" to sort in descending order
				{
					char temp = upper[j];
					upper[j] = upper[i];
					upper[i] = temp;
					
					temp = orig[j];
					orig[j] = orig[i];
					orig[i] = temp;
				}
			}
		}
		
		for(int i = 0; i < orig.length; i++)
			System.out.print(orig[i]);
		
	}

}
