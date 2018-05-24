import java.awt.AWTException;
import java.awt.FlowLayout;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;


public class DataEntryRdBtn extends JFrame implements ActionListener
{
	
	private static final long	serialVersionUID	= 1L;

	public JButton btnName = new JButton();
	public String[] criteria, criteriaData, line, lineData;
	
	int btnCount = 0;
	
	Robot r = new Robot();
	File f;
	Scanner s;
	
	public DataEntryRdBtn() throws AWTException
	{
		setTitle("RdBtn Entry");
		setSize(350,125);
		setLayout(new FlowLayout());
		setAlwaysOnTop(true);
		
		Object[] possibilities = {"C", "D", "E", "F", "G"};
		String str = (String)JOptionPane.showInputDialog(
		                    this,
		                    "Select Drive Letter where data.txt is located",
		                    "FileLocation",
		                    JOptionPane.PLAIN_MESSAGE,
		                    null, possibilities,
		                    "C");
		
		f = new File(str + ":\\data.txt");
		
		JLabel lbl = new JLabel("Done By: Namit Nathwani");
		add(lbl);

		try
		{
			s = new Scanner(f);
		}
		catch(FileNotFoundException e)
		{
			JOptionPane.showMessageDialog(null, "File: data.txt was not found in " + str + ": drive");
			try
			{
				Thread.sleep(5000);
			} catch (InterruptedException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.exit(0);
		}
		
		int lineCount = 0;
		try
		{
			lineCount = DataEntryRdBtn.countLines(str + ":\\data.txt");
		} catch (IOException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		String criteria = s.nextLine();
		criteriaData = criteria.split(",");
		
		line = new String[lineCount - 1];
		
		for(int i = 0; i < lineCount - 2; i++)
			line[i] = s.nextLine();
		
		
		lineData = line[0].split(",");
		btnName.setText(lineData[0]);
		add(btnName);
		
		btnName.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					Thread.sleep(10000);
				} catch (InterruptedException e1)
				{
					e1.printStackTrace();
				}
				
				
				for(int i = 0; i < 3; i++)
				{
					r.keyPress(KeyEvent.VK_TAB);
					r.keyRelease(KeyEvent.VK_TAB);
				}
				
				for(int count = 1; count < lineData.length; count++)
				{
					
					lineData = line[btnCount].split(",");
					
					if(lineData[count].equals(""))
						lineData[count] = " ";
					
					
					switch(criteriaData[count])
					{
						case "Grade":	performGradeEntry(lineData[count]);
										break;
										
						case "YN":		performYesNoEntry(lineData[count]);
										break;
										
						case "Award":	performAwardEntry(lineData[count]);
										break;
										
						case "Skill":	performSkillEntry(lineData[count]);
										break;
					}
					
					try
					{
						Thread.sleep(100);
					} catch (InterruptedException e2)
					{
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				}
				
				
				try
				{
					if(btnCount < DataEntryRdBtn.countLines(str + ":\\data.txt") - 1)
					{
						btnCount++;
						lineData = line[btnCount].split(",");
						btnName.setText(lineData[0]);

					}
				} catch (IOException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});

		
		
		setVisible(true);
	}
	
	
	public void performSkillEntry(String line)
	{
		
		int i;
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
		int i;
		
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
		int i = 0;
		
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
		int i;
		
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
	
	public static int countLines(String filename) throws IOException 
	{
	    InputStream is = new BufferedInputStream(new FileInputStream(filename));
	    try {
	        byte[] c = new byte[1024];
	        int count = 0;
	        int readChars = 0;
	        boolean empty = true;
	        while ((readChars = is.read(c)) != -1) {
	            empty = false;
	            for (int i = 0; i < readChars; ++i) {
	                if (c[i] == '\n') {
	                    ++count;
	                }
	            }
	        }
	        return (count == 0 && !empty) ? 1 : ++count;
	    } finally {
	        is.close();
	    }
	}
	
	public static void main(String[] args) throws AWTException
	{
		try
		{
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException e)
		{
			e.printStackTrace();
		}
		new DataEntryRdBtn();
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

}
