package ngonngulaptrinhjava.baitap;

import java.util.Scanner;

public class ChuyenDoiTienTe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rate = 23000;
        System.out.println("USD: ");
        int usd = Integer.parseInt(sc.nextLine());
        double vnd = usd*rate;
        System.out.printf("VND: %.2f",vnd);
    }
}
