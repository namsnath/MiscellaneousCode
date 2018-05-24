package programmingAssignment;

import java.util.Arrays;
import java.util.Scanner;

public class Q5_ArrayEquality
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		Q5_ArrayEquality Ae = new Q5_ArrayEquality();
		
		int[] a, b;
		System.out.println("Enter Sizes of both arrays");
		a = new int[s.nextInt()];
		b = new int[s.nextInt()];
		
		
		System.out.println("Enter Elements of Array A");
		for(int i = 0; i < a.length; i++)
			a[i] = s.nextInt();
		
		System.out.println("\n\nEnter Elements of Array B");
		for(int i = 0; i < b.length; i++)
			b[i] = s.nextInt();
		
		System.out.println("Using Arrays.Equals(): " + Ae.ArrEq(a, b));
		System.out.println("Using Loops: " + Ae.ArrLoop(a, b));
		System.out.println("Using String/StringBuffer: " + Ae.ArrStr(a, b));
		
		s.close();
	}
	
	public boolean ArrEq(int[] a, int[] b)		//Function to check array equality using Arrays.equals(int[] a, int[] b) function
	{
		return Arrays.equals(a, b);
	}
	
	public boolean ArrLoop(int[] a, int[] b) 	//Function to check array equality by looping
	{
		if(a.length != b.length)				//checks equality of lengths of arrays
			return false;
		for(int i = 0; i < a.length; i++)		//loop to iterate through arrays
			if(a[i] != b[i])					//checks equality of each element of array
				return false;
		return true;
	}
	
	public boolean ArrStr(int[] a, int[] b) 	//Function to check array equality using Strings
	{
		if(a.length != b.length)				//checks equality of lengths of arrays
			return false;
		StringBuffer sta = new StringBuffer();	//StringBuffer for array a
		StringBuffer stb = new StringBuffer();	//StringBuffer for array b
		
		for(int i = 0; i < a.length; i++)		//iterates through the arrays
		{
			sta.append(a[i]);					//appends a[i] to sta
			stb.append(b[i]);					//appends b[i] to stb
		}
		
		return sta.toString().equals(stb.toString());	//checks for equality of both strings
	}

}
