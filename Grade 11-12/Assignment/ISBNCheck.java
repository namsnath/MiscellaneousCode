import java.util.Scanner;
public class ISBNCheck
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		long Input, i, Sum = 0, temp;
		
		
		System.out.println("Enter ISBN Code:");
		Input = s.nextLong();
		
		if(Long.toString(Input).length() != 10)
		{
			System.out.println("Illegal ISBN");
			System.exit(0);
		}
		
		for(i = 10; i > 0; i--)
		{
			temp = Input % 10;
			Input /= 10;
			
			Sum += temp * i;
		}
		
		System.out.println(Sum);
		
		if(Sum % 11 == 0)
			System.out.println("Valid ISBN Code");
		else
			System.out.println("Invalid ISBN");
	}

}
