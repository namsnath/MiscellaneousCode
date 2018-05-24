import java.util.Scanner;
public class InsertionSortArray
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		int A[] = new int[10];
		int i, x, j;
		
		System.out.println("Enter 10 elements:");
		for(i = 0; i < 10; i++)	//Data Entry
			A[i] = s.nextInt();
		
		for(i = 0; i < 10; i++)
		{
			x = A[i];	//Takes current element
			
			for(j = i - 1; j >= 0 && A[j] > x; j--)	//Shifts all elements ahead one space to make place for sorting element
				A[j + 1] = A[j];
				
			A[j + 1] = x;	//Places element in space
		}
			   
		for(i = 0; i < 10; i++)	//Printing
			System.out.print(A[i] + " ");
		
	}

}
