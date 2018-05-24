import java.util.Scanner;
public class ArraySort
//Bubble Sorting
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter Number of elements");
		int n = s.nextInt();
		
		double[] Array = new double[n];
		double Temp = 0;
		
		
		System.out.println("Enter " + n + " Numbers for array");
		for(int i = 0; i < Array.length; i++)
		{
			Array[i] = s.nextDouble();
		}
		
		System.out.println("Your Original Array:\n");
		for(int i = 0; i < Array.length; i++)
		{
			System.out.print(Array[i] + "\t");
		}

		System.out.println();
		
		for(int i = 0; i < Array.length; i++)
		{
			for(int j = 0; j < Array.length-1; j++)
			{
				if(Array[j + 1] < Array [j]) //Change this to "Array[j + 1] > Array [j]" to sort in descending order
				{
					Temp = Array[j + 1];
					Array[j + 1] = Array [j];
					Array[j] = Temp;
				}
			}
		}
		
		System.out.println("Your Sorted Array:\n");
		
		for(int i = 0; i < Array.length; i++)
		{
			System.out.print(Array[i] + "\t");
		}
		
		s.close();
	}

}
