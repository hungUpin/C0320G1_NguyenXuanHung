package exception;

import java.util.Scanner;

public class EmailException extends Exception {
    private static Scanner sc = new Scanner(System.in);
    public EmailException(String s){
        super(s);
    }
    public static String emailException() throws EmailException {
        String regex ="^([a-zA-Z0-9\\_\\+])+\\@([a-zA-Z0-9])+\\.([a-zA-Z0-9])+$";
        String email = sc.nextLine();
        if(email.matches(regex)){
            return email;
        }else {
            throw new EmailException("Email is not valid!!!Must be: abc@abc.com");
        }
    }
}
