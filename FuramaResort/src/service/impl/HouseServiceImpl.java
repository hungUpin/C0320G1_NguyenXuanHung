package service.impl;

import model.House;
import model.Services;
import service.ServiceInterface;
import validation.ValidationTask04;

public class HouseServiceImpl implements ServiceInterface {
    @Override
    public Services addNewService() {
        Services house = new House();
        System.out.println("Enter id");
        house.setId(ValidationTask04.validateId(house));
        System.out.println("Enter service included: ");
        house.setServiceIncluded(ValidationTask04.validateServiceIncluded());
        System.out.println("Enter House service name: ");
        house.setServiceName(ValidationTask04.standardizedName());
        System.out.println("Enter area of house: ");
        house.setArea(ValidationTask04.validateAreaAndPoolArea());
        System.out.println("Enter rent fee of house: ");
        house.setRentFee(ValidationTask04.validateRentFee());
        System.out.println("Enter max number of person: ");
        house.setMaxNumOfPerson(ValidationTask04.validateNumberOfPerson());
        System.out.println("Enter type of rent:");
        house.setTypeOfRent(ValidationTask04.standardizedName());
        System.out.println("Enter room stander:");
        ((House) house).setRoomStander(ValidationTask04.standardizedName());
        System.out.println("Enter other facilities: ");
        ((House) house).setOtherFacilities(ValidationTask04.standardizedName());
        System.out.println("Enter floor number: ");
        ((House) house).setFloorNumber(ValidationTask04.validatFloorNumber());
        return house;
    }
}
