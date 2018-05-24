package taxOperations;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Employee
{
	Scanner s = new Scanner(System.in);
	FileWriter fw;
	PrintWriter pw;
	
	int[] PAN, empCode;
	int empCount;
	
	public void dataEntry() throws Exception		//Function to enter new records
	{
		dataParse();
		
		EmployeeSalary es = new EmployeeSalary();
		
		System.out.println("Enter PAN Number (5 numeric digits):");
		int n = s.nextInt();
		if(Integer.toString(n).length() != 5)		//Validates PAN number input
		{
			System.out.println("Invalid PAN Number. Function will now exit");
			return;
		}
		pw.print(n);
		
		int code = 0;
		
		if(empCount != 0)						//Assigns generated code, 100 if no records exist, else next in order
			code = empCode[empCount - 1] + 1;
		else
			code = 100;
		
		pw.println("," + code);
		
		es.dataEntry(code);						//Calls Data entry function for Salary
	}
	
	public void dataParse() throws Exception		//Parses data from file
	{
		FileReader fr = new FileReader("Emp_Details.txt");
		Scanner st = new Scanner(fr);
		StringTokenizer stt;
		empCount = 0;
		
		while(st.hasNextLine())					//Counts number of lines and employees
		{
			st.nextLine();
			empCount++;
		}
		
		PAN = new int[empCount];
		empCode = new int[empCount];
			
		fr.close();
		st.close();
		
		fr = new FileReader("Emp_Details.txt");
		st = new Scanner(fr);
		
		//Reading data from file to arrays
		
		for(int i = 0; i < empCount; i++)
		{
			stt = new StringTokenizer(st.nextLine(), ",");
			empCode[i] = Integer.parseInt(stt.nextToken());
			PAN[i] = Integer.parseInt(stt.nextToken());
		}
		fr.close();
		st.close();
		
		
	}
	
	public void recordDelete() throws Exception		//Function to delete records
	{
		dataParse();
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Employee Code of Employee to Delete Record for:");
		int key = s.nextInt(), position = 0;
		boolean exists = false;
		
		for(int i = 0; i < empCount; i++)		//Checks if record exists
			if(empCode[i] == key)
			{
				exists = true;
				position = i;
			}
				
		if(exists ==  false)
		{
			System.out.println("Record Does Not Exist");
			return;
		}
		
		
		FileWriter fw = new FileWriter("Emp_Details.txt");
		PrintWriter pw = new PrintWriter(fw);
		
		for(int i = 0; i < empCount; i++)		//Prints records to file excluding record to delete
		{
			if(i == position)
				continue;
			
			pw.print(empCode[i] + ",");
			pw.println(PAN[i]);
		}
		
		fw.close();
		pw.close();
		
		//Calling delete functions for the same record in other files
		
		EmployeeSalary es = new EmployeeSalary();		
		es.dataDelete(position);
		
		EmployeeExemptions ee = new EmployeeExemptions();
		ee.dataDelete(position);
		
	}
	
	public void recordModify() throws Exception		//Function to modify records
	{
		dataParse();
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Employee Code of Employee to Modify Record for:");
		int key = s.nextInt(), position = 0;
		boolean exists = false;
		
		for(int i = 0; i < empCount; i++)			//Checks if record exists
			if(empCode[i] == key)
			{
				exists = true;
				position = i;
			}
				
		if(exists ==  false)
		{
			System.out.println("Record Does Not Exist");
			return;
		}
		
		System.out.println("\n\n");
		System.out.println("Pan Number: " + PAN[position]);
		
		System.out.println("Are you sure you want to modify data for this employee? (1 = yes, any other number = no");
		int confirm = s.nextInt();
		
		if(confirm != 1)
			return;
		
		System.out.println("Enter New PAN Number:");
		int n = s.nextInt();
		
		if(Integer.toString(n).length() != 5)		//Validates PAN Number input
		{
			System.out.println("Invalid PAN Number. Function will now exit");
			return;
		}
		PAN[position] = n;
		
		FileWriter fw = new FileWriter("Emp_Details.txt");
		PrintWriter pw = new PrintWriter(fw);
		
		//Printing records to file including modified record
		
		for(int i = 0; i < empCount; i++)
		{
			pw.print(empCode[i] + ",");
			pw.println(PAN[i]);
		}
		
		fw.close();
		pw.close();
		
	}
	
	public void employeeMenu() throws Exception		//Main Menu
	{
			
		int choice;
		
		do
		{
			fw = new FileWriter("Emp_Details.txt", true);		//Creates file. True makes sure file is not overwritten
			pw = new PrintWriter(fw);
			
			System.out.println("Enter the Appropriate choice. Any other number will take you back to the main menu:");
			System.out.println("1 - Add Records");
			System.out.println("2 - Delete Records");
			System.out.println("3 - Modify Records");
			
			choice = s.nextInt();
			
			switch(choice)
			{
				case 1:	dataEntry();
						break;
						
				case 2:	recordDelete();
						break;
						
				case 3:	recordModify();
						break;
			}
			
			pw.close();
			fw.close();
		} while(choice > 0 && choice < 4);	
		
		pw.close();
		
	}
}
