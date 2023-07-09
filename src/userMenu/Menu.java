package userMenu;

import animals.Animal;
import animals.AnimalTypeDeterminer;
import fileWriter.FileOperations;
import fileWriter.Operations;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Menu {
    public static void startMenu(){
        AnimalTypeDeterminer determiner = new AnimalTypeDeterminer();
        FileOperations fileOp = new FileOperations("pets.txt");
        Operations operations = new Operations();
        MyCounter counter = new MyCounter();
        while (true) {
            System.out.println("1. Добавить новое животное");
            System.out.println("2. Показать детальную информацию о животных");
            System.out.println("3. Список команд, которое выполняет животное");
            System.out.println("4. Обучить животное новым командам");
            System.out.println("5. Удалить запись");
            System.out.println("6. Сколько всего животных в питомнике");
            System.out.println("7. Выход");
            System.out.println();
            try {
                Scanner scanner = new Scanner(System.in);
                int n = scanner.nextInt();
                if (n == 2) {
                    if (operations.fileIsEmpty()) {
                        System.out.println("File is empty");
                        continue;
                    }
                    fileOp.showFile();
                } else if (n == 1) {
                    String animalType = chooseAnimalType();
                    Scanner scanner2 = new Scanner(System.in);
                    System.out.print("Имя животного: ");
                    String name = scanner2.nextLine();
                    System.out.print("Возраст: ");
                    int age = Integer.parseInt(scanner2.nextLine());
                    System.out.println("Изученные команды: ");
                    String commands = scanner2.nextLine();
                    Animal animal = determiner.determine(animalType, name, age, commands);
                    int number_of_line = counter.getCount();
                    fileOp.saveAnimal(animal, number_of_line + 1);
                    counter.add();
                } else if (n == 3) {
                    if (operations.fileIsEmpty()) {
                        System.out.println("File is empty");
                        continue;
                    }
                    fileOp.showFile();
                    System.out.print("Выберите животное: ");
                    Scanner scanner3 = new Scanner(System.in);
                    int position = scanner3.nextInt();
                    try {
                        operations.showCommands(position);
                    } catch (Exception e) {
                        System.out.println("Wrong input");
                    }
                } else if (n == 4) {
                    if (operations.fileIsEmpty()) {
                        System.out.println("File is empty");
                        continue;
                    }
                    fileOp.showFile();
                    System.out.print("Выберите животное: ");
                    Scanner scanner4 = new Scanner(System.in);
                    String num = scanner4.nextLine();
                    try {
                        operations.learnCommand(Integer.parseInt(num));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } else if (n == 5) {
                    if (operations.fileIsEmpty()) {
                        System.out.println("File is empty");
                        continue;
                    }
                    fileOp.showFile();
                    System.out.print("Выберите животное: ");
                    Scanner scanner5 = new Scanner(System.in);
                    String num = scanner5.nextLine();
                    try {
                        operations.deleteNote(Integer.parseInt(num));
                    } catch (Exception e) {
                        System.out.println("Wrong input");
                    }
                } else if (n == 6) {
                    System.out.println(counter.getCount());
                } else if (n == 7) {
                    break;
                } else {
                    System.out.println("Invalid input");
                }
            } catch (Exception e) {
                System.out.println("Please, enter the number");
            }
        }
    }
    public static String chooseAnimalType(){
        System.out.println("Выберите животное: ");
        System.out.println("1. Кошка");
        System.out.println("2. Собака");
        System.out.println("3. Хомяк");
        System.out.println("4. Лошадь");
        System.out.println("5. Осел");
        System.out.println("6. Верблюд");
        Scanner sc = new Scanner(System.in);
        String animal = sc.nextLine();
        if (animal.equals("1")) return "Кошка";
        else if (animal.equals("2")) return "Собака";
        else if (animal.equals("3")) return "Хомяк";
        else if (animal.equals("4")) return "Лошадь";
        else if (animal.equals("5")) return "Осел";
        else return "Верблюд";
    }
}

