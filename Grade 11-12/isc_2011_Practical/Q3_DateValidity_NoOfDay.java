package isc_2011_Practical;

import java.util.Scanner;

public class Q3_DateValidity_NoOfDay
{

	public static void main(String[] args)
	{
		Scanner s  = new Scanner(System.in);
		
		System.out.println("Enter date in dd mm yyyy format.");
		int d = s.nextInt();	//Date
		int m = s.nextInt();	//Month
		int y = s.nextInt();	//Year
		int days = 0;	//Number of days
		
		if(d <= 0 || m <= 0 || y <= 0 || d > 31 )	//Checks if input is within bounds
		{
			System.out.println("Invalid Date");
			System.exit(0);
		}

		boolean leap = isLeapYear(y);	//Checks if it is a leap year
		if((leap && d > 29 && m == 2) || (!leap && d > 28 && m == 2))	//Checks entered date in case of February
		{
			System.out.println("Invalid Date");
			System.exit(0);
		}
		if(m == 4 || m == 6 || m == 9 || m == 11)	//Checks entered date in case of months with 30 days
		{
			if(d > 30)
			{
				System.out.println("Invalid Date");
				System.exit(0);
			}
		}
		
		switch(m)	//Adds days for all months before the entered one
		{
			case 12:	days += 30;
			
			case 11:	days += 31;
			
			case 10:	days += 30;
			
			case 9:		days += 31;
			
			case 8:		days += 31;
			
			case 7:		days += 30;
			
			case 6:		days += 31;
			
			case 5:		days += 30;
			
			case 4:		days += 31;
			
			case 3:		if(leap)
							days += 29;
						else
							days += 28;
			
			case 2:		days += 31;
		}
		
		days += d;	//Days in the entered month
		
		System.out.println(days);
	}

	public static boolean isLeapYear(int year)	//Checks for leap year
	{
		return (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));
	}
	
}
