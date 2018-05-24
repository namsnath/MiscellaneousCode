import java.util.Scanner;
public class WordCharReverseString
{
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter String");
		String Sentence = s.nextLine().trim();
		
		String Words[] = Sentence.split(" ");
		
		StringBuffer temp;
		
		for(int i = 0; i < Words.length; i++)
		{
			temp = new StringBuffer(Words[i]);
			System.out.print(temp.reverse() + " ");
		}
	}

}
