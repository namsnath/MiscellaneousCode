package isc_2011_Practical;

import java.util.Scanner;

public class Q2_Encryption
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		int i, j;
		
		System.out.println("Enter size of Array");
		int n = s.nextInt();
		
		if(n <= 1 || n >= 10)
		{
			System.out.println("Invalid size");
			System.exit(0);
		}
		
		String[] sent = new String[n];
		
		System.out.println("Enter " + (n) + " Sentences ending with Fullstop( . )");
		for(i = 0; i < n; i++)
		{
			sent[i] = s.nextLine().toUpperCase();	//standardises input
		}
		
		for(i = 0, j = 1; i < n; i++, j++)
		{
			if(j % 2 == 0) //Even rows
			{
				String[] sent_Split = sent[i].split(" ");
				int l = sent_Split.length - 1; //length  - 1
				sent_Split[l] = sent_Split[l].substring(0, sent_Split[l].length() - 1); //removes fullstop
				
				sent[i] = "";
				
				for(int k = l; k >= 0; k--)
					sent[i] = sent[i] + sent_Split[k];	//reverses string
				sent[i] += ".";	//adds fullstop
			}
			else
			{
				StringBuffer st = new StringBuffer(sent[i]);
				
				for(int k = 0; k < st.length(); k++)
				{	
					char ch = st.charAt(k);
					if(ch == ' ' || ch == '.')
						continue;
					else if(ch == 'Z')
						st.setCharAt(k, 'B');
					else if(ch == 'Y')
						st.setCharAt(k, 'A');
					else
						st.setCharAt(k, (char)((int)st.charAt(k) + 1));
				}
				
				sent[i] = st.toString();
			}
			
			
			for(i = 0; i < n; i++)
				System.out.println(sent[i]);
		}
		
	}

}
