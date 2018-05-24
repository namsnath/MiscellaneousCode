package programmingAssignment;

import java.util.Scanner;

public class Q28_MatrixInSpiral
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter No of Rows");
		int rows = s.nextInt();						//To store number of rows
		System.out.println("Enter No of Columns");
		int cols = s.nextInt();						//To store number of columns
		
		int[][] a = new int[rows][cols];			//new int array of size rows*columns
		
		String direction = "right";					//Direction to run loop in
		int up_limit = 0, down_limit = rows - 1, left_limit = 0, right_limit = cols - 1, elements = rows * cols; //Limits of each direction and total number of elements
		
		System.out.println("Enter data row-wise");
		for(int i = 0; i < rows; i++)				//Loop to input data
			for(int j = 0; j < cols; j++)
				a[i][j] = s.nextInt();
		
		System.out.println("Original 2D Array - ");
		for(int i = 0; i < rows; i++)				//Loop to print data
		{
			for(int j = 0; j < cols; j++)
				System.out.print(a[i][j] + "\t");
			
			System.out.println();
		}
		
		System.out.println("2D Array in Spiral Form - ");
		
		for(int i = 0, j = 0; elements > 0; elements--)		//Runs loop from number of elements to 0 and row number(i) and column number(j)
		{
			System.out.print(a[i][j] + " ");				//Prints element at index (i, j)
			
			if(direction.equals("right"))					//For checking if current direction is 'right'
			{
				if(++j > right_limit)						//checks if j + 1 > limit of right
	            {
	                --j;
	                direction = "down";						//direction changed to 'down'
	                ++up_limit;								//upper limit increased
	                ++i;									//row number increased
	            }
			}
			else if(direction.equals("down")) 				//For checking if current direction is 'down'
			{
				if(++i > down_limit)						//checks if i + 1 > limit of down
	            {
	                --i;
	                direction = "left";						//direction changed to 'left'
	                --right_limit;							//right limit decreased
	                --j;									//column number decreased
	            }
			}
			else if(direction.equals("left"))				//For checking if current direction is 'left'
			{
				if(--j < left_limit)						//checks if j - 1 < limit of left
	            {
	                ++j;
	                direction = "up";						//direction changed to 'up'
	                --down_limit;							//down limit decreased
	                --i;									//row number decreased
	            }
			}
			else if(direction.equals("up"))					//For checking if current direction is 'up'
			{
				if(--i < up_limit)							//checks if i - 1 < limit of up
	            {
	                ++i;
	                direction = "right";					//direction changed to 'right'
	                ++left_limit;							//left limit increased
	                ++j;									//column number increased
	            }
			}
		}
		
		s.close();
	}

}
