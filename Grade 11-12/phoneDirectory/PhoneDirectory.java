package phoneDirectory;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class PhoneDirectory
{
	
	int count;	//For number of records
	String[] name, email, city, state, homeadd, workadd;	//Personal Detail Fields	
	int[] wrknum, homenum, mobnum;	//Contact Information fields
	int[] UID;	//ID Field
	static String filename = "phoneDirectory.txt";	//Filename for ease
	
	//Objects for reusability
	FileWriter fw;
	PrintWriter pw;
	Scanner s;
	

	public static void main(String[] args) throws Exception
	{
		FileWriter fw = new FileWriter(filename, true);	//Creates file if it doesn't exist, does nothing otherwise since it is closed immediately after
		fw.close();
		
		PhoneDirectory pd = new PhoneDirectory();	//Creating a new Class object and calling the menu() function
		pd.menu();
	}
	
	public void menu() throws Exception
	{
		Scanner s = new Scanner(System.in);
		int choice = 1;
		
		do
		{
			fw = new FileWriter(PhoneDirectory.filename, true);	//Makes the file appendable, creates it if it doesn't exist
			pw = new PrintWriter(fw);	//Object to allow writing to file
			
			choice = 0;
			System.out.println("Enter choice. Any other number will exit the program.");
			System.out.println("1 - Add Records");
			System.out.println("2 - Modify Records");
			System.out.println("3 - Delete Records");
			System.out.println("4 - Display Alphabetically");
			System.out.println("5 - Display City-Wise");
			System.out.println("6 - Display State-Wise");
			
			choice = s.nextInt();	//Takes input for menu choice
			
			switch(choice)	//Switch block for calling appropriate function according to choice
			{
				case 1:		addRecord();
							break;
						
				case 2:		modifyRecord();
							break;
					
				case 3:		deleteRecord();
							break;
					
				case 4:		displayAlpha();
							break;
					
				case 5:		displayCity();
							break;
					
				case 6:		displayState();
							break;
			}
			
			pw.close();
			fw.close();
			
		} while(choice > 0 && choice < 7);
		
		fw.close();
		pw.close();
		s.close();
	}

	public void dataParse() throws Exception
	{
		FileReader fr = new FileReader(PhoneDirectory.filename);		//Opens the file to read
		Scanner st = new Scanner(fr);	//Allows reading data
		StringTokenizer stt;	//For operations
		count = 0;		//Count of records
		
		while(st.hasNextLine())		//Loops till file has a line and counts lines
		{
			st.nextLine();
			count++;
		}
		
		//Data arrays initialised
		name = new String[count]; 
		email = new String[count]; 
		city = new String[count]; 
		state = new String[count]; 
		homeadd = new String[count];
		workadd = new String[count];
		wrknum = new int[count]; 
		homenum = new int[count];
		mobnum = new int[count];
		UID = new int[count];;
			
		fr.close();
		st.close();
		//Readers closed to reset them
		
		//Readers reopened to read data
		fr = new FileReader(PhoneDirectory.filename);
		st = new Scanner(fr);
		
		for(int i = 0; i < count; i++)	//Loop to parse all data in each line and assign it to the respective array
		{
			stt = new StringTokenizer(st.nextLine(), ",");
			UID[i] = Integer.parseInt(stt.nextToken());
			name[i] = stt.nextToken();
			email[i] = stt.nextToken();
			city[i] = stt.nextToken();
			state[i] = stt.nextToken();
			homeadd[i] = stt.nextToken();
			workadd[i] = stt.nextToken();
			homenum[i] = Integer.parseInt(stt.nextToken());
			wrknum[i] = Integer.parseInt(stt.nextToken());
			mobnum[i] = Integer.parseInt(stt.nextToken());
		}
		fr.close();
		st.close();
	}
	
	public void modifyRecord() throws Exception
	{
		dataParse();	//Parses data in file
		
		s = new Scanner(System.in);	//For user input
		
		System.out.println("Enter Name of the person to modify record for: ");
		String sname = s.nextLine();	//Takes record to search for
		int index = 0;	//Index where record is found
		boolean found = false;	//To check if record exists
		
		for(int i = 0; i < count; i++)	//Loops till record is found or list ends
			if(sname.equalsIgnoreCase(name[i]))
			{
				index = i;
				found = true;
				break;
			}
		
		if(!found)
		{
			System.out.println("Record not found, Returning to menu");
			return;
		}
		
		System.out.println("Enter Appropriate choice to modify:");
		System.out.println("1 - Name");
		System.out.println("2 - Email ID");
		System.out.println("3 - City");
		System.out.println("4 - State");
		System.out.println("5 - Home Address");
		System.out.println("6 - Work Address");
		System.out.println("7 - Home Phone Number");
		System.out.println("8 - Work Phone Number");
		System.out.println("9 - Mobile Phone Number");
		
		int c = s.nextInt();
		s.nextLine();
		
		switch(c)	//Switch Block to accept input for new data according to choice
		{
			case 1:	System.out.println("Enter New Name");
					name[index] = s.nextLine();
					break;
					
			case 2:	System.out.println("Enter New Email ID");
					email[index] = s.nextLine();
					break;
					
			case 3:	System.out.println("Enter new City");
					city[index] = s.nextLine();
					break;
					
			case 4:	System.out.println("Enter new State");
					state[index] = s.nextLine();
					break;
					
			case 5:	System.out.println("Enter new Home Address");
					homeadd[index] = s.nextLine();
					break;
					
			case 6:	System.out.println("Enter new Work Address");
					workadd[index] = s.nextLine();
					break;
					
			case 7:	System.out.println("Enter new Home Phone Number");
					homenum[index] = s.nextInt();
					break;
					
			case 8:	System.out.println("Enter new Work Phone Number");
					wrknum[index] = s.nextInt();
					break;
					
			case 9:	System.out.println("Enter New Mobile phone Number");
					mobnum[index] = s.nextInt();
					break;
		}
		
		//Objects to write to the file
		fw = new FileWriter(PhoneDirectory.filename);	//Overwrites the original file
		pw = new PrintWriter(pw);
		
		for(int i = 0; i < count; i++)	//Writes new data to the file
		{
			pw.print(UID[i] + ",");
			pw.print(name[i] + ",");
			pw.print(email[i] + ",");
			pw.print(city[i] + ",");
			pw.print(state[i] + ",");
			pw.print(homeadd[i] + ",");
			pw.print(workadd[i] + ",");
			pw.print(homenum[i] + ",");
			pw.print(wrknum[i] + ",");
			pw.print(mobnum[i]);
			pw.println();
		}
		
		//Closes the writers to save the file
		fw.close();
		pw.close();
	}
	
	public void deleteRecord() throws Exception
	{
		dataParse();		//Parses data from the file
		
		s = new Scanner(System.in);		//For user input
		
		System.out.println("Enter Name of the person to modify record for: ");
		String sname = s.nextLine();	//Takes record to search for
		int index = 0;	//Index of record
		boolean found = false;	//Checks if record found
		
		for(int i = 0; i < count; i++)		//Loop to find record and store index if found
			if(sname.equalsIgnoreCase(name[i]))
			{
				index = i;
				found = true;
				break;
			}
		
		if(!found)
		{
			System.out.println("Record not found, Returning to menu");
			return;
		}
		
		fw = new FileWriter(PhoneDirectory.filename);	//To allow writing to file
		pw = new PrintWriter(pw);	//To write to file
		
		for(int i = 0; i < count; i++)	//Loop to print data to file
		{
			if(i == index)	//Skips if record matches index of record to be deleted
				continue;
			
			pw.print(UID[i] + ",");
			pw.print(name[i] + ",");
			pw.print(email[i] + ",");
			pw.print(city[i] + ",");
			pw.print(state[i] + ",");
			pw.print(homeadd[i] + ",");
			pw.print(workadd[i] + ",");
			pw.print(homenum[i] + ",");
			pw.print(wrknum[i] + ",");
			pw.print(mobnum[i]);
			pw.println();
		}
		
		//Writers closed
		fw.close();
		pw.close();
		
	}
	
	public void addRecord() throws Exception
	{
		dataParse();	//Parses data from the file
			
		s = new Scanner(System.in);		//For user input
		fw = new FileWriter(PhoneDirectory.filename, true);	//Makes file appendable and allows writing
		pw = new PrintWriter(pw);	//To write to the file
		
		int code = 0;	//UID for the new record
			
		sortUID();	//Sorts data by UID
		
		if(count != 0)	//For adding a record to existing file
			code = UID[count - 1] + 1;
		
		else		//For record in new file
			code = 100000;
		
		pw.print(code + ",");	//Prints code to file
		
		//To take input for data and print it to file
		System.out.println("Enter Name:");
		pw.print(s.nextLine() + ",");
		System.out.println("Enter Email ID:");
		pw.print(s.nextLine() + ",");
		System.out.println("Enter City:");
		pw.print(s.nextLine() + ",");
		System.out.println("Enter State:");
		pw.print(s.nextLine() + ",");
		System.out.println("Enter Home Address (Separate Lines if applicable with hyphens(-) ):");
		pw.print(s.nextLine() + ",");
		System.out.println("Enter Work Address (Separate Lines if applicable with hyphens(-) ):");
		pw.print(s.nextLine() + ",");
		System.out.println("Enter Home Phone Number:");
		pw.print(s.nextInt() + ",");
		System.out.println("Enter Work Phone Number:");
		pw.print(s.nextInt() + ",");
		System.out.println("Enter Mobile Phone Number:");
		pw.println(s.nextInt());
		
		//Writers closed
		fw.close();
		pw.close();
	}
	
	public void sortUID() throws Exception	//To sort the data according to UIDs
	{
		dataParse();		//Parses data from the file
		
		for(int i = 0; i < UID.length; i++)	//Sorts using Bubble Sort
		{
			for(int j = 0; j < UID.length-1; j++)
			{
				if(UID[j] > UID[j + 1]) 
				{
					String temp = name[j + 1];
					name[j + 1] = name[j];
					name[j] = temp;
					
					temp = email[j + 1];
					email[j + 1] = email[j];
					email[j] = temp;
				
					temp = city[j + 1];
					city[j + 1] = city[j];
					city[j] = temp;
					
					temp = state[j + 1];
					state[j + 1] = state[j];
					state[j] = temp;
					
					temp = workadd[j + 1];
					workadd[j + 1] = workadd[j];
					workadd[j] = temp;
					
					temp = homeadd[j + 1];
					homeadd[j + 1] = homeadd[j];
					homeadd[j] = temp;
					
					int temp2 = wrknum[j + 1];
					wrknum[j + 1] = wrknum[j];
					wrknum[j] = temp2;
					
					temp2 = homenum[j + 1];
					homenum[j + 1] = homenum[j];
					homenum[j] = temp2;
					
					temp2 = mobnum[j + 1];
					mobnum[j + 1] = mobnum[j];
					mobnum[j] = temp2;
					
					temp2 = UID[j + 1];
					UID[j + 1] = UID[j];
					UID[j] = temp2;
				}
			}
		}
	}
	
	public void sortAlpha() throws Exception		//To sort data Alphabetically by name
	{
		dataParse();	//Parses data from the file
		
		for(int i = 0; i < name.length; i++)	//Sorts data by Bubble Sort
		{
			for(int j = 0; j < name.length-1; j++)
			{
				if(name[j].compareToIgnoreCase(name[j + 1]) > 0) 
				{
					String temp = name[j + 1];
					name[j + 1] = name[j];
					name[j] = temp;
					
					temp = email[j + 1];
					email[j + 1] = email[j];
					email[j] = temp;
				
					temp = city[j + 1];
					city[j + 1] = city[j];
					city[j] = temp;
					
					temp = state[j + 1];
					state[j + 1] = state[j];
					state[j] = temp;
					
					temp = workadd[j + 1];
					workadd[j + 1] = workadd[j];
					workadd[j] = temp;
					
					temp = homeadd[j + 1];
					homeadd[j + 1] = homeadd[j];
					homeadd[j] = temp;
					
					int temp2 = wrknum[j + 1];
					wrknum[j + 1] = wrknum[j];
					wrknum[j] = temp2;
					
					temp2 = homenum[j + 1];
					homenum[j + 1] = homenum[j];
					homenum[j] = temp2;
					
					temp2 = mobnum[j + 1];
					mobnum[j + 1] = mobnum[j];
					mobnum[j] = temp2;
					
					temp2 = UID[j + 1];
					UID[j + 1] = UID[j];
					UID[j] = temp2;
				}
			}
		}
	}
		
	public void sortCity() throws Exception		//To sort the data alphabetically by city
	{
		dataParse();	//Parses data from the file
		
		for(int i = 0; i < city.length; i++)	//Looop to sort data by bubble sort
		{
			for(int j = 0; j < city.length-1; j++)
			{
				if(city[j].compareToIgnoreCase(city[j + 1]) > 0) 
				{
					String temp = name[j + 1];
					name[j + 1] = name[j];
					name[j] = temp;
					
					temp = email[j + 1];
					email[j + 1] = email[j];
					email[j] = temp;
				
					temp = city[j + 1];
					city[j + 1] = city[j];
					city[j] = temp;
					
					temp = state[j + 1];
					state[j + 1] = state[j];
					state[j] = temp;
					
					temp = workadd[j + 1];
					workadd[j + 1] = workadd[j];
					workadd[j] = temp;
					
					temp = homeadd[j + 1];
					homeadd[j + 1] = homeadd[j];
					homeadd[j] = temp;
					
					int temp2 = wrknum[j + 1];
					wrknum[j + 1] = wrknum[j];
					wrknum[j] = temp2;
					
					temp2 = homenum[j + 1];
					homenum[j + 1] = homenum[j];
					homenum[j] = temp2;
					
					temp2 = mobnum[j + 1];
					mobnum[j + 1] = mobnum[j];
					mobnum[j] = temp2;
					
					temp2 = UID[j + 1];
					UID[j + 1] = UID[j];
					UID[j] = temp2;
				}
			}
		}
	}
	
	public void sortState() throws Exception	//To sort data alphabetically by state
	{	
		dataParse();//Parses data from the file
		
		for(int i = 0; i < state.length; i++)	//Loop to sort data using Bubble Sort
		{
			for(int j = 0; j < state.length-1; j++)
			{
				if(state[j].compareToIgnoreCase(state[j + 1]) > 0) 
				{
					String temp = name[j + 1];
					name[j + 1] = name[j];
					name[j] = temp;
					
					temp = email[j + 1];
					email[j + 1] = email[j];
					email[j] = temp;
				
					temp = city[j + 1];
					city[j + 1] = city[j];
					city[j] = temp;
					
					temp = state[j + 1];
					state[j + 1] = state[j];
					state[j] = temp;
					
					temp = workadd[j + 1];
					workadd[j + 1] = workadd[j];
					workadd[j] = temp;
					
					temp = homeadd[j + 1];
					homeadd[j + 1] = homeadd[j];
					homeadd[j] = temp;
					
					int temp2 = wrknum[j + 1];
					wrknum[j + 1] = wrknum[j];
					wrknum[j] = temp2;
					
					temp2 = homenum[j + 1];
					homenum[j + 1] = homenum[j];
					homenum[j] = temp2;
					
					temp2 = mobnum[j + 1];
					mobnum[j + 1] = mobnum[j];
					mobnum[j] = temp2;
					
					temp2 = UID[j + 1];
					UID[j + 1] = UID[j];
					UID[j] = temp2;
				}
			}
		}
	}
	
	public void display()	//To display the data
	{
		System.out.println("UID\t\tName\t\temail\t\tCity\t\tState\t\tWork Address\t\tHome Address\t\tWork Number\t\tHome Number\t\tMobile Number");
		for(int i = 0; i < count; i++)
		{
			System.out.print(UID[i] + "\t\t");
			System.out.print(name[i] + "\t\t");
			System.out.print(email[i] + "\t\t");
			System.out.print(city[i] + "\t\t");
			System.out.print(state[i] + "\t\t");
			System.out.print(workadd[i] + "\t\t");
			System.out.print(homeadd[i] + "\t\t");
			System.out.print(wrknum[i] + "\t\t");
			System.out.print(homenum[i] + "\t\t");
			System.out.println(mobnum[i] + "\t\t");
		}
	}
	
	public void displayAlpha() throws Exception	//Displays data after sorting alphabetically by name
	{
		sortAlpha();
		display();
	}
	
	public void displayCity() throws Exception	//Displays data after sorting Alphabetically by city
	{
		sortCity();
		display();
	}
	
	public void displayState() throws Exception	//Displays data after sorting alphabetically by state
	{
		sortState();
		display();
	}
	
}