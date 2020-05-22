package advanced_object_oriented_design.baitap.interface_resizeable;

import kethua.thuchanh.Shape;

public class Rectangle extends Shape implements Resizeable {
    private double height;
    private double width;

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public Rectangle() {
    }

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }
    public double getArea() {
        return width * this.height;
    }

    public double getPerimeter() {
        return 2 * (width + this.height);
    }

    @Override
    public void resize(double percent) {
        height += height*percent/100;
        width += width*percent/100;
    }
    @Override
    public String toString(){
        return "Rectangle: height = "+height +", width= " +width +", Area = "+getArea()+", Perimeter: "+getPerimeter();
    }
}
