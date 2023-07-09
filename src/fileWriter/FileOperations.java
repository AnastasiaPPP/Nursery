package fileWriter;

import animals.Animal;
import animals.AnimalTypeDeterminer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileOperations {
    private String fileName;

    public FileOperations(String fileName) {
        this.fileName = fileName;
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static void showFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("pets.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> readAllLines() {
        List<String> lines = new ArrayList<>();
        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            if (line != null) {
                lines.add(line);
            }
            while (line != null) {
                line = reader.readLine();
                if (line != null) {
                    lines.add(line);
                }
            }
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public void saveAnimal(Animal animal, int numberOfLine) {
        AnimalTypeDeterminer determine = new AnimalTypeDeterminer();
        String information = numberOfLine + " Кличка: "+ animal.getName() + " Вид: " + determine.returnType(animal)
        + " Возраст: " + animal.getAge() + " Команды: " + animal.getCommands();
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(information);
            writer.append('\n');

            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
