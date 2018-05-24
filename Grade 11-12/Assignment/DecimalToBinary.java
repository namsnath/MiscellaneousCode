import java.util.Scanner;


public class DecimalToBinary
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter Number to convert");
		int number = s.nextInt();
		
		String x;
		
		x = Integer.toBinaryString(number);
		
		StringBuffer str = new StringBuffer(x);

		int mod = 4 - (str.length() % 4);
		str.reverse();
		
		if(mod > 0) 
		{
			for(int i = 0; i < mod; i++)
			{
				str.append("0");
			}
		}
		str.reverse();
		
		int idx = str.length() - 4;
		
		while (idx > 0)
		{
		    str.insert(idx, " ");
		    idx = idx - 4;
		}
		
		System.out.println(str);
	}

}
