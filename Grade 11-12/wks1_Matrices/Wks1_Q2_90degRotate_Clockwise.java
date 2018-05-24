package wks1_Matrices;
import java.util.Scanner;


public class Wks1_Q2_90degRotate_Clockwise
{

	public static void main(String[] args)
	{

		Scanner s  = new Scanner(System.in);
		int m,n, i, j;
		//Dimensions
		System.out.println("Enter Order of Matrix:");
		n = s.nextInt();
		
		int A[][] = new int[n][n];	//Matrix
		
		System.out.println("Enter the elements in the array, Row-Wise:");
		//Data Entry
		for(i = 0; i < n; i++)
			for(j = 0; j < n; j++)
				A[i][j] = s.nextInt();
		
		System.out.println("Your Matrix:");
		//Original Matrix
		for(i = 0; i < n; i++)
		{
			for(j = 0; j < n; j++)
				System.out.print(A[i][j] + "\t");
			System.out.println();
		}
		
		System.out.println("Rotated Matrix:");
		for(i = 0; i < n; i++)
		{
			for(j = n - 1; j >= 0; j--)	//Transposes and prints rows in opposite direction
				System.out.print(A[j][i] + "\t");
			System.out.println();
		}
		
		s.close();
	}

}
