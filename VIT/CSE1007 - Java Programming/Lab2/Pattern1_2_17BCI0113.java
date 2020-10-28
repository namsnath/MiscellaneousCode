import java.util.Scanner;

class Pattern1_2_17BCI0113 {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n;

        System.out.println("Enter n:");
        n = s.nextInt();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();

        for(int i = n; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}