package programmingAssignment;

import java.util.Scanner;

public class Q22_CheckStringRotation
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter String");
		String inp = s.nextLine();				//Stores input String
		System.out.println("Enter String to Check");
		String check = s.nextLine();			//Stores String to check with input
		
		boolean rotation = false;				//Flag for rotation
		
		StringBuffer st = new StringBuffer(inp);	//StringBuffer to store rotations
		
		for(int i = 0; i < inp.length(); i++)		//Loop to iterate through String
		{
			char c = st.charAt(inp.length() - 1);	//character at end of String
			st.deleteCharAt(inp.length() - 1);		//Deletes character at end
			st.reverse();							//reverses StringBuffer
			st.append(c);							//Appends character
			st.reverse();							//reverses StringBuffer
			
			if(st.toString().equals(check))			//Checks if obtained String is equal to input string
				rotation = true;
			else
				continue;
		}
		
		if(rotation)
			System.out.println(check + " is Rotation of " + inp);
		else
			System.out.println(check + " is not Rotation of " + inp);
		
		s.close();
	}

}
