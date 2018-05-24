import java.util.Scanner;
public class LuckyNums
{
	boolean isLucky(int n)
	{
		int counter = 2;
	 
		int next_position = n;
	  
		if(counter > n)
			return true;
		if(n % counter == 0)
			return false;      
	 
		//calculate next position of input no
		next_position -= next_position/counter;
	   
		counter++;
		return isLucky(next_position);
	}
	 
	public static void main(String args[])
	{
	  Scanner s = new Scanner(System.in);
	  LuckyNums l = new LuckyNums();
	  System.out.println("Enter Limit");
	  int x = s.nextInt();
	  
	  for(int i = 1; i <= x; i++)
		  if(l.isLucky(i))
			  System.out.print(i + " ");
	  
	  if(l.isLucky(x))
	    System.out.println(x + " is a lucky no.");
	  else
	    System.out.println(x + " is not a lucky no.");
	}
}
