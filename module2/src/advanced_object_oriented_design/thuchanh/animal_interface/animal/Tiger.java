package advanced_object_oriented_design.thuchanh.animal_interface.animal;

import advanced_object_oriented_design.thuchanh.animal_interface.edible.Edible;

public class Tiger extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "Tiger: roarrrrr!";
    }

    @Override
    public String howToEat() {
        return "can be eat!!!";
    }
}
