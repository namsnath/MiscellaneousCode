import java.util.*;

class CA2 {
    String name;
    int age;

    CA2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void print() {
        System.out.println(name + " - " + age);
    }
}

public class Mock_17BCI0113 {
    public static void main(String args[]) {
        ArrayList<CA2> objs = new ArrayList<CA2>();

        objs.add(new CA2("A", 10));
        objs.add(new CA2("B", 12));
        objs.add(new CA2("C", 14));

        for (CA2 o : objs) {
            o.print();
        }
    }
}