import java.util.Scanner;
public class WordReverseString
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter String");
		String Sentence = s.nextLine().trim();
		
		String Words[] = Sentence.split(" ");
		
		for(int i = Words.length - 1; i >= 0; i--)
			System.out.print(Words[i] + " ");
	}

}
