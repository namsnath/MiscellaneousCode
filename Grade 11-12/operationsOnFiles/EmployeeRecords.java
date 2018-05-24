package operationsOnFiles;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class EmployeeRecords
{

	public static void main(String[] args) throws Exception
	{
		Scanner s = new Scanner(System.in);
		FileWriter fw = new FileWriter("EmployeeRecords.txt", true);
		PrintWriter pw = new PrintWriter(fw);
		
		System.out.println("Enter Number of Employees");
		int n = s.nextInt();
		s.nextLine();
		
		String empCode[] = new String[n];
		String name[] = new String[n];
		int age[] = new int[n];
		double salary[] = new double[n];
		
		for(int i = 0; i < n; i++)
		{
			System.out.println("Enter name of employee #" + (i + 1) + (" (Name Surname):"));
			name[i] = s.nextLine();
			System.out.println("Enter Age");
			age[i] = s.nextInt();
			if(age[i] <= 0)
			{
				System.out.println("Invalid Age");
				System.exit(0);
			}
			System.out.println("Enter salary");
			salary[i] = s.nextDouble();
				if(salary[i] < 0)
				{
					System.out.println("Invalid Salary");
					System.exit(0);
				}
			String nameSplit[] = name[i].split(" ");
			empCode[i] = nameSplit[0].substring(0, 2) + nameSplit[1].substring(0, 2) + age.toString() + "";
			s.nextLine();
		}
		
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n - 1; j++)
				if(salary[j + 1] < salary[j])
				{
					String temp = name[j + 1];
					name[j + 1] = name[j];
					name[j] = temp;
					
					temp = empCode[j + 1];
					empCode[j + 1] = empCode[j];
					empCode[j] = temp;
					
					double temp2 = salary[j + 1];
					salary[j + 1] = salary[j];
					salary[j] = temp2;
					
					int temp3 = age[j + 1];
					age[j + 1] = age[j];
					age[j] = temp3;
				}
		
		for(int i = 0; i < n; i++)
		{
			pw.println(empCode[i]);
			pw.println(name[i]);
			pw.println(age[i]);
			pw.println(salary[i]);
		}
		
		fw.close();
		s.close();
	}

}
