package wks3_Recursion;

import java.util.Scanner;

public class wks3_Revstr
{

	String Str;		//To Store the input String
	StringBuffer Revst = new StringBuffer("");	//For editing and storing edited String
	
	public static void main(String[] args)
	{
		wks3_Revstr r = new wks3_Revstr();	//Object of class
		//Method Calls
		r.getStr();
		r.recReverse(r.Str.length() - 1);
		r.check();
	}

	
	void getStr()	//Function to take input
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the String to reverse");
		Str = s.nextLine();
	}
	
	void recReverse(int n)	//Recursive Function to reverse the string
	{
		if(n == 0)	//Appends first character
			Revst.append(Str.charAt(0));
		else
		{
			Revst.append(Str.charAt(n));	//Appends nth character
			recReverse(n - 1);	//Recursive call
		}
	}
	
	void check()	//Function to check if the String is a palindrome
	{
		System.out.println("Original String: " + Str);
		System.out.println("Reversed String: " + Revst);
		if(Str.equalsIgnoreCase(Revst.toString()))
			System.out.println("They are palindromes");
		else
			System.out.println("They are not palindromes");
		
	}
}
