package model;

public class House extends Services {
    private String roomStander;
    private String otherFacilities;
    private int floorNumber;

    public House() {
    }

    public House(String roomStander, String otherFacilities, int floorNumber) {
        this.roomStander = roomStander;
        this.otherFacilities = otherFacilities;
        this.floorNumber = floorNumber;
    }

    public House(String id, String serviceName, double area, double rentFee, int maxNumOfPerson, String typeOfRent, String roomStander, String otherFacilities, int floorNumber) {
        super(id,serviceName, area, rentFee, maxNumOfPerson, typeOfRent);
        this.roomStander = roomStander;
        this.otherFacilities = otherFacilities;
        this.floorNumber = floorNumber;
    }

    public String getRoomStander() {
        return roomStander;
    }

    public void setRoomStander(String roomStander) {
        this.roomStander = roomStander;
    }

    public String getOtherFacilities() {
        return otherFacilities;
    }

    public void setOtherFacilities(String otherFacilities) {
        this.otherFacilities = otherFacilities;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    @Override
    public String toString() {
        //serviceName, area, rentFee, maxNumOfPerson, typeOfRent
        return "House{" +
                ", roomStander='" + roomStander + '\'' +
                ", otherFacilities='" + otherFacilities + '\'' +
                ", floorNumber=" + floorNumber +
                '}';
    }

    @Override
    public String showInfor() {
        return "House{"
                +"Service name: "+super.getServiceName()+
                ", area: "+super.getArea()+", rent Fee: "+super.getRentFee()+
                ", max number of person: " +super.getMaxNumOfPerson()+
                ", type of rent: " +super.getTypeOfRent()+
                ", roomStander='" + roomStander + '\'' +
                ", otherFacilities='" + otherFacilities + '\'' +
                ", floorNumber=" + floorNumber +
                '}';
    }
}
