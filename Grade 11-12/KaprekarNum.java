import java.util.Scanner;
public class KaprekarNum
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter A Number");
		int inp = s.nextInt();		//User input of integer
		int num = inp * inp;		//input squared
		
		StringBuffer st = new StringBuffer(Integer.toString(num));	//String Buffer initialised with String
		int d = Integer.toString(inp).length();		//length of original integer
		
		StringBuffer part1 = new StringBuffer(st.toString());
		part1.setLength(st.length() - d);	//StringBuffer divided into parts of d and (length - d) characters
		
		
		//Making the second part of length (st.length - d)
		StringBuffer part2 = new StringBuffer(st.toString());
		part2.reverse();
		part2.setLength(d);
		part2.reverse();
		
		if(Integer.parseInt(part2.toString()) + Integer.parseInt(part1.toString()) == inp) //checking condition for Kaprekar Numbers
			System.out.println("It is Kaprekar Number");
		else
			System.out.println("It is not Kaprekar Number");
		
	}

}
