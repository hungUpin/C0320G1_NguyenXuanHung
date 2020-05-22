package advanced_object_oriented_design.baitap.colorable;

public interface Colorable {
    public void howToColor();
    default void test(){
        System.out.println("hello!!!");
    }
}
