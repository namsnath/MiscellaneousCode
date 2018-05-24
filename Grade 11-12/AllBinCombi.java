import java.util.Scanner;
public class AllBinCombi
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a number");
		int n = s.nextInt(), i, j, k, l, m, count;
		
		StringBuffer st[] = new StringBuffer[(int) Math.pow(2, n)];
		
		for(i = 0; i < Math.pow(2, n); i++)
			st[i] = new StringBuffer("");
		
		for(i = 0, m = 0; i < n; i++)
			for(j = n; j > 0; j--)
				for(k = 0; k < Math.pow(2, j); k++)
					for(l = 0; l < Math.pow(2, n - j) && m < n; l++, m++)
					{
						if(k % 2 == 0)
							st[m].append("0");
						else
							st[m].append("1");
					}	
		
		
		
		//for(i = n - 1, l = 0; i >= 0; i--, l++)
			
		
		
		for(i = 0; i < n; i++)
			System.out.println(st[i]);
	}

}
