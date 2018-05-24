package wks2_Strings;

import java.util.Scanner;

public class wks2_Q2_RemoveDuplicates
{

	@SuppressWarnings("resource")
	public static void main(String[] args)
	{
		System.out.println("Enter Word");
		char orig[] = new Scanner(System.in).next().toCharArray();
		int i, j, k = 1;
		char op[] = new char[orig.length];
		
		op[0] = orig[0];
		
		for(i = 1; i < orig.length; i++)
		{
			int flag = 0;
			for(j = 0; j < op.length; j++)
			{
				if(orig[i] == op[j])
				{
					flag = 1;
					break;
				}
			}
			if(flag == 0)
			{
				op[k] = orig[i];
				k++;
			}
		}
		
		System.out.println("\n\nOriginal Word:");
		
		for(i = 0; i < orig.length; i++)
			System.out.print(orig[i]);
		
		System.out.println("\nNew word:");
		
		for(i = 0; i < op.length; i++)
			System.out.print(op[i]);
	}

}
