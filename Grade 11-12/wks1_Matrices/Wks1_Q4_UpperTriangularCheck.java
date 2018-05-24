package wks1_Matrices;
import java.util.Scanner;


public class Wks1_Q4_UpperTriangularCheck
{

	public static void main(String[] args)
	{
		Scanner s  = new Scanner(System.in);
		int m,n, i, j;
		
		System.out.println("Enter Number of Rows:");
		m = s.nextInt();
		
		System.out.println("Enter Number of Columns:");
		n = s.nextInt();
		
		if(m != n)
		{
			System.out.println("Matrix has to be a square Matrix to check");
			System.exit(0);
		}
		
		int A[][] = new int[m][n];
		
		System.out.println("Enter the elements in the array, Row-Wise:");
		
		for(i = 0; i < m; i++)
			for(j = 0; j < n; j++)
				A[i][j] = s.nextInt();
		
		System.out.println("Your Matrix:");
		
		for(i = 0; i < m; i++)
		{
			for(j = 0; j < n; j++)
				System.out.print(A[i][j] + "\t");
			System.out.println();
		}
		
		boolean flag = false;
		
		for(i = m - 1; i >= 0; i--)
		{
			for(j = i - 1; j >= 0; j--)
				if(A[i][j] != 0)
				{
					flag = true;
					break;
				}
			if(flag)
				break;
		}
		
		if(flag)
			System.out.println("Not a Upper Triangular Matrix");
		else
			System.out.println("It is a Upper Triangular Matrix");
		
		s.close();
	}

}
