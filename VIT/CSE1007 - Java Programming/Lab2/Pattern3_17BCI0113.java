import java.util.Scanner;

public class Pattern3_17BCI0113 {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter n:");
        int n = s.nextInt();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            for(int j = 0; j < 2 * (n - i - 1); j++) {
                System.out.print(" ");
            }
            for(int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i = n - 1; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                System.out.print("*");
            }
            for(int j = 0; j < 2 * (n - i); j++) {
                System.out.print(" ");
            }
            for(int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}