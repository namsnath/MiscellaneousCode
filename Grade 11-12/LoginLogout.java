import java.util.Scanner;
public class LoginLogout
{

	int id;		//Employee ID
	int loginhr, loginmin, loginday, loginmonth;	//Login Details
	int logouthr, logoutmin, logoutday, logoutmonth;	//Logout Details
	int durahr, duramin;	//Duration
	Scanner s = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter number of users");
		int n = s.nextInt();
		
		LoginLogout l[] = new LoginLogout[n];
		
		for(int i = 0; i < n; i++)
		{
			l[i] = new LoginLogout();
			l[i].input();
			l[i].durationcount();
		}
		
		System.out.println("User ID\t\tLogin Time & Date\t\tLogout Time & Date\t\tDuration");
		for(int i = 0; i < n; i++)
		{
			System.out.print(l[i].id + "\t\t" + l[i].loginhr + ":" + l[i].loginmin + " " + l[i].loginday + "-" + l[i].loginmonth);
			System.out.print("\t\t" + l[i].logouthr + ":" + l[i].logoutmin + " " + l[i].logoutday + "-" + l[i].logoutmonth);
			System.out.print("\t\t" + l[i].durahr + ":" + l[i].duramin);
			System.out.println();
		}
	}

	
	public void input()
	{
		System.out.println("Enter ID");
		id = s.nextInt();
		
		System.out.println("Enter login hour, minute, day and month");
		loginhr = s.nextInt();
		loginmin = s.nextInt();
		loginday = s.nextInt();
		loginmonth = s.nextInt();
		
		System.out.println("Enter logout hour, minute, day and month");
		logouthr = s.nextInt();
		logoutmin = s.nextInt();
		logoutday = s.nextInt();
		logoutmonth = s.nextInt();
	}

	
	public void durationcount()
	{
		if(loginmonth == logoutmonth)
		{
			if(loginday == logoutday)
			{
				if(loginhr == logouthr)
				{
					duramin = logoutmin - loginmin;
					durahr = 0;
				}
				else
				{
					if(loginmin <= logoutmin)
					{
						duramin = logoutmin - loginmin;
						durahr = logouthr - loginhr;
					}
					else
					{
						duramin = 60 - (loginmin - logoutmin);
						durahr = logouthr - loginhr - 1;
					}
				}
			}
			else // days different
			{
				if(loginhr <= logouthr)
				{
					durahr = (logoutday - loginday) * 24;
					
					if(loginmin <= logoutmin)
					{
						duramin = logoutmin - loginmin;
						durahr += logouthr - loginhr;
					}
					else
					{
						duramin = 60 - (loginmin - logoutmin);
						durahr += logouthr - loginhr - 1;
					}
				}
				else
				{
					durahr = (logoutday - loginday ) * 24;
					
					if(loginmin <= logoutmin)
					{
						duramin = logoutmin - loginmin;
						durahr += logouthr - loginhr;
					}
					else
					{
						duramin = 60 - (loginmin - logoutmin);
						durahr += logouthr - loginhr - 1;
					}
				}
			}
		}
		else
		{
			//crazy logic
		}
	}
	
}
