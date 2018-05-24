package wks2_Strings;

import java.util.Scanner;

public class Wks2_Q3_FiboString
{

		Scanner s = new Scanner(System.in);
		
		String x, y, z;
		int n;
		
		Wks2_Q3_FiboString()
		{
			x = "a";
			y = "b";
			z = "ba";
		}
		
		void accept()
		{
			System.out.println("Enter the number of terms to be printed.");
			n = s.nextInt();
		}
		
		void generate()
		{
			System.out.println(" " + x + "\n " + y);
					
			for(int m = 0;m < (n - 2);m++)
			{
				z = y + x;
				System.out.println(" " + z);
				x = y;
				y = z;
			}
		}
		
		public static void main(String[] args)
		{
			Wks2_Q3_FiboString FS = new Wks2_Q3_FiboString();
			
			FS.accept();
			FS.generate();
		}
	

}
