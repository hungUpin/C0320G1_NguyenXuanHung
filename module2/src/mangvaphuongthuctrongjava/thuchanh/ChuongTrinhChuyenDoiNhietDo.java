package mangvaphuongthuctrongjava.thuchanh;

import java.util.Arrays;
import java.util.Scanner;

public class ChuongTrinhChuyenDoiNhietDo {
    public static double fahrenheitToCelsius(double fah){
        return  (5.0 / 9) * (fah - 32);
    }
    public static double celsiusToFahrenheit(double cel){
        return cel*1.8000 +32.00;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Menu\n" +
                "1. Fahrenheit to Celsius\n" +
                "2. Celsius to Fahrenheit\n" +
                "0. Exit \n"+
                "Enter the function: ");
        int choose = Integer.parseInt(sc.nextLine());
        switch (choose){
            case 1:
                System.out.println("1. Fahrenheit to Celsius:");
                System.out.println("Enter Fahrenheit: ");
                double fah = Double.parseDouble(sc.nextLine());
                System.out.println("Celsius: " +fahrenheitToCelsius(fah));
                break;
            case 2:
                System.out.println("2. Celsius to Fahrenheit:");
                System.out.println("Enter Celsius: ");
                double cel = Double.parseDouble(sc.nextLine());
                System.out.println("Celsius: " +celsiusToFahrenheit(cel));
                break;
            case 3:
                System.exit(0);
            default:
                System.out.print("Invalid function!!!");
        }
    }
}
