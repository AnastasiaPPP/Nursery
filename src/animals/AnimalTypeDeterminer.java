package animals;

import animals.home.Cat;
import animals.home.Dog;
import animals.home.Hamster;
import animals.home.HomeAnimals;
import animals.packed.Camel;
import animals.packed.Donkey;
import animals.packed.Horse;
import animals.packed.PackedAnimals;

public class AnimalTypeDeterminer {
    public Animal determine(String type, String name, int age, String commands){
        if(type.equals("Кошка")) return new Cat(name, age, commands);
        else if (type.equals("Собака")) return new Dog(name, age, commands);
        else if (type.equals("Хомяк")) return new Hamster(name, age, commands);
        else if (type.equals("Лошадь")) return new Horse(name, age, commands);
        else if (type.equals("Верблюд")) return new Camel(name, age, commands);
        else return new Donkey(name, age, commands);
    }
    public String returnType(Animal animal){
        if(animal instanceof HomeAnimals) return ((HomeAnimals) animal).getType();
        else return ((PackedAnimals) animal).getType();
    }
}
