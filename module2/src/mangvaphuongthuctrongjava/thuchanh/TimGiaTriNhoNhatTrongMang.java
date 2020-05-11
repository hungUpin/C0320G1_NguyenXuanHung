package mangvaphuongthuctrongjava.thuchanh;

import java.util.Arrays;
import java.util.Scanner;

public class TimGiaTriNhoNhatTrongMang {
    public static void main(String[] args) {
        int[] arr = new int[5];
        Scanner sc = new Scanner(System.in);
        for(int i =0;i<arr.length;i++){
            System.out.println("Element "+(i+1)+": ");
            arr[i] = Integer.parseInt(sc.nextLine());
        }
        int min = arr[0];
        for(int i=1;i<arr.length;i++){
            if(min>arr[i]){
                min = arr[i];
            }
        }
        //display array:
        for(int element:arr){
            System.out.print(element+"\t");
        }
        System.out.println("\nThe smallest element in the array: "+ arr +" is: " +min);
    }
}
