package isc_2012_Practical;

import java.util.Scanner;

public class Q1_PrimePalindromeCheck
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Limits m and n (0 < m & n < 3000)");
		int m, n;
		m = s.nextInt();
		n = s.nextInt();
		
		
		if(m <= 0 || m >= 3000 || n <= 0 || n >= 3000)
		{
			System.out.println("Invalid Input");
			System.exit(0);
		}
		
		for(int i = m; i <= n; i++)
			if(checkPalindrome(i) && checkPrime(i))
				System.out.print(i + ",");
	}

	public static boolean checkPalindrome(int n)
	{
		StringBuffer st = new StringBuffer(Integer.toString(n));
		if(st.equals(st.reverse()))
			return true;
		
		return false;
	}
	
	public static boolean checkPrime(int n)
	{
		if(n == 1 || n == 0)
			return false;
		if(n == 2)
			return true;
		if(n % 2 == 0)
			return false;
	    for(int i = 3; i * i <= n; i += 2) 
	        if(n % i == 0)
	            return false;
	    
	    return true;
	}
	
}
