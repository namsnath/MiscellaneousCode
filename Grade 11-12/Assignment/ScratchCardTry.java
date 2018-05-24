import java.util.Random;
import java.util.Scanner;

public class ScratchCardTry
{

	public static void main(String[] args)
	{
		int Extra;
		boolean Win = false;
		Random r = new Random();
		Scanner s = new Scanner(System.in);
		long Scratch_CardNum = r.nextInt(999999999 - 1) + 1;
		long[] Winning_SCardNum = {45632, 84213, 513798, 123438, 5678941, 25, 6894, 7892153, 0, 6847, 13487, 1348, 6541, 2348, 5455, 
									48648, 56412589, 213879, 789621325, 1324586, 846792, 1254895, 2348951, 256794, 12348, 4554, 6897, 
									56791245, 759846, 5481225, 56482, 48815, 846251, 15, 99, 999999999, 464562, 7892155, 19, 2245};
		String[] Items = {"KODAK Digital Photo Frame Keychain", "ENVENT Neckband MP3 Player", "COMFII 20 Ultra Light Weight AirBag", 
							"AVA Guitar Shaped Wine Holder with Wooden Wine Case", "PORTRONICS Multipurpose Laptop Cooling Table"};
		String Item_Won = Items[r.nextInt(5 - 1) + 1];
		
		System.out.println("You Have Recieved A Scratch Card!! The Number Is:" + Scratch_CardNum);
		System.out.println("Press 1 to continue...");
		Extra = s.nextInt();
		
		for(int i = 0; i < 39; i++)
		{
			if(Scratch_CardNum == Winning_SCardNum[i])
			{
				Win = true;
				break;
			}
			else
			{
				Win = false;
			}
		}
		
		if (Win == true)
		{
			System.out.println("You Have Won: " + Item_Won + "!!!");
		}
		else if (Win == false)
		{
			System.out.println("Sorry, You Did Not Win Anything...");
		}
		
	

	}

}
