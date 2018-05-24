package Extra;

import java.util.Scanner;

public class ParaWordCount
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the paragraph:");
		String para = s.nextLine();
		
		para.replace('?', '.');	//replaces ? with . for ease in splitting
		
		String sentences[] = para.split(".");
		
		if((sentences.length > 4 || sentences.length < 0) || !para.equals(para.toUpperCase()))
		{
			System.out.println("Invalid Input");
			System.exit(0);
		}
		
		
		para = para.replace('.', '\u0000'); //replaces . with null, so you're left with words only, no extra spaces
		
		String[] words = para.split(" ");	//array of words in the paragraph
		String[] wordCount = new String[words.length]; //to store only one of each word for counting.
		int[] count = new int[words.length];	//to store count of each word
		
		for(int i = 0; i < count.length; i++)
		{
			wordCount[i] = "";
			count[i] = 0;
			words[i] = words[i].trim();
		}
		
		
		for(int i = 0; i < words.length; i++)
		{
			for(int j = 0; j < wordCount.length; j++)
			{
				if(wordCount[j].equals(""))	//if wordCount[j] is null
				{
					wordCount[j] = words[i];		//sets wordCOunt[j] to current word
					count[j] = 1;					//increases frequency of that word to 1
					break;
				}
				if(wordCount[j].equals(words[i]))		//if word present in array
				{
					count[j]++;						//increases frequency of word by 1
					break;
				}
			}
		}
		
		for(int i = 0; i < wordCount.length; i++)
		{
			if(count[i] == 0)
				continue;
			
			System.out.println(wordCount[i] + " : " + count[i]);
		}
		
		
		
	}

}
