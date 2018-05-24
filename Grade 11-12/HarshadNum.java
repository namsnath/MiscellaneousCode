import java.util.Scanner;
public class HarshadNum
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Number");
		int n = s.nextInt();	//user Input of Number
		int sum = 0;	//To store the sum of digits
		
		for(int i = n; i > 0; sum += i % 10, i = i / 10)	//Loop to obtain sum of digits
		{}
		
		if(n % sum == 0)	//If the Number is divisible by its Sum
			System.out.println(n + " is a Harshad Number");
		else
			System.out.println(n + " is not a Harshad Number");
	}

}
