
public class Char_Count
{

	public static void main(String[] args)
	{
		String Input = "COMPUTER HARDWARE";
		
		char[] Letter = new char[26];
		int[] Freq = new int[26];
		int k = 0;
		
		for(int i = 0; i < 26; i++)
			Freq[i] = 0;
		
		for(char i = 'A'; i <= 'Z'; i++, k++)
		{
			Letter[k] = i;
			
			for(int j = 0; j < Input.length(); j++)
			{
				if(Input.charAt(j) == i)
					Freq[k]++;
			}
			
			
		}
		
		for(int i = 0; i < 26; i++)
		{
			if(Freq[k] == 0)
			{
				continue;
			}
			else
			{
				System.out.print(" " + Letter[i]);
			}
		}

		

		for(int i = 0; i < 26; i++)
		{
			if(Freq[k] == 0)
			{
				continue;
			}
			else
			{
				System.out.print(" " + Freq[i]);
			}
		}
		
	}

}
