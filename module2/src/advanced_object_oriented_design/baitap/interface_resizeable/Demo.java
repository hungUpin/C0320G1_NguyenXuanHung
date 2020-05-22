package advanced_object_oriented_design.baitap.interface_resizeable;

import kethua.thuchanh.Shape;

import java.util.Random;

public class Demo {
    public static void main(String[] args) {
        Random random = new Random();
        int dis = random.nextInt(100);
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(15);
        shapes[1] = new Rectangle(15,20);
        shapes[2] = new Square(20);
        for(Shape hinh:shapes){
            System.out.println(hinh);
        }
        System.out.println("After resizeable: " +dis +" percent");
        for(Shape hinh:shapes){
//            if(hinh instanceof Circle){
//                Circle circle = (Circle) hinh;
//                circle.resize(dis);
//            }
//            if(hinh instanceof Rectangle){
//                Rectangle rectangle = (Rectangle) hinh;
//                rectangle.resize(dis);
//            }
//            if(hinh instanceof Square){
//                Square square = (Square) hinh;
//                square.resize(dis);
//            }
            hinh.resize(10);
            System.out.println(hinh);
        }
    }
}
