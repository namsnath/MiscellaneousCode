
class Person {
    String name;

    Person(String name) {
        this.name = name;
    }
}

class Student_17BCI0113 extends Person {
    String regno;

    public static void main(String args[]) {
        Student_17BCI0113 s = new Person("Namit");
        Student_17BCI0113 s1 = new Student_17BCI0113("Regno", "Name");
    }

    Student_17BCI0113(String name, String regno) {
        super(name);
        this.regno = regno;
    }
}