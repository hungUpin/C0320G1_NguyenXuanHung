package mangvaphuongthuctrongjava.baitap;

import sun.security.util.ArrayUtil;

import java.util.Scanner;

public class IllegalTriangleExceptionDemo {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        System.out.println("Kiểm tra cạnh tam giác: ");
        System.out.println("Nhập cạnh thứ nhất: ");
        int a = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập cạnh thứ hai: ");
        int b = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập cạnh thứ ba: ");
        int c = Integer.parseInt(sc.nextLine());
        try{
            if(a<0||b<0||c<0||(a+b)>c||(a+c)>b||(b+c)>a){
                throw new IllegalTriangleException("Sai rồi!!!");
            }
        } catch (IllegalTriangleException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Chương trình kết thúc");
        }
    }
}
