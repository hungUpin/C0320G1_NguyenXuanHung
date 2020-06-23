import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Customer {
    private String name;
    private String birth;
    private String address;
    private String pictureLink;
    //private List<Customer> customerList;
    private static final DateFormat df = new SimpleDateFormat("DD/MM/YYYY");
    public Customer() {
    }

    public Customer(String name, String birth, String address, String pictureLink) {
        this.name = name;
//        try{
//            this.birth = df.parse(birth);
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }
        this.birth = birth;
        this.address = address;
        this.pictureLink = pictureLink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPictureLink() {
        return pictureLink;
    }

    public void setPictureLink(String pictureLink) {
        this.pictureLink = pictureLink;
    }

//    public List<Customer> getCustomerList() {
//        return customerList;
//    }
//
//    public void setCustomerList(List<Customer> customerList) {
//        this.customerList = customerList;
//    }
//
//
//    public void addCustomer(Customer customer){
//        if(this.customerList==null){
//            this.customerList = new ArrayList<>();
//        }
//        this.customerList.add(customer);
//    }
}
