import java.util.Scanner;

public class ArraySorting
//Selection Sorting
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("ENter length of Array");
		int n = s.nextInt();
		
		int[] Array = new int[n];
		int Temp = 0;
		
		
		System.out.println("Enter " + n + " Numbers for array");
		for(int i = 0; i < n; i++)
		{
			Array[i] = s.nextInt();
		}
		
		System.out.println("Your Original Array:\n");
		for(int i = 0; i < n; i++)
		{
			System.out.print(Array[i] + "\t");
		}

		System.out.println();
		
		for(int i = 0; i < Array.length - 1; i++)
		{
			for(int j = i + 1; j < Array.length; j++)
			{
				if(Array[j] < Array [i]) //Change this to "Array[j] > Array [j]" to sort in descending order
				{
					Temp = Array[j];
					Array[j] = Array [i];
					Array[i] = Temp;
				}
			}
		}
		
		System.out.println("Your Sorted Array:\n");
		
		for(int i = 0; i < n; i++)
		{
			System.out.print(Array[i] + "\t");
		}

	}

}
