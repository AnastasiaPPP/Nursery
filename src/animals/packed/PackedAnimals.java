package animals.packed;

import animals.Animal;

import java.util.ArrayList;

public class PackedAnimals extends Animal {
    protected static final String TYPE = "Packed Animals";
    public PackedAnimals(String name, int age, String commands) {
        super(name, age, commands);
    }
    public String getType(){return TYPE;}
}
