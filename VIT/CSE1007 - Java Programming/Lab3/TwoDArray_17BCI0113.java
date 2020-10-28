import java.util.Scanner;

class TwoDArray_17BCI0113 {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter # Rows: ");
        int r = s.nextInt();

        System.out.print("Enter # Cols: ");
        int c = s.nextInt();

        int arr[][] = new int[r][c];
        int arr2[][] = new int[r][c];

        System.out.println("Enter the elements of Array 1 row-wise: ");
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                arr[i][j] = s.nextInt();
            }
        }

        System.out.println("Enter the elements of Array 2 row-wise: ");
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                arr2[i][j] = s.nextInt();
            }
        }

        int transpose[][] = new int[c][r];
        int sumsOfRows[] = new int[r];
        int arrSum[][] = new int[r][c];
        boolean isIdentity = true;

        for(int i = 0; i < r; i++) {
            sumsOfRows[i] = 0;
            for(int j = 0; j < c; j++) {
                transpose[j][i] = arr[i][j];
                sumsOfRows[i] += arr[i][j];
                if((i == j && arr[i][j] != 1) || (i != j && arr[i][j] != 0)) 
                    isIdentity = false;
                arrSum[i][j] = arr[i][j] + arr2[i][j];
            }
        }

        if(isIdentity) {
            System.out.println("\nArray 1 is an identity matrix");
        } else {
            System.out.println("\nArray 1 is NOT an identity matrix");
        }

        System.out.println("\nTransposed Array 1:");
        for(int i = 0; i < c; i++) {
            for(int j = 0; j < r; j++) {
                System.out.print(transpose[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\nSums of Rows for Array 1:");
        for(int i = 0; i < r; i++) {
            System.out.println("Row " + i + " Sum = " + sumsOfRows[i]);
        }

        System.out.println("\nArr1 + Arr2:");
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                System.out.print(arrSum[i][j] + " ");
            }
            System.out.println();
        }
    }
}