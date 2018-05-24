public class SomeWeirdProgShit
{

	public static void main(String[] args)
	{
		String Sent = "26 January is Republic Day";
		
		System.out.println("Sentence: " + Sent);
		
		String ReplaceWords[] = {"26", "January", "Republic"};
		String ReplaceWith[] = {"15", "August", "Independance"};
		String Words[] = Sent.split(" ");
		
		for(int i = 0; i < Words.length; i++)
			for(int j = 0; j < 3; j++)
				if(Words[i].equals(ReplaceWords[j]))
					Words[i] = ReplaceWith[j];
		
		
		for(int i = 0; i < Words.length ;i++)
			System.out.print(Words[i] + " ");
	}

}
