import java.util.Scanner;

public class NumSort15
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
	
		int Array[] = new int[15], i, Temp;
		//int i, Temp;
		
		
		System.out.println("Enter 15 Numbers. No Number should be zero.");
		for(i = 0; i < 15; i++)
		{
			Array[i] = s.nextInt();
		}
		
		System.out.println("Your Original Array:\n");
		for(i = 0; i < 15; i++)
		{
			System.out.print(Array[i] + "\t");
		}

		System.out.println();
		
		for(i = 0; i < 15; i++)
		{
			for(int j = 0; j < 14; j++)
			{
				if(Array[j + 1] < Array [j]) //Change this to "Array[j + 1] > Array [j]" to sort in descending order
				{
					Temp = Array[j + 1];
					Array[j + 1] = Array [j];
					Array[j] = Temp;
				}
			}
		}
		
		System.out.println("Your Sorted Array (Ascending):\n");
		
		for(i = 0; i < 15; i++)
		{
			System.out.print(Array[i] + "\t");
		}
		
		for(i = 0; i < 15; i++)
		{
			for(int j = 0; j < 14; j++)
			{
				if(Array[j + 1] > Array [j])
				{
					Temp = Array[j + 1];
					Array[j + 1] = Array [j];
					Array[j] = Temp;
				}
			}
		}
		
		System.out.println();
		System.out.println("Your Sorted Array (Descending):\n");
		
		for(i = 0; i < 15; i++)
		{
			System.out.print(Array[i] + "\t");
		}
	}

}