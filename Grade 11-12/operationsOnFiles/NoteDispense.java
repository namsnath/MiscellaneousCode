package operationsOnFiles;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class NoteDispense
{

	int[] denominations = {1000, 500, 100, 50, 20, 10, 5, 2, 1};	//Array for denominations
	
	public static void main(String[] args) throws Exception
	{
		Scanner s = new Scanner(System.in);
		NoteDispense nd = new NoteDispense();
		
		FileOutputStream fis = new FileOutputStream("NoteDispense.dat");		//Creates a .dat file to write to
		DataOutputStream dis = new DataOutputStream(fis);						//Passes object to D.O.S. to allow writing to the file
	
		int[] nums = new int[10];		//Array to store 10 Numbers to parse
		
		System.out.println("Enter 10 Amounts");
		for(int i = 0 ; i < 10; i++)		//Loop to input numbers into array
		{
			int n = s.nextInt();
			if(n < 0)						//Checks validity of input
			{
				System.out.println("Invalid Input");
				System.exit(0);
			}
			nums[i] = n;
		}
		
		for(int i = 0; i < 10; i++)			//Writes the numbers to the file
			dis.writeInt(nums[i]);
		
		fis.close();
		dis.close();			//fis, dis closed to save file
		s.close();
		
		FileInputStream fr = new FileInputStream("NoteDispense.dat");		//Input stream Objects declared for reading from the file
		DataInputStream dr = new DataInputStream(fr);
		
		for(;;)
		{
			try
			{
				nd.dispense(dr.readInt());			//reads numbers from the file and passes them to the dispense() function
			}
			catch(Exception e)						//Catches EndOfFile Exception and breaks the loop
			{
				break;
			}
		}
		
		dr.close();
		fr.close();
	}

	
	public void dispense(int n)		//Function to dispense notes
	{
		int x = n;		//Saves the value in a varible
		
		int[] noteNumber = new int[denominations.length];		//Array to store number of notes
		for(int i = 0; i < noteNumber.length; i++)				//Loop to initialize the new array
			noteNumber[i] = 0;
		
		for(int i = 0; i < 9; i++)		//Loop to iterate and calculate number of notes for each denomination
		{
			noteNumber[i] += (n / denominations[i]);		//Adds integral multiples of the current denomination to the number
			n = n % denominations[i];	//Sets value to remainder
		}
		
		System.out.println("Amount: " + x);
		for(int i = 0; i < noteNumber.length; i++)		//Prints Amount and the denominations
		{
			System.out.println(denominations[i] + ": " + noteNumber[i] + " notes");
		}
		
		System.out.println("\n\n");
	}
}
