import java.util.Scanner;
public class Arr_fill
{
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		int n, i, j, k;
		char c1, c2, c3;	//To store characters
		System.out.println("Enter order");
		n = s.nextInt();	//Input for order
		
		System.out.println("Enter 3 characters");
		c1 = s.next().charAt(0);
		c2 = s.next().charAt(0);
		c3 = s.next().charAt(0);
		char M[][] = new char[n][n];	//Array to fill
		
		for(i = 0, j = 0; i < n; i++, j++)	//Fills left diagonal
			M[i][j] = c3;
		for(i = (n - 1), j = 0; i >= 0; i--, j++)	//Fills Right Diagonal
			M[i][j] = c3;
		
		int limit;	//To store loop limit (half of order)
		
		if(n % 2 == 0)
			limit = (n / 2) - 1;
		else
			limit = n / 2;
		
		for(i = 0, j = 0; i < limit; i++, j++)	//To fill top part
			for(k = i + 1; k < n - 1 - i; k++)
				M[i][k] = c1;
		
		for(i = n - 1, j = 0; j < limit; i--, j++) //To fill bottom part
			for(k = j + 1; k < n - j - 1; k++)
				M[i][k] = c1;
		
		for(i = 0, j = 0; i < limit; i++, j++)	//To fill left part
			for(k = i + 1; k < n - 1 - i; k++)
				M[k][i] = c2;
		
		for(i = n - 1, j = 0; j < limit; i--, j++)	//To fill right part
			for(k = j + 1; k < n - j - 1; k++)
				M[k][i] = c2;
		
		for(i = 0; i < n; i++)	//To Print Array
		{
			for(j = 0; j < n; j++)
				System.out.print(M[i][j] + " ");
			System.out.println();
		}
	}
}