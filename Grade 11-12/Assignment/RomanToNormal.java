import java.util.Scanner;

public class RomanToNormal 
{
	public static void romanToDecimal(String romanNumber) 
	{
	    int decimal = 0;
	    int lastNumber = 0;
	    String romanNumeral = romanNumber.toUpperCase();
	         /* operation to be performed on upper cases even if user enters roman values in lower case chars */
	    for (int x = romanNumeral.length() - 1; x >= 0 ; x--) 
	    {
	        char convertToDecimal = romanNumeral.charAt(x);
	
	        switch (convertToDecimal) 
	        {
	            case 'M':
	                decimal = processDecimal(1000, lastNumber, decimal);
	                lastNumber = 1000;
	                break;
	
	            case 'D':
	                decimal = processDecimal(500, lastNumber, decimal);
	                lastNumber = 500;
	                break;
	
	            case 'C':
	                decimal = processDecimal(100, lastNumber, decimal);
	                lastNumber = 100;
	                break;
	
	            case 'L':
	                decimal = processDecimal(50, lastNumber, decimal);
	                lastNumber = 50;
	                break;
	
	            case 'X':
	                decimal = processDecimal(10, lastNumber, decimal);
	                lastNumber = 10;
	                break;
	
	            case 'V':
	                decimal = processDecimal(5, lastNumber, decimal);
	                lastNumber = 5;
	                break;
	
	            case 'I':
	                decimal = processDecimal(1, lastNumber, decimal);
	                lastNumber = 1;
	                break;
	        }
	    }
	    System.out.println(decimal);
	}
	
	public static int processDecimal(int decimal, int lastNumber, int lastDecimal) 
	{
	    if (lastNumber > decimal) //Checks For Values Like XC or IV
	        return lastDecimal - decimal; //returns C - X if First char smaller than Second
	    else
	        return lastDecimal + decimal; //returns C + X if first char larger than Second
	}
	
	public static void main(java.lang.String args[]) 
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter Roman Number: ");
		String Input = s.nextLine().trim().toUpperCase(); // takes input removes whitespaces before and after string (if any) and changes all to uppercase
		
	    romanToDecimal(Input); //Passes Input String to function
	}
}