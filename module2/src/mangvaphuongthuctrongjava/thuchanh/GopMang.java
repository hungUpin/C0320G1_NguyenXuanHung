package mangvaphuongthuctrongjava.thuchanh;

import java.util.Arrays;
import java.util.Scanner;

public class GopMang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr1 = new int[6];
        int[] arr2 = new int[5];
        int[] arr3 = new int[arr1.length+arr2.length];
        for(int i=0;i<arr1.length;i++){
            System.out.print("Enter the element " +(i+1) +" of array 1:");
            arr1[i] = Integer.parseInt(sc.nextLine());
        }
        for(int i=0;i<arr2.length;i++){
            System.out.print("Enter the element " +(i+1) +" of array 2:");
            arr2[i] = Integer.parseInt(sc.nextLine());
        }
        for(int i=0;i<arr1.length;i++){
            arr3[i] = arr1[i];
        }
        int j=0;
        for(int i = arr1.length;i<arr3.length;i++){
            arr3[i]=arr2[j];
            j++;
        }
    }
}
