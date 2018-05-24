package Extra;

import java.util.*;

public class ListTry
{

	public static void main(String[] args)
	{
		List list = new ArrayList<String>();
		
		list.add("a");
		list.add("abc");
		list.add("b");
		
		list.remove(1);
		
		System.out.println(list.get(0));
		System.out.println(list.get(1));
	}

}
