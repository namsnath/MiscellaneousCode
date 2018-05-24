import java.util.Scanner;
public class SpecialNum
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter Number to check:");
		int n = s.nextInt();	//Data entry
		
		int sum = 0;	//To store sum of factorials
		
		String st = String.valueOf(n);	//Converts to String
		for(int i = 0; i < st.length(); i++)
		{
			sum += factorial(Integer.parseInt(st.charAt(i) + ""));	//Extracts each digit and adds its factorial
		}
		
		if(n == sum)
			System.out.println(n + " is a Special Number");
		else
			System.out.println(n + " is not a Special Number");
	}
	
	static int factorial(int n)	//Recursive function to calculate factorial
	{
		if(n < 2)
			return 1;
		
		return n * factorial(n - 1);
	}	
}
