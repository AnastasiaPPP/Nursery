package fileWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Operations {
    FileOperations fileOp = new FileOperations("pets.txt");

    public void learnCommand(int lineToChange) {
        List<String> linesFromFile = fileOp.readAllLines();
        Scanner scanner = new Scanner(System.in);;
        System.out.print("Новая команда: ");
        String command = scanner.nextLine();
        String save = linesFromFile.get(lineToChange - 1);
        linesFromFile.set(lineToChange - 1, save +  " " + command);

        try (FileWriter file = new FileWriter("pets.txt")) {
            for (String row : linesFromFile) {
                file.write(String.join(" ", row) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void deleteNote(int number) {
        List<String> l = fileOp.readAllLines();
            l.remove(number - 1);
        try (FileWriter file = new FileWriter("pets.txt")) {
            for (String row : l) {
                file.write(String.join(" ", row) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static boolean fileIsEmpty() {
        List<String> fileList = new ArrayList<>();
        try (BufferedReader csvFile = new BufferedReader(new FileReader("pets.txt"))) {
            String line;
            while ((line = csvFile.readLine()) != null) {
                fileList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (fileList.size() >= 1) {
            return false;
        } else {
            return true;
        }
    }


    public static void showCommands(int number) {
        List<String[]> l = new ArrayList<>();
        try (BufferedReader csvFile = new BufferedReader(new FileReader("pets.txt"))) {
            String line;
            while ((line = csvFile.readLine()) != null) {
                l.add(line.split(" "));
            }
            String commands = "";
            for (int i = 0; i < l.size(); i++){
                for (int j = 8; j < l.get(i).length; j++){
                    if(i == number - 1){
                        commands += l.get(i)[j] + " ";
                    }
                }
            }
            System.out.println(commands);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
