import java.util.Scanner;

class Student {
    public String name;
    int age;
    int luckyNumber;
    protected String prefixedName;
    private String prefixedAge;

    Student(String name, int age, int luckyNumber) {
        this.name = name;
        this.age = age;
        this.luckyNumber = luckyNumber;
        this.prefixedName = luckyNumber + "" + name;
        this.prefixedAge = luckyNumber + "" + age;
    }

    String getPrefixedName() {
        return this.prefixedName;
    }

    String getPrefixedAge() {
        return this.prefixedAge;
    }
}

class LuckyNumber_17BCI0113 {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        Student st = new Student(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]));

        System.out.println("Name: " + st.name);
        System.out.println("Age: " + st.age);
        System.out.println("Lucky Number: " + st.luckyNumber);
        System.out.println("Prefixed Name: " + st.getPrefixedName());
        System.out.println("Prefixed Age: " + st.getPrefixedAge());
    }
}