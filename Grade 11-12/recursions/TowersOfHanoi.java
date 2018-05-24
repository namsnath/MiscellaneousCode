package recursions;
import java.util.Scanner;

public class TowersOfHanoi
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		char start = 'L', inter = 'C', dest = 'R';
		
		System.out.println("Enter number of disks");
		int N = s.nextInt();		//Number of disks
		TowersOfHanoi t = new TowersOfHanoi();
		t.move(N, start, inter, dest);
	}
	
	private void move(int N, char startPeg, char intPeg, char destPeg)
	{
		if(N != 0)
		{
			//Move n - 1 disks from starting peg to intermediate peg
			move(N-1, startPeg, destPeg, intPeg);
			//Move disk N from start to Destination
			System.out.println("Move disk " + N + " from " + startPeg + " to " + destPeg);
			//Move n - 1 disks from intermediate peg to destination peg
			move(N-1, intPeg, startPeg, destPeg);
		}
	}

}
