import java.util.Scanner;

public class MergeSortArray
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter number of elements");
		int n = s.nextInt();
		
		int[] A = new int[n];
		
		System.out.println("Enter elements");
		for(int i = 0; i < n; i++)
			A[i] = s.nextInt();
		
		MergeSortArray ms = new MergeSortArray();
		ms.MergeSort(A, 0, A.length - 1);				//Passes the entire array to the function
		
		for(int i = 0; i < A.length; i++)
			System.out.print(A[i]  + " ");
	}

	public void MergeSort(int[] A, int p, int r)
	{
		int q;
		if(p < r)									//Runs till lower index is less then upper index
		{
			q = (p + r) / 2;						//Gets middle index
			MergeSort(A, p, q);						//Passes first half of array to itself
			MergeSort(A, q + 1, r);					//Passes seconds half of aray to itself
			Merge(A, p, q, r);						//Calls merge on entire array with q as middle element
		}
	}
	
	public void Merge(int[] A, int p, int q, int r)
	{
		int n1 = q - p + 1;		//Gets size of first half of array passed
		int n2 = r - q ;		//Gets size of second half of array passed
		int i, j, k;
		
		
		int[] L = new int[n1 + 1], R = new int[n2 + 1];		//Declaring arrays corresponding to halves
		
		//Filling elements in the new arrays
		
		for(i = 0; i < n1; i++)
			L[i] = A[p + i];
		for(j = 0; j < n2; j++)
			R[j] = A[q + j + 1];
		
		
		//Sets last element in array to Maximum value of integer for comparison
		L[n1] = Integer.MAX_VALUE;		
		R[n2] = Integer.MAX_VALUE;
		
		i = 0;
		j = 0;
		
		for(k = p; k <= r; k++)		//Iterates thtough elements in the given range
		{
			//Rewrites elements to original array after comparison of two halves
			
			if(L[i] <= R[j])
			{
				A[k] = L[i];
				i++;
			}
			else
			{
				A[k] = R[j];
				j++;
			}
		}	
				
	}
}
