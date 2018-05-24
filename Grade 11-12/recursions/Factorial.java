package recursions;

import java.util.Scanner;

public class Factorial
{

	public static void main(String[] args)
	{
		System.out.println("Enter Number to Find Factorial");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		s.close();
		
		System.out.println("Factorial : " + new Factorial().Fact(n));
	}
	
	int Fact(int n)
	{
		if(n == 1 || n == 0)
			return 1;
		else
			return n * Fact(n - 1);
	}

}
