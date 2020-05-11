package mangvaphuongthuctrongjava.thuchanh;

import java.util.Arrays;
import java.util.Scanner;

public class TimPhanTuLonNhatTrongMang02Chieu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[10][10];
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                arr[i][j] = (int) Math.floor(Math.random()*100);
            }
        }
        int max = arr[0][0];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(max<arr[i][j]){
                    max = arr[i][j];
                }
            }
        }
        for(int i=0;i<arr.length;i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("The biggest element in the array is: " +max);
    }
}
