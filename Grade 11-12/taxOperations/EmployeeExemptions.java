package taxOperations;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

//2 lakh - null, 5-lakh - 10%, 10 lakh - 20% , >10 lakh - 30%

public class EmployeeExemptions
{
	Scanner s = new Scanner(System.in);
	FileWriter fw;
	PrintWriter pw;

	int[] loan, insurance, empCode;
	int empCount;
	
	
	public void dataEntry(int empCodeNew) throws Exception
	{
		dataParse();
		
		
		fw = new FileWriter("Emp_Exemptions.txt", true);
		pw = new PrintWriter(fw);
		
		pw.print(empCodeNew + ",");
		
		System.out.println("Enter Loan Interest per year");
		int n = s.nextInt();
		pw.print(n + ",");
		System.out.println("Enter Insurance Amount per year");
		n = s.nextInt();
		pw.println(n);
		
		fw.close();
		pw.close();
	}
	
	public void dataParse() throws Exception
	{
		FileReader fr = new FileReader("Emp_Exemptions.txt");
		Scanner st = new Scanner(fr);
		StringTokenizer stt;
		empCount = 0;
		
		while(st.hasNextLine())
		{
			st.nextLine();
			empCount++;
		}
		
		empCode = new int[empCount];
		loan = new int[empCount];
		insurance = new int[empCount];
			
		fr.close();
		st.close();
		
		fr = new FileReader("Emp_Exemptions.txt");
		st = new Scanner(fr);
		
		for(int i = 0; i < empCount; i++)
		{
			stt = new StringTokenizer(st.nextLine(), ",");
			empCode[i] = Integer.parseInt(stt.nextToken());
			loan[i] = Integer.parseInt(stt.nextToken());
			insurance[i] = Integer.parseInt(stt.nextToken());
			
		}
		fr.close();
		st.close();
		
	}
	
	public void dataModify() throws Exception
	{
		dataParse();
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Employee Code of Employee to Modify Record for:");
		int key = s.nextInt(), position = 0;
		boolean exists = false;
		
		for(int i = 0; i < empCount; i++)
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
		
		System.out.println("Loan Interest per year: " + loan[position]);
		System.out.println("Insurance per year: " + insurance[position]);
		
		System.out.println("\n\nAre you sure you want to modify data for this employee? (1 = yes, any other number = no");
		int confirm = s.nextInt();
		
		if(confirm != 1)
			return;
		
		System.out.println("Enter new Loan Interest Amount: ");
		loan[position] = s.nextInt();
		System.out.println("Enter new Insurance Amount:");
		insurance[position] = s.nextInt();
		
		FileWriter fw = new FileWriter("Emp_Exemptions.txt");
		PrintWriter pw = new PrintWriter(fw);
		
		for(int i = 0; i < empCount; i++)
			pw.println(empCode[i] + "," + loan[i] + "," + insurance[i]);
		
		fw.close();
		pw.close();
	}
	
	public void dataDelete(int position) throws Exception
	{
		dataParse();
		
		FileWriter fw = new FileWriter("Emp_Exemptions.txt");
		PrintWriter pw = new PrintWriter(fw);
		
		for(int i = 0; i < empCount; i++)
		{
			if(i == position)
				continue;
			pw.println(empCode[i] + "," + loan[i] + "," + insurance[i]);
		}
		fw.close();
		pw.close();
	}
}
