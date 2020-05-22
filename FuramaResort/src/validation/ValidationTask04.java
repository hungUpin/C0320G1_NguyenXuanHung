package validation;

import model.Services;
import model.*;

import java.util.Scanner;

public class ValidationTask04 {
    private static String regex = "";
    private static Scanner sc = new Scanner(System.in);
    public static <T> String validateId(T abc){
        while (true){
            String id = sc.nextLine();
            if(abc instanceof Villa){
                regex = "^SVVL-[0-9]{4}$";
            } else if(abc instanceof House){
                regex = "^SVHO-[0-9]{4}$";
            } else if(abc instanceof Room){
                regex = "^SVRO-[0-9]{4}$";
            }
            if(id.matches(regex)){
                return id;
            }else {
                System.out.println("Id is not valid! Please retype id: ");
            }
        }
    }
    public static String validateNameService(){
        String nameService = sc.nextLine();
        nameService=nameService.trim();
        StringBuilder temp = new StringBuilder();
        for(int i=0;i<nameService.length();i++){
            if(nameService.charAt(i) ==' '&& nameService.charAt(i+1) ==' '){
                continue;
            }else {
                if(i==0){
                    temp.append(Character.toUpperCase(nameService.charAt(i)));
                } else {
                    temp.append(Character.toLowerCase(nameService.charAt(i)));
                }
            }
        }
        return temp.toString();
    }
    public static Double validateRentFee(){
        Double rentFee = Double.valueOf(sc.nextLine());
        while (true){
            if(rentFee>0){
                return rentFee;
            }else {
                System.out.println("Invalid rent fee!!!");
                System.out.println("Input rent fee: ");
                rentFee = Double.parseDouble(sc.nextLine());
            }
        }
    }
    public static Double validateAreaAndPoolArea(){
        while (true){
            try{
                double poolArea = Double.parseDouble(sc.nextLine());
                if(poolArea>30){
                    return poolArea;
                }
            }catch (Exception e){
                System.out.println("Invalid pool area!");
                System.out.println("Input pool area: ");
            }
        }
    }
    public static int validateNumberOfPerson(){
        while (true){
            try{
                int numofPerson = Integer.parseInt(sc.nextLine());
                if(numofPerson>0&&numofPerson<20){
                    return numofPerson;
                }
            }catch (Exception e){
                System.out.println("Invalid Number of person!");
                System.out.println("Input number of person: ");
            }
        }
    }
}
