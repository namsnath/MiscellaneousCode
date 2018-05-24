package excel360DataEntry;
import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class XLSXRead
{

	
	int i, j, k, l;
	
	int Stu_Num = 0;
	String[] Name;
	String[] EngRec1, EngRec2, EngRec3, EngRecAward, EngSB1, EngSB2, EngSBAward, EngL, EngS, EngR, EngW;
	String[] HinRec1, HinRec2, HinRec3, HinRecAward, HinSB1, HinSB2, HinSBAward, HinL, HinS, HinR, HinW;
	String[] GujRec1, GujRec2, GujRec3, GujRecAward, GujSB1, GujSB2, GujSBAward, GujL, GujS, GujR, GujW;
	String[] QuizR1, QuizR2, QuizAvg, QuizFR, QuizAward;
	String[] ArtOA, ArtCD, ArtSPA, ArtTA, ArtC, ArtTC, ArtO, ArtMA, ArtRA, ArtCSA;
	String[] SkillO, SkillCC, SkillP, SkillGI, SkillID, SkillLT;
	
	
	FileInputStream fis;
	Workbook wb;
	Sheet English;
	Sheet Hindi;
	Sheet Gujarati;
	//Sheet Math_Asset;
	Sheet EVS_Quiz;
	Sheet Art_Music;
	//Sheet Att_Chess;
	Sheet Skills;
	//Sheet Overall;
	//Sheet ThreeStar;
	//Sheet PG;
	
	Sheet Art;

	Row row;
	Cell cell;
	
	public XLSXRead() 
	{
		
	}
	
	public XLSXRead(File Teacher, File Art, File Music) throws AWTException, IOException
	{	
		try
		{
			fis = new FileInputStream(Teacher);
			wb = new XSSFWorkbook(fis);
			English = wb.getSheetAt(0);
			Hindi = wb.getSheetAt(1);
			Gujarati = wb.getSheetAt(2);
			//Math_Asset = wb.getSheetAt(3);
			EVS_Quiz = wb.getSheetAt(4);
			Art_Music = wb.getSheetAt(5);
			//Att_Chess = wb.getSheetAt(6);
			Skills = wb.getSheetAt(7);
			//Overall = wb.getSheetAt(8);
			//ThreeStar = wb.getSheetAt(9);
			//PG = wb.getSheetAt(10);
			
			
			fis = new FileInputStream(Art);
			wb = new XSSFWorkbook(fis); 
			this.Art = wb.getSheetAt(0);
			
			
		}
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		
			//To Count number of Students
			for(i = 4; i < 27; i++)
			{
				row = English.getRow(i);
				cell = row.getCell(3);
				
				if(cell.getCellType() == 1)	//Text has value 1, Numeric: 3, By default empty cells formatted as Numeric, we need text
					Stu_Num++;				
				else
					break;;
			}
			
			
			
			Name = new String[Stu_Num];
			EngRec1 = new String[Stu_Num];
			EngRec2 = new String[Stu_Num];
			EngRec3 = new String[Stu_Num];
			EngRecAward = new String[Stu_Num];
			EngSB1 = new String[Stu_Num];
			EngSB2 = new String[Stu_Num];
			EngSBAward = new String[Stu_Num];
			EngL = new String[Stu_Num];
			EngS = new String[Stu_Num];
			EngR = new String[Stu_Num];
			EngW = new String[Stu_Num];
			HinRec1 = new String[Stu_Num];
			HinRec2 = new String[Stu_Num];
			HinRec3 = new String[Stu_Num];
			HinRecAward = new String[Stu_Num];
			HinSB1 = new String[Stu_Num];
			HinSB2 = new String[Stu_Num];
			HinSBAward = new String[Stu_Num];
			HinL = new String[Stu_Num];
			HinS = new String[Stu_Num];
			HinR = new String[Stu_Num];
			HinW = new String[Stu_Num];
			GujRec1 = new String[Stu_Num];
			GujRec2 = new String[Stu_Num];
			GujRec3 = new String[Stu_Num];
			GujRecAward = new String[Stu_Num];
			GujSB1 = new String[Stu_Num];
			GujSB2 = new String[Stu_Num];
			GujSBAward = new String[Stu_Num];
			GujL = new String[Stu_Num];
			GujS = new String[Stu_Num];
			GujR = new String[Stu_Num];
			GujW = new String[Stu_Num];
			QuizR1 = new String[Stu_Num];
			QuizR2 = new String[Stu_Num];
			QuizAvg = new String[Stu_Num];
			QuizFR = new String[Stu_Num];
			QuizAward = new String[Stu_Num];
			SkillO = new String[Stu_Num];
			SkillCC = new String[Stu_Num];
			SkillP = new String[Stu_Num];
			SkillGI = new String[Stu_Num];
			SkillID = new String[Stu_Num];
			SkillLT = new String[Stu_Num];
			ArtOA = new String[Stu_Num];
			ArtCD = new String[Stu_Num];
			ArtSPA = new String[Stu_Num];
			ArtTA = new String[Stu_Num];
			ArtC = new String[Stu_Num];
			ArtTC = new String[Stu_Num];
			ArtO = new String[Stu_Num];
			ArtMA = new String[Stu_Num];
			ArtRA = new String[Stu_Num];
			ArtCSA = new String[Stu_Num];
			
			
			for(i = 4, j = 0, k = 33, l = 61; j < Stu_Num; i++, j++, k++, l++)
			{
				Name[j] = English.getRow(i).getCell(3).getStringCellValue();
			
				EngRec1[j] = English.getRow(k).getCell(7).getStringCellValue();
				EngRec2[j] = English.getRow(k).getCell(11).getStringCellValue();
				EngRec3[j] = English.getRow(k).getCell(15).getStringCellValue();
				EngRecAward[j] = English.getRow(k).getCell(18).getStringCellValue();
			
				EngSB1[j] = English.getRow(k).getCell(22).getStringCellValue();
				EngSB2[j] = English.getRow(k).getCell(26).getStringCellValue();
				EngSBAward[j] = English.getRow(k).getCell(29).getStringCellValue();
			
				EngL[j] = English.getRow(l).getCell(7).getStringCellValue();
				EngS[j] = English.getRow(l).getCell(10).getStringCellValue();
				EngR[j] = English.getRow(l).getCell(13).getStringCellValue();
				EngW[j] = English.getRow(l).getCell(16).getStringCellValue();
			
				
				
				HinRec1[j] = Hindi.getRow(k).getCell(7).getStringCellValue();
				HinRec2[j] = Hindi.getRow(k).getCell(11).getStringCellValue();
				HinRec3[j] = Hindi.getRow(k).getCell(15).getStringCellValue();
				HinRecAward[j] = Hindi.getRow(k).getCell(18).getStringCellValue();
				
				HinSB1[j] = Hindi.getRow(k).getCell(22).getStringCellValue();
				HinSB2[j] = Hindi.getRow(k).getCell(26).getStringCellValue();
				HinSBAward[j] = Hindi.getRow(k).getCell(29).getStringCellValue();
				
				HinL[j] = Hindi.getRow(l).getCell(7).getStringCellValue();
				HinS[j] = Hindi.getRow(l).getCell(10).getStringCellValue();
				HinR[j] = Hindi.getRow(l).getCell(13).getStringCellValue();
				HinW[j] = Hindi.getRow(l).getCell(16).getStringCellValue();
				
				
				
				GujRec1[j] = Gujarati.getRow(k).getCell(7).getStringCellValue();
				GujRec2[j] = Gujarati.getRow(k).getCell(11).getStringCellValue();
				GujRec3[j] = Gujarati.getRow(k).getCell(15).getStringCellValue();
				GujRecAward[j] = Gujarati.getRow(k).getCell(18).getStringCellValue();
				
				GujSB1[j] = Gujarati.getRow(k).getCell(22).getStringCellValue();
				GujSB2[j] = Gujarati.getRow(k).getCell(26).getStringCellValue();
				GujSBAward[j] = Gujarati.getRow(k).getCell(29).getStringCellValue();
				
				GujL[j] = Gujarati.getRow(l).getCell(7).getStringCellValue();
				GujS[j] = Gujarati.getRow(l).getCell(10).getStringCellValue();
				GujR[j] = Gujarati.getRow(l).getCell(13).getStringCellValue();
				GujW[j] = Gujarati.getRow(l).getCell(16).getStringCellValue();
				
			}
			
			
			for(i = 32, j = 0; j < Stu_Num; i++, j++)
			{
				QuizR1[j] = EVS_Quiz.getRow(i).getCell(7).getStringCellValue();
				QuizR2[j] = EVS_Quiz.getRow(i).getCell(10).getStringCellValue();
				QuizAvg[j] = EVS_Quiz.getRow(i).getCell(13).getStringCellValue();
				QuizFR[j] = EVS_Quiz.getRow(i).getCell(17).getStringCellValue();
				QuizAward[j] = EVS_Quiz.getRow(i).getCell(20).getStringCellValue();
			}
			
			
			for(i = 3, j = 0; j < Stu_Num; i++, j++)
			{
				SkillO[j] = Skills.getRow(i).getCell(12).getStringCellValue();
				SkillCC[j] = Skills.getRow(i).getCell(20).getStringCellValue();
				SkillP[j] = Skills.getRow(i).getCell(28).getStringCellValue();
				SkillGI[j] = Skills.getRow(i).getCell(36).getStringCellValue();
				SkillID[j] = Skills.getRow(i).getCell(44).getStringCellValue();
				SkillLT[j] = Skills.getRow(i).getCell(52).getStringCellValue();
			}
			
		
			for(i = 4, j = 0; j < Stu_Num; i++, j++)
			{
				ArtCD[j] = this.Art.getRow(i).getCell(7).getStringCellValue();
				ArtSPA[j] = this.Art.getRow(i).getCell(10).getStringCellValue();
				ArtTA[j] = this.Art.getRow(i).getCell(13).getStringCellValue();
				ArtC[j] = this.Art.getRow(i).getCell(16).getStringCellValue();
				ArtTC[j] = this.Art.getRow(i).getCell(19).getStringCellValue();
				ArtO[j] = this.Art.getRow(i).getCell(22).getStringCellValue();
				ArtMA[j] = this.Art.getRow(i).getCell(25).getStringCellValue();
				ArtRA[j] = this.Art.getRow(i).getCell(28).getStringCellValue();
				ArtCSA[j] = this.Art.getRow(i).getCell(31).getStringCellValue();
				ArtOA[j] = this.Art.getRow(i).getCell(34).getStringCellValue();
			}
		
	}
	
	public static void main(String[] args) throws AWTException, IOException
	{
		MakeGUI m = null;
		try
		{
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException e)
		{
			e.printStackTrace();
		}
		
		
		try
		{
			m = new MakeGUI();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(m,
				    e.getMessage(),
				    "Error",
				    JOptionPane.ERROR_MESSAGE);
			
			System.exit(0);
		}
	}

}
