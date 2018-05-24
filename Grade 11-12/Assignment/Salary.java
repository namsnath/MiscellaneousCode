/*
 * Data members : Name, Address, Phone, Subject Specialization, Annual Salary, Income Tax. 
Member methods: - to accept the details of a teacher including the Annual salary. 
- To display the details of the teacher 
- To compute the annual income tax as 5% of the annual salary above Rs. 175000 

Write a main method to create object of a class and call the above method.

 */
import java.util.Scanner;

public class Salary
{
	
	
	String Name, Add, Phone, SubSpec;
	double Sal, IT;
	
	public static void main(String[] args)
	{
		Salary sal = new Salary();
		
		sal.Details();
		sal.ITCalc();
		sal.Display();
	}

	public void Details()
	{
	
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Name:");
		Name = s.nextLine();
		
		System.out.println("Enter Address:");
		Add = s.nextLine();
		
		System.out.println("Enter Phone Number:");
		Phone = s.nextLine();
		
		System.out.println("What Subject Do You Specialize In?");
		SubSpec = s.nextLine();
		
		System.out.println("Enter Your Annual Salary:");
		Sal = s.nextDouble();
	}
	
	public void Display()
	{
		System.out.println("Your Annual Salary:" + Sal);
		
		System.out.println("Your Income Tax: " + IT);
	}
	
	public void ITCalc()
	{
		if(Sal >= 175000)
		{
			IT = 5 / 100 * (Sal - 175000);
		}
	}
}
