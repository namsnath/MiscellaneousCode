import java.util.*;
public class CombineArray
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		int[] A = new int[10];
		int[] B = new int[5];

		int[] C = new int[15];
		int[] D;
		
		int Temp = 0;
		int i = 0, j = 0;
		boolean zero = false;
		
		System.out.println("Enter 15 Values. 10 for 1st array, 5 for second.");
		
		for(i = 0; i < 10; i++)
		{
			A[i] = s.nextInt();
		}
		
		for (i = 0; i < 5; i++)
		{
			B[i] = s.nextInt();
		}
		
		for(i = 0, j = 0; i < 10 && j < 5; j++, i++)
		{
			if (A[i] == 0 || B[j] == 0)
			{
				zero = true;
				break;
			}
		}
		
		if (zero == false)
		{
			//Adding A to C
			for(i = 0; i < 10; i++)
			{
				C[i] = A[i];
			}
			
			
			//Adding B to C
			for(j = 0; i < 15 && j < 5; j++, i++)
			{
				C[i] = B[j];
			}
			
			
			for(i = 0; i < 15; i++)
			{
				for(j = 0; j < 14; j++)
				{
					if(C[j + 1] < C [j]) //Change this to "C[j + 1] > C [j]" to sort in descending order
					{
						Temp = C[j + 1];
						C[j + 1] = C [j];
						C[j] = Temp;
					}
				}
			}
			
			int k = 0;
			
			for(i = 0; i < 14; i++)
			{
				if (C[i] == C[i + 1])
				{
					C[i] = 0;
					k++;
				}
			}
			
			for(i = 0; i < 15; i++)
			{
				for(j = 0; j < 14; j++)
				{
					if(C[j + 1] < C [j]) //Change this to "C[j + 1] > C [j]" to sort in descending order
					{
						Temp = C[j + 1];
						C[j + 1] = C [j];
						C[j] = Temp;
					}
				}
			}
			
			
			
			int ArrLength = C.length - k;
			D = new int[ArrLength];
			
			for(i = 0;k < 15 && i < ArrLength; k++, i++)
			{
				D[i] = C[k];
			}
			
			System.out.println("");
			
			for(i = 0; i < D.length; i++)
			{
				System.out.print(D[i] + " ");
			}
		}
		else
		{
			System.out.println("Array Cannot Contain Zero");
		}
	}

}
