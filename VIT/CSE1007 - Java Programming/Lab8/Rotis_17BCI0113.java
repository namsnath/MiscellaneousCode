import java.util.concurrent.ThreadLocalRandom;
import java.util.LinkedList;

public class Rotis_17BCI0113 {
    public static void main(String args[]) throws InterruptedException {
        final People p = new People();
        Thread t1 = new Thread(new Runnable() { 
            @Override
            public void run() 
            { 
                try { 
                    p.mum(); 
                } 
                catch (InterruptedException e) { 
                    e.printStackTrace(); 
                } 
            } 
        }); 
  
        // Create consumer thread 
        Thread t2 = new Thread(new Runnable() { 
            @Override
            public void run() 
            { 
                try { 
                    p.child(); 
                } 
                catch (InterruptedException e) { 
                    e.printStackTrace(); 
                } 
            } 
        }); 
  
        // Start both threads 
        t1.start(); 
        t2.start(); 
  
        // t1 finishes before t2 
        t1.join(); 
        t2.join(); 
    }
}

class People {
    LinkedList<Integer> rotis = new LinkedList<>();
    int capacity = 10;

    public void mum() throws InterruptedException {
        int i = 0;
        while(true) {
            synchronized(this) {
                while (rotis.size() == capacity)
                    wait();

                System.out.println("Roti prepd: " + i);
                rotis.add(i++);
                notify();
                wait();
                Thread.sleep(ThreadLocalRandom.current().nextInt(0, 500));
            }
        }
    }

    public void child() throws InterruptedException {
        while(true) {
            synchronized(this) {
                while(rotis.size() == 0)
                    wait();

                int val = rotis.removeFirst();
                System.out.println("Roti eaten: " + val);
                notify();
                wait();
                Thread.sleep(ThreadLocalRandom.current().nextInt(0, 500));
            }
        }
    }
}