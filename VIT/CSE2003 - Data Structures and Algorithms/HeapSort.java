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
public class HeapSort 
{
    int a[];
    public static void main(String args[])
    {
        Scanner s = new Scanner(System.in);
        
        HeapSort h = new HeapSort();
        
        System.out.println("Enter n: ");
        int n = s.nextInt();
        h.a = new int[n];
        
        System.out.println("Enter elements: ");
        for(int i = 0; i < n; i++)
            h.a[i] = s.nextInt();
        
        h.heapsort(n);
        
        System.out.println("Sorted Array: ");
        for(int i = 0; i < n; i++)
            System.out.print(h.a[i] + " ");
    }
    
    void heapify(int n, int i)
    {
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;
        
        if(l < n && a[l] > a[largest])
            largest = l;
        if(r < n && a[r] > a[largest])
            largest = r;
        
        if(largest != i)
        {
            swap(largest, i);
            
            heapify(n, largest);
        }
    }
    
    void heapsort(int n)
    {
        for(int i = n/2 - 1; i >= 0; i--)
            heapify(n, i);
        
        for(int i = n - 1; i >= 0; i--)
        {
            swap(0, i);
            heapify(i, 0);
        }
    }
    
    void swap(int l, int r)
    {
        int temp = a[l];
        a[l] = a[r];
        a[r] = temp;
    }
}
