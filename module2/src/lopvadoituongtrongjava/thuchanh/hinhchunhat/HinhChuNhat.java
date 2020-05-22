package lopvadoituongtrongjava.thuchanh.hinhchunhat;

import java.util.Scanner;

public class HinhChuNhat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter width: ");
        double width = sc.nextDouble();
        System.out.println("Enter height: ");
        double height = sc.nextDouble();
        LopHinhChuNhat rectangle = new LopHinhChuNhat(width,height);
        System.out.println("Your rectangle: "+rectangle.display());
        System.out.println("Perimeter of the Rectangle: " +rectangle.getPerimeter());
        System.out.println("Area of the Rectangle: " +rectangle.getArea());
    }
}
