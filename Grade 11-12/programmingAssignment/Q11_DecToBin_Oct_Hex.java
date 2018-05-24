package programmingAssignment;

import java.util.Scanner;

public class Q11_DecToBin_Oct_Hex
{
	static char[] rems = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};	//Array
	
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter Number to Convert");
		int n = s.nextInt();
		
		System.out.println("Number in Binary: " + Q11_DecToBin_Oct_Hex.DecToBin(n));	//Prints Binary equivalent by calling Function
		System.out.println("Number in Octal: " + Q11_DecToBin_Oct_Hex.DecToOct(n));		//Prints Octal equivalent by calling Function
		System.out.println("Number in Hexadecimal: " + Q11_DecToBin_Oct_Hex.DecToHex(n));	//Prints Hexadecimal equivalent by calling Function
		
		s.close();
	}
	
	public static String DecToBin(int n)	//Function to return Binary equivalent of a decimal number
	{
		if(n == 0)
			return "0";
		
		String Binary = "";	//String to store Binary equivalent
		for(int rem = n % 2; n > 0; rem = n % 2)	//Loop to append remainder to string, creating Binary number
		{
			Binary = rems[rem] + Binary; 
			n = n / 2; 
		}
		return Binary;	//returns Binary equivalent
	}
	
	public static String DecToOct(int n)	//Function to return Octal equivalent of a decimal number
	{
		if(n == 0)
			return "0";
		
		String Octal = "";	//String to store Octal equivalent
		for(int rem = n % 8; n > 0; rem = n % 8)	//Loop to append remainder to string, creating Octal number
		{
			Octal = rems[rem] + Octal;
			n = n / 8; 
		}
		return "0o" + Octal;	//returns Octal equivalent
	}
	
	public static String DecToHex(int n)	//Function to return Hexadecimal equivalent of a decimal number
	{
		if(n == 0)
			return "0";
		
		String Hex = "";	//String to store Hexadecimal equivalent
		for(int rem = n % 16; n > 0; rem = n % 16)	//Loop to append remainder to string, creating Hexadecimal number
		{
			Hex = rems[rem] + Hex;
			n = n / 16;
		}
		return "0x" + Hex;	//returns Hexadecimal equivalent
	}
}
