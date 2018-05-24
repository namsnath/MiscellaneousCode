package operationsOnFiles;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class DATFileTry
{

	public static void main(String[] args) throws Exception
	{
		FileOutputStream fis = new FileOutputStream("ReverseIntegers.dat");
		DataOutputStream dis = new DataOutputStream(fis);
		Scanner s = new Scanner(System.in);
		
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
		
		for(int i = nums.length - 1; i >= 0 ; i--)
		{
			StringBuffer st = new StringBuffer(Integer.toString(nums[i]));
			st.reverse();
			dis.writeInt(Integer.parseInt(st.toString()));
		}
		fis.close();
		dis.close();
		
		
		FileInputStream fr = new FileInputStream("ReverseIntegers.dat");
		DataInputStream dr = new DataInputStream(fr);
		
		for(;;)
		{
			try
			{
				System.out.println(dr.readInt());
			}
			catch(EOFException e)
			{
				break;
			}
		}
		
		fr.close();
		dr.close();
		s.close();
	}

}
