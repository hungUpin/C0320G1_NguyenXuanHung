package mangvaphuongthuctrongjava.baitap;

import sun.security.util.ArrayUtil;

import java.util.Arrays;
import java.util.Scanner;

public class ThemPhanTuVaoMang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size;
        do{
            System.out.println("Size of the array is(max:20) : ");
            size = Integer.parseInt(sc.nextLine());
            if(size>20||size<0){
                System.out.println("Invalid size!!!!");
            }
        }while (size>20);
        int arr[] = new int[size];
        for(int i=0;i<arr.length;i++){
            System.out.println("Element "+(i+1)+" : ");
            arr[i] = Integer.parseInt(sc.nextLine());
        }
        System.out.println("Enter the number to insert: ");
        int num = Integer.parseInt(sc.nextLine());
        int index;
        do{
            System.out.print("Enter the index to insert: ");
            index = Integer.parseInt(sc.nextLine());
            if(index<=1||index>=arr.length-1){
                System.out.print("Invalid index!!!");
            }
        }while (index>=arr.length-1||index<=1);
        for(int element:arr){
            System.out.print(element + "\t");
        }
        int newArray[] = new int[arr.length+1];
        for(int i=0;i<index;i++){
            newArray[i]=arr[i];
        }
        newArray[index] = num;
        for(int i=index+1;i<newArray.length;i++){
            newArray[i] = arr[i-1];
        }
        System.out.println("The array after inserted is: "+newArray);

    }
}
