package model;

public class Room extends Services {
    private String freeServicesIncluded;

    public Room() {
    }

    public Room(String freeServicesIncluded) {
        this.freeServicesIncluded = freeServicesIncluded;
    }

    public Room(String id, String serviceName, double area, double rentFee, int maxNumOfPerson, String typeOfRent, String freeServicesIncluded) {
        super(id,serviceName, area, rentFee, maxNumOfPerson, typeOfRent);
        this.freeServicesIncluded = freeServicesIncluded;
    }

    public String getFreeServicesIncluded() {
        return freeServicesIncluded;
    }

    public void setFreeServicesIncluded(String freeServicesIncluded) {
        this.freeServicesIncluded = freeServicesIncluded;
    }

    @Override
    public String toString() {
        return "Room{" +
                "freeServicesIncluded='" + freeServicesIncluded + '\'' +
                '}';
    }

    @Override
    public String showInfor() {
        return "Room{"+"Service name: "+super.getServiceName()+
                ", area: "+super.getArea()+", rent Fee: "+super.getRentFee()+
                ", max number of person: " +super.getMaxNumOfPerson()+
                ", type of rent: " +super.getTypeOfRent()+
                "freeServicesIncluded='" + freeServicesIncluded + '\'' +
                '}';
    }
}
