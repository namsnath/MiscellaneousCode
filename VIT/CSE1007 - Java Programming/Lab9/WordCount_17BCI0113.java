import java.io.File;
import java.util.Scanner;

public class WordCount_17BCI0113 {
    public static void main (String args[]) {
        try {
            Scanner sc = new Scanner(new File("wordCount.txt"));

            int codeCount = 0, nameCount = 0;

            while (sc.hasNext()) {
                String s = sc.next();
                if (s.equals("CSE1007"))
                    codeCount++;

                if (s.equals("JAVA"))
                    nameCount++;
            }

            System.out.println("CSE1007: " + codeCount);
            System.out.println("JAVA: " + nameCount);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}