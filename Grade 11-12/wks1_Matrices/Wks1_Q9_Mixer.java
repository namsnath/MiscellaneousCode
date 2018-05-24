package wks1_Matrices;
import java.util.Scanner;


public class Wks1_Q9_Mixer
{
	
	int n;
	int arr[];
	Scanner s = new Scanner(System.in);
	
	Wks1_Q9_Mixer (int nn)
	{
		n = nn;
		arr = new int[n];
	}
	
	
	
	public void accept()
	{
		System.out.println("Enter Elements of Array without duplicates and in ascending order");
		arr[0] = s.nextInt();
		for(int i = 1; i < n; i++)
		{
			int x = s.nextInt();
			if(x <= arr[i - 1])
			{
				System.out.println("Please enter array in ascending order only");
				System.exit(0);
			}
			arr[i] = x;
		}
	}
	
	Wks1_Q9_Mixer mix(Wks1_Q9_Mixer A)
	{
		int size = this.arr.length + A.arr.length;
		Wks1_Q9_Mixer B = new Wks1_Q9_Mixer(size);
		
		int x = 0;
		for(int i=0; i<size; i++)
		{
			if(i < A.arr.length)
				B.arr[i] = A.arr[i];
			else
			{
				B.arr[i] = this.arr[x];
				x++;
			}
		}
		
		int temp=0;
		 for(int i=0; i<size-1; i++)
		 {
			 for(int j=i+1; j<size; j++)
			 {
				 if(B.arr[i]>B.arr[j])
				 {
					 temp = B.arr[i];
					 B.arr[i] = B.arr[j];
					 B.arr[j] = temp;
				 }
			 }
		 }
		 
		 return B;
	}
	
	void display()
	{
		for(int i = 0; i < n; i++)
			System.out.print(arr[i] + "\t");
		System.out.println();
	}
	
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter size of first array");
		int p = s.nextInt();
		Wks1_Q9_Mixer obj1 = new Wks1_Q9_Mixer(p);
		obj1.accept();
		

		System.out.println("Enter size of second array");
		int q = s.nextInt();
		Wks1_Q9_Mixer obj2 = new Wks1_Q9_Mixer(q);
		obj2.accept();
		
		Wks1_Q9_Mixer obj3 = obj2.mix(obj1);
		
		System.out.println("First Array");
		obj1.display();
		

		System.out.println("Second Array");
		obj2.display();
		

		System.out.println("Merged Array");
		obj3.display();
	}

}
