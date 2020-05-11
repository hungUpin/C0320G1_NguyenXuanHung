package mangvaphuongthuctrongjava.baitap;

import java.util.Arrays;
import java.util.Scanner;

public class XoaPhanTuKhoiMang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = {15, 29, 35, 46, 78, -15, 152};
        int num;
        int index;
        boolean flag = false;
        do {
            System.out.println("Enter value of element to delete: ");
            num = Integer.parseInt(sc.nextLine());
            for (index = 0; index < arr.length; index++) {
                if (arr[index] == num) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                System.out.println("\n" + num + " is not existed in the array!!!");
            }
        } while (!flag);
        if (flag) {
            System.out.println(num + " is existed in the array with index: " + index);
        }
        int newArray[] = new int[arr.length - 1];
        for (int i = index; i < arr.length-1; i++) {
            arr[i] = arr[i + 1];
        }
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = arr[i];
        }
        System.out.println("The new array after deleted " + num + " at index: " + index +" is: " + newArray);
    }
}
