package mangvaphuongthuctrongjava.baitap;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Scanner;

public class TinhTongMotCot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float[][] arr = new float[5][6];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (float) (Math.random() * 100);
            }
        }
        System.out.println("Display the array: ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%.2f%s", arr[i][j],"\t");
            }
            System.out.println();
        }
        System.out.println("Input the column to get total: ");
        int column = Integer.parseInt(sc.nextLine());
        float total = 0;
        for(int i=0;i<arr.length;i++){
            total += arr[i][column];
        }
        System.out.printf("The total of column "+column+" is: %.2f",total);
    }
}
