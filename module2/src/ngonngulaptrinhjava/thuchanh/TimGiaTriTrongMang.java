package ngonngulaptrinhjava.thuchanh;

import java.util.Scanner;

public class TimGiaTriTrongMang {
    public static void main(String[] args) {
        String[] students = {"Nam","Toan","Linh","Kiều"};
        Scanner scan = new Scanner(System.in);
        System.out.print("Mời bạn nhập tên sinh viên để tìm kiếm: ");
        String input_name = scan.nextLine();
        boolean isExit = false;
        for(int i=0;i<students.length;i++){
            if(students[i].equals(input_name)) {
                System.out.println("Vị trí của "+input_name+" trong mảng là: " +(i+1));
                isExit = true;
                break;
            }
            }
        if(!isExit) {
            System.out.println("Không tìm thấy " +input_name +" trong mảng!!!!");
        }
        }
    }
    
