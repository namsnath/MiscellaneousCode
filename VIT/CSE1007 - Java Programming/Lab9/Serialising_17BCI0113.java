import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileWriter;
import java.io.FileReader;

class MyInfo implements Serializable {
    String regno;
    String name;
    double cgpa;
    String phno;
    String hobbies;
    String favfood;
    String favplace;

    MyInfo(String regno, String name, double cgpa, 
    String phno, String hobbies, String favfood, String favplace) {
        this.regno = regno;
        this.name = name;
        this.cgpa = cgpa;
        this.phno = phno;
        this.hobbies = hobbies;
        this.favfood = favfood;
        this.favplace = favplace;
    }

    void print() {
        System.out.format("%s,%s,%f,%s,%s,%s,%s\n", regno, name, cgpa, phno, hobbies, favfood, favplace);
    }
}

public class Serialising_17BCI0113 {
    public static void main (String args[]) throws Exception {
        MyInfo myInfo = new MyInfo(
            "17BCI0113", "Namit", 9.0, "123456789",
            "Cycling", "Pizza", "Mumbai"
        );

        MyInfo friendInfo = new MyInfo(
            "17BCI0112", "Namit2", 9.2, "987654321",
            "Reading", "Burger", "Delhi"
        );

        System.out.println("Original Objects:");
        myInfo.print();
        friendInfo.print();

        byte newLine[] = {13, 10};

        FileOutputStream fOut = new FileOutputStream("serialOutput.txt");
        ObjectOutputStream oOut = new ObjectOutputStream(fOut);

        oOut.writeObject(myInfo);
        oOut.flush();
        oOut.writeObject(friendInfo);
        oOut.flush();

        oOut.close();
        fOut.close();

        FileWriter fw = new FileWriter("normalOutput.txt");

        fw.write("17BCI0113,Namit,9.0,123456789,Cycling,Pizza,Mumbai\n");
        fw.write("17BCI0112,Namit2,9.2,987654321,Reading,Burger,Delhi");
        fw.close();


        System.out.println("\nDeserialised Objects:");
        FileInputStream fIn = new FileInputStream("serialOutput.txt");
        ObjectInputStream oIn = new ObjectInputStream(fIn);
        MyInfo myInfoRead = (MyInfo)oIn.readObject();
        MyInfo friendInfoRead = (MyInfo)oIn.readObject();

        myInfoRead.print();
        friendInfoRead.print();

        oIn.close();
        fIn.close();

        FileReader fr = new FileReader("normalOutput.txt");
        int i;

        System.out.println("\nData read from file:");
        while ((i = fr.read()) != -1)
            System.out.print((char)i);
        fr.close();
    }
}