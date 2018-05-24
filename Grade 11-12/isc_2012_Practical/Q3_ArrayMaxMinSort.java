package isc_2012_Practical;

import java.util.Scanner;

public class Q3_ArrayMaxMinSort
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Number of Rows");
		int m = s.nextInt();
		
		System.out.println("Enter Number of Columns");
		int n = s.nextInt();
		
		if(m > 20 || m < 2 || n > 20 || n < 2)
		{
			System.out.println("Invalid Input");
			System.exit(0);
		}
		
		int A[][] = new int[m][n], i, j, k = 0, B[] = new int[m*n];
		
		System.out.println("Input Integers Row-Wise");
		for(i = 0; i < m; i++)
			for(j = 0; j < n; j++)
			{
				int x = s.nextInt();
				B[k] = x;
				k++;
				A[i][j] = x;
			}
		
		System.out.println("\n\nYour Input Matrix:");
		for(i = 0; i < m ; i++)
		{
			for(j = 0; j < n; j++)
				System.out.print(A[i][j] + "\t");
			System.out.println();
		}
		
		for(i = 0; i < (m*n-1); i++)
			for(j = i + 1; j < m*n; j++)
				if(B[j] < B[i])
				{
					k = B[i];
					B[i] = B[j];
					B[j] = k;
				}
		
		int min = B[0], max = B[B.length - 1];
		boolean maxF = false, minF = false;
		
		for(i = 0; i < m; i++)
			for(j = 0; j < n; j++)
			{
				if(!maxF)
					if(A[i][j] == max)
					{
						System.out.println("Max element " + max + " found at [" + i + "][" + j + "]");
						maxF = true;
					}
				
				if(!minF)
					if(A[i][j] == min)
					{
						System.out.println("Min element " + min + " found at [" + i + "][" + j + "]");
						minF = true;
					}
			}
		k = 0;
		for(i = 0; i < m; i++)
			for(j = 0; j < n; j++, k++)
				A[i][j] = B[k];
		
		
		System.out.println("\n\nSorted Array:");
		for(i = 0; i < m; i++)
		{
			for(j = 0; j < n; j++)
			{
				System.out.print(A[i][j] + "\t");
			}
			System.out.println();
		}
			
	}

}
