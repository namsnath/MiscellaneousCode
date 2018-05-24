import java.util.Scanner;

/*
 * Given two positive numbers M and N, such that M is between 100 and 10000 and N is less than 100. 
 * Find the smallest integer that is greater than M and whose digits add up to N. 
 * For example, if M = 100 and N = 11, then the smallest integer greater than 100 whose digits add up to 11 is 119.
 * Write a program to accept the numbers M and N from the user and print the smallest required number whose sum of all its digits is equal to N. 
 * Also, print the total number of digits present in the required number. 
 * The program should check for the validity of the inputs and display an appropriate message for an invalid input.
 */

public class SmallestNumAddsUpToInput
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter A number between 100 and 10000 (M)");
		int M = s.nextInt();
		
		if(M < 100 || M > 10000)
		{
			System.out.println("M cannot be lesser than 100 or more than 10000");
			System.exit(0);
		}
		
		System.out.println("Enter Second Number (N)");
		int N = s.nextInt();
		
		if(N >= 100)
		{
			System.out.println("Number cannot be greater than 100");
			System.exit(0);
		}
		
		for(int i = M; i < 10000; i++)
		{
			if(findSum(i) == N)
			{
				System.out.println("Smallest required number = " + i);
				System.out.println("Digits in Required Number: " + Integer.toString(i).length());
				break;
			}
		}
		
	}
	
	public static int findSum(int n)
	{
		int a;
		for(a = 0; n >= 1; n /= 10)
			a = a + (n % 10);
		
		return a;
	}

}
