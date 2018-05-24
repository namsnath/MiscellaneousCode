package wks1_Matrices;

import java.util.Scanner;

public class Wks1_Q8_SaddlePoint
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter order of Matrix");
		int n = s.nextInt();
		int i = 0, j = 0, x = 0;		
		
		int A[][] = new int[n][n];	//2-D array to store matrix
		
		System.out.println("Enter Elements of Array, Row-wise:");
		
		for(i = 0; i < n; i++)		//Loops to input data
		{
			for(j = 0; j < n; j++)
			{
				x = s.nextInt();
				if(x < 0) 
				{
					System.out.println("Please enter only positive Integers");
					System.exit(0);
				}
				A[i][j] = x;
			}
		}
		
		int max, min, f = 0;
	       for(i = 0; i < n; i++)		//Iterates through each row
	       {
	           min = A[i][0];			//Sets first element in the row as minimum
	           x = 0;
	           for(j = 0; j < n; j++)	//Iterates through each column of the given row
	           {
	                if(A[i][j] < min)	//If current element is smaller than minimum, sets element as minimum 
	                {
	                    min = A[i][j];
	                    x = j;
	                }
	           }
	             
	          
	           max = A[0][x]; 				//Sets first element in the column where minimum was found as maximum
	           for(i = 0; i < n; i++)		//Iterates through column
	           {
	                if(A[i][x] > max)		//if element is greater than max, sets new element as max
	                {
	                    max = A[i][x];
	                }
	           }
	             
	           if(max == min)				//If max and min are same, saddle point is found
	           {
	               System.out.println("Saddle point = " + max);
	               f = 1;					//raises flag
	           }
	        	   
	       }
	         
	       if(f == 0)						//If flag is not raised, saddle point does not exist
	       {
	           System.out.println("No saddle point");
	       }
	}

}
