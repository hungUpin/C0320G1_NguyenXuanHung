package cau_truc_du_lieu_va_giai_thuat.thuchanh.trienkhailoplistdongian;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> listInteger = new MyList<Integer>();
        listInteger.add(10);
        listInteger.add(100);
        listInteger.add(2000);
        System.out.println("Element 3: " + listInteger.get(2));
        System.out.println("Element 1: "+listInteger.get(0));
        listInteger.add(-1);
        System.out.println("element -1: " + listInteger.get(-1));
    }
}
