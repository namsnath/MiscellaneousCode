import java.util.Scanner;
public class ROunding
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		double a, b, c, Min;
		double rounded = 0;
		
		System.out.println("Enter 3 Decimal Number");
		a = s.nextDouble();
		b = s.nextDouble();
		c = s.nextDouble();
		
		if((a % 1) != 0)
			{
				a = (a * 1000);
				a = Math.round(a);
			}
		if((b % 1) != 0)
		{
			b = (b * 1000);
			b = Math.round(b);
		}
		if((c % 1) != 0)
		{
			c = (c * 1000);
			c = Math.round(c);
		}

		if (a < b && a < c)
		{
			Min = a;
		}
		else if(b < a && b < c)
			{
				Min = b;
			}
			else
			{
				Min = c;
			}
		
		double Prime = 1;
		double D = 2;
		
		while (Prime < Min)
		{
			Prime++;
			D = 2;
			
			while (D <= Prime)
			{
				if (D == Prime)
				{
					if(a % Prime == 0 && b % Prime == 0 && c % Prime == 0 )
					{
						while(a % Prime == 0 && b % Prime == 0 && c % Prime == 0 )
						{
							a /= Prime;
							b /= Prime;
							c /= Prime;
						}
					}
					break;
					
				}
				else if ((Prime % D) == 0)
					{
						break;
					}
					else
					{
						D++;
					}
			}
			
		}
		
		System.out.println("\n\nSimplified:");
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}

}
