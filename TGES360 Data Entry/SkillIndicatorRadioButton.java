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

public class SkillIndicatorRadioButton extends JFrame
{

	private static final long	serialVersionUID	= 1L;
	public JButton btnSelect = new JButton();
	public String[] line;
	public String[] lineData;
	
	int btnCount = 0;
	
	Robot r = new Robot();
	File f = new File("D:\\data.txt");
	Scanner s;
	
	public SkillIndicatorRadioButton() throws AWTException
	{
		setTitle("5 OPTIONS");
		setSize(350,125);
		setLayout(new FlowLayout());
		
		JLabel lbl = new JLabel("Done By: Namit Nathwani");
		add(lbl);
		
		JLabel lbl2 = new JLabel("Works for Skills, Attitude, Life-Skills and Work Habits");
		add(lbl2);
		
		int lineCount = 0;
		try
		{
			lineCount = SkillIndicatorRadioButton.countLines("D:\\data.txt");
		} catch (IOException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try
		{
			s = new Scanner(f);
		}
		catch(FileNotFoundException e)
		{
			JOptionPane.showMessageDialog(null, "File: data.txt was not found in D: drive");
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
		
		line = new String[lineCount];
		
		for(int i = 0; i < lineCount - 1; i++)
			line[i] = s.nextLine();
		
		
		//line[0] = s.nextLine();
		lineData = line[0].split(",");
		btnSelect.setText(lineData[0]);
		add(btnSelect);
		
		btnSelect.addActionListener(new ActionListener()
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
					
					performSkills(lineData[count]);
						
					doubleTab();
					
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
					if(btnCount < SkillIndicatorRadioButton.countLines("D:\\data.txt") - 1)
					{
						btnCount++;
						lineData = line[btnCount].split(",");
						btnSelect.setText(lineData[0]);

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
	
	public static void main(String[] args) throws AWTException
	{
		new SkillIndicatorRadioButton();
	}
	
	public void performSkills(String line)
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
	
	public void doubleTab()
	{
		for(int i = 0; i < 2; i++)
		{
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
		}
	}
	
}
