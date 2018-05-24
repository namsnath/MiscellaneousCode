package taxOperations;

import java.io.FileWriter;
import java.util.Scanner;

public class TaxInit		//Class to initialize critical Objects and Display menu to link other classes required
{
	
	public static void main(String[] args) throws Exception
	{
		FileWriter fw1, fw2, fw3;
		
		//Creating new files for data entry
		
		fw1 = new FileWriter("Emp_Details.txt", true);	//true prevents overwriting if file already exists
		fw2 = new FileWriter("Emp_Salary.txt", true);
		fw3 = new FileWriter("Emp_Exemptions.txt", true);
		
		fw1.close();
		fw2.close();
		fw3.close();
		
		Employee e = new Employee();
		EmployeeExemptions ee = new EmployeeExemptions();
		EmployeeSalary es = new EmployeeSalary();
		TaxInit t = new TaxInit();
		
		Scanner s = new Scanner(System.in);
		
		int choice;
		
		do
		{
			System.out.println("Enter Appropriate Choice. Enter Any Other Number To Exit:");
			System.out.println("1 - Employee Details (Adding, Modifying, Deleting Employee Records)");
			System.out.println("2 - Employee Salary (Modifying Existing Employees' Salary Data)");
			System.out.println("3 - Employee Exemptions (Modifying Existing Employees' Tax Exemption Data)");
			System.out.println("4 - Display All Employee Details");
			
			choice = s.nextInt();
			
			switch(choice)
			{
				case 1:	e.employeeMenu();
						break;
						
				case 2:	es.dataModify();
						break;
						
				case 3:	ee.dataModify();
						break;
						
				case 4:	t.displayAll();	
			}
			
		} while(choice > 0 && choice < 5);
		
		s.close();
	}
	
	public void displayAll() throws Exception		//Function to display all details of an employee
	{
		Employee e = new Employee();
		EmployeeExemptions ee = new EmployeeExemptions();
		EmployeeSalary es = new EmployeeSalary();
		
		e.dataParse();
		ee.dataParse();
		es.dataParse();
		
		System.out.println("Employee Code\tPAN Number\tTotal Salary\tTax Exemption\tTaxable Income\tTax");
		
		for(int i = 0; i < e.empCount; i++)
		{
			int exemption = ee.insurance[i] + ee.loan[i];		//total tax exemption
			int amt = es.totalSal[i] - exemption;				//total taxable income
			
			System.out.println(e.empCode[i] + "\t\t"  + e.PAN[i] + "\t\t" + es.totalSal[i] + "\t\t" + exemption + "\t\t" + amt + "\t\t" + calcTax(amt));
		}
		
	}

	/*
	 * Tax Parameters:
	 * Up to 2 Lakh = no tax
	 * 2-5 Lakh = 10% tax
	 * 5-10 Lakh = 20% tax
	 * >10 Lakh = 30% tax
	 */
	
	public double calcTax(int amt)		//Function to calculate tax based on parameters stated above
	{
		double tax;
		
		if(amt <= 200000)
			tax = 0;
		
		else if(amt <= 500000)
			tax = (amt - 200000) * 0.1;
		
		else if(amt <= 1000000)
			tax = 3000 + (amt - 500000) * 0.2;
		
		else
			tax = 13000 + (amt - 1000000) * 0.3;
		return tax;
	}
	
}
