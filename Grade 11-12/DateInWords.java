import java.util.Scanner;
public class DateInWords
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Date in format: ddmmyyyy");
		String input = s.next();		//Takes User input as a String
		
		StringBuffer p1, p2, p3;		//Declaration and initialisation of three String Buffers with the input String
		p1 = new StringBuffer(input);
		p2 = new StringBuffer(input);
		p3 = new StringBuffer(input);
		
		p1.setLength(2);			//First two characters extracted
		
		p2.setLength(4);			//Middle two characters extracted
		p2.reverse();
		p2.setLength(2);
		p2.reverse();
		
		p3.reverse();				//Last two characters extracted
		p3.setLength(4);
		p3.reverse();
		
		int date = Integer.parseInt(p1.toString());		//StringBuffers parsed to Integers
		int month = Integer.parseInt(p2.toString());
		int year = Integer.parseInt(p3.toString());
		
		if((date > 30 && (month == 2 || month == 4 || month == 6 || month == 9 || month == 1)) || date > 31 || 	//Checking Validity of Dates
				(date > 28 && month == 2 && year % 4 != 0) || (date > 29 && month == 2 && year % 4 == 0))
			System.out.println("Invalid Date");
		else
		{
			System.out.print(date);		//Date along with appropriate suffix printed
			switch(date)
			{
				case 1:	System.out.print("st "); break;
				case 2:	System.out.print("nd "); break;
				case 3:	System.out.print("rd "); break;
				case 21:	System.out.print("st "); break;
				case 22:	System.out.print("nd "); break;
				case 23:	System.out.print("rd "); break;
				case 31:	System.out.print("st "); break;
				default:	System.out.print("th "); break;
			}
			
			String months[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}; //Array of Month Names
			System.out.print(months[month - 1] + ", " + year); 		//Printing of Year and Month
			
			
		}
	}

}
