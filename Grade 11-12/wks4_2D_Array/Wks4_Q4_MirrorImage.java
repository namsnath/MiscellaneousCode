package wks4_2D_Array;
import java.util.Scanner;

public class Wks4_Q4_MirrorImage
{

	public static void main(String[] args)
	{
		Scanner s  = new Scanner(System.in);
		int m,n, i, j, k, temp;
		//Dimensions of the Matrix
		System.out.println("Enter Number of Rows:");
		m = s.nextInt();
		
		System.out.println("Enter Number of Columns:");
		n = s.nextInt();
		
		int A[][] = new int[m][n], B[][] = new int[m][n];	//A is original, B is mirror
		
		System.out.println("Enter the elements in the array, Row-Wise:");	//Data Entry
		
		for(i = 0; i < m; i++)
			for(j = 0, k = n - 1; j < n && k >= 0; j++, k--)
			{
				temp = s.nextInt();
				A[i][j] = temp;	//Add to A normally
				B[i][k] = temp;	//Add to B with columns in opposite order
			}
		
		System.out.println("Your array:");
		//Printing
		for(i = 0; i < m; i++)
		{
			for(j = 0; j < n; j++)
				System.out.print(A[i][j] + "\t");
			System.out.println();
		}
		
		System.out.println("Mirror array:");
		
		for(i = 0; i < m; i++)
		{
			for(j = 0; j < n; j++)
				System.out.print(B[i][j] + "\t");
			System.out.println();
		}
		
	}

}
