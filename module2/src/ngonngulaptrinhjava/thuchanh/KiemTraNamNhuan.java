package ngonngulaptrinhjava.thuchanh;

import java.util.Scanner;

public class KiemTraNamNhuan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a year: ");
        boolean check = false;
        int year = Integer.parseInt(sc.nextLine());
        if(year%4==0){
            if(year%100==0){
                if(year%400==0){
                    check = true;
                }
            }else {
                check = true;
            }
        }
        if(!check){
            System.out.println(year + " is not a leap year!!!");
        } else {
            System.out.println(year + " is a leap year!!!");
        }
    }
}
