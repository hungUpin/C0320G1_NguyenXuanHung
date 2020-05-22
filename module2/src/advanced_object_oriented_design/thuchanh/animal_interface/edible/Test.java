package advanced_object_oriented_design.thuchanh.animal_interface.edible;

public class Test {
    public static void main(String[] args) {
        Fruit[] fruits = new Fruit[2];
        fruits[0] = new Orange();
        fruits[1] = new Apple();
        for(Fruit fruit:fruits){
            System.out.println(fruit.howToEat());
        }
    }

}
