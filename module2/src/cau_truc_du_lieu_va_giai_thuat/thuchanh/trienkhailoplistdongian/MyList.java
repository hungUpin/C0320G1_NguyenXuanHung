package cau_truc_du_lieu_va_giai_thuat.thuchanh.trienkhailoplistdongian;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private int DEFAULT_CAPACITY = 10;
    private Object elements[];
    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }
    public void ensureCapa(){
        int newSize = elements.length*2;
        elements = Arrays.copyOf(elements,newSize);
    }
    //them phan tu phia cuoi mang add()
    public void add(E e){
        if(size == elements.length){
            ensureCapa();
        }
        elements[size++] = e;
    }
    //Phương thức get() trả về phần tử vừa ở vị trí thứ i trong danh sách.
    public E get(int index){
        if(index<0){
            throw new IndexOutOfBoundsException("Index: "+index +", Size: "+size);
        }
        return (E) elements[index];
    }


}
