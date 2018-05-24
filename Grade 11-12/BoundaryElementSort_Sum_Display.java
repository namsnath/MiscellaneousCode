import java.util.Scanner;
public class BoundaryElementSort_Sum_Display
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter dimensions of the Array: row and column");
		int m = s.nextInt(), n = s.nextInt(), a[][] = new int[m][n], i, j;	//Input of Array dimensions and declaration of array
		
		System.out.println("Enter data row-wise:");
		for(i = 0; i < m; i++)
			for(j = 0; j < n; j++)
				a[i][j] = s.nextInt();	//To Store user inputs
		
		System.out.println("The Input Array: ");
		for(i = 0; i < m; i++)
		{
			for(j = 0; j < n; j++)
				System.out.print(a[i][j] + "\t");	//Displaying User Input array
			System.out.println();
		}
		
		
		int bounds[] = new int[2*(n + m -2)];
		
		for(i = 0, j = 0; i < n; i++, j++)		//Storing elements from row 0
			bounds[j] = a[0][i];	
		for(i = 1; i < m - 1; i++, j++)			//Storing elements of column (n - 1), from row 1 to row (m-2)
			bounds[j] = a[i][n - 1];
		for(i = n - 1; i >= 0; i--, j++)		//Storing Elements of row (m - 1), from Columns (n - 2) to 1
			bounds[j] = a[m - 1][i];
		for(i = m - 2; i >= 1; i--, j++)		//Storing Elements of Column 0, from rows (m - 2) to 1
			bounds[j] = a[i][0];
		
		for(i = 0; i < bounds.length; i++)			//Sorting the array of boundary elements
			for(j = 0; j < bounds.length - 1; j++)
				if(bounds[j] > bounds[j+ 1])
				{
					int temp = bounds[j];
					bounds[j] = bounds[j + 1];
					bounds[j + 1] = temp;
				}
		
		for(i = 0, j = 0; i < n; i++, j++) 		//Filling elements in row 0
			a[0][i] = bounds[j];
		for(i = 1; i < m - 1; i++, j++) 		//Filling elements in column (n - 1), from row 1 to row (m-2)
			a[i][n - 1] = bounds[j];
		for(i = n - 1; i >= 0; i--, j++) 		//Filling Elements in row (m - 1), from Columns (n - 2) to 1
			a[m - 1][i] = bounds[j];
		for(i = m - 2; i >= 1; i--, j++) 		//Filling Elements in Column 0, from rows (m - 2) to 1
			a[i][0] = bounds[j];
		
		System.out.println("Rearranged Matrix:");
		for(i = 0; i < m; i++)
		{
			for(j = 0; j < n; j++)
				System.out.print(a[i][j] + "\t");		//Printing the Rearranged Array
			System.out.println();
		}
		
		
		System.out.println("Only Boundary Elements: ");
		for(i = 0; i < m ; i++)					//Displaying only boundary elements
		{
			for(j = 0; j < n; j++)
			{
				if(i > 0 && i < m - 1 && j > 0 && j < n - 1)
					System.out.print("\t");
				else
					System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}
		
		int sum = 0;
		for(i = 0; i < bounds.length; i++)		//Calculating sum of boundary elements
			sum += bounds[i];
		
		System.out.println("Sum Of Boundary Elements = " + sum);
	}
	

}
