package isc_2010_Practical;

import java.util.Scanner;

public class Q1_DenominationDisplay
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		int denoms[] = {1000, 500, 100, 50, 20, 10, 5, 2, 1};
		String nums[] = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
		
		System.out.println("Enter amount:");
		int amt = s.nextInt();
		int count = 0;
		
		if(amt > 99999)
		{
			System.out.println("Input is > 5 digits. INVALID");
			System.exit(0);
		}
		
		for(int i = Integer.parseInt(new StringBuffer(Integer.toString(amt)).reverse().toString()); i > 0; i = i / 10)
			System.out.print(nums[i%10 ] + " ");
		
		System.out.println();
		
		System.out.println("DENOMINATION:/t");
		
		for(int i = 0; i < 9; i++)
		{
			if(amt / denoms[i] > 0)
				System.out.println(denoms[i] + " x " + (amt / denoms[i]) + " = " + (amt - (amt % denoms[i])));
			count += (amt / denoms[i]);
			amt = amt % denoms[i];
		}
		
		System.out.println("Number of Notes: " + count);
		
	}

}
