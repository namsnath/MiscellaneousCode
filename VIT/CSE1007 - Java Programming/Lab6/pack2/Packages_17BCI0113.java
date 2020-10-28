package pack2;

import pack1.subpack1.Student;
import java.util.Scanner;

public class Packages_17BCI0113 {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);

        String name, phno;
        int age;

        System.out.print("Enter Name: ");
        name = s.nextLine();

        System.out.print("Enter Phone Number: ");
        phno = s.nextLine();

        System.out.print("Enter Age: ");
        age = s.nextInt();

        Student st = new Student(name, age, phno);
        st.printData();
    }
}