package exception;

import java.util.Scanner;

public class IDCardException extends Exception {
    public IDCardException(String s){
        super(s);
    }
    public String checkIDCard() throws IDCardException{
        Scanner sc = new Scanner(System.in);
        String idCard = sc.nextLine();
        String regex = "^[0-9]{3}\\s[0-9]{3}\\s[0-9]{3}$";
        if(idCard.matches(regex)){
            return idCard;
        }else {
            throw new IDCardException("Invalid id Card!! Must be XXX XXX XXX");
        }
    }
}
