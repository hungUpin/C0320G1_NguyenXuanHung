package advanced_object_oriented_design.thuchanh.animal_interface.animal;

import advanced_object_oriented_design.thuchanh.animal_interface.edible.Edible;

public class AbstractAndInterfaceTests {
    public static void main(String[] args) {
        Animal[] animals = new Animal[3];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        animals[2] = new Tiger();
        for(Animal animal:animals){
            System.out.println(animal.makeSound());
            if(animal instanceof Chicken){
                Edible edible = (Chicken) animal;
                System.out.println(edible.howToEat());
            }
            if(animal instanceof Tiger){
                Tiger tiger = (Tiger) animal;
                System.out.println("Tiger: "+tiger.howToEat());
            }
        }
    }
}
