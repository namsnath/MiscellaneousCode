import java.util.Scanner;

class Fibonacci_17BCI0113 {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter n to generate Fibonacci series: ");
        int n = s.nextInt();
        int a = 0, b = 1, c;

        System.out.print(a + " ");
        System.out.print(b + " ");
        for(int i = 0; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
            System.out.print(c + " ");
        }
        System.out.println();

        s.close();
    }
} 
