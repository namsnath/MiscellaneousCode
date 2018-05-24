package programmingAssignment;

import java.util.Scanner;

public class Q26_CircularPrimeCheck
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Number");
		int num = s.nextInt();					//Stores input
		boolean prime = true;					//Flag for prime
		
		String inp = num + "";					//Converts input to String
		
		
		StringBuffer st = new StringBuffer(inp);	//StringBuffer used to rotate the String
		for(int i = 0; i < inp.length(); i++)		//Loop to rotate the String
		{	
			System.out.println(st);					//Prints String
			
			char c = st.charAt(inp.length() - 1);	//Character to store last char in current rotation of input String
			st.deleteCharAt(inp.length() - 1);		//Deletes saved character from string
			st.reverse();							//Reverses String	
			st.append(c);							//Appends char
			st.reverse();							//Reverses String again
			
			if(isPrime(Integer.parseInt(st.toString())))	//Checks if current rotation is prime, if yes, goes to next rotation
				continue;
			else
				prime = false;								//else, sets flag to false
		}
		
		System.out.println();
		if(prime)
			System.out.println(num + " is Circular Prime");
		else
			System.out.println(num + " is not Circular Prime");
		
		s.close();
	}
	
	public static boolean isPrime(int n)		//Function to check for prime
	{
		if(n == 0 || n == 1)
			return false;
		if(n == 2)
			return true;	
		if(n % 2 == 0)							//Checks for multiple of 2
			return false;
		for(int i = 3; i * i < n; i += 2)		//Checks for multiples of all odd numbers
			if(n % i == 0)
				return false;
		return true;
	}

}
