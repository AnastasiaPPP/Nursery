package animals.home;

import animals.Animal;

import java.util.ArrayList;

public class HomeAnimals extends Animal {
    protected static final String TYPE = "Home Animal";
    public HomeAnimals(String name, int age, String commands) {
        super(name, age, commands);
    }
    public String getType(){
        return TYPE;
    }

}
