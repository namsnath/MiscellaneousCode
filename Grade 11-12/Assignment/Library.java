import java.util.Scanner;

public class Library
{

	int Acc_Num;
	String Title;
	String Author;

	public void input()
	{
		Scanner s = new Scanner (System.in);
		
		System.out.println("Enter Your Accession Number");
		Acc_Num = s.nextInt();
		s.nextLine();
		
		System.out.println("Enter The Title Of The Book");
		Title = s.nextLine();
		
		System.out.println("Enter The Author Of The Book");
		Author = s.next();
	}
	
	public void compute()
	{
		Scanner s = new Scanner (System.in);
		
		System.out.println("Enter Number Of Days Late");
		int Day_Late = s.nextInt();
		
		int Fine = 2 * Day_Late;
		
		System.out.println("Fine: " + Fine);
	}
	
	public void display()
	{
		System.out.println("Accession Number\t\tTitle\t\tAuthor");
		System.out.println(Acc_Num + "\t\t" + Title + "\t\t" + Author);
	}
	
	public static void main(String[] args)
	{
		Library Mem1 = new Library();
		Mem1.input();
		Mem1.compute();
		Mem1.display();

	}

}
