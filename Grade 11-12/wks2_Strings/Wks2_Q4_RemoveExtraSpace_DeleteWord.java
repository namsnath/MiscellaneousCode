package wks2_Strings;

import java.util.Scanner;

public class Wks2_Q4_RemoveExtraSpace_DeleteWord
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter String");
		String st = s.nextLine().toUpperCase();
		System.out.println("Enter Word to be deleted");
		String word = s.next();
		System.out.println("Enter position of word");
		int n = s.nextInt();
		
		if(st.endsWith(".") || st.endsWith("!") || st.endsWith("?"))
		{}	
		else
		{
			System.out.println("Invalid Input");
			System.exit(0);
		}
		
		String[] st1 = st.split(" "), st2 = new String[st1.length];
		
		for(int i = 0, j = 0; i < st1.length; i++)
		{
			if(st1[i].equals("") || i == n)
				continue;
			else
			{
				st2[j] = st1[i];
				j++;
			}
		}
		
		for(int i = 0; i < st2.length; i++)
		{
			if(st2[i] == null)
				continue;
			else
				System.out.print(st2[i] + " ");
		}
			
		
	}

}
