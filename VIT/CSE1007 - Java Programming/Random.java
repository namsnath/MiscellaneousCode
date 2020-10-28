import java.io.*;
import java.util.*;

class Random {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        String filename;
        filename = s.nextLine();

        long count = 0;
        long sum = 0;

        try {
            Scanner f = new Scanner(new File(filename));
            while (f.hasNext()) {
                String str = f.nextLine();
                String[] data = str.split(",");
                int bytes = Integer.parseInt(data[data.length - 1]);

                if (bytes > 5000) {
                    count++;
                    sum += bytes;
                }
            }
            f.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        FileWriter fw = new FileWriter("bytes_" + filename);
        fw.write(count + "\n");
        fw.write(sum + "\n");
        fw.close();
    }
}