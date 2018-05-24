import java.util.Scanner;
public class CharFreqSentence
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter Sentence");
		String Sentence = s.nextLine().trim().toLowerCase();
		
		System.out.println("Enter Character To Search");
		char SearchChar = s.next().trim().charAt(0);
		
		int count = 0;
		
		char SentChar[] = Sentence.toCharArray();
		
		for(int i = 0; i < SentChar.length; i++)
		{
			if(SearchChar == SentChar[i])
				count++;
		}
		
		System.out.println(SearchChar + " is repeated " + count + " times");
	}
}
