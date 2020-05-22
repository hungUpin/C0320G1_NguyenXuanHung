package advanced_object_oriented_design.baitap.colorable;

import advanced_object_oriented_design.baitap.interface_resizeable.Circle;
import advanced_object_oriented_design.baitap.interface_resizeable.Rectangle;
import kethua.thuchanh.Shape;

public class Test {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Square(5);
        shapes[1] = new Circle(15);
        shapes[2] = new Rectangle(20,30);
        for(Shape shape:shapes){
            if(shape instanceof  Square){
                System.out.println(((Square) shape).getPerimeter());
            }
            if(shape instanceof  Circle){
                System.out.println(((Circle) shape).getPerimeter());
            }
            if(shape instanceof Rectangle){
                Rectangle rectangle = (Rectangle) shape;
                System.out.println(rectangle.getPerimeter());
            }
            if(shape instanceof Colorable){
                ((Colorable) shape).howToColor();
            }
        }
    }
}
