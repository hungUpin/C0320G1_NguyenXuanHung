package advanced_object_oriented_design.baitap.colorable;

import kethua.thuchanh.Shape;

public class Square extends Shape implements Colorable {
    private int size;

    public Square() {
    }

    public Square(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public double getArea(){
        return size*4;
    }
    public double getPerimeter(){
        return size*size;
    }
    @Override
    public void howToColor() {
        System.out.println("Color all four sides..");
    }
}
