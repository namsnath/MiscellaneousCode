import java.util.Scanner;

public class Arrays_17BCI0113 {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n;
        System.out.println("Enter number of elements:");
        n = s.nextInt();
        int arr[] = new int[n];

        System.out.println("Enter elements:");
        for(int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        System.out.println("Entered Array:");
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        for(int i = 0; i < n - 1; i++) {
            for(int j = 0; j < n - i - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println("Sorted Array:");
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        int noDup[] = new int[n];
        int noDupLength = 0;
        for(int i = 0; i < n - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                noDup[noDupLength++] = arr[i];
            }
        }
        noDup[noDupLength++] = arr[n - 1];

        System.out.println("No Duplicates Array:");
        for(int i = 0; i < noDupLength; i++) {
            System.out.print(noDup[i] + " ");
        }
        System.out.println();

        for(int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }

        System.out.println("Reversed Array:");
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        System.out.println("Enter element to search for:");
        int search = s.nextInt();
        int index = -1;

        for(int i = 0; i < n; i++) {
            if (arr[i] == search) {
                index = i;
                break;
            }
        }
        if(index != -1) {
            System.out.println("Element found at " + index);
        } else {
            System.out.println("Element not found");
        }
    }
}