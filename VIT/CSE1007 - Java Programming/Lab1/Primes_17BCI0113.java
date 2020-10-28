import java.util.Scanner;

class Primes_17BCI0113 {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter two numbers for range: ");
        int low = s.nextInt();
        int high = s.nextInt();
        boolean[] sieve = new boolean[high];

        sieve[0] = false;
        sieve[1] = false;
        for(int i = 2; i < high; i++)
            sieve[i] = true;

        for(int i = 2; i < high; i++) {
            if(sieve[i]) 
                for(int j = i * 2; j < high; j += i)
                    sieve[j] = false;
        }

        for(int i = low; i < high; i++) {
            if(sieve[i])
                System.out.print(i + " ");
        } 

        System.out.println();

        s.close();
    }
} 
 
