package excel360DataEntry;

import java.io.File;
import java.io.IOException;

import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

public class ODSRead
{
	final Sheet Music;
	String[] MusicOA, MusicEP, MusicR, MusicD, MusicE, MusicST;
	
	public ODSRead(File Music, int num) throws IOException
	{
		MusicOA = new String[num];
		MusicEP = new String[num];
		MusicR = new String[num];
		MusicD = new String[num];
		MusicE = new String[num];
		MusicST = new String[num];
		
		this.Music = SpreadSheet.createFromFile(Music).getSheet(0);
		//System.out.println(this.Music.getCellAt("H4").getTextValue());
		
		for(int i = 4, j = 0; j < num; i++, j++)
		{
			
			MusicEP[j] = this.Music.getCellAt("H" + i).getTextValue();
			MusicR[j] = this.Music.getCellAt("K" + i).getTextValue();
			MusicD[j] = this.Music.getCellAt("N" + i).getTextValue();
			MusicE[j] = this.Music.getCellAt("Q" + i).getTextValue();
			MusicST[j] = this.Music.getCellAt("T" + i).getTextValue();
			MusicOA[j] = this.Music.getCellAt("W" + i).getTextValue();
		}
		
		//System.out.println(MusicEP[0] + "  " + MusicR[0] + "  " + MusicD[0] + "  " + MusicE[0] + "  " + MusicST[0] + "  " + MusicOA[0]);
		
	}
}
