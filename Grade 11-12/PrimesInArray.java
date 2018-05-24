import java.util.Scanner;

public class PrimesInArray
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter Number of Rows");			//Take input for number of rows
		int m = s.nextInt();
		
		
		System.out.println("Enter Number of Columns");		//Take input for number of columns
		int n = s.nextInt();
		
		int[][] A = new int[m][n];							//Declare array of size of input values
		
		int i, j, k = 2;
		int[] primes = new int[m * n];						//Declare array of size m * n
		
		for(i = 0; i < m * n; k++)							//Run through numbers more than 2
		{
			if(checkPrime(k))								//Check if current number is prime
			{
				primes[i] = k;
				i++;										//Increment counter if number is prime
			}
		}
		
		k = 0;
		
		for(i = 0; i < m; i++)								//Write primes to 2-D array
			for(j = 0; j < n; j++)
				{
					A[i][j] = primes[k];
					k++;
				}
		
		System.out.println("Your Prime Array");
		
		//Print Array
		
		for(i = 0; i < m; i++)
		{
			for(j = 0; j < n; j++)
				System.out.print(A[i][j] + "\t");
			
			System.out.println();
		}
		
	}
	
	public static boolean checkPrime(int n)		//Function to check Primes
	{
		if(n == 2)
			return true;
		if (n % 2 == 0) 
			return false;
	    for(int i = 3; i * i <= n; i += 2) 
	        if(n % i == 0)
	            return false;
	    
	    return true;
	}

}
