import java.util.Scanner;
class Factorizer
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		
		int Input;
		double Prime = 0, Max, D = 2;
		
		System.out.println("Enter Number to find factors of:");
		Input = s.nextInt();
		Max = Input;
		
		StringBuffer str = new StringBuffer("");
		String st;
		
		System.out.println("\n\nFactors:\n");
		//System.out.println("1");
		
		while (Prime <= Max)
		{
			Prime++;
			D = 2;
			
			while (D <= Prime)
			{
				if (D == Prime)
				{
					if(Input % Prime == 0)
					{
						while(Input % Prime == 0)
						{
							Input /= Prime;
							//System.out.println(Long.valueOf((long)Prime));
							str.append((long)Prime + "x");
							//System.out.println(str);
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
		
		st = String.valueOf(str);
		
		st = st.substring(0, (str.length() - 1));
		System.out.println(st);
		
	}
}