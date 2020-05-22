package service.impl;

import model.Services;
import model.Villa;
import service.ServiceInterface;

import java.util.Scanner;

import static validation.ValidationTask04.validateId;

public class VillaServiceImp implements ServiceInterface {
    @Override
    public Services addNewService() {
        Scanner sc = new Scanner(System.in);
        Services villa = new Villa();
        //serviceName,area,rentFee,maxNumOfPerson,typeOfRent,roomStander,otherFacilities,floorNumber
        System.out.println("Enter id");
        villa.setId(validateId(villa));
        System.out.println("Enter Villa service name: ");
        villa.setServiceName(sc.nextLine());
        System.out.println("Enter area of villa: ");
        villa.setArea(Double.parseDouble(sc.nextLine()));
        System.out.println("Enter rent fee of villa: ");
        villa.setRentFee(Double.parseDouble(sc.nextLine()));
        System.out.println("Enter max number of person: ");
        villa.setMaxNumOfPerson(Integer.parseInt(sc.nextLine()));
        System.out.println("Enter type of rent:");
        villa.setTypeOfRent(sc.nextLine());
        System.out.println("Enter room stander:");
        ((Villa) villa).setRoomStander(sc.nextLine());
        System.out.println("Enter other facilities: ");
        ((Villa) villa).setOtherFacilities(sc.nextLine());
        System.out.println("Enter pool area");
        ((Villa) villa).setPoolArea(Integer.parseInt(sc.nextLine()));
        System.out.println("Enter floor number: ");
        ((Villa) villa).setFloorNumber(Integer.parseInt(sc.nextLine()));
        return villa;
    }
}
