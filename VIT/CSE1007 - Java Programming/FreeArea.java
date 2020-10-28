import java.util.*;
class FreeArea {
    public static void main(String args[]) {
        int n = 3;
        int s0 = 2;
        int k = 3;
        int b = 3;
        int m = 2;
        long a;

        int list[] = new int[n]; 
        for(int i = 1; i < n; i++) {
            list.add(
                (((k * list[i-1]) + b) % m) + 1 + list[i-1]);
        }

        for(int i = 0; i < n; i++) {
            
        }


    }
}