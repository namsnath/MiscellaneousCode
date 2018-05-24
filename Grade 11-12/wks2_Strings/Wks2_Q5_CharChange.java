package wks2_Strings;

import java.util.Scanner;

public class Wks2_Q5_CharChange
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		String input = "";
		
		System.out.println("Enter a Sentence.");
		input = s.nextLine();
		
		System.out.println("Enter the numbers of two words.");
		int m = s.nextInt();
		int n = s.nextInt();
		
		String words[] = input.split(" ");
		
		StringBuffer a = new StringBuffer(words[m - 1]);
	
		StringBuffer b = new StringBuffer(words[n - 1]);
		
		for(int i = 0; i < a.length(); i++)
		{
				if(a.charAt(i) != 'z' && a.charAt(i) != ' ')
					a.setCharAt(i,(char)((int)a.charAt(i)+1));
				
				else if(a.charAt(i) == 'z')
					a.setCharAt(i,'a');
		}
			
		for(int i = 0; i < b.length(); i++)
		{
				if(b.charAt(i) != 'z' && b.charAt(i) != ' ')
					b.setCharAt(i,(char)((int)b.charAt(i)+1));
			
				else if(b.charAt(i) == 'z')
					b.setCharAt(i,'a');
		}
		
		words[m - 1] = a.toString();
		words[n - 1] = b.toString();	
		
		System.out.println("Modified String - ");
		for(int i = 0; i < words.length; i++)
			System.out.print(" " + words[i]);
		
		s.close();
	}

}
