import java.util.Scanner;
public class SeriesQ7Misc
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		int a, n;
		double Sum = 0;
		
		System.out.println("Enter number and limit");
		a = s.nextInt();
		n = s.nextInt();
		
		for(int i = 2; i <= n; i++)
		{
			Sum += a / i;
		}
		
		System.out.println("Sum: " + Sum);
	}

}
