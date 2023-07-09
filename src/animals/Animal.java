package animals;

public abstract class Animal {
    protected String name;
    protected int age;
    protected String commands;

    public Animal(String name, int age, String commands) {
        this.name = name;
        this.age = age;
        this.commands = commands;
    }
    public String getCommands(){
        return commands;
    }
    public void learnCommand(String command){
        commands += command;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCommands(String commands) {
        this.commands = commands;
    }
}
