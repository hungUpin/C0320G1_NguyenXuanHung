package ngonngulaptrinhjava.baitap;

import java.util.Scanner;

public class HienThi20SNTDauTien {
    public static Boolean KiemTraSoNguyenTo(int num){
        boolean flag = true;
        if(num<2){
            flag = false;
        }
        if(num>2){
            for( int i=2;i<Math.sqrt(num);i++){
                if(num%i==0){
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }
    public static void main(String[] args) {
        int count =0;
        int i=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Vui lòng nhập số lượng SNT muốn hiển thị: ");
        int num = Integer.parseInt(sc.nextLine());
        while (count<=num){
            if(KiemTraSoNguyenTo(i)){
                System.out.printf("%o%s",i," ");
                count++;
            }
            i++;
        }
    }
}
