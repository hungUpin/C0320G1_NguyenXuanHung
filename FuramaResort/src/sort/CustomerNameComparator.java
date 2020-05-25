package sort;

import model.Customer;

import java.util.Comparator;

public class CustomerNameComparator implements Comparator<Customer> {
    @Override
    public int compare(Customer o1, Customer o2) {
        String name1 = o1.getCustomerName().substring(o1.getCustomerName().lastIndexOf(" "),o1.getCustomerName().length());
        String name2 = o2.getCustomerName().substring(o2.getCustomerName().lastIndexOf(" "),o2.getCustomerName().length());
        if(name1.equals(name2)){
            return o1.getYearOfBirth()-o2.getYearOfBirth();
        }
        return name1.compareTo(name2);
    }
}
