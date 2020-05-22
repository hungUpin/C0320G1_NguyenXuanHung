package service.impl;

import model.Room;
import model.Services;
import service.ServiceInterface;

import java.util.Scanner;

import static validation.ValidationTask04.*;

public class RoomServiceImp implements ServiceInterface {
    @Override
    public Services addNewService() {
        Scanner sc = new Scanner(System.in);
        Services room = new Room();
        System.out.println("Enter id");
        room.setId(sc.nextLine());
        System.out.println("Enter Room service name: ");
        room.setServiceName(validateNameService());
        System.out.println("Enter area of room: ");
        room.setArea(validateAreaAndPoolArea());
        System.out.println("Enter rent fee of room: ");
        room.setRentFee(validateRentFee());
        System.out.println("Enter max number of person: ");
        room.setMaxNumOfPerson(Integer.parseInt(sc.nextLine()));
        System.out.println("Enter type of rent:");
        room.setTypeOfRent(sc.nextLine());
        System.out.println("Enter free services included: ");
        ((Room) room).setFreeServicesIncluded(sc.nextLine());
        return room;
    }
}
