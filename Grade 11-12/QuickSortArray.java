import java.util.Scanner;
public class QuickSortArray
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter size of array");
		int n = s.nextInt();
		
		int A[] = new int[n];
		
		System.out.println("Enter elements");
		for(int i = 0; i < n; i++)
			A[i] = s.nextInt();
		
		QuickSortArray qs = new QuickSortArray();
		
		qs.quicksort(A, 0, A.length - 1);			//Calls quicksort on given array
		
		for(int i = 0; i < A.length; i++)
			System.out.print(A[i]  + " ");
	}

	public void quicksort(int A[], int left, int right)
	{
		int q;
		if(right > left)					//if upper index is more than lower index
		{
			q = partition(A, left, right);	//Calls partition on array between left and right indices
			quicksort(A, left, q - 1);		//Calls itself on array between left and index of j passed back from partition function
			quicksort(A, q + 1, right);		//Calls itself on array between q + 1 and right
		}
	}
	
	public int partition(int A[], int left, int right)	//Function to split array into 3 parts, left block, pivot, right block
	{
		int P = A[left];		//Set Pivot P to the first element in the given array
		int i = left;			//first index in array
		int j = right + 1;		//last index + 1 in array
		
		for(;;)
		{
			while(A[++i] < P)	//finds last element in line which is smaller than Pivot
				if(i >= right)	//Breaks if index exceeds array range
					break;
			
			while(A[--j] > P)	//Finds last element in line (from the rear) which is larger than Pivot
				if(j <= left)	//Breaks if index is smaller than lowest index of array
					break;
			
			
			if(i >= j)			//Breaks if i and j are same, or i is larger
				break;
			else
				swap(A, i, j);	//Swap elements at i and j to put elements smaller than pivot in 1st subblock and larger than pivot in second subblock
		}
		
		if(j == left)			//If j has gone down to lowest index, returns lowest index
			return j;
		
		swap(A, left, j);		//Swap lowest index and current index of j
		return j;				//Returns j
	}
	
	public void swap(int[] A, int i, int j)		//Function to swap elements at indices i and j
	{
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	
}
