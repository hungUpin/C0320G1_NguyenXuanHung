package kethua.baitap.LopTriangle;

import kethua.thuchanh.Shape;

public class Demo {
    public static void main(String[] args) {
        Shape shape = new Shape("green",true);
        Triangle triangle = new Triangle("yellow",true,15,20,30);
        System.out.println(shape);
        System.out.println(triangle);
    }
}
