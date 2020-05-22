package cau_truc_du_lieu_va_giai_thuat.baitap.trienkhaiphuongthucarraylist;

import java.util.Arrays;

public class MyList<E> {
    private int size;
    private int capacity = 7;
    private Object[] array;

    public MyList() {
        array = new Object[capacity];
    }

    public MyList(int capacity) {
        this.capacity = capacity;
    }

    public int size() {
        return this.size;
    }

    public void ensureCapacity() {
        capacity = capacity * 2;
        array = Arrays.copyOf(array, capacity);
    }

    public void ensureCapacity(int minCapacity) {
        array = Arrays.copyOf(array, minCapacity);
    }

    public void add(int index, E element) {
        if (size == array.length) {
            ensureCapacity(size+1);
        }
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = element;
        size++;
    }

    public void printList() {
        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);
        }
    }

    public void remove(int index) throws Exception {
        if (index < 0 ||index>=array.length) {
            throw new Exception("Out of index!!!");
        } else {
            for (int i = index; i < size-1; i++) {
                array[i] = array[i + 1];
            }
            ensureCapacity(--size);
        }
    }
    public MyList clone(){
        MyList myList = new MyList();
        for(int i=0;i<size;i++){
            myList.array[i] = array[i];
        }
        myList.size = size;
        return myList;
    }
    public boolean contains(E value){
        for(int i=0;i<array.length;i++){
            if(array[i]==value){
                return true;
            }
        }
        return false;
    }
   public E get(int i){
       return (E) array[i];
   }
   public void clear(){
        array = null;
        this.size = 0;
        //ensureCapacity(0);
   }
   public boolean add(E element){
       if(size<=capacity){
           ensureCapacity(size+1);
           array[size++] = element;
           return true;
       }else {
           return false;
       }
   }
}
