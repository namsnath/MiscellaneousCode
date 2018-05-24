import java.util.Scanner;

public class DeterminantSolver
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter Order of Determinant");
		int n = s.nextInt();		//Takes input for order of the Determinant
		
		if(n <= 0)					//Checks validity of input
		{
			System.out.println("Invalid Size. Program will Exit");
			System.exit(0);
		}
		
		int[][] det = new int[n][n];	//Declares a determinant of given order
		
		System.out.println("Enter Elements, row-wise");	//Loop for entry of data into array
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				det[i][j] = s.nextInt();
		
		/*	
	  	Sample Determinant. Ans = -52	
		int[][] det = {{1, 2, 3, 4},
						{2, 3, 4, 5},
						{5, 7, 2, 9},
						{4, 8, 3, 6}};
	 	*/
		
		DeterminantSolver d = new DeterminantSolver();	//Object of same class
		int sol = d.Solve(det);		//Passes determinant into recursive function Solve(int[][] det)
		
		System.out.println("\n\n Solution: " + sol);	
	}

	public int Solve(int[][] det)
	{
		int rows = det.length;		//Parses number of rows
		if(rows == 1)				//Returns sole element if order is 1
			return det[0][0];
		int cols = rows;
		
		int val = 0;	//To store value of row in consideration
		
		for(int a = 0; a < cols; a++)	//Runs a loop iterating through the columns
		{
			int[][] newDet = new int[rows - 1][cols - 1];	//Declares a new determinant of order one less than original passed into function
			
			for(int i = 1; i < rows; i++)	//Runs loop through the rows
			{		
				for(int j = 0; j < cols; j++)	//Runs loop through the columns
				{	
					if(j < a)					//Skips the row and column in consideration in first loop
						newDet[i - 1][j] = det[i][j];
					if(j > a)
						newDet[i - 1][j - 1] = det[i][j];
				}
			}
			val += det[0][a] * ((int) (Math.pow(-1, a)) * Solve(newDet));		//Adds the value of current element to val
		}
		return val;		//Returns value of determinant
	}
	
}
