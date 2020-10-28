class GrandParent {
    String name;
    public GrandParent(String n) {
        name = n;
        System.out.println("In GrandParent class");
    }  
}

class Parent extends GrandParent {
    String name;
    public Parent(String n1, String n2) {
        super(n1);
        this.name = n2;
        System.out.println("In Parent class");
    } 
}

public class Child extends Parent {
    String name;
    public Child(String n1, String n2, String n3) {
        super(n1, n2);
        this.name = n3;
	    System.out.println("In Child class");
    }
    public static void main(String[] args) {
        Child childObject = new Child("Grand Parent", "Parent", "Child");
    } 
}