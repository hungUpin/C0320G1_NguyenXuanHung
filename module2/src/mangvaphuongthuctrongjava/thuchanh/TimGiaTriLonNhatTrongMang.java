package mangvaphuongthuctrongjava.thuchanh;

import java.util.Scanner;

public class TimGiaTriLonNhatTrongMang {
    public static void main(String[] args) {
        int num=0;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Enter the number of size (max: 20): ");
            num = Integer.parseInt(sc.nextLine());
            if(num>20||num<=0){
                System.out.println("Invalid size");
            }
        }while (num>20);
        int[] propertyPerson = new int[num];
        for(int i=0;i<propertyPerson.length;i++){
            System.out.print("The property "+(i+1)+" :");
            propertyPerson[i] = Integer.parseInt(sc.nextLine());
        }
        System.out.println("Property list: ");
        for(int i=0;i<propertyPerson.length;i++){
            System.out.print(propertyPerson[i]+"\t");
        }
        int max = propertyPerson[0];
        for(int i=1;i<propertyPerson.length;i++){
            if(propertyPerson[i]>max){
                max = propertyPerson[i];
            }
        }
        System.out.printf("\nThe biggest property is %d",max);
    }
}
