package cau_truc_du_lieu_va_giai_thuat.thuchanh.trienkhailoplinkedlist;

import javax.xml.soap.Node;

public class MyLinkedList {
    private Node head;
    private int numNodes;
    public MyLinkedList(Object data){
        head = new Node(data);
    }
    private class Node{
        private Node next;
        private Object data;

        public Node(Object data){
            this.data = data;
        }
        public Object getData(){
            return this.data;
        }
    }
    //Thêm đối tượng vào vị trí thứ index trong danh sách
    public void add(int index, Object data){
        Node temp = head;
        Node holder;
        if(index==0){
            head = new Node(data);
            head.next = temp;
            return;
        }
        for(int i=0;i<index-1&&temp.next!=null;i++){
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(data);
        temp.next.next = holder;
        numNodes++;
    }
    public void addFirst(Object data){
        Node temp = head;
        head = new Node(data);
        head.next = temp;
    }
    public Node get(int index){
        Node temp = head;
        for(int i=0;i<index;i++){
            temp = temp.next;
        }
        return temp;
    }

    public void printList(){
        Node temp = head;
        while (temp.next!=null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
