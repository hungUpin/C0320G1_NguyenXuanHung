package exception;

import java.util.Scanner;

public class NameException extends Exception {
    private static Scanner sc = new Scanner(System.in);

    public NameException(String s) {
        super(s);
    }

    public static String nameException() throws NameException {
        String customerName = sc.nextLine();
        customerName = customerName.trim();
        String temp = "";
        if (customerName.charAt(0) == Character.toUpperCase(customerName.charAt(0))) {
            temp += customerName.charAt(0);
        }else {
            throw new NameException("First character of name is not Upper Case!!!");
        }
        for (int i = 1; i < customerName.length(); i++) {
            if(customerName.charAt(i)==' '&&customerName.charAt(i+1)==' '){
                continue;
            }else {
                if (customerName.charAt(i - 1) == ' ') {
                    temp += Character.toUpperCase(customerName.charAt(i));
                } else {
                    temp += Character.toLowerCase(customerName.charAt(i));
                }
            }
        }
        if (customerName.equals(temp)) {
            return temp;
        } else {
            throw new NameException("Customer name has to uppercase every first character and has not 2 consecutive spaces .");
        }
    }

}
