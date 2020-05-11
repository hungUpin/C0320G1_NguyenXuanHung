package mangvaphuongthuctrongjava.thuchanh;

import java.util.Scanner;

public class DaoNguocGiaTriTrongMang {
    public static void reserveArray(int arr[]){
        for(int i=0;i<arr.length/2;i++){
            int temp = arr[i];
            arr[i]=arr[arr.length-1-i];
            arr[arr.length-1-i] = temp;
        }
    }
    public static void main(String[] args) {
        int size;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Enter the size of the array: 'Max: 20'");
            size = Integer.parseInt(sc.nextLine());
            if(size>20){
                System.out.println("Invalid size!!!");
            }
        }while (size>20);
        int arr[] = new int[size];
        int i =0;
        while (i<size){
            System.out.println("The element " +(i+1) +" :");
            arr[i] = Integer.parseInt(sc.nextLine());
            i++;
        }
        System.out.printf("%-20s", "Element in the array: ");
        for(int j=0;j<arr.length;j++){
            System.out.print("Element "+(j+1) + ": " +arr[j] +"\t");
        }
        reserveArray(arr);
        System.out.printf("\n%-20s", "Element in the array after reversed: ");
        for(int j=0;j<arr.length;j++){
            System.out.print("Element "+(j+1)+ ": " +arr[j] +"\t");
        }
    }
}
