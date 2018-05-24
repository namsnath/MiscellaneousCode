
public class SeriesQ12Misc
{

	public static void main(String[] args)
	{
		SeriesQ12Misc obj = new SeriesQ12Misc();
		double Sum;
		int Fact, i;
		
		Sum = 1;
		
		for(i = 2; i <= 10; i++)
		{
			Fact = obj.Factorial(i);
			Sum += 1 / Fact;
		}
		
		System.out.println("Sum is: " + Sum);
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
