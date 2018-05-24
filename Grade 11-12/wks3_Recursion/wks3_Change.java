package wks3_Recursion;

import java.util.Scanner;

public class wks3_Change
{
	
	String str;
	StringBuffer newstr = new StringBuffer("");
	int len;
	

	public static void main(String[] args)
	{
		wks3_Change c = new wks3_Change();
		c.inputword();
		c.recchange(0);
		c.display();
	}

	wks3_Change()
	{
		
	}
	
	void inputword()
	{
		Scanner s  = new Scanner(System.in);
		System.out.println("Enter Word");
		str = s.next().trim();
		len = str.length();
		s.close();
	}
	
	char caseconvert(char ch)
	{
		if (Character.isLowerCase(ch))
			return Character.toUpperCase(ch);
		else if(Character.isUpperCase(ch))
			return Character.toLowerCase(ch);
		return ch;
	}
	
	void recchange(int n)
	{
		if(n >= len)
			return;
		else
		{
			newstr.append(caseconvert(str.charAt(n)));
			recchange(n + 1);
		}
	}
	
	void display()
	{
		System.out.println("Original String: " + str);
		System.out.println("New String: " + newstr.toString());
	}
}
