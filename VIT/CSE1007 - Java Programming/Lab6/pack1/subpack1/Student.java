package pack1.subpack1;
import pack1.Person;

public class Student extends Person {
    public Student(String name, int age, String phno) {
        super(name, age, phno);
    }

    public void printData() {
        System.out.println("Name: " + super.getName());
        System.out.println("Age: " + super.getAge());
        System.out.println("Phno: " + super.getPhno());
    }
}