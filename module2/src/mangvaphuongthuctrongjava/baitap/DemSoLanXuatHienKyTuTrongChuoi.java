package mangvaphuongthuctrongjava.baitap;

import java.util.Scanner;

public class DemSoLanXuatHienKyTuTrongChuoi {
    public static void main(String[] args) {
        String str = "Hello CodyGym Da Nang";
        Scanner sc = new Scanner(System.in);
        char cha = 'o';
        int count = 0;
        for(int i=0;i<str.length();i++){
            if(str.toLowerCase().charAt(i)==cha){
                count++;
            }
        }
        if(count!=0){
            System.out.println("The character: "+cha+" has "+count +" display in string: "+str);
        }else {
            System.out.println("The character "+cha+" isn't existed in the string ");
        }
    }
}
