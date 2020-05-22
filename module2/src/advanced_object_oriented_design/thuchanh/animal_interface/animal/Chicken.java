package advanced_object_oriented_design.thuchanh.animal_interface.animal;

import advanced_object_oriented_design.thuchanh.animal_interface.edible.Edible;

public class Chicken extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "Chicken: cooku!!!!";
    }

    @Override
    public String howToEat() {
        return "could be fried!!!";
    }
}
