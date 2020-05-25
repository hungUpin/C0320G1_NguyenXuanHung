package model;

public class Customer {
    private String id;
    private String customerName;
    private String dayOfBirth;
    private String gender;
    private String idNumber;
    private String phoneNumber;
    private String email;
    private String typeOfCustomer;
    private String address;
    private Services service;

    public Customer() {
    }

    public Customer(String id, String customerName, String dayOfBirth, String gender, String idNumber, String phoneNumber, String email, String typeOfCustomer, String address, Services service) {
        this.id = id;
        this.customerName = customerName;
        this.dayOfBirth = dayOfBirth;
        this.gender = gender;
        this.idNumber = idNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.typeOfCustomer = typeOfCustomer;
        this.address = address;
        this.service = service;
    }
    public void setService(String id,String serviceIncluded,String serviceName, double area, double rentFee, int maxNumOfPerson, String typeOfRent) {
        this.service = new Villa();
        this.service.setId(id);
        this.service.setServiceIncluded(serviceIncluded);
        this.service.setServiceName(serviceName);
        this.service.setArea(area);
        this.service.setRentFee(rentFee);
        this.service.setMaxNumOfPerson(maxNumOfPerson);
        this.service.setTypeOfRent(typeOfRent);
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public int getYearOfBirth(){
        return Integer.parseInt(this.getDayOfBirth().substring(this.getDayOfBirth().length()-4,this.getDayOfBirth().length()));
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTypeOfCustomer() {
        return typeOfCustomer;
    }

    public void setTypeOfCustomer(String typeOfCustomer) {
        this.typeOfCustomer = typeOfCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Services getService() {
        return service;
    }

    public void setService(Services service) {
        this.service = service;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", customerName='" + customerName + '\'' +
                ", dayOfBirth='" + dayOfBirth + '\'' +
                ", gender='" + gender + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", typeOfCustomer='" + typeOfCustomer + '\'' +
                ", address='" + address + '\'' +
                ", service=" + service +
                '}';
    }

    public String showInfor(){
        return "Customer{" +
                "id='" + id + '\'' +
                "customerName='" + customerName + '\'' +
                ", dayOfBirth='" + dayOfBirth + '\'' +
                ", gender='" + gender + '\'' +
                ", Id number='" + idNumber + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", typeOfCustomer='" + typeOfCustomer + '\'' +
                ", address='" + address + '\'' +
                ", service=" + service +
                '}';
    }
}
