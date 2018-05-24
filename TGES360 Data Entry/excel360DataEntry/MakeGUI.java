package excel360DataEntry;


import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

@SuppressWarnings("serial")
public class MakeGUI extends JFrame implements ActionListener
{
	
	Entry360 en = new Entry360();
	JFileChooser jfc1, jfc2, jfc3;
	JPanel pnl = new JPanel();
	JButton btnLanAb = new JButton();
	JButton btnSkill = new JButton();
	JButton btnCC = new JButton();
	JButton btnMusic = new JButton();
	int LanAbBtnCount = 0, SkillBtnCount = 0, CCBtnCount = 0, MusicBtnCount = 0;
	
	public MakeGUI() throws AWTException, IOException
	{
		jfc1 = new JFileChooser();
		jfc1.setDialogTitle("Teacher File");
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
		        "XLSX File", "xlsx");
		    jfc1.setFileFilter(filter);
		    int returnVal = jfc1.showOpenDialog(this);
		    if(returnVal == JFileChooser.APPROVE_OPTION) 
		    {
		       System.out.println("You chose to open this file: " +
		            jfc1.getSelectedFile());
		    }
		    
		    jfc2 = new JFileChooser();
		    jfc2.setDialogTitle("Art File");
			    jfc2.setFileFilter(filter);
			    returnVal = jfc2.showOpenDialog(this);
			    if(returnVal == JFileChooser.APPROVE_OPTION) 
			    {
			       System.out.println("You chose to open this file: " +
			            jfc2.getSelectedFile());
			    }
			    
			    jfc3 = new JFileChooser("");
			    jfc3.setDialogTitle("Music File");
			    filter = new FileNameExtensionFilter(
				        "ODS File", "ods");
				    jfc3.setFileFilter(filter);
				    returnVal = jfc3.showOpenDialog(this);
				    if(returnVal == JFileChooser.APPROVE_OPTION) 
				    {
				       System.out.println("You chose to open this file: " +
				            jfc3.getSelectedFile());
				    }
		
		XLSXRead read = new XLSXRead(jfc1.getSelectedFile(), jfc2.getSelectedFile(), jfc3.getSelectedFile());
		       
		ODSRead or = new ODSRead(jfc3.getSelectedFile(), read.Stu_Num);
		
		setTitle("Data Entry for 360");
		setSize(350,200);
		setLayout(new BorderLayout());
		setAlwaysOnTop(true);
		
		pnl.setLayout(new BoxLayout(pnl, BoxLayout.PAGE_AXIS));
		pnl.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		add(pnl, BorderLayout.CENTER);
		
		JLabel lbl = new JLabel("Done By: Namit Nathwani");
		add(lbl, BorderLayout.NORTH);

		btnLanAb.setText(read.Name[0] + ": Language Ability");
		pnl.add(btnLanAb);
		
		btnLanAb.addActionListener(new ActionListener()
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
				
				
				en.TripleTab();
				
				en.performGradeEntry(read.EngL[LanAbBtnCount]);
				en.performGradeEntry(read.HinL[LanAbBtnCount]);
				en.performGradeEntry(read.GujL[LanAbBtnCount]);
				
				en.performGradeEntry(read.EngS[LanAbBtnCount]);
				en.performGradeEntry(read.HinS[LanAbBtnCount]);
				en.performGradeEntry(read.GujS[LanAbBtnCount]);
				
				en.performGradeEntry(read.EngR[LanAbBtnCount]);
				en.performGradeEntry(read.HinR[LanAbBtnCount]);
				en.performGradeEntry(read.GujR[LanAbBtnCount]);
				
				en.performGradeEntry(read.EngW[LanAbBtnCount]);
				en.performGradeEntry(read.HinW[LanAbBtnCount]);
				en.performGradeEntry(read.GujW[LanAbBtnCount]);
				
				if(LanAbBtnCount < read.Stu_Num - 1)
				{
					LanAbBtnCount++;
					btnLanAb.setText(read.Name[LanAbBtnCount] + ": Language Ability");

				}
			}
			
		});
		
		
		btnSkill.setText(read.Name[0] + ": Skill - Indicators");
		pnl.add(btnSkill);
		
		btnSkill.addActionListener(new ActionListener()
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
				
				
				en.TripleTab();
				
				en.performSkillEntry(read.SkillO[SkillBtnCount]);
				en.performSkillEntry(read.SkillCC[SkillBtnCount]);
				en.performSkillEntry(read.SkillP[SkillBtnCount]);
				en.performSkillEntry(read.SkillGI[SkillBtnCount]);
				en.performSkillEntry(read.SkillID[SkillBtnCount]);
				en.performSkillEntry(read.SkillLT[SkillBtnCount]);
				
				
				if(SkillBtnCount < read.Stu_Num - 1)
				{
					SkillBtnCount++;
					btnSkill.setText(read.Name[SkillBtnCount] + ": Skill - Indicators");

				}
			}
			
		});
		
		btnCC.setText(read.Name[0] + ": Co-Curricular");
		pnl.add(btnCC);
		
		btnCC.addActionListener(new ActionListener()
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
				
				
				en.TripleTab();
				
				en.performGradeEntry(read.EngRec1[CCBtnCount]);
				en.performGradeEntry(read.EngRec2[CCBtnCount]);
				en.performGradeEntry(read.EngRec3[CCBtnCount]);
				en.performAwardEntry(read.EngRecAward[CCBtnCount]);
				
				en.performGradeEntry(read.HinRec1[CCBtnCount]);
				en.performGradeEntry(read.HinRec2[CCBtnCount]);
				en.performGradeEntry(read.HinRec3[CCBtnCount]);
				en.performAwardEntry(read.HinRecAward[CCBtnCount]);
				
				en.performGradeEntry(read.GujRec1[CCBtnCount]);
				en.performGradeEntry(read.GujRec2[CCBtnCount]);
				en.performGradeEntry(read.GujRec3[CCBtnCount]);
				en.performAwardEntry(read.GujRecAward[CCBtnCount]);
				
				en.performGradeEntry(read.EngSB1[CCBtnCount]);
				en.performGradeEntry(read.EngSB2[CCBtnCount]);
				en.performAwardEntry(read.EngSBAward[CCBtnCount]);
				
				en.performGradeEntry(read.HinSB1[CCBtnCount]);
				en.performGradeEntry(read.HinSB2[CCBtnCount]);
				en.performAwardEntry(read.HinSBAward[CCBtnCount]);
				
				en.performGradeEntry(read.GujSB1[CCBtnCount]);
				en.performGradeEntry(read.GujSB2[CCBtnCount]);
				en.performAwardEntry(read.GujSBAward[CCBtnCount]);
				
				en.performGradeEntry(read.QuizR1[CCBtnCount]);
				en.performGradeEntry(read.QuizR2[CCBtnCount]);
				en.performGradeEntry(read.QuizAvg[CCBtnCount]);
				en.performGradeEntry(read.QuizFR[CCBtnCount]);
				en.performAwardEntry(read.QuizAward[CCBtnCount]);
				
				
				en.performGradeEntry(read.ArtCD[CCBtnCount]);
				en.performGradeEntry(read.ArtSPA[CCBtnCount]);
				en.performGradeEntry(read.ArtTA[CCBtnCount]);
				en.performGradeEntry(read.ArtC[CCBtnCount]);
				en.performGradeEntry(read.ArtTC[CCBtnCount]);
				en.performGradeEntry(read.ArtO[CCBtnCount]);
				en.performGradeEntry(read.ArtMA[CCBtnCount]);
				en.performGradeEntry(read.ArtRA[CCBtnCount]);
				en.performGradeEntry(read.ArtCSA[CCBtnCount]);
				en.performGradeEntry(read.ArtOA[CCBtnCount]);
				
				if(CCBtnCount < read.Stu_Num - 1)
				{
					CCBtnCount++;
					btnCC.setText(read.Name[CCBtnCount] + ": Co-Curricular");

				}
			}
			
		});
		
	
		btnMusic.setText(read.Name[0] + ": Music");
		pnl.add(btnMusic);
		
		btnMusic.addActionListener(new ActionListener()
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
				
				
				en.TripleTab();
				
				en.performGradeEntry(or.MusicEP[MusicBtnCount]);
				en.performGradeEntry(or.MusicR[MusicBtnCount]);
				en.performGradeEntry(or.MusicD[MusicBtnCount]);
				en.performGradeEntry(or.MusicE[MusicBtnCount]);
				en.performGradeEntry(or.MusicST[MusicBtnCount]);
				en.performGradeEntry(or.MusicOA[MusicBtnCount]);
				
				
				if(MusicBtnCount < read.Stu_Num - 1)
				{
					MusicBtnCount++;
					btnMusic.setText(read.Name[MusicBtnCount] + ": Music");

				}
			}
			
		});
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
	}
	
}
