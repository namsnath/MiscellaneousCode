package taxOperations;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class EmployeeSalary
{
	
	Scanner s = new Scanner(System.in);
	FileWriter fw;
	PrintWriter pw;

	
	String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	int[][] salary;
	int[] empCode, totalSal;
	int empCount;
	
	public void dataEntry(int empCodeNew) throws Exception		//Function to enter data, Employee Code is passed as argument from Employee's dataEntry function
	{
		dataParse();
		fw = new FileWriter("Emp_Salary.txt", true);
		pw = new PrintWriter(fw);
		
		
		pw.print(empCodeNew + ",");
		
		for(int i = 0; i < 11; i++)					//Takes input of salaray for each month and prints to file
		{
			System.out.println("Enter Salary for " + months[i]);
			int n = s.nextInt();
			
			pw.print(n + ",");
		}
		
		System.out.println("Enter Salary for December");
		int n = s.nextInt();
		
		pw.println(n);
		
		EmployeeExemptions ee = new EmployeeExemptions();		//Calls dataEntry method for exemptions, passing Employee Code as argument
		ee.dataEntry(empCodeNew);
	
		fw.close();
		pw.close();
	}
	
	public void dataParse() throws Exception		//Function to parse data from file
	{
		FileReader fr = new FileReader("Emp_Salary.txt");
		Scanner st = new Scanner(fr);
		StringTokenizer stt;
		empCount = 0;
		
		while(st.hasNextLine())				//Counts lines and employees in file
		{
			st.nextLine();
			empCount++;
		}
		
		empCode = new int[empCount];
		salary = new int[empCount][12];
		totalSal = new int[empCount];
			
		fr.close();
		st.close();
		
		fr = new FileReader("Emp_Salary.txt");
		st = new Scanner(fr);
		
		for(int i = 0; i < empCount; i++)			//Parses data from file to arrays
		{
			stt = new StringTokenizer(st.nextLine(), ",");
			empCode[i] = Integer.parseInt(stt.nextToken());
			
			for(int j = 0; j < 12; j++)
				salary[i][j] = Integer.parseInt(stt.nextToken());
		}
		
		for(int i = 0; i < empCount; i++)			//Calculates total salary
			for(int j = 0; j < 12; j++)
				totalSal[i] += salary[i][j];
		
		fr.close();
		st.close();
		
		
		
	}
	
	public void dataModify() throws Exception		//Function to modify records
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
		
		System.out.println("\n\nSalary:");
		for(int i = 0; i < 12; i++)
			System.out.println(months[i] + ": " + salary[position][i]);
		
		System.out.println("\n\nAre you sure you want to modify data for this employee? (1 = yes, any other number = no");
		int confirm = s.nextInt();
		
		if(confirm != 1)
			return;
		
		for(int i = 0; i < 11; i++)
		{
			System.out.println("Enter Salary for " + months[i]);
			int n = s.nextInt();
			
			salary[position][i] = n;
		}
		
		System.out.println("Enter Salary for December");
		int n = s.nextInt();
		
		salary[position][11] = n;
		
		FileWriter fw = new FileWriter("Emp_Salary.txt");
		PrintWriter pw = new PrintWriter(fw);
		
		for(int i = 0; i < empCount; i++)			//Prints data to file
		{
			pw.print(empCode[i] + ",");
			for(int j = 0; j < 11; j++)
				pw.print(salary[i][j] + ",");
			pw.print(salary[i][12]);
		}
		
		fw.close();
		pw.close();
	}
	
	public void dataDelete(int position) throws Exception		//Function to delete data
	{
		dataParse();
		
		FileWriter fw = new FileWriter("Emp_Salary.txt");
		PrintWriter pw = new PrintWriter(fw);
		
		for(int i = 0; i < empCount; i++)		//Prints data other than that for index passed in argument from Employee class
		{
			if(i == position)
				continue;
			
			pw.print(empCode[i] + ",");
			for(int j = 0; j < 11; j++)
				pw.print(salary[i][j] + ",");
			pw.print(salary[i][11]);
		}
		
		fw.close();
		pw.close();
	}
	
}
