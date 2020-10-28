import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class EventThreads_17BCI0113 extends Thread {

    static int[] choices;
    static int[] counts;
    static AtomicInteger n;

    public static void main(String args[]) {
        choices = new int[1000];
        counts = new int[6];

        for (int i = 0; i < 1000; i++)
            choices[i] = ThreadLocalRandom.current().nextInt(0, 6);

        for (int i = 0; i < 6; i++)
            counts[i] = 0;

        n = new AtomicInteger(-1);

        EventThreads_17BCI0113 threads[] = new EventThreads_17BCI0113[6];
        for(int i = 0; i < 6; i++) {
            threads[i] = new EventThreads_17BCI0113();
            threads[i].start();
        }

        int total = 0;
        for(int i = 0; i < 6; i++)
            total += counts[i];

        System.out.println("Unregistered: " + counts[0]);
        System.out.println("Event 1: " + counts[1]);
        System.out.println("Event 2: " + counts[2]);
        System.out.println("Event 3: " + counts[3]);
        System.out.println("Event 4: " + counts[4]);
        System.out.println("Event 5: " + counts[5]);
        System.out.println("Total: " + total);
    }

    public void run() {
        int index = n.incrementAndGet();
        while (index < 1000) {
            synchronized(counts) {
                counts[choices[index]]++;
            }
            index = n.incrementAndGet();
        }
    }
}