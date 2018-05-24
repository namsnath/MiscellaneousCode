import java.util.Scanner;

class ShortFormName
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		String Input;
		
		System.out.println("Enter Name");
		Input = s.nextLine().trim();
		
		int length = Input.length() - 1, counter = 0, i = 0;
		
		for(i = 0; i < length; i++)
			if(Input.charAt(i) == ' ')
				counter++;			
		
		String[] Words = Input.split(" ");
		char[] FirstLetters = new char[(Words.length)];
		
		for(i = 0; i < counter; i++)
			FirstLetters[i] = Words[i].charAt(0);
		
		for(i = 0; i < counter; i++)
			System.out.print(FirstLetters[i] + ". ");
		
		System.out.println(Words[Words.length - 1]);
		
		s.close();
	}
}