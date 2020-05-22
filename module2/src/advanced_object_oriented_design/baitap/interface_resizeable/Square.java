package advanced_object_oriented_design.baitap.interface_resizeable;

import kethua.thuchanh.Shape;

public class Square extends Shape implements Resizeable{
    private double size;

    public Square(double size) {
        this.size = size;
    }

    public Square() {
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
    public double getArea(){
        return size*4;
    }
    public double getPerimeter(){
        return size*size;
    }
    @Override
    public void resize(double percent) {
        size += size*percent/100;
    }
    @Override
    public String toString(){
        return "Square: size= "+size+ ", Area= "+getArea()+", Perimeter= "+getPerimeter();
    }
}
