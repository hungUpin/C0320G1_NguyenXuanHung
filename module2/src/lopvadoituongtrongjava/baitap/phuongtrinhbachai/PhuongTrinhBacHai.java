package lopvadoituongtrongjava.baitap.phuongtrinhbachai;

import java.util.Scanner;

public class PhuongTrinhBacHai {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input a: ");
        double a = sc.nextDouble();
        System.out.println("Input b: ");
        double b = sc.nextDouble();
        System.out.println("Input c: ");
        double c = sc.nextDouble();
        QuadraticEquation quadraticEquation = new QuadraticEquation(a,b,c);
        double delta = quadraticEquation.getDiscriminant();
        if(delta>0){
            System.out.println("The equation has 2 root: "+quadraticEquation.getRoot1()+" and "+quadraticEquation.getRoot2());
        } else if(delta==0) {
            System.out.println("The equation has 1 root: "+quadraticEquation.getRoot1());
        } else {
            System.out.println("The equation has no real roots");
        }
    }
}
