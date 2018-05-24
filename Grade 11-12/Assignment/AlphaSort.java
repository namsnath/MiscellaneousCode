import java.util.Scanner;
public class AlphaSort
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		String[] Array = new String[5];
		int i = 0, j = 0;
		String Temp;
		
		System.out.println("Enter 5 Words");
		for(i = 0; i < 5; i++)
		{
			Array[i] = s.nextLine();
		}
		
		for(i = 0; i < Array.length; i++)
		{
			for(j = 0; j < Array.length-1; j++)
			{
				if(Array[j].compareToIgnoreCase(Array[j + 1]) > 0) //Change this to "Array[j + 1] > Array [j]" to sort in descending order
				{
					Temp = Array[j + 1];
					Array[j + 1] = Array [j];
					Array[j] = Temp;
				}
			}
		}
		
		for(i = 0; i < 5; i++)
		{
			System.out.println(Array[i]);
		}
		
		s.close();
	}

}
