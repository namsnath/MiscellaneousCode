package wks1_Matrices;
import java.util.Scanner;


public class Wks1_Q1_Sort2D
{
	public static void main (String args[])
	{
		Scanner s  = new Scanner(System.in);
		int m,n, i, j, temp;
		
		System.out.println("Enter Number of Rows:");
		m = s.nextInt();
		
		System.out.println("Enter Number of Columns:");
		n = s.nextInt();
		
		int A[][] = new int[m][n];
		
		System.out.println("Enter the elements in the array, Row-Wise:");
		
		for(i = 0; i < m; i++)
			for(j = 0; j < n; j++)
				A[i][j] = s.nextInt();
		
		System.out.println("Your array:");
		
		for(i = 0; i < m; i++)
		{
			for(j = 0; j < n; j++)
				System.out.print(A[i][j] + "\t");
			System.out.println();
		}
			
		
		int B[] = new int[m * n], k = 0;
		
		for(i = 0; i < m; i++)
			for(j = 0; j < n; j++)
				{
					B[k] = A[i][j];
					k++;
				}
		
		for(i = 0; i < B.length - 1; i++)
			for(j = i + 1; j < B.length; j++)
				if(B[j] < B[i])
				{
					temp = B[j];
					B[j] = B[i];
					B[i] = temp;
				}
		
		k = 0;
		
		for(i = 0; i < m; i++)
			for(j = 0; j < n; j++)
				{
					A[i][j] = B[k];
					k++;
				}
		
		System.out.println("Your Sorted Array:");
		
		for(i = 0; i < m; i++)
		{
			for(j = 0; j < n; j++)
				System.out.print(A[i][j] + "\t");
			System.out.println();
		}
		
		s.close();
	}
}
