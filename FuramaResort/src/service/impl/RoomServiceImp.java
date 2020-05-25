package service.impl;

import model.Room;
import model.Services;
import service.ServiceInterface;
import validation.ValidationTask04;

import static validation.ValidationTask04.*;

public class RoomServiceImp implements ServiceInterface {
    @Override
    public Services addNewService() {
        Services room = new Room();
        System.out.println("Enter id");
        room.setId(ValidationTask04.validateId(room));
        System.out.println("Enter service included: ");
        room.setServiceIncluded(ValidationTask04.validateServiceIncluded());
        System.out.println("Enter Room service name: ");
        room.setServiceName(standardizedName());
        System.out.println("Enter pool area: ");
        room.setArea(validateAreaAndPoolArea());
        System.out.println("Enter rent fee of room: ");
        room.setRentFee(validateRentFee());
        System.out.println("Enter max number of person: ");
        room.setMaxNumOfPerson(ValidationTask04.validateNumberOfPerson());
        System.out.println("Enter type of rent:");
        room.setTypeOfRent(ValidationTask04.standardizedName());
        System.out.println("Enter free services included: ");
        ((Room) room).setFreeServicesIncluded(ValidationTask04.standardizedName());
        return room;
    }
}
