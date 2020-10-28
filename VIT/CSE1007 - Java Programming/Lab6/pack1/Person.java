package pack1;

public class Person {
    private String name;
    private int age;
    private String phno;

    public Person(String name, int age, String phno) {
        this.name = name;
        this.age = age;
        this.phno = phno;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhno() {
        return phno;
    }
}