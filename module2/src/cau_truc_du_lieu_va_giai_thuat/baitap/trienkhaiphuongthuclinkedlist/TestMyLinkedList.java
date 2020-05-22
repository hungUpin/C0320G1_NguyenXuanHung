package cau_truc_du_lieu_va_giai_thuat.baitap.trienkhaiphuongthuclinkedlist;

public class TestMyLinkedList {
    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>(12345);
        myLinkedList.addFirst(123);
        myLinkedList.addFirst(5464);
        myLinkedList.add(1,456);
        myLinkedList.addLast(999);
        myLinkedList.printList();
//        myLinkedList.remove(3);
//        System.out.println("After remove: ");
//        myLinkedList.printList();
        System.out.println(myLinkedList.contains(999));
        System.out.println(myLinkedList.getIndexOf(15));
        System.out.println("Get value");
        System.out.println(myLinkedList.get(1));
        System.out.println(myLinkedList.getLast());
        MyLinkedList<Integer> cloneList = new MyLinkedList<>();
        cloneList = myLinkedList.clone();
        System.out.println("clone list");
        cloneList.printList();
    }
}
