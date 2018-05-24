import java.util.Scanner;
public class DecimalRoman
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		String[] Hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};	//Array for Hundreds in Roman
		String Tens[]={"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};	//Array for Tens in Roman
		String Units[]={"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};	//Array for Units in Roman
		
		System.out.println("Enter Decimal Number to Convert to Roman (Less than 1000):");	//Input
		int n = s.nextInt();
		
		String Hund = Hundreds[n / 100];	//Division by 100 yields number of hundreds
		String Ten = Tens[(n / 10) % 10];	//Division by 10 and the remainder of further division by 10 yields Tens
		String Unit = Units[n % 10];	//Remainder of division by 10 yields number of Ones
		
		System.out.println("Roman Equivalent: " + Hund + Ten + Unit);	//Final Answer
	}

}
