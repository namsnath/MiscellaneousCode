import java.util.Scanner;
public class RecursiveGCD
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter two numbers:");	//Data Entry
		int n = s.nextInt();
		int m = s.nextInt();
			
		System.out.println("GCD = " + GCD(n, m));
		System.out.println("LCM = " + m * n / GCD(m, n));	//GCD * LCM = m * n
	}
	
	static int GCD(int n, int m)	//Recursive Function to calculate GCD
	{
		if(m == 0)
			return n;
		return GCD(m, n % m);
	}

}
