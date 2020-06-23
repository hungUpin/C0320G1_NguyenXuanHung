import java.util.ArrayList;
import java.util.List;

public class DBUtils {
    private static final List<Customer> customerList= new ArrayList<>();
    static {
        customerList.add(new Customer("Nguyen Van A","12/05/2006","Da Nang", "larva1.jpg"));
        customerList.add(new Customer("Nguyen Van B","13/07/1995","Quang Nam", "larva2.jpg"));
        customerList.add(new Customer("Nguyen Van C","15/06/2007","Ha Noi", "larva3.jpg"));
    }
    public static List<Customer> getCustomerList(){
        return customerList;
    }
}
