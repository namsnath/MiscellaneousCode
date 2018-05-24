
public class trial
{

	public static void main(String[] args)
	{
		int squareArray[][] = {{1, 2, 4, 5, 6, 8, 9}, {1,2,3,4,5,6,7}};
		
		for(int numbers[] : squareArray)
			for(int x : numbers)
				System.out.println(x);
	}

}
