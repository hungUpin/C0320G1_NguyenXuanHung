package exception;

import java.time.LocalDate;
import java.util.Scanner;

public class BirthdayException extends Exception {
    public BirthdayException(String s) {
        super(s);
    }

    public static String checkBirthdayException() throws BirthdayException {
        Scanner sc = new Scanner(System.in);
        String birthday = sc.nextLine();
        String regex = "^(3[0-1]|[0-2][0-9])\\/(0[1-9]|1[1-2])\\/([1-2][0-9]{3})$";
        LocalDate date = LocalDate.now();
        int yearNow = date.getYear();
        int year = Integer.parseInt(birthday.substring(birthday.length() - 4, birthday.length()));
        boolean flag = false;
        if (birthday.matches(regex)) {
            if (year > 1900 && (yearNow - year) >= 18) {
                return birthday;
            }
        }
        throw new BirthdayException("Birthday must be DD/MM/YYYY, Year must be bigger than 1900, age must be over 18!!");
    }
}
