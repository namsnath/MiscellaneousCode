package wks1_Matrices;
import java.util.Scanner;

public class Wks1_Q10_Symmetric_DiagonalSum
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter Order of the Matrix");
		int n = s.nextInt();	//Input
		
		if(n < 2 || n > 10)	//Validation of Input
		{
			System.out.println("Order of matrix cannot be less than 2 or more than 10");
			System.exit(0);
		}
		
		int i, j, A[][] = new int[n][n], sumLeft = 0, sumRight = 0;	//Iteration variables, Matrix, Sums of Diagonals
		
		System.out.println("Enter Elements of the Matrix, Row-wise");	//Data Entry
		for(i = 0; i < n; i++)
			for(j = 0; j < n; j++)
			{
				A[i][j] = s.nextInt();	//User Input for each element
			}
		
		for(i = 0; i < n; i++)
			for(j = 0; j < n; j++)
				if(A[i][j] != A[j][i])	//Checks for elements on opposites of the Matrix
				{
					System.out.println("Not Symmetrical");
					System.exit(0);
				}
		System.out.println("Symmetrical");
		
		
		for(i = 0, j = 0; i < n && j < n; i++, j++)	//Left Diagonal Sum
				sumLeft += A[i][j];
		
		for(i = n - 1, j = 0; i >= 0 && j < n; i--, j++)	//Right Diagonal Sum
				sumRight += A[i][j];
		
		//Printing
		System.out.println("Sum of Left Diagonal = " + sumLeft);
		System.out.println("Sum of Right Diagonal = " + sumRight);
	}

}
