package practicalPapers.p2011;

import java.util.Scanner;

public class NumToWords
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
		String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
		String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
		
		System.out.println("Enter Number between 0 and 1000 (Exclusive)");
		int num = s.nextInt();
		
		if(num < 1 || num >= 1000)
		{
			System.out.println("Out Of Range");
			System.exit(0);
		}
		
		String inpNum = num + "";
		
		if(inpNum.length() == 1)
			System.out.print(ones[Integer.parseInt(inpNum)]);
		
		if(inpNum.length() == 2)
		{
			if(num > 9 && num < 20)
				System.out.print(teens[num - 10]);
			
			if(num >= 20)
				System.out.print(tens[num / 10] + " " + ones[num % 10]);
		}
		
		if(inpNum.length() == 3)
		{
			int tenOne = num % 100;
			
			System.out.print(ones[num / 100] + " Hundred and ");
			
			if(tenOne > 9 && tenOne < 20)
				System.out.print(teens[tenOne - 10]);
			
			if(tenOne >= 20)
				System.out.print(tens[tenOne / 10] + " " + ones[tenOne % 10]);
		}
			
	}

}
