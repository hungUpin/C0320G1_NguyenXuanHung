package model;

public abstract class Services {
    private String id;
    private String serviceName;
    private double area;
    private double rentFee;
    private int maxNumOfPerson;
    private String typeOfRent;
    private String serviceIncluded;
    public Services() {
    }

    public Services(String id,String serviceIncluded,String serviceName, double area, double rentFee, int maxNumOfPerson, String typeOfRent) {
        this.id = id;
        this.serviceIncluded = serviceIncluded;
        this.serviceName = serviceName;
        this.area = area;
        this.rentFee = rentFee;
        this.maxNumOfPerson = maxNumOfPerson;
        this.typeOfRent = typeOfRent;
    }

    public String getServiceIncluded() {
        return serviceIncluded;
    }

    public void setServiceIncluded(String serviceIncluded) {
        this.serviceIncluded = serviceIncluded;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getRentFee() {
        return rentFee;
    }

    public void setRentFee(double rentFee) {
        this.rentFee = rentFee;
    }

    public int getMaxNumOfPerson() {
        return maxNumOfPerson;
    }

    public void setMaxNumOfPerson(int maxNumOfPerson) {
        this.maxNumOfPerson = maxNumOfPerson;
    }

    public String getTypeOfRent() {
        return typeOfRent;
    }

    public void setTypeOfRent(String typeOfRent) {
        this.typeOfRent = typeOfRent;
    }

    public abstract String showInfor();

    @Override
    public String toString() {
        return "Services{" +
                "serviceName='" + serviceName + '\'' +
                ", area=" + area +
                ", rentFee=" + rentFee +
                ", maxNumOfPerson=" + maxNumOfPerson +
                ", typeOfRent='" + typeOfRent + '\'' +
                '}';
    }
}
