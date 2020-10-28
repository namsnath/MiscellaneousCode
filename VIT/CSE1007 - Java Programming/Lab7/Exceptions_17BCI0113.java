/* 
Create a user defined exception class by extending exception class to handle two kind of scenario, where
(1) input cannot be negative
(2) input cannot be in the range 0 to 25
Throw object of user defined exception class and handle it by using nested try block 
with specific exceptions catch block. Also define finally block in the program.
*/
import java.util.Scanner;

class NegativeValueException extends Exception {
    public NegativeValueException() {
        super("Value provided cannot be negative");
    }
}

class RangeValueException extends Exception {
    public RangeValueException() {
        super("Value provided cannot be in range 0-25");
    }
}

class Exceptions_17BCI0113 {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int choice;

        try {
            try {
                choice = s.nextInt();
                if (choice < 0) throw new NegativeValueException();
                if (choice >= 0 && choice <= 25) throw new RangeValueException();
            } catch (NegativeValueException e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.println("Inner finally block executed");
            }
        } catch (RangeValueException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Outer finally block executed");
        }
    }
}