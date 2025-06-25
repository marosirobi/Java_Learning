package model.abstractions;

import java.util.ArrayList;

public class Abstractions {

    public static void main(String[] args) {
//        Animal animal = new Animal("animal","big",100);
        Dog dog = new Dog("Wolf", "big", 100);
//        dog.makeNoise();
        doAnimalStuff(dog);

        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(dog);
        animals.add(new Dog("German Shepard", "big", 150));
        animals.add(new Fish("Goldfish","small", 1));
        animals.add(new Fish("Barracuda","big",75));
        animals.add(new Dog("Pug","small",20));

        for(var animal : animals){
            doAnimalStuff(animal);
        }
    }

    private static void doAnimalStuff(Animal animal){
        animal.makeNoise();
        animal.move("Slow");
    }
}
