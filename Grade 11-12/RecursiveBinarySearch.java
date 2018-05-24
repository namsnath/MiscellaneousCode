import java.util.Scanner;
public class RecursiveBinarySearch
{

	public static void main(String[] args)
	{
		int A[] = {2, 45, 69, 234, 567, 876, 900, 976, 999};	//Sample Data
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter data to search for:");
		int x = s.nextInt();
		
		int found = binarySearch(A, x, 0, A.length - 1);
		
		if(found != -1)
			System.out.println("Found at position " + (found + 1));
		else
			System.out.println("Not Found");
	}	

	static int binarySearch(int A[], int x, int low, int high) 
	{
		if(low > high)
			return -1;
		int mid = (low + high) / 2;
		if(x > A[mid])
			return binarySearch(A, x, mid + 1, high);
		else if(x < A[mid])
			return binarySearch(A, x, low, mid - 1);
		
		return mid;
	}
	
}
