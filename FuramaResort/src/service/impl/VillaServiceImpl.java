package service.impl;

import model.Services;
import model.Villa;
import service.ServiceInterface;
import validation.ValidationTask04;

import java.util.Scanner;

import static validation.ValidationTask04.validateId;

public class VillaServiceImpl implements ServiceInterface {
    @Override
    public Services addNewService() {
        Scanner sc = new Scanner(System.in);
        Services villa = new Villa();
        //serviceName,area,rentFee,maxNumOfPerson,typeOfRent,roomStander,otherFacilities,floorNumber
        System.out.println("Enter id");
        villa.setId(validateId(villa));
        System.out.println("Enter service included: ");
        villa.setServiceIncluded(ValidationTask04.validateServiceIncluded());
        System.out.println("Enter Villa service name: ");
        villa.setServiceName(ValidationTask04.standardizedName());
        System.out.println("Enter area of villa: ");
        villa.setArea(ValidationTask04.validateAreaAndPoolArea());
        System.out.println("Enter rent fee of villa: ");
        villa.setRentFee(ValidationTask04.validateRentFee());
        System.out.println("Enter max number of person: ");
        villa.setMaxNumOfPerson(ValidationTask04.validateNumberOfPerson());
        System.out.println("Enter type of rent:");
        villa.setTypeOfRent(ValidationTask04.standardizedName());
        System.out.println("Enter room stander:");
        ((Villa) villa).setRoomStander(ValidationTask04.standardizedName());
        System.out.println("Enter other facilities: ");
        ((Villa) villa).setOtherFacilities(ValidationTask04.standardizedName());
        System.out.println("Enter pool area");
        ((Villa) villa).setPoolArea(ValidationTask04.validateAreaAndPoolArea());
        System.out.println("Enter floor number: ");
        ((Villa) villa).setFloorNumber(ValidationTask04.validatFloorNumber());
        return villa;
    }
}
