package cau_truc_du_lieu_va_giai_thuat.baitap.trienkhaiphuongthucarraylist;

public class MyListTest {
    public static void main(String[] args) throws Exception {
        MyList<Integer> myList = new MyList<Integer>();
        myList.add(0,123);
        myList.add(1,1234);
        myList.add(2,46546);
        myList.add(1,4564654);
        myList.add(1,2656545);
        myList.add(0,789);
        myList.printList();
        myList.remove(5);
        System.out.println("After remove: ");
        myList.printList();
        System.out.println("The element at index is "+myList.get(3));
//        MyList<String> myList = new MyList<>();
//        myList.add(0,new String("hello"));
//        myList.printList();
//        System.out.println(myList.contains("hello24"));
        System.out.println(myList.add(156));
        myList.printList();
    }
}
