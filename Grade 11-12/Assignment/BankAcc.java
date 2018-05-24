import java.util.Scanner;

public class BankAcc
{
		String Name;
		String Acc_Type;
		long Acc_Num;
		double Balance;
		double Acc_Deposit;
		double Acc_Withdraw;
		
	
	public BankAcc(String name, String type, long num, double bal)
	{
		Name = name;
		Acc_Type = type;
		Acc_Num = num;
		Balance = bal;		
	}

	
	public void deposit()
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter The amount you want to deposit:");
		Acc_Deposit = s.nextDouble();
		
		Balance += Acc_Deposit;
	}
	
	public void withdraw()
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Your Balance: " + Balance);
		
		System.out.println("Enter The amount you want to withdraw:");
		Acc_Withdraw = s.nextDouble();
		
		Balance -= Acc_Withdraw;
	}
	
	public void display()
	{
		System.out.println("\n\n" + Name);
		System.out.println("Your Balance: " + Balance);
	}
	
	public static void main(String[] args)
	{
		Scanner s = new Scanner (System.in);
		
		System.out.println("Enter your name:");
		String TempName = s.nextLine();
	
		System.out.println("Enter your Account Type (Current, Recurring)");
		String TempAcc_Type = s.nextLine();
		
		System.out.println("Enter Your Account Number:");
		long TempAcc_Num = s.nextLong();
		
		System.out.println("Enter Your Balance:");
		double TempBalance = s.nextDouble();
		
		BankAcc Customer1 = new BankAcc(TempName, TempAcc_Type, TempAcc_Num, TempBalance);
		Customer1.deposit();
		Customer1.withdraw();
		Customer1.display();
		
		
	}

}
