package wks2_Strings;

import java.util.Scanner;

public class Wks2_Q6_WordFrequency
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the sentence.");
		String input = s.nextLine();
		
		if(input.endsWith("."))
		{
			StringBuffer str = new StringBuffer(input);
			str.setLength(input.length() - 1);
			input = str.toString();
			
			System.out.println("Enter the word.");
			String word = s.nextLine();
			
			int frequency = 0;
			
			String words[] = input.split(" ");
			
			for(int i = 0; i < words.length; i++)
				if(words[i].equalsIgnoreCase(word))
					frequency++;
			
			System.out.println("Frequancy of the word '" + word + "' = " + frequency);
			System.exit(0);
		}
		
		System.out.println("Sentence must end with '.'");
		s.close();
	}

}
