import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;
public class ODSReadTry
{
	Robot r = new Robot();
	File file = new File("D:\\data.ods");
	Scanner s;

	public ODSReadTry() throws AWTException, IOException
	{
		final Sheet sheet = SpreadSheet.createFromFile(file).getSheet(14);
		
		System.out.println(sheet.getCellAt("A1").getTextValue());
	}
	
	public static void main(String args[])
	{
		try
		{
			new ODSReadTry();
		} catch (AWTException | IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
