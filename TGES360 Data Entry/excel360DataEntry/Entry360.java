package excel360DataEntry;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class Entry360
{
	Robot r = new Robot();
	int i;
	
	public Entry360() throws AWTException
	{
		
	}
	
	public void performSkillEntry(String line)
	{
		switch(line)
		{
			case "E":		r.keyPress(KeyEvent.VK_RIGHT);
							r.keyRelease(KeyEvent.VK_RIGHT);
							r.keyPress(KeyEvent.VK_LEFT);
							r.keyRelease(KeyEvent.VK_LEFT);
							break;

			case "M":	for(i = 1; i < 2; i++)
						{
							r.keyPress(KeyEvent.VK_RIGHT);
							r.keyRelease(KeyEvent.VK_RIGHT);
						}
						break;		
						
			case "P":	for(i = 1; i < 3; i++)
						{
							r.keyPress(KeyEvent.VK_RIGHT);
							r.keyRelease(KeyEvent.VK_RIGHT);
						}
						break;	
						
			case "S":	for(i = 1; i < 4; i++)
							{
								r.keyPress(KeyEvent.VK_RIGHT);
								r.keyRelease(KeyEvent.VK_RIGHT);
							}
							break;
							
			case "B":	for(i = 1; i < 5; i++)
						{
							r.keyPress(KeyEvent.VK_RIGHT);
							r.keyRelease(KeyEvent.VK_RIGHT);
						}
						break;				
		}
		
		doubleTab();
	}

	
	public void performAwardEntry(String line)
	{
		switch(line)
		{
			case "Gold":	r.keyPress(KeyEvent.VK_RIGHT);
							r.keyRelease(KeyEvent.VK_RIGHT);
							r.keyPress(KeyEvent.VK_LEFT);
							r.keyRelease(KeyEvent.VK_LEFT);
							break;
			
			case "Silver":	for(i = 1; i < 2; i++)
							{
								r.keyPress(KeyEvent.VK_RIGHT);
								r.keyRelease(KeyEvent.VK_RIGHT);
							}
							break;		
							
			case "Bronze":	for(i = 1; i < 3; i++)
							{
								r.keyPress(KeyEvent.VK_RIGHT);
								r.keyRelease(KeyEvent.VK_RIGHT);
							}
							break;	
							
			case "Excellence":	for(i = 1; i < 4; i++)
								{
									r.keyPress(KeyEvent.VK_RIGHT);
									r.keyRelease(KeyEvent.VK_RIGHT);
								}
								break;
								
			case "Proficiency":	for(i = 1; i < 5; i++)
							{
								r.keyPress(KeyEvent.VK_RIGHT);
								r.keyRelease(KeyEvent.VK_RIGHT);
							}
							break;		
			
			case "Active Particpation":	for(i = 1; i < 6; i++)
						{
							r.keyPress(KeyEvent.VK_RIGHT);
							r.keyRelease(KeyEvent.VK_RIGHT);
						}
						break;	
			
			case "No Type":	for(i = 1; i < 7; i++)
						{
							r.keyPress(KeyEvent.VK_RIGHT);
							r.keyRelease(KeyEvent.VK_RIGHT);
						}
						break;
						
			case "Special Recognition":	for(i = 1; i < 8; i++)
						{
							r.keyPress(KeyEvent.VK_RIGHT);
							r.keyRelease(KeyEvent.VK_RIGHT);
						}
						break;		
			
			case "Exemplary Performance":	for(i = 1; i < 9; i++)
						{
							r.keyPress(KeyEvent.VK_RIGHT);
							r.keyRelease(KeyEvent.VK_RIGHT);
						}
						break;	
						
			case "Outstanding":	for(i = 1; i < 10; i++)
						{
							r.keyPress(KeyEvent.VK_RIGHT);
							r.keyRelease(KeyEvent.VK_RIGHT);
						}
						break;
			
			case "Distinguished Performance":	for(i = 1; i < 11; i++)
						{
							r.keyPress(KeyEvent.VK_RIGHT);
							r.keyRelease(KeyEvent.VK_RIGHT);
						}
						break;
			
			case "Creditable Performance":	for(i = 1; i < 12; i++)
						{
							r.keyPress(KeyEvent.VK_RIGHT);
							r.keyRelease(KeyEvent.VK_RIGHT);
						}
						break;
			
			case "Participation":	for(i = 1; i < 13; i++)
						{
							r.keyPress(KeyEvent.VK_RIGHT);
							r.keyRelease(KeyEvent.VK_RIGHT);
						}
						break;
		}
		
		doubleTab();
	}
	
	
	public void performYesNoEntry(String line)
	{
		switch(line)
		{
			case "Yes":	r.keyPress(KeyEvent.VK_RIGHT);
						r.keyRelease(KeyEvent.VK_RIGHT);
						r.keyPress(KeyEvent.VK_LEFT);
						r.keyRelease(KeyEvent.VK_LEFT);
						break;
						
			case "No":	for(i = 1; i < 2; i++)
						{
							r.keyPress(KeyEvent.VK_RIGHT);
							r.keyRelease(KeyEvent.VK_RIGHT);
						}
						break;
			
			case "- -":	for(i = 1; i < 3; i++)
						{
							r.keyPress(KeyEvent.VK_RIGHT);
							r.keyRelease(KeyEvent.VK_RIGHT);
						}
						break;
								
		}
		
		doubleTab();	
	}
	
	public void performGradeEntry(String line)
	{
		switch(line)
		{
			case "O":	r.keyPress(KeyEvent.VK_RIGHT);
						r.keyRelease(KeyEvent.VK_RIGHT);
						r.keyPress(KeyEvent.VK_LEFT);
						r.keyRelease(KeyEvent.VK_LEFT);
						break;
						
			case "A++":	for(i = 1; i < 2; i++)
						{
							r.keyPress(KeyEvent.VK_RIGHT);
							r.keyRelease(KeyEvent.VK_RIGHT);
						}
						break;		
						
			case "A+":	for(i = 1; i < 3; i++)
						{
							r.keyPress(KeyEvent.VK_RIGHT);
							r.keyRelease(KeyEvent.VK_RIGHT);
						}
						break;	
						
			case "A":	for(i = 1; i < 4; i++)
						{
							r.keyPress(KeyEvent.VK_RIGHT);
							r.keyRelease(KeyEvent.VK_RIGHT);
						}
						break;
						
			case "B++":	for(i = 1; i < 5; i++)
						{
							r.keyPress(KeyEvent.VK_RIGHT);
							r.keyRelease(KeyEvent.VK_RIGHT);
						}
						break;		
			
			case "B+":	for(i = 1; i < 6; i++)
						{
							r.keyPress(KeyEvent.VK_RIGHT);
							r.keyRelease(KeyEvent.VK_RIGHT);
						}
						break;	
			
			case "B":	for(i = 1; i < 7; i++)
						{
							r.keyPress(KeyEvent.VK_RIGHT);
							r.keyRelease(KeyEvent.VK_RIGHT);
						}
						break;
						
			case "C++":	for(i = 1; i < 8; i++)
						{
							r.keyPress(KeyEvent.VK_RIGHT);
							r.keyRelease(KeyEvent.VK_RIGHT);
						}
						break;		
			
			case "C+":	for(i = 1; i < 9; i++)
						{
							r.keyPress(KeyEvent.VK_RIGHT);
							r.keyRelease(KeyEvent.VK_RIGHT);
						}
						break;	
						
			case "C":	for(i = 1; i < 10; i++)
						{
							r.keyPress(KeyEvent.VK_RIGHT);
							r.keyRelease(KeyEvent.VK_RIGHT);
						}
						break;
			
			case "D":	for(i = 1; i < 11; i++)
						{
							r.keyPress(KeyEvent.VK_RIGHT);
							r.keyRelease(KeyEvent.VK_RIGHT);
						}
						break;
			
			case "NT":	for(i = 1; i < 12; i++)
						{
							r.keyPress(KeyEvent.VK_RIGHT);
							r.keyRelease(KeyEvent.VK_RIGHT);
						}
						break;
			
			case "NA":	for(i = 1; i < 13; i++)
						{
							r.keyPress(KeyEvent.VK_RIGHT);
							r.keyRelease(KeyEvent.VK_RIGHT);
						}
						break;
						
			case "Ab":	for(i = 1; i < 14; i++)
						{	
							r.keyPress(KeyEvent.VK_RIGHT);
							r.keyRelease(KeyEvent.VK_RIGHT);
						}						
						break;
						
			case "- -":	for(i = 1; i < 15; i++)
						{
							r.keyPress(KeyEvent.VK_RIGHT);
							r.keyRelease(KeyEvent.VK_RIGHT);
						}
						break;
		}
		
		doubleTab();
	}
	
	public void doubleTab()
	{
		for(int i = 0; i < 2; i++)
		{
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
		}
	}
	
	public void TripleTab()
	{
		for(int i = 0; i < 3; i++)
		{
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
		}
	}
	
}
