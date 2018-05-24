package wks1_Matrices;
import java.util.Scanner;


public class Matrix_Transpose
{

	public static void main(String[] args)
	{
		Scanner s  = new Scanner(System.in);
		int m,n, i, j;
		
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
		
		System.out.println("Transposed Matrix:");
		
		for(i = 0; i < m; i++)
		{
			for(j = 0; j < n; j++)
				System.out.print(A[j][i] + "\t");
			System.out.println();
		}
		s.close();

	}

}
