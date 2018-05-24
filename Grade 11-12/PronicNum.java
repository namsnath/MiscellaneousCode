import java.util.Scanner;

//(int) root of num * int root  + 1. check if  == num. if tru: pronic else not
public class PronicNum
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Number to Check");
		int n = s.nextInt();
		
		if((int)Math.sqrt(n) * ((int)Math.sqrt(n) + 1) == n)
			System.out.println("Pronic Number");
		else
			System.out.println("Not Pronic");
		
		s.close();
	}

}
