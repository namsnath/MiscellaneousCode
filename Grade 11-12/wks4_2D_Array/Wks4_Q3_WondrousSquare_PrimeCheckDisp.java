package wks4_2D_Array;

import java.util.Scanner;

public class Wks4_Q3_WondrousSquare_PrimeCheckDisp
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter Order of Matrix such that it is >=2 & <=10");
		int n = s.nextInt();
		
		if(n < 2 || n > 10)
		{
			System.out.println("Invalid size of Matrix");
			System.exit(0);
		}
		
		int i, j, k, A[][] = new int[n][n];
		
		System.out.println("Enter Elements of Matrix Row-Wise");
		
		for(i = 0; i < n; i++)
			for(j = 0; j < n; j++)
			{
				int x = s.nextInt();
				if(x < 0 || x > n*n)
				{
					System.out.println("Invalid Input");
					System.exit(0);
				}
				A[i][j] = x;
			}
		
		System.out.println();
		
		for(i = 0; i < n; i++)
		{
			for(j = 0; j < n; j++)
				System.out.print(A[i][j] + "\t");
			System.out.println();
		}
		
		
		boolean flag = false;
		double sum = 0.5 * n * (n * n + 1);
		
		for(i = 0; i < n; i++)
		{
			double sumc = 0, sumr = 0;
			for(j = 0; j < n; j++)
			{
				sumc += A[i][j];
				sumr += A[j][i];
			}
				
			
			if(sumc != sum || sumr != sum)
			{
				flag = true;
				break;
			} 
		}
		
		
		if(flag)
			System.out.println("Not Wondrous Square");
		else
			System.out.println("Wondrous Square");
		
		System.out.println("\n\nPrime\tRow\tColumn");
		for(i = 0; i < n; i++)
			for(j = 0; j < n; j++)
				if(checkPrime(A[i][j]))
					System.out.println(A[i][j] + "\t" + i + "\t" + j);
	}

	public static boolean checkPrime(int n)
	{
		if(n == 1)
			return false;
		if(n == 2)
			return true;
		if (n % 2 == 0) 
			return false;
	    for(int i = 3; i * i <= n; i += 2) 
	        if(n % i == 0)
	            return false;
	    
	    return true;
	}
	
}
