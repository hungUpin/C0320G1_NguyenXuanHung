package advanced_object_oriented_design.thuchanh.lophinhoc;

import kethua.thuchanh.Circle;

import java.util.Comparator;
import java.util.stream.Collector;

public class CircleComparator implements Comparator<Circle> {
    @Override
    public int compare(kethua.thuchanh.Circle c1, kethua.thuchanh.Circle c2) {
        if(c1.getRadius()>c2.getRadius()) return 1;
        else if(c1.getRadius()<c2.getRadius()) return -1;
        else return 0;
    }

}
