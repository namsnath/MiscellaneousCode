
public class SeriesQ9Misc
{

	public static void main(String[] args)
	{
		SeriesQ9Misc q9 = new SeriesQ9Misc();
		int i, j;
		long Sum = 0, temp = 1;

		for(i = 1; i <= 10; i++)
		{
			Sum += q9.Factorial(i);
		}
		
		System.out.println("Sum: " + Sum);
	}

	
	public int Factorial(int n)
	{
		int f;
		
		f = 1;
		
		while (n >= 1)
		{
			f = f * n;
			n--;
		}
		return f;
	}
	
}
