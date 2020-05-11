package ngonngulaptrinhjava.baitap;

import java.util.Scanner;

public class HienThiCacLoaiHinh {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Menu: \n"+"1.Print the rectangle\n" +
                "2.Print the square triangle\n" +
                "3.Print isosceles triangle\n" +
                "0.Exit\n"+"Enter the function: \n");
        int choose = Integer.parseInt(sc.nextLine());
        switch (choose){
            case 1:
            for(int i=0;i<3;i++){
                for(int j=0;j<6;j++){
                    System.out.print("* ");
                }
                System.out.print("\n");
            }
            break;
            case 2:
                System.out.println("square triangle bottom-left");
                for(int i=0;i<5;i++){
                    for(int j=0;j<i+1;j++){
                        System.out.print("* ");
                    }
                    System.out.print("\n");
                }
                System.out.println("square triangle top-left");
                for(int i=0;i<5;i++){
                    for(int j=5-i;j>0;j--){
                        System.out.print("* ");
                    }
                    System.out.print("\n");
                }
                break;
            case 3:
                System.out.println("isosceles triangle");
                for(int i=0;i<5;i++){
                    for(int j=0;j<5-i;j++){
                        System.out.print(" ");
                    }
                    for(int k=0;k<=i;k++){
                        System.out.print("* ");
                    }
                    System.out.print("\n");
                }
                break;
            case 0:
                System.exit(0);
            default:
                System.out.println("Invalid function!!!");
        }
    }
}
