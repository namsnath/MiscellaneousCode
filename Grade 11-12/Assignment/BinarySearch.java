import java.util.Scanner;
public class BinarySearch
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		int[] A = new int[10];
		int L = 0, U = 0, M = 0, i = 0, j = 0, Input, Temp;
		boolean Found = false;
		
		System.out.println("Enter 10 Elements");
		for(i = 0; i < A.length; i++)
		{
			A[i] = s.nextInt();
		}
		
		for(i = 0; i < 10; i++)
		{
			for(j = 0; j < 9; j++)
			{
				if(A[j + 1] < A [j]) //Change this to "Array[j + 1] > Array [j]" to sort in descending order
				{
					Temp = A[j + 1];
					A[j + 1] = A [j];
					A[j] = Temp;
				}
			}
		}
		
		System.out.println("Enter Number To Search");
		Input = s.nextInt();
		
		L = 0;
		U = (A.length);

		while(L < U)
		{
			M = (L + U) / 2;
			
			if (Input > A[M])
			{
				L = M + 1;
			}
			else if (Input < A[M])
			{
				U = M - 1;
			}
			else
			{
				Found = true;
				break;
			}
			
		}
		
		
		if (Found == true)
		{
			System.out.println("Found");
		}
		else
		{
			System.out.println("Not Found");
		}
	}

}
