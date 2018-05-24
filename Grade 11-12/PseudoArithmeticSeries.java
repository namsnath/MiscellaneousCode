public class PseudoArithmeticSeries
{

	public static void main(String[] args)
	{
		int[] A = {2, 5, 7, 9, 12};	//Sample Data
		
		int sum = A[0] + A[A.length - 1];
		boolean flag = true;
		
		
		for(int i = 0, j = A.length - 1; i <= j; i++, j--)	//Checks oposite elements and sums them
			if((A[i] + A[j]) != sum)	//If sums don't match
				flag = false;
		
		int num = (A.length % 2 == 0) ? A.length / 2 : (A.length + 1) / 2;	//Stores number of elements in half the list for calculating sum
		
		if(flag)
			System.out.println("It is a Pseudo Arithmetic Series \nCommon sum is " + sum + "\nTotal Sum is " + (sum * num));
		else
			System.out.println("It is not a Pseudo Arithmetic Series");
	}

}
