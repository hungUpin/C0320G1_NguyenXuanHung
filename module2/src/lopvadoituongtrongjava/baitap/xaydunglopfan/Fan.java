package lopvadoituongtrongjava.baitap.xaydunglopfan;

public class Fan {
    final int slow = 1;
    final int medium =2;
    final int fast =3;
    private int speed =slow;
    boolean on = false;
    private double radius = 5;
    private String colour = "blue";

    public int getSlow() {
        return slow;
    }

    public int getMedium() {
        return medium;
    }

    public int getFast() {
        return fast;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
    Fan(){

    }
    public String toString(){
        //Nếu quạt đang ở trạng thái on, phương thức trả về speed, color, và radius với chuỗi “fan is on”.
        // Nếu quạt không ở trạng thái on, phương thức trả về color, radius với chuỗi “fan is off”.
        if(isOn()){
            return "Speed: "+getSpeed()+", colour: "+getColour()+" ,radius: "+getRadius()+ " , fan is on!!!";
        }else {
            return "Colour: "+getColour()+" ,radius: "+getRadius()+ " , fan is off!!!";
        }
    }
}
