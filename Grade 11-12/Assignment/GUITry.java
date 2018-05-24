import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import java.awt.*;
import java.awt.event.*;


public class GUITry extends JFrame implements ActionListener
{

	JButton btn = new JButton("Add");
	JPanel pnl;
	JTextField tf1, tf2, tf3;
	JLabel lbl;
	
	double val1, val2, ans;
	
	
	public GUITry()
	{
		setTitle("GUI");
		setSize(400, 300);
		setDesign();
		
		final JTextField tf1 = new JTextField(15);
		final JTextField tf2 = new JTextField(15);
		final JTextField tf3 = new JTextField(10);
		tf3.setEditable(false);
		tf3.setText("Answer");
		
		btn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				val1 = Double.parseDouble(tf1.getText());
				val2 = Double.parseDouble(tf2.getText());
				
				ans = val1 + val2;
				
				tf3.setText(String.valueOf(ans));
			}
		});
		
		JPanel pnl = new JPanel();
		
		
		pnl.add(tf1);
		pnl.add(tf2);
		pnl.add(tf3);
		pnl.add(btn);
		add(pnl);
		
		setVisible(true);
	}

	public static void main(String[] args)
	{
		new GUITry();
	}

	public void setDesign()
	{
		try
		{
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		}
		catch (Exception e)
		{
			
		}
	}
	
	public void actionPerformed(ActionEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

}
