package wks2_Strings;

import java.util.Scanner;

public class wks2_Q1_CountCons_Vowels_SentenceCase
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter String:");
		String str = s.nextLine().trim();
		
		if(!str.endsWith(".") && !str.endsWith("?"))
		{
			System.out.println("Invalid Input");
			System.exit(0);
		}
		
		String[] words = str.split(" ");
		int[] cons = new int[words.length], vow = new int[words.length];
		StringBuffer st;
		
		for(int i = 0; i < words.length; i++)
		{
			cons[i] = 0;
			vow[i] = 0;
			st = new StringBuffer(words[i]);
			st.setCharAt(0, Character.toUpperCase(st.charAt(0)));
			if(i == words.length - 1)
				st.deleteCharAt(st.length() - 1);
			words[i] = st.toString();
		}
		
		for(int i = 0; i < words.length; i++)
		{
			//char[] letters = words[i].toCharArray();
			
			for(int j = 0; j < words[i].length(); j++)
			{
				if(words[i].charAt(j) == 'a' || words[i].charAt(j) == 'A' || words[i].charAt(j) == 'e' || words[i].charAt(j) == 'E' 
						|| words[i].charAt(j) == 'j' || words[i].charAt(j) == 'I' || words[i].charAt(j) == 'o' || words[i].charAt(j) == 'O'
						|| words[i].charAt(j) == 'u' || words[i].charAt(j) == 'U')
					vow[i]++;
				else
					cons[i]++;
			}
				
		}
		
		System.out.println("Word\tVowels\tConsonants");
		
		for(int i = 0; i < words.length; i++)
		{
			System.out.println(words[i] + "\t" + vow[i] + "\t" + cons[i]);
		}
		
		
	}

}
