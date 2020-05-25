package exception;

import java.util.Scanner;

public class GenderException extends Exception {
    public GenderException(String s){
        super(s);
    }
    public static String checkGenderException() throws GenderException {
        Scanner sc = new Scanner(System.in);
        String gender = sc.nextLine();
        gender = gender.toLowerCase();
        String regex = "^male$|^female$|^unknown$";
        if(gender.matches(regex)){
            String temp="";
            temp+=Character.toUpperCase(gender.charAt(0));
            for(int i=1;i<gender.length();i++){
                temp+=Character.toLowerCase(gender.charAt(i));
            }
            return temp;
        }else {
            throw new GenderException("Gender is not valid!!!Must be female/male/unknown");
        }
    }
}
