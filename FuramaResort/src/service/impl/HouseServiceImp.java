package service.impl;

import model.House;
import model.Services;
import service.ServiceInterface;

import java.util.Scanner;

public class HouseServiceImp implements ServiceInterface {
    @Override
    public Services addNewService() {
        Scanner sc = new Scanner(System.in);
        Services house = new House();
        System.out.println("Enter id");
        house.setId(sc.nextLine());
        System.out.println("Enter House service name: ");
        house.setServiceName(sc.nextLine());
        System.out.println("Enter area of house: ");
        house.setArea(Double.parseDouble(sc.nextLine()));
        System.out.println("Enter rent fee of house: ");
        house.setRentFee(Double.parseDouble(sc.nextLine()));
        System.out.println("Enter max number of person: ");
        house.setMaxNumOfPerson(Integer.parseInt(sc.nextLine()));
        System.out.println("Enter type of rent:");
        house.setTypeOfRent(sc.nextLine());
        System.out.println("Enter room stander:");
        ((House) house).setRoomStander(sc.nextLine());
        System.out.println("Enter other facilities: ");
        ((House) house).setOtherFacilities(sc.nextLine());
        System.out.println("Enter floor number: ");
        ((House) house).setFloorNumber(Integer.parseInt(sc.nextLine()));
        return house;
    }
}
