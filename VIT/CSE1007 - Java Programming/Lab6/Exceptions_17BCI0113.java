import java.util.Scanner;

class Exceptions_17BCI0113 {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        
        System.out.println("1 - Arithmetic Exception");
        System.out.println("2 - NullPointer Exception");
        System.out.println("3 - ArrayIndexOutOfBounds Exception");
        System.out.println("Enter your choice: ");
        int c = s.nextInt();

        System.out.println();

        switch(c) {
            case 1: 
            try {
                int temp = 2 / 0;
            } catch (ArithmeticException e) {
                System.out.println("Arithmetic Exception:");
                System.out.println("Thrown when an exceptional arithmetic condition has occurred. For example, an integer \"divide by zero\" throws an instance of this class.");
            }
            break;

            case 2: 
            try {
                String t = null;
                t.length();
            } catch(NullPointerException e) {
                System.out.println("NullPointer Exception:");
                System.out.println("Thrown when an application attempts to use null in a case where an object is required.");
            }
            break;

            case 3:
            try {
                int[] a = {1};
                a[2] = 1;
            } catch(ArrayIndexOutOfBoundsException e) {
                System.out.println("ArrayIndexOutOfBounds Exception:");
                System.out.println("Thrown to indicate that an array has been accessed with an illegal index. The index is either negative or greater than or equal to the size of the array.");
            }
        }
    }
}