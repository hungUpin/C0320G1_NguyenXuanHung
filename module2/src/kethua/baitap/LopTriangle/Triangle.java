package kethua.baitap.LopTriangle;

import kethua.thuchanh.Shape;

public class Triangle extends Shape {
    private double size1 = 1.0;
    private double size2 = 1.0;
    private double size3 = 1.0;

    public Triangle() {
    }
    public Triangle(double size1, double size2, double size3) {
        this.size1 = size1;
        this.size2 = size2;
        this.size3 = size3;
    }

    public Triangle(String color, boolean filled, double size1, double size2, double size3) {
        super(color, filled);
        this.size1 = size1;
        this.size2 = size2;
        this.size3 = size3;
    }

    public double getSize1() {
        return size1;
    }

    public void setSize1(double size1) {
        this.size1 = size1;
    }

    public double getSize2() {
        return size2;
    }

    public void setSize2(double size2) {
        this.size2 = size2;
    }

    public double getSize3() {
        return size3;
    }

    public void setSize3(double size3) {
        this.size3 = size3;
    }
    public double getArea(){
        return getSize1()+getSize2()+getSize3();
    }
    public double getPerimeter(){
        double halfArea = getArea()/2;
        return Math.sqrt(halfArea*(halfArea-getSize1())*(halfArea-getSize2())*(halfArea-getSize3()));
    }
    @Override
    public String toString(){
        return "Triangle: Area: " +getArea() +", Perimeter: "+getPerimeter()+", color: "+getColor()+
                ", which is a subclass of "+super.toString();
    }
}
