package mangvaphuongthuctrongjava.baitap;

import java.util.Arrays;
import java.util.Scanner;

public class TimGiaTriNhoNhatTrongMang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        for(int i=0;i<arr.length;i++){
            System.out.println("Element "+(i+1)+": ");
            arr[i] = Integer.parseInt(sc.nextLine());
        }
        int min =arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i]<min){
                min = arr[i];
            }
        }
        System.out.println("\n The smallest element in the array "+ arr +" is: "+min);
    }
}
