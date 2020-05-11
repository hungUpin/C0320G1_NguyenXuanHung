package ngonngulaptrinhjava.thuchanh;

import java.util.Scanner;

public class ThietKeMenuChoUngDung {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Menu\n" + "1. Draw the triangle\n" + "2. Draw the square\n" + "3. Draw the rectangle\n" +
                "0. Exit\n" + "Enter your choice: \n");
        int choose = Integer.parseInt(sc.nextLine());
        switch (choose) {
            case 1:
                System.out.println("Draw the triangle");
                for (int i = 0; i < 6; i++) {
                    for (int j = 0; j < 6 - i; j++) {
                        System.out.print("*");
                    }
                    System.out.print("\n");
                }
                break;
            case 2:
                System.out.println("Draw the square");
                for (int i = 0; i < 6; i++) {
                    for (int j = 0; j < 6; j++) {
                        System.out.print("*");
                    }
                    System.out.print("\n");
                }
                break;
            case 3:
                System.out.println("Draw the rectangle");
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 6; j++) {
                        System.out.print("*");
                    }
                    System.out.print("\n");
                }
                break;
            case 0:
                System.exit(0);
            default:
                System.out.println("No choice!");
        }
    }
}
