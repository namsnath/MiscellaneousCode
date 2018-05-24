import java.util.Scanner;

public class CharSortAscendWord
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		String Word;
		
		System.out.println("Enter Word");
		Word = s.next().toLowerCase().trim();
		
		int i, j;
		
		char Chars[] = Word.toCharArray(), temp;
		
		for(i = 0; i < Chars.length; i++)
			for(j = 0; j < (Chars.length - 1); j++)
				if(Chars[i] < Chars[j])
				{
					temp = Chars[i];
					Chars[i] = Chars[j];
					Chars[j] = temp;
				}
		
		System.out.println("");
		
		for(i = 0; i < Chars.length; i++)
			System.out.print(Chars[i]);
	}

}
