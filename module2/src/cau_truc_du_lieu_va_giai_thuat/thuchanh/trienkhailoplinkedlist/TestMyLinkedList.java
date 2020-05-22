package cau_truc_du_lieu_va_giai_thuat.thuchanh.trienkhailoplinkedlist;

public class TestMyLinkedList {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList(10);
        myLinkedList.addFirst("hello");
        myLinkedList.addFirst(152);
        myLinkedList.addFirst(1000);
        myLinkedList.addFirst(564);
        myLinkedList.add(0,156);
        myLinkedList.printList();
    }
}
