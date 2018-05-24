import java.util.Scanner;

public class SieveOfErasthosenes
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);		//Creates Object of Scanner
		
		System.out.println("Enter limit:");
		int maxNum = s.nextInt(), count = 0;
		
		if(maxNum <= 0)
		{
			System.out.println("Entered range is invalid");
			System.exit(0);
		}
		
		boolean[] primes = new boolean[maxNum];			//Creates boolean array to implement the sieve
		for(int i = 0; i < maxNum; i++)					//Sets all values in array to true
			primes[i] = true;
		
		primes[0] = false;							//Sets 1 to false
		
		for(int i = 1; i < maxNum; i++)					//Loop to iterate through array
			if(primes[i] && isPrime(i + 1))			//Checks if current element is true and is a prime
				for(int j = 2 * (i + 1); j <= maxNum; j += (i + 1))	//Sets all multiples of the current prime element to false
					primes[j - 1] = false;
		
		for(int i = 0; i < maxNum; i++)		//Loop to iterate through the array
			if(primes[i])		//Prints the elemnt if it is prime
			{
				System.out.print((i + 1) + "  ");
				count++;
			}
			
		System.out.println("\n" + count + " primes");		//Prints count of primes
	}
	
	public static boolean isPrime(int n)		//Function to check if a given number is Prime
	{
		if(n == 0 || n == 1)
			return false;
		if(n == 2)
			return true;
		if(n % 2 == 0)
			return false;
		for(int i = 3; i * i <= n; i += 2)
			if(n % i == 0)
				return false;
		return true;
	}

}
