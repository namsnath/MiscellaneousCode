package operationsOnFiles;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class StudentRecords
{

	String fileName = "StudentRecords.txt";	//Filename for ease
	String Name[];	//Array for Student name
	int[] Class, RollNo, English, Math, Science, SS, Percent, Rank;	//Arrays for Student data
	int lineCount, stuCount;	//Other data for ease and reusability
	
	public static void main(String[] args) throws Exception
	{
		FileWriter fw = new FileWriter("StudentRecords.txt", true);		//Creates a new file which is appendable (or appends to existing file)
		Scanner s = new Scanner(System.in);
		StudentRecords stu = new StudentRecords();
		
		int menuChoice = 1;
		
		do
		{
			menuChoice = 0;
			
			System.out.println("Choose Operation\nEnter Any Other Number to Exit");
			System.out.println("1 - Enter Data");
			System.out.println("2 - Modify Data");
			System.out.println("3 - Delete Record");
			System.out.println("4 - Display All Data");
			System.out.println("5 - Display Marks and Percentage");
			System.out.println("6 - Display Rank");
			
			menuChoice = s.nextInt();
			
			switch(menuChoice)
			{
				case 1:	stu.dataEntry();
						break;
						
				case 2:	stu.dataModify();
						break;
						
				case 3:	stu.dataDelete();
						break;
						
				case 4:	stu.displayAll();
						break;
					
				case 5:	stu.displayMarksPercent();
						break;
						
				case 6:	stu.displayRank();
						break;
			}
			
		} while(menuChoice > 0 && menuChoice < 7);		//Displays menu until appropriate choice is given
		
		fw.close();
		s.close();
	}
	
	public void dataEntry() throws Exception	//Function to input data
	{
		FileWriter fw = new FileWriter(fileName, true);		//Creates object to allow appending to the file
		PrintWriter pw = new PrintWriter(fw);				//Object to allow printing to the file
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter Number of Students to Enter Data For:");
		int n = s.nextInt();		//To store number of students
		
		for(int i = 0; i < n; i++)		//Loop to take input for various data
		{
			System.out.println("Enter Data for Student #" + (i + 1) + ":");
			System.out.println("Name:");
			pw.println(s.nextLine());
			System.out.println("Class:");
			pw.println(s.nextInt());
			System.out.println("Roll Number:");
			pw.println(s.nextInt());
			System.out.println("English Marks (out of 100):");
			pw.println(s.nextInt());
			System.out.println("Math Marks (out of 100):");
			pw.println(s.nextInt());
			System.out.println("Science Marks (out of 100):");
			pw.println(s.nextInt());
			System.out.println("Social Studies Marks (out of 100):");
			pw.println(s.nextInt());
			System.out.println("\n\n");
		}
		
		fw.close();
		pw.close();
	}

	public void dataModify() throws Exception		//Function to modify entered data
	{
		dataParse();		//Parses the file
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Roll Number of Student to Modify Record for:");
		int key = s.nextInt(), position = 0;		//Stores Roll Number to modify data for
		boolean exists = false;		//Flag to check if record exists
		
		for(int i = 0; i < stuCount; i++)		//Iterates through Roll Number array
			if(RollNo[i] == key)	//Checks if current element is the required record
			{
				exists = true;
				position = i;
			}
				
		if(exists ==  false)
		{
			System.out.println("Record Does Not Exist");
			return;
		}
		
		//Displays Data for Confirmation
		
		System.out.println("\n\n");
		System.out.println("Student Number: " + (position + 1));
		System.out.println("Student Name: " + Name[position]);
		System.out.println("Class: " + Class[position]);
		System.out.println("Roll Number: " + RollNo[position]);
		System.out.println("English: " + English[position]);
		System.out.println("Math: " + Math[position]);
		System.out.println("Science: " + Science[position]);
		System.out.println("Social Science: " + SS[position]);
		
		System.out.println("Are you sure you want to modify data for this student? (1 = yes, any other number = no");
		int confirm = s.nextInt();	//For confirmation
		
		if(confirm != 1)
			return;
		
		//Inputting new data
		
		System.out.println("Enter Data for Student #" + (position + 1) + ":");
		System.out.println("Name:");
		Name[position] = s.nextLine();
		System.out.println("Class:");
		Class[position] = s.nextInt();
		System.out.println("Roll Number:");
		RollNo[position] = s.nextInt();
		System.out.println("English Marks (out of 100):");
		English[position] = s.nextInt();
		System.out.println("Math Marks (out of 100):");
		Math[position] = s.nextInt();
		System.out.println("Science Marks (out of 100):");
		Science[position] = s.nextInt();
		System.out.println("Social Studies Marks (out of 100):");
		SS[position] = s.nextInt();
		
		FileWriter fw = new FileWriter(fileName);	//Makes the file non-appendable to allow overwriting
		PrintWriter pw = new PrintWriter(fw);	
		
		for(int i = 0; i < stuCount; i++)	//Prints data to file from the start to overwrite
		{
			pw.println(Name[i]);
			pw.println(Class[i]);
			pw.println(RollNo[i]);
			pw.println(English[i]);
			pw.println(Math[i]);
			pw.println(Science[i]);
			pw.println(SS[i]);
		}
		
		fw.close();
		pw.close();
	}
	
	
	public void dataDelete() throws Exception		//Function to delete selected record
	{
		dataParse();		//Parses data from file
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Roll Number of Student to Delete Record for:");
		int key = s.nextInt();		//Stores roll number to find record for
		boolean exists = false;		//Flag to check if record exists
		
		for(int i = 0; i < stuCount; i++)		//Iterates through the roll number array
			if(RollNo[i] == key)	//Checks if current element is the required record
				exists = true;
		
		if(!exists)
		{
			System.out.println("Record Does Not Exist");
			return;
		}
		
		FileWriter fw = new FileWriter(fileName);	//Non-appendable writer to allow overwriting
		PrintWriter pw = new PrintWriter(fw);
		
		for(int i = 0; i < stuCount; i++)		//Overwrites data to file
		{	
			if(RollNo[i] == key)				//Skips writing record to be deleted
				continue;
			
			
			pw.println(Name[i]);
			pw.println(Class[i]);
			pw.println(RollNo[i]);
			pw.println(English[i]);
			pw.println(Math[i]);
			pw.println(Science[i]);
			pw.println(SS[i]);
		}
		
		fw.close();
		pw.close();
	}
	
	public void displayAll() throws Exception		//Function to Display all records as in the file
	{
		dataParse();		//Parses data from file
		for(int i = 0; i < stuCount; i++)	//Iterates through the data arrays and prints them
		{
			System.out.println("Student Number: " + (i + 1));
			System.out.println("Student Name: " + Name[i]);
			System.out.println("Class: " + Class[i]);
			System.out.println("Roll Number: " + RollNo[i]);
			System.out.println("English: " + English[i]);
			System.out.println("Math: " + Math[i]);
			System.out.println("Science: " + Science[i]);
			System.out.println("Social Science: " + SS[i]);
			System.out.println("\n\n");
		}	
	}
	
	public void displayMarksPercent() throws Exception		//Function to display essential details along with marks and percentage
	{
		dataParse();		//Parses data from file
		for(int i = 0; i < stuCount; i++)		//Iterates through the data arrays and prints Name, Roll Number, marks and percentage
		{
			System.out.println("Student Number: " + (i + 1));
			System.out.println("Student Name: " + Name[i]);
			System.out.println("English: " + English[i]);
			System.out.println("Math: " + Math[i]);
			System.out.println("Science: " + Science[i]);
			System.out.println("Social Science: " + SS[i]);
			System.out.println("Percentage: " + Percent[i]);
			System.out.println("\n\n");
		}	
	}
	
	public void displayRank() throws Exception		//Function to Display Student number, name, percentage and rank
	{	
		dataParse();		//Parses Data from file
		for(int i = 0; i < stuCount; i++)	//Iterates through the data arrays and print Name, Roll number, percentage and rank
		{
			System.out.println("Student Number: " + (i + 1));
			System.out.println("Student Name: " + Name[i]);
			System.out.println("Percentage: " + Percent[i]);
			System.out.println("Rank: " + Rank[i]);
			System.out.println("\n\n");
		}	
	}
	
	public void dataParse() throws Exception	//Function to parse data from file and perform required calculations
	{
		FileReader fr = new FileReader(fileName);		//File Reader
		Scanner s = new Scanner(fr);	//To read data
		lineCount = 0;	//Counts total lines for reference
			
		while(s.hasNextLine())		//Loops until it reaches end of file, gives line count
		{
			s.nextLine();
			lineCount++;
		}
		
		stuCount = lineCount / 7;	//Calculates number of students based on number of lines in the file
		
		//Initialization of the arrays
		
		Name = new String[stuCount];
		Class = new int[stuCount];
		RollNo = new int[stuCount];
		English = new int[stuCount];
		Math = new int[stuCount];
		Science = new int[stuCount];
		SS = new int[stuCount];
		Percent = new int[stuCount];
		Rank = new int[stuCount];
		
		for(int i = 0; i < stuCount; i++)		//Reads lines and parses the data into arrays
		{
			Name[i] = s.nextLine();
			Class[i] = Integer.parseInt(s.nextLine());
			RollNo[i] = Integer.parseInt(s.nextLine());
			English[i] = Integer.parseInt(s.nextLine());
			Math[i] = Integer.parseInt(s.nextLine());
			Science[i] = Integer.parseInt(s.nextLine());
			SS[i] = Integer.parseInt(s.nextLine());
			Percent[i] = (English[i] + Math[i] + Science[i] + SS[i]) / 4;	//Calculates percentage
		}
		
		assignRank();		//Assigns rank to the students based on percentage
		
		s.close();
		fr.close();
	}
	
	public void assignRank()		//Function to assign rank to the students based on percentage
	{
		int[] Percentage = Percent, index = new int[stuCount];		//Percentage is a copy of Percent[], index stores index of students for reference
		
		for(int i = 0; i < stuCount; i++)		//Assigns index in order
			index[i] = i;
		
		//Sorting the two arrays
		
		for(int i = 0; i < stuCount; i++)
			for(int j = 0; i < stuCount - 1; j++)
				if(Percentage[j + 1] < Percentage [j])
				{
					int temp = Percentage[j];
					Percentage[j + 1] = Percentage[j];
					Percentage[j] = temp;
					
					temp = index[j];
					index[j + 1] = index[j];
					index[j] = temp;
				}
		
		//Compares index with student and assigns appropriate rank
		
		for(int i = 0; i < stuCount; i++)
			for(int j = 0; j < stuCount; j++)
				if(index[j] == i)
					Rank[i] = j + 1;
		
	}
}
