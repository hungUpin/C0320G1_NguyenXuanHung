package ngonngulaptrinhjava.thuchanh;

import java.util.Scanner;

public class KiemTraUCLN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input first number: ");
        int first = Integer.parseInt(sc.nextLine());
        System.out.println("Input second number: ");
        int second = Integer.parseInt(sc.nextLine());
        first = Math.abs(first);
        second = Math.abs(second);
        if(first==0&&second==0){
            System.out.println("No greatest common factor");
        } else {
            if(first==0){
                System.out.println("The greatest common factor" +second);
            }
            if(second==0){
                System.out.println("The greatest common factor" +first);
            }
        }
        while (first!=second){
            if(first>second){
                first -= second;
            } else {
                second -= first;
            }
        }
        System.out.println("Greatest common factor: " + first);
    }
}
