
public class Loop
{

	public static void main(String[] args)
	{
		int[] a = {5,7,1,9,3};
		
		int i, j, temp;
		
		for(i = 0; i < 5; i++)
		{
			for(j = 3; j >= 0; j--)
			{
				if(a[j] > a[j+1])
				{
					temp = a[j];
					a[j] = a[i];
					a[i] = temp;
				}
			}
		}
		
		System.out.println("");
		
		for(i = 0; i <5; i++)
		{
			System.out.print(a[i] + "\t");
		}
		

	}

}
