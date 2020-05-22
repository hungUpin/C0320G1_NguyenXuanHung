package advanced_object_oriented_design.baitap.interface_resizeable;

import kethua.thuchanh.Shape;

public class Circle extends Shape implements Resizeable {
    private double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    public void resize(double percent) {
        this.radius += radius * percent / 100;
    }

    @Override
    public String toString() {
        return "Circle: radius= " + radius + ", Area = " + getArea() + ", Perimeter: " + getPerimeter();
    }
}
