package wks4_2D_Array;

import java.util.Scanner;

public class Wks4_Q1_DispMax_2ndMax_SortAsc
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Order of Matrix:");
		int n = s.nextInt();	//Order of the Matrix
		
		int A[][] = new int[n][n], B[] = new int[n*n], k = 0, i, j;	//A is original Matrix, B is for sorting
		
		System.out.println("Enter elements of array Row-wise:");
		//Data Entry
		for(i = 0; i < n; i++)
			for(j = 0; j < n; j++)
			{
				int x = s.nextInt();
				if(x < 0)
				{
					System.out.println("Invalid Input. Input cannot be less than 0");
					System.exit(0);
				}
				A[i][j] = x;	//Adds to A
				B[k] = x;	//Adds to B
				k++;
			}
		
		for(i = 0; i < n * n; i++)	//Sorting B
			for(j = 0; j < n * n - 1; j++)
				if(B[j + 1] < B[j])
				{
					int temp = B[j];
					B[j] = B[j + 1];
					B[j + 1] = temp;
				}
		
		int max = B[B.length - 1];
		int max2 = B[B.length - 2];
		
		
		for(i = 0; i < n; i++)
			for(j = 0; j < n; j++)
			{
				if(A[i][j] == max)
					System.out.println("Max Element " + max + " found at [" + (i + 1) + "][" + (j + 1) + "]");
				if(A[i][j] == max2)
					System.out.println("Second Max Element " + max2 + " found at [" + (i + 1) + "][" + (j + 1) + "]");
			}
		
		k = 0;
		
		for(i = 0; i < n; i++)	//Copies elements from B to A in order
			for(j = 0; j < n; j++, k++)
				A[i][j] = B[k];
		
		for(i = 0; i < n; i++)	//Printing
		{
			for(j = 0; j < n; j++)
			{
				System.out.print(A[i][j] + "\t");
			}
			System.out.println();
		}
		
	}

}
