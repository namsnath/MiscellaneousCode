import java.util.Scanner;
public class HCF
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		int Num2, Num1, Max, HCF = 1;
		
		System.out.println("Enter 2 numbers:");
		Num1 = s.nextInt();
		Num2 = s.nextInt();
		
		if(Num1 < Num2)
			Max = Num1;
		else
			Max = Num2;
		
		for(int i = 1; i < Max; i++)
		{
			if(Num1 % i == 0 && Num2 % i == 0 && i > HCF)
				HCF = i;
		}
		
		System.out.println("The HCF is: " + HCF);
	}

}
