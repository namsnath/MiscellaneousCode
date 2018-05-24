package Prelim2;

import java.util.Scanner;

public class GCDSum
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		int N = 2, A = 3, B = 2;
		double sum = 0;
		
		for(int i = 1; i <= N; i++)
			for(int j = 1; j <= N; j++)
			{
				sum += findGCD((Math.pow(A, i) - Math.pow(B, i)), (Math.pow(A, j) - Math.pow(B, j)));
				if(i == N && j == N)
					System.out.print("GCD(" + (int)(Math.pow(A, i) - Math.pow(B, i)) + "," + (int)(Math.pow(A, j) - Math.pow(B, j)) +") = ");
				else
				System.out.print("GCD(" + (int)(Math.pow(A, i) - Math.pow(B, i)) + "," + (int)(Math.pow(A, j) - Math.pow(B, j)) +") + ");
			}
		System.out.println((int)sum);
	}

	private static double findGCD(double a, double b)
	{
		if(b == 0)
        	return a;
		return findGCD(b, a % b);
	}
	
}
