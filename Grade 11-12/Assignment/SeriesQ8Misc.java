import java.util.Scanner;
public class SeriesQ8Misc
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int a, n, i, j, k;
		double Sum = 0;
		
		System.out.println("Enter number and limit");
		a = s.nextInt();
		n = s.nextInt();
		
		for(i = 0, j = 1, k = 2; i <= n; i++, j += 2, k += 2)
		{
			Sum += (a + j) / k;
		}
		
		System.out.println("Sum: " + Sum);
	}
}
