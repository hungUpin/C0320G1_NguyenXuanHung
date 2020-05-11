package ngonngulaptrinhjava.thuchanh;

import java.util.Scanner;

public class KiemTraSoNguyenTo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = sc.nextInt();
        boolean check = true;
        if(num<2){
            System.out.println("%f is not a Prime!!!");
        } else {
            int i =2;
            while (i<=Math.sqrt(num)){
                if(num%i==0){
                    check = false;
                    break;
                }
                i++;
            }
        }
        if(check){
            System.out.printf("%d is a Prime!!!",num);
        }else {
            System.out.printf("%d is not a Prime!!!",num);
        }
    }
}
