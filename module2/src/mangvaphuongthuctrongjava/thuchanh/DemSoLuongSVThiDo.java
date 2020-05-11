package mangvaphuongthuctrongjava.thuchanh;

import java.util.Scanner;

public class DemSoLuongSVThiDo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] diemSinhVien;
        int size;
        do{
            System.out.println("Enter size of the array:");
            size = Integer.parseInt(sc.nextLine());
            if(size>30){
                System.out.println("Size could not be largest than 30");
            }
        }while (size>30);
        diemSinhVien = new int[size];
        for(int i=0;i<diemSinhVien.length;i++){
            System.out.print("Điểm sinh viên thứ "+(i+1)+": ");
            diemSinhVien[i] = Integer.parseInt(sc.nextLine());
        }
        System.out.println("Danh sách điểm sinh viên: ");
        for(int element:diemSinhVien){
            System.out.print(element+"\t");
        }
        int count=0;
        for(int i=0;i<diemSinhVien.length;i++){
            if(diemSinhVien[i]>=5){
                count++;
            }
        }
        System.out.println("\nCó "+count+" sinh viên thi đỗ");
    }
}
