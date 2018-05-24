package wks3_Recursion;

import java.util.Scanner;

public class wks3_Convert
{

	int n;

	void inpNum()
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter number");
		n = s.nextInt();
		
		StringBuffer st = new StringBuffer(Integer.toString(n));
		st.reverse();
		
		n = Integer.parseInt(st.toString());
		s.close();
	}
	
	void extDigit(int x)
	{
		if(x >= 1)
		{
			int c = x % 10;
			num_to_words(c);
			extDigit(x/10);
		}
	}
	
	void num_to_words(int x)
	{
		switch(x)
		{
			case 0:	System.out.println("Zero");
					break;
					
			case 1:	System.out.println("One");
					break;
					
			case 2: System.out.println("Two");
					break;
					
			case 3: System.out.println("Three");
					break;

			case 4: System.out.println("Four");
					break;

			case 5: System.out.println("Five");
					break;

			case 6: System.out.println("Six");
					break;

			case 7: System.out.println("Seven");
					break;

			case 8: System.out.println("Eight");
					break;

			case 9: System.out.println("Nine");
					break;
		}
	}
	
	public static void main(String[] args)
	{
		wks3_Convert c = new wks3_Convert();
		c.inpNum();
		c.extDigit(c.n);
	}

}
