import java.util.Scanner;

class BMI_17BCI0113 {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);

        double weight, height, bmi;

        System.out.println("Enter weight (kg) and Height (cm):");
        weight = s.nextDouble();
        height = s.nextDouble();

        bmi = weight / Math.pow(height / 100, 2);

        System.out.printf("BMI is: %.2f\n", bmi);

        s.close();
    }
}