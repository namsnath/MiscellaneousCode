
public class LAF_CodeGen
{

	public static void main(String[] args)
	{
		String[] lafs = {"Aluminium", "Bernstein", "Fast", "Graphite", "HiFi", "Luna", "McWin", "Mint", "Noire", "Smart", "Texture"};
		
		for(int i = 0; i < 11; i++)
		{
			System.out.println("public static void set" + lafs[i] + "(JFrame frame)");
			System.out.println("{");
			System.out.println("\ttry");
			System.out.println("\t{");
			System.out.println("\t\tProperties props = new Properties();\n\t\tprops.put(\"logoString\", \"\");\n\t\t" + lafs[i] + "LookAndFeel.setCurrentTheme(props);\n\t\tUIManager.setLookAndFeel(\"com.jtattoo.plaf.aero." + lafs[i] + "LookAndFeel\");\n\t\tSwingUtilities.updateComponentTreeUI(frame);");
			System.out.println("\t}");
			System.out.println("\tcatch(Exception e){}");
			System.out.println("}");
			System.out.println();
			

		}
	}

}
