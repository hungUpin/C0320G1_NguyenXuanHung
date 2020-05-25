package validation;

import model.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class ValidationTask04 {
    private static String regex = "";
    private static Scanner sc = new Scanner(System.in);

    public static <T> String validateId(T abc) {
        while (true) {
            String id = sc.nextLine();
            if (abc instanceof Villa) {
                regex = "^SVVL-[0-9]{4}$";
            } else if (abc instanceof House) {
                regex = "^SVHO-[0-9]{4}$";
            } else if (abc instanceof Room) {
                regex = "^SVRO-[0-9]{4}$";
            }
            if (id.matches(regex)) {
                return id;
            } else {
                System.out.println("Id is not valid! Please retype id: ");
            }
        }
    }

    public static String standardizedName() {
        String nameService = sc.nextLine();
        nameService = nameService.trim();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < nameService.length(); i++) {
            if (nameService.charAt(i) == ' ' && nameService.charAt(i + 1) == ' ') {
                continue;
            } else {
                if (i == 0) {
                    temp.append(Character.toUpperCase(nameService.charAt(i)));
                } else {
                    temp.append(Character.toLowerCase(nameService.charAt(i)));
                }
            }
        }
        return temp.toString();
    }

    public static Double validateRentFee() {
        while (true) {
            try {
                Double rentFee = Double.parseDouble(sc.nextLine());
                if (rentFee > 0) {
                    return rentFee;
                } else {
                    System.out.println("Invalid rent fee!!!");
                    System.out.println("Input rent fee: ");
                }
            } catch (Exception e) {
                System.out.println("Invalid rent fee!!!");
                System.out.println("Enter to continue");
                sc.nextLine();
            }
        }
    }

    public static Double validateAreaAndPoolArea() {
        while (true) {
            try {
                double poolArea = Double.parseDouble(sc.nextLine());
                if (poolArea > 30) {
                    return poolArea;
                } else {
                    System.out.println("Area has to bigger than 30!!!");
                }
            } catch (Exception e) {
                System.out.println("Invalid area!");
                System.out.println("Enter to continue");
                sc.nextLine();
            }
        }
    }

    public static int validateNumberOfPerson() {
        while (true) {
            try {
                int numofPerson = Integer.parseInt(sc.nextLine());
                if (numofPerson > 0 && numofPerson < 20) {
                    return numofPerson;
                } else {
                    System.out.println("Number of person has to between 0 and 20!!!");
                    System.out.println("Input number of person:");
                }
            } catch (Exception e) {
                System.out.println("Invalid Number of person!");
                System.out.println("Enter to continue");
                sc.nextLine();
            }
        }
    }

    public static int validatFloorNumber() {
        while (true) {
            try {
                int floorNumber = Integer.parseInt(sc.nextLine());
                if (floorNumber > 0) {
                    return floorNumber;
                } else {
                    System.out.println("Floor number has to more than 0!!");
                }
            } catch (Exception e) {
                System.out.println("Invalid Floor Number!");
                System.out.println("Enter to continue");
                sc.nextLine();
            }
        }
    }

    public static String validateServiceIncluded() {
        while (true) {
            try {
                String serviceIncluded = sc.nextLine();
                String[] test = {"massage", "karaoke", "food", "drink", "car"};
                String[] splitdata = serviceIncluded.split(",");
                String temp = "";
                for (int i = 0; i < splitdata.length; i++) {
                    if (Arrays.stream(test).anyMatch(splitdata[i].trim()::equals)) {
                        if (i != (splitdata.length - 1)) {
                            temp += splitdata[i].trim()+ "- ";
                        } else {
                            temp += splitdata[i].trim();
                        }
                    } else {
                        temp = "";
                        break;
                    }
                }
                if (temp != "") {
                    return temp;
                } else {
                    System.out.println("ServiceIncluded is not valid!!!");
                    System.out.println("Input service included: (massage, karaoke, food, drink, car)");
                }
            } catch (Exception e) {
                System.out.println("Invalid service include!");
                System.out.println("Enter to continue");
                sc.nextLine();
            }
        }
    }

    public static String validateDayOfBirth() {
        while (true) {
            String dayOfBirth = sc.nextLine();
            regex = "^[0-9]{2}\\/[0-9]{2}\\/[0-9]{4}$";
            LocalDate date = LocalDate.now();
            int yearNow = date.getYear();
            if (dayOfBirth.matches(regex)) {
                String temp = "";
                int year = Integer.parseInt(dayOfBirth.substring(dayOfBirth.length() - 4, dayOfBirth.length()));
                if (yearNow - year >= 18) {
                    return dayOfBirth;
                }
            }
            System.out.println("Invalid day of birth!!");
            System.out.println("Input day of birth: ");
        }
    }
}
