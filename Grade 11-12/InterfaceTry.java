
public class InterfaceTry implements A
{

	public static void main(String[] args)
	{
		InterfaceTry it = new InterfaceTry();
		it.calc();
	}

	@Override
	public void calc()
	{
		System.out.println("Blehhh");
	}

}

interface A
{
	void calc();
}