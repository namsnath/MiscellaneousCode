package programmingAssignment;

import java.util.Scanner;

public class Q18_ReverseEachWord
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter String");
		String inp = s.nextLine();			//String to store input
		
		String[] words = inp.split(" ");	//Splits string at each space (each word)
		StringBuffer st = new StringBuffer("");	//New empty StringBuffer to store reverse of string
		
		for(int i = 0; i < words.length; i++)	//Loop to iterate through array formed by splitting string
		{
			StringBuffer temp = new StringBuffer(words[i]);	//StringBuffer to store each word
			temp.reverse();									//Each word is reversed
			st.append(temp + " ");							//Reversed word is appended to StringBuffer st
		}
		
		System.out.println(st);
		
		s.close();
	}

}
