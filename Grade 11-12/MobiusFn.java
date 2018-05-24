import java.util.Scanner;
public class MobiusFn
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);	//To take user input
		MobiusFn f = new MobiusFn();	//Class Object
		
		System.out.println("Enter number to check:");
		int n = s.nextInt();	//Number to check
		s.close();
		
		System.out.println(f.primeFac(n));	//Prints value of M(n)
	}
	
	int primeFac(int n)	//Function to Factorize the number
	{
		int primeCount = 0;	//Number of Prime Factors
		
		if(checkPrime(n))	//Checks if the number is prime (has only 1 prime factor)
			return -1;
		
		for(int i = 2; i < n; i++)	//Loops through numbers till n to check for factors contained more than once
		{	
			if(checkPrime(i))	//Checks if the number is a prime
			{
				if(n % (i * i) == 0)	//factor present more than once
					return 0;
				if(n % i == 0)	//Factor present only once
					primeCount++;
			}	
		}
		
		return (int) Math.pow(-1, primeCount);	//returns (-1)^p
	}
	
	boolean checkPrime(int num)	//Function to check if number is prime
	{
		if(num == 1 || num == 0)
			return false;
		if(num == 2)
			return true;
		if(num % 2 == 0)
			return false;
		
		for(int i = 3; i * i < num; i += 2)
			if(num % i == 0)
				return false;
		
		return true;
	}

}
