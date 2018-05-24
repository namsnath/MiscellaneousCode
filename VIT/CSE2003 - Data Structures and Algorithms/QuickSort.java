/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package other;

import java.util.Scanner;

/**
 *
 * @author Namit Nathwani
 */
public class QuickSort 
{
    
    int a[];
    void swap(int i, int j)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    void quicksort(int low, int high)
    {
        if(low < high)
        {
            int p = partition(low, high);
            quicksort(low, p - 1);
            quicksort(p + 1, high);
        }
    }
    
    int partition(int low, int high)
    {
        int pivot = a[high];
        int i = low - 1;
        
        for(int j = low; j < high; j++)
            if(a[j] <= pivot)
                swap(++i, j);
        
        swap(i + 1, high);
        return i + 1;
    }
    
    public static void main(String args[])
    {
        Scanner s = new Scanner(System.in);
        
        QuickSort q = new QuickSort();
        
        System.out.println("Enter n: ");
        int n = s.nextInt();
        q.a = new int[n];
        
        System.out.println("Enter elements: ");
        for(int i = 0; i < n; i++)
            q.a[i] = s.nextInt();
        
        q.quicksort(0, n - 1);
        
        System.out.println("Sorted Array: ");
        for(int i = 0; i < n; i++)
            System.out.print(q.a[i] + " ");
    }
}
