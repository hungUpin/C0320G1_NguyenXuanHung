package cau_truc_du_lieu_va_giai_thuat.baitap.trienkhaiphuongthuclinkedlist;

public class MyLinkedList<E> {
    private int size;
    private Node head;
    private class Node{
        E data;
        Node next;
        Node(E data){
            this.data = data;
        }
    }
    MyLinkedList(){

    }
    MyLinkedList(E data){
        this.head = new Node(data);
        size++;
    }
    public void add(int index, E element){
        Node pointer = head;
        for(int i=0;i<index-1;i++){
            pointer = pointer.next;
        }
        Node holder = pointer.next;
        pointer.next = new Node(element);
        pointer.next.next = holder;
        size++;
    }
    public void addFirst(E element){
        Node temp = head;
        head = new Node(element);
        head.next = temp;
        size++;
    }
    public void addLast(E element){
        Node pointer = head;
        for(int i=0;i<size-1;i++){
            pointer = pointer.next;
        }
        pointer.next = new Node(element);
        size++;
    }
    public void printList(){
        Node pointer = head;
        while(pointer!=null){
            System.out.println(pointer.data);
            pointer = pointer.next;
        }
    }
    public void remove(int index){
        if(index ==0){
            head = head.next;
            return;
        }
        Node pointer = head;
        for(int i=0;i<index-1;i++){
            pointer = pointer.next;
        }
        pointer.next = pointer.next.next;
        size--;
    }
    public int size(){
        return size;
    }
    public boolean contains(E element){
        Node pointer = head;
        for(int i=0;i<size;i++){
            if(pointer.data.equals(element)){
                return true;
            }
            pointer = pointer.next;
        }
        return false;
    }
    public int getIndexOf(E element){
        Node pointer = head;
        for(int i=0;i<size;i++){
            if(pointer.data.equals(element)){
                return i;
            }
            pointer = pointer.next;
        }
        return -1;
    }
    public E get(int index){
        Node pointer = head;
        for(int i=0;i<index;i++){
            pointer = pointer.next;
        }
        return pointer.data;
    }
    public E getFirst(){
        return head.data;
    }
    public E getLast(){
        Node pointer = head;
        for(int i=0;i<size-1;i++){
            pointer = pointer.next;
        }
        return pointer.data;
    }
    public MyLinkedList<E> clone(){
        MyLinkedList<E> myLinkedList = new MyLinkedList<E>(head.data);
        Node pointer = head.next;
        for(int i=0;i<size -1;i++){
            myLinkedList.addLast(pointer.data);
            pointer = pointer.next;
        }
        return myLinkedList;
    }
    public void clear(){
        head = null;
    }
}
