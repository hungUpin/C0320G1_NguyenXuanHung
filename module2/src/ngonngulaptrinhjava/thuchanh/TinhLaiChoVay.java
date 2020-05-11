package ngonngulaptrinhjava.thuchanh;

import java.util.Scanner;

public class TinhLaiChoVay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời bạn nhập số tiền gửi: ");
        double money = Double.parseDouble(sc.nextLine());
        System.out.println("Mời bạn nhập số tháng gửi: ");
        int month = Integer.parseInt(sc.nextLine());
        System.out.println("Mời bạn nhập tỷ lệ lãi suất: ");
        double interestRate = Double.parseDouble(sc.nextLine());
        double totalInterest = 0;
        for (int i = 0; i < month; i++) {
            totalInterest = money * (interestRate / 100) / 12 * month;
        }
        System.out.println("Total of interset: " + totalInterest);
    }
}
