package wks1_Matrices;

import java.util.Scanner;

public class Wks1_Q7_Multiplication
{

	public static void main(String[] args)
	{
		Scanner s  = new Scanner(System.in);
		int r1, r2, c1, c2, i, j;
		
		//Dimensions of the two Matrices
		System.out.println("Enter Number of Rows in First Matrix:");
		r1 = s.nextInt();
		
		System.out.println("Enter Number of Columns in First Matrix:");
		c1 = s.nextInt();
		
		System.out.println("Enter Number of Rows in Second Matrix:");
		r2 = s.nextInt();
		
		System.out.println("Enter Number of Columns in Second Matrix:");
		c2 = s.nextInt();
		
		
		if(c1 != r2)	//Condition for multiplication
		{
			System.out.println("Number of Columns in Matrix 1 have to be equal to Rows in Matrix 2");
			System.exit(0);
		}
		
		//Creating the Matrices
		int A[][] = new int[r1][c1];
		int B[][] = new int [r2][c2];
		
		//Data Entry
		System.out.println("Enter the elements in the First Matrix, Row-Wise:");
		
		for(i = 0; i < r1; i++)
			for(j = 0; j < c1; j++)
				A[i][j] = s.nextInt();
		
		
		System.out.println("Enter the elements in the Second Matrix, Row-Wise:");
		
		for(i = 0; i < r2; i++)
			for(j = 0; j < c2; j++)
				B[i][j] = s.nextInt();
		
		System.out.println("\n\n\n");
		
		//Printing the Original Matrices
		System.out.println("Matrix 1:");
		
		for(i = 0; i < r1; i++)
		{
			for(j = 0; j < c1; j++)
				System.out.print(A[i][j] + "\t");
			System.out.println();
		}
		
		System.out.println("Matrix 2:");
		
		for(i = 0; i < r2; i++)
		{
			for(j = 0; j < c2; j++)
				System.out.print(B[i][j] + "\t");
			System.out.println();
		}
		
		int C[][] = new int [r1][c2];	//Multiplication array
		
		for( i = 0; i < r1; i++)
		{
			for( j = 0;j < c2; j++)
			{
				for(int k = 0;k < r1; k++)
				{
		            C[i][j] += A[i][k] * B[k][j];	//Multiplies Row of 1st matrix with Column of the other and adds to third
		        }
		    }
		}
		
		System.out.println("Multiplied Matrix:");	//Printing the Multiplied Matrix
		
		for(i = 0; i < r1; i++)
		{
			for(j = 0; j < c2; j++)
				System.out.print(C[i][j] + "\t");
			System.out.println();
		}
		
		s.close();
	}

}
