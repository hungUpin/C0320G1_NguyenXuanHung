package mangvaphuongthuctrongjava.thuchanh;

import java.util.Random;
import java.util.Scanner;

public class ArrayIndexOutOfBoundsException {
    public static void main(String[] args) {
        ArrayExample arrExample = new ArrayExample();
        Integer[] arr = arrExample.createRandom();

        Scanner sc = new Scanner(System.in);
        System.out.println("Vui lòng nhập chỉ số một phần tử bất kỳ: ");
        int x = Integer.parseInt(sc.nextLine());
        try{
            System.out.println("Giá trị của phần tử có chỉ số " + x + " là " + arr[x]);
        }catch (IndexOutOfBoundsException e){
            System.err.println("Chỉ số vượt quá giới hạn của mảng");
        }
    }
}
