import java.util.Scanner;

public class Pattern4_17BCI0113 {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter n:");
        int n = s.nextInt();

        for (int i = n; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            for (int j = 0; j < 2 * (n - i); j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            for (int j = 0; j < 2 * (n - i - 1); j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("Variation 2");

        for (int i = n; i > 0; i--) {
            if (i == n) {
                for (int j = 0; j < 2 * n - 1; j++) {
                    System.out.print("*");
                }
            } else {
                for (int j = 0; j < i; j++) {
                    System.out.print("*");
                }
                for (int j = 0; j < (2*n - 2*i - 1); j++) {
                    System.out.print(" ");
                }
                for (int j = 0; j < i; j++) {
                    System.out.print("*");
                }
            }
            System.out.println();
        }

        for (int i = 1; i < n; i++) {
            if (i == n - 1) {
                for (int j = 0; j < 2 * n - 1; j++) {
                    System.out.print("*");
                }
            } else {
                for (int j = 0; j <= i; j++) {
                    System.out.print("*");
                }
                for (int j = 0; j < (n - i - 1); j++) {
                    System.out.print(" ");
                }
                for (int j = 0; j <= i; j++) {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}