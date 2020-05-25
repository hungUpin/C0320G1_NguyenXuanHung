package model;

public class Villa extends Services {
    private String roomStander;
    private String otherFacilities;
    private double poolArea;
    private int floorNumber;

    public Villa() {
    }

    public Villa(String roomStander, String otherFacilities, Integer poolArea, int floorNumber) {
        this.roomStander = roomStander;
        this.otherFacilities = otherFacilities;
        this.poolArea = poolArea;
        this.floorNumber = floorNumber;
    }

    public Villa(String id, String serviceIncluded, String serviceName, double area, double rentFee, int maxNumOfPerson, String typeOfRent, String roomStander, String otherFacilities, Integer poolArea, int floorNumber) {
        super(id, serviceIncluded, serviceName, area, rentFee, maxNumOfPerson, typeOfRent);
        this.roomStander = roomStander;
        this.otherFacilities = otherFacilities;
        this.poolArea = poolArea;
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

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    @Override
    public String toString() {
        return "Villa{" +
                "typeOfRoom='" + roomStander + '\'' +
                ", otherFacilities='" + otherFacilities + '\'' +
                ", poolArea='" + poolArea + '\'' +
                ", floorNumber=" + floorNumber +
                '}';
    }

    @Override
    public String showInfor() {
        return "Villa{\n"
                +"Service id: "+super.getId()+
                ", Service included: "+super.getServiceIncluded()
                +",Service name: "+super.getServiceName()+
                ", area: "+super.getArea()+", rent Fee: "+super.getRentFee()+
                ", max number of person: " +super.getMaxNumOfPerson()+
                ", type of rent: " +super.getTypeOfRent()+
                ", typeOfRoom='" + roomStander + '\'' +
                ", otherFacilities='" + otherFacilities + '\'' +
                ", poolArea='" + poolArea + '\'' +
                ", floorNumber=" + floorNumber +
                "\n}";
    }
}
