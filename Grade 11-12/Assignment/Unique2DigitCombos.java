/*
 * Q6. Write a program that asks the user to enter an integer and print all unique two digit 
 * integers that can be formed using the digits of that number. For example, if the input is 
 * 1231, the output should be 12, 13, 11, 21, 23, 31, 32. [15 marks]
 */

import java.util.Scanner;

public class Unique2DigitCombos
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		int i, j, temp;

		System.out.println("Enter a number");
		int num = s.nextInt();
		
		int length = String.valueOf(num).length();	//Length of input	
		
		int[] digits = new int[length];		//Array of digits
		for(i = 0; i < length; i++)	//Parses each digit to an elemnt in array
		{
			digits[i] = num % 10;
			num = num / 10;
		}
		
		StringBuffer str = new StringBuffer("");	//For editing
		
		for(i = 0; i < length; i++)
			str.append(digits[0] + "" + digits[i] + " ");	//Appends all digits with last one
		
		for(i = -1; i < length - 1; i++)	
		{
			for(j = i - 1; j >= 0; j--)	//iterates though digits and appends with all before them
				str.append(digits[i] + "" + digits[j] + " ");	
			for(j = i + 1; j <= length - 1; j++)	//iterates though digits and appends with all after them
				str.append(digits[i] + "" + digits[j] + " ");	
		}
		
		for(i = length - 2; i >= 0; i--)
			str.append(digits[length - 1] + "" + digits[i] + " ");	//Appends first digit with all before it
		
		String[] num_str = str.toString().split(" ");	//Splits StringBuffer into numbers
		int numbers[] = new int[num_str.length];	//Array for numbers
		
		
		for(i = 0; i < numbers.length;i++)
			numbers[i] = Integer.parseInt(num_str[i]);	//Parses each String to int
		
		for(i = 0; i < numbers.length; i++)		//Sorts in ascending order
		{
			for(j = 0; j < numbers.length - 1; j++)
			{
				if(numbers[j + 1] < numbers [j]) //Change this to "Array[j + 1] > Array [j]" to sort in descending order
				{
					temp = numbers[j + 1];
					numbers[j + 1] = numbers [j];
					numbers[j] = temp;
				}
			}
		}
		
	
		int[] uniques = new int[numbers.length];	//Array of unique numbers
		
		for(i = 0; i < numbers.length; i++)	//initializes all elements to 0
		{
			uniques[i] = 0;
		}
		uniques[0] = numbers[0];
		
		for(i = 1, j = 1; i < numbers.length && j < uniques.length - 1; i++)
		{
			if(numbers[i] == uniques[j])	//Compares consecutive number with element in uniques, skips if equal
				continue;
			else
			{
				j++;	//Go to next element
				uniques[j] = numbers[i];	//Set uniques to number
			}
		}
		
		for(i = 0; i < uniques.length; i++)
			if(uniques[i] == 0)
				continue;
			else
				System.out.print(uniques[i] + " ");
		
	}

}
