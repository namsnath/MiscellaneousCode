package programmingAssignment;
import java.util.Scanner;

public class Q25_CalendarGenerator
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter Year");
		int year = s.nextInt();					//To store year
		System.out.println("Enter Month");
		String month = s.next().trim();			//To store month
		System.out.println("Enter First Day of Month");
		String day = s.next().trim();			//To store first day of the month
		
		boolean isLeapYear = (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));	//To check for leap year
		
		int cal[][] = new int[5][7];			//Creates an Array to store the dates
		
		int days, startPos = 0;					//Days to store number of days in month, startPos to store start position of dates in array
		
		if(month.equalsIgnoreCase("January") || month.equalsIgnoreCase("March") || month.equalsIgnoreCase("May") || month.equalsIgnoreCase("July") || month.equalsIgnoreCase("August")
				|| month.equalsIgnoreCase("October") || month.equalsIgnoreCase("December"))		//Checks for months with 31 days
			days = 31;
		else if(month.equalsIgnoreCase("February") && isLeapYear)		//Checks for February in Leap Year
			days = 29;
		else if(month.equalsIgnoreCase("February") && !isLeapYear)		//Checks for February in non-Leap year
			days = 28;
		else
			days = 30;		//else month has 30 days
		
		switch(day.toLowerCase())		//To assign startPos based on Day
		{
			case "sunday":	startPos = 0; break;
			case "monday":	startPos = 1; break;
			case "tuesday":	startPos = 2; break;
			case "wednesday":	startPos = 3; break;
			case "thursday":	startPos = 4; break;
			case "friday":	startPos = 5; break;
			case "saturday":	startPos = 6; break;
		}
		
		for(int i = 0, count = 1; count <= days; i++)	//Loop to fill dates in array
		{
			if(i == 0)
				for(int j = startPos; j < 7 && count <= days; j++, count++)		//For 1st row
					cal[i][j] = count;
			else
				for(int j = 0; j < 7 && count <= days; j++, count++)		//For other rows
					cal[i][j] = count;
		}
		
		
		//Printing
		System.out.println("-------------------------------------------------------");
		System.out.println("\t\t " + month + " " + year + "");
		System.out.println("-------------------------------------------------------");
		System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
		
		for(int i = 0; i < 5; i++)
		{
			for(int j = 0; j < 7; j++)
			{
				if(cal[i][j] == 0)
					System.out.print("\t");
				else
					System.out.print(cal[i][j] + "\t");
			}
			System.out.println();
				
		}
		
		s.close();
	}

}
