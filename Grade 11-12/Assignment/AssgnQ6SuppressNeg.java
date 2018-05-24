public class AssgnQ6SuppressNeg
{

	public static void main(String[] args)
	{
		int Array1[] = {5 , -4 , 3 , -2 , 6 , -11 , 12 , -8 , 9, -3};
		int Neg = 0, Pos = 0;
		int i, j, k;
		
		for(i = 0; i < 10; i++)
		{
			if(Array1[i] < 0)
			{
				Neg++;
			}
			else
			{
				Pos++;
			}
		}
		
		int ArrayNeg[] = new int[Neg];
		int ArrayPos[] = new int[Pos];
		
		for(i = 0, j = 0, k = 0; i < 10; i++)
		{
			if(Array1[i] < 0)
			{
				ArrayNeg[j] = Array1[i];
				j++;
			}
			if(Array1[i] > 0)
			{
				ArrayPos[k] = Array1[i];
				k++;
			}
		}
		
		for(i = 0, j = 0; i < 10 && j < Pos; i++, j++)
		{
			Array1[i] = ArrayPos[j];
		}
		for(j = 0; i < 10 && j < Neg; i++, j++)
		{
			Array1[i] = ArrayNeg[j];
		}
		
		for(i = 0; i < 10; i++)
		{
			System.out.println(Array1[i] + "\t");
		}
	}

}