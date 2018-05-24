
public class SeriesQ11Misc
{

	public static void main(String[] args)
	{
		int i;
		double Sum = 0;
		
		for(i = 0; i < 10; i++)
		{
			if(i % 2 == 0)
				Sum -= i /(i + 1);
			else
				Sum += i / (i + 1);
		}
		
		System.out.println("Sum is: " + Sum);
	}

}
