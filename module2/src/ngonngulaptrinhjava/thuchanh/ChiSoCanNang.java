package ngonngulaptrinhjava.thuchanh;

import java.util.Scanner;

public class ChiSoCanNang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double bmi;
        System.out.println("Your weight: ");
        double weight = sc.nextDouble();
        System.out.print("Your height: ");
        double height = sc.nextDouble();
        bmi = weight/Math.pow(height,2);
        System.out.printf("%-20s%s", "bmi", "Interpretation\n");
        if (bmi < 18)
            System.out.printf("%-20.3f%-20s", bmi, "Underweight");
        else if (bmi < 25.0)
            System.out.printf("%-20.3f%-20s", bmi, "Normal");
        else if (bmi < 30.0)
            System.out.printf("%-20.3f%-20s", bmi, "Overweight");
        else
            System.out.printf("%-20.3f%-20s", bmi, "Obese");
    }
}
