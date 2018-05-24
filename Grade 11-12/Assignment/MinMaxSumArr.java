import java.util.Scanner;

/*
 * 5. Write a program to initialize the given data in an array and find the minimum and maximum values along with the sum of the given elements. Numbers : 2 5 1 4 3 
Output:
 Maximum value = 5 
Minimum value = 1 
Sum of the elements = 15

 */

public class MinMaxSumArr
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		int Array[] = new int[10];
		int i, Temp, Sum = 0;
		
		System.out.println("Enter 10 Numbers");
		
		for(i = 0; i < 10; i++)
		{
			Array[i] = s.nextInt();
			Sum = Sum + Array[i];
		}
		
		for(i = 0; i < 10; i++)
		{
			for(int j = 0; j < 9; j++)
			{
				if(Array[j + 1] < Array [j])
				{
					Temp = Array[j + 1];
					Array[j + 1] = Array [j];
					Array[j] = Temp;
				}
			}
		}
		
		System.out.println("Maximum: " + Array[9]);
		System.out.println("Minimum: " + Array[0]);
		System.out.println("Sum:" + Sum);
		
	}

}
