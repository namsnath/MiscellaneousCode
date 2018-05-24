package operationsOnFiles;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class IntegerReversePrint
{

	public static void main(String[] args) throws Exception
	{
		Scanner s = new Scanner(System.in);
		
		FileWriter fw = new FileWriter("ReverseIntegers.txt");
		PrintWriter pw = new PrintWriter(fw);
		
		int[] nums = new int[10];
		int n;
		
		System.out.println("Enter 10 three digit numbers");
		for(int i = 0 ; i < 10; i++)
		{
			n = s.nextInt();
			if(n < 100 || n > 999)
			{
				System.out.println("Invalid Input");
				System.exit(0);
			}
			
			nums[i] = n;
		}
		
		for(int i = 0; i < 10; i++)
			pw.println(nums[i]);
		pw.close();
		fw.close();
	
		FileReader fr = new FileReader("ReverseIntegers.txt");
		Scanner s2 = new Scanner(fr);
		int i = 0;
		
		while(s2.hasNextLine())
		{
			nums[i] = Integer.parseInt(s2.nextLine());
			i++;
		}
		
		s.close();
		fr.close();
		s2.close();
		
		fw = new FileWriter("ReverseIntegers.txt");
		pw = new PrintWriter(fw);
		
		for(i = nums.length - 1; i >= 0 ; i--)
		{
			StringBuffer st = new StringBuffer(Integer.toString(nums[i]));
			st.reverse();
			pw.println(st.toString());
		}
		
		fw.close();
		pw.close();
	}

}
