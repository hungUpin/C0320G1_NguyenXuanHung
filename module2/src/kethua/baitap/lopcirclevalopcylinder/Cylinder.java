package kethua.baitap.lopcirclevalopcylinder;

public class Cylinder extends Circle {
    private double height;

    public Cylinder() {
    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public double getCylinderVolume(){
        return height*Math.PI*Math.pow(getRadius(),2);
    }
    @Override
    public String toString(){
        return "A Cylinder with height: "+getHeight()+", Radius: "+getRadius()+", Volume: "+getCylinderVolume()+
                ", which a subclass of: "+super.toString();
    }
}
