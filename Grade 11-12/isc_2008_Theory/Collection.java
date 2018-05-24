package isc_2008_Theory;
import java.util.Scanner;
public class Collection
{

	int arr[];
	int len;
	
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter length of array 1");
		int n = s.nextInt();
		Collection c = new Collection(n);
		c.inparr();
		
		System.out.println("Enter length of array 2");
		int m = s.nextInt();
		Collection c2 = new Collection(m);
		c2.inparr();
		
		c.common(c2);
		
		
	}

	Collection()
	{
		
	}
	
	Collection(int length)
	{
		len = length;
		arr = new int[len];
	}
	
	void inparr()
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Elemnts");
		for(int i = 0; i < len; i++)
			arr[i] = s.nextInt();
		
	}
	
	Collection common(Collection c)
	{
		Collection cmn = new Collection((this.arr.length > c.arr.length) ? c.arr.length : this.arr.length);
		int k = 0;
		if(this.arr.length > c.arr.length)
		{
			for(int i = 0; i < c.len; i++)
			{
				for(int j = 0; j < this.len; j++)
					if(c.arr[i] == this.arr[j])
					{
						cmn.arr[k] = c.arr[i];
						k++;
						break;
					}
			}
		}
		else
		{
			for(int i = 0; i < this.len; i++)
			{
				for(int j = 0; j < c.len; j++)
					if(this.arr[i] == c.arr[j])
					{
						cmn.arr[k] = this.arr[i];
						k++;
						break;
					}
			}
		}
		
		cmn.arrange();
		cmn.display();
		
		return cmn;
	}
	
	void arrange()
	{
		for(int i = 0; i < this.len; i++)
			for(int j = 0; j < this.len - 1; j++)
				if(this.arr[j] > this.arr[j+ 1])
				{
					int temp = this.arr[j];
					this.arr[j] = this.arr[j + 1];
					this.arr[j + 1] = temp;
				}
	}
	
	void display()
	{
		System.out.println("Sorted Common Array");
		for(int i = 0; i < this.len; i++)
		{
			if(this.arr[i] == 0)
				continue;
			else
				System.out.print(this.arr[i] + "  ");
		}
	}
	
}
