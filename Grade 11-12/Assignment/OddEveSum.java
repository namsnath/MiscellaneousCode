import java.util.Scanner;
public class OddEveSum
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		int i;
		double Limit, OddSum = 0, EveSum = 0;
		
		System.out.println("Enter Limit");
		Limit = s.nextDouble();
		
		for(i = 1; i <= Limit; i++)
		{
			if(i % 2 == 0)
			{
				EveSum = EveSum + i;
			}
			else
			{
				OddSum = OddSum + i;
			}
		}
		
		System.out.println("Sum Of Odd Numbers: " + OddSum);
		System.out.println("Sum Of Even Numbers: " + EveSum);
	}

}
