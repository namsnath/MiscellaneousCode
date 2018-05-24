public class Displacement
{

	double u = 20;
	double t = 1200;
	double a = 10;
	double S = 0;
	
	public void displacement()
	{
		S = (u * t) + (0.5 * a * t * t);
		System.out.println(S + "m");
	}
	
	public static void main(String[] args)
	{
		Displacement d = new Displacement();
		d.displacement();
	}

}
