import java.util.Scanner;
public class SimplifyingRoots
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter value inside root");
		int x = s.nextInt();
		
		double Prime = 0, Max, D = 2;
		int Input = x;
		Max = Input;
		
		StringBuffer AnsStrBuf = new StringBuffer("");
		
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
							AnsStrBuf.append((long)Prime + "x");
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
		
		String AnsStr;
		AnsStr = String.valueOf(AnsStrBuf);
		AnsStr = AnsStr.substring(0, (AnsStr.length() - 1));
		
		String[] factors = AnsStr.split("x");
		int num = 1;
		
		for(int j = 0 ; j < factors.length - 1;)
		{
			if(Integer.parseInt(factors[j]) == Integer.parseInt(factors[j + 1]))
			{
				int temp = Integer.parseInt(factors[j]);
				num = num * temp;
				
				if((j+2) < factors.length)
					j += 2;
				
			}
			else
			{
				if(j+1 < factors.length)
				j++;
			}
		}
		
		
		if(num != 1)
		System.out.println(num + "_/" + (x/(num*num)));
		else
			System.out.println("_/" + x);
	}

}
