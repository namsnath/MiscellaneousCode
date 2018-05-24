import java.util.Scanner;
public class CustomPyramid
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter String To Make Pyramid");
		String Word = s.next().trim();
		
		for(int i = 0; i <= Word.length(); i++)
			System.out.println(Word.substring(0, i));
	}

}
