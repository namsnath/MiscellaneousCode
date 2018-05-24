package programmingAssignment;
import java.util.Scanner;

public class Q3_SmartSubstring
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter String");
		String inp = s.nextLine(), st;			//Stores input String
		
		System.out.println("Enter Max Chars");	
		int n = s.nextInt();					//Stores maximum number of characters
		int i = 0;								//iteration variable
		String[] words = inp.split(" ");		//Splits string into String array containing words
		for(st = ""; st.length() + words[i].length() <= n; st = st + words[i] + " ", i++)		//Loop to append each word to empty string till length of new string < n
		{}
		
		if(st.length() > n)			//Checks if length of new string > n
		{
			st.trim();				//trims extra spaces
			if(st.length() > n)		//Checks length again
			{
				String words2[] = st.split(" ");	//Splits String into words
				st = "";							//sets st to ""
				for(i = 0; i < words2.length - 1; i++)	//appends each word to st
					st = st + words2[i] + " ";
				st.trim();	//trims extra spaces
			}
		}
		
		System.out.println(st);		//Prints smart substring
		
		s.close();
	}

}
