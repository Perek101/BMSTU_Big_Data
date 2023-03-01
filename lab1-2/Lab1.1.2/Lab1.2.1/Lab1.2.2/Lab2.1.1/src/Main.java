import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    /*  Ввести n слов с консоли. Найти слово, состоящее только из различных символов.
        Если таких слов несколько, найти первое из них.
     */
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.print("Input string: ");
        String string = myObj.nextLine();
        String[] str = string.split(" ");
        StringBuilder arg2 = new StringBuilder();
        for (String s : str) {
            if (s.chars().distinct().count() == s.length()) {
                arg2.append(s);
                //    arg2.append(" ");
                break;
            }
        }
        System.out.println(arg2);
        getDateOfEndTask();
    }


    static void getDateOfEndTask() {
        Date getDateOfTask = new Date();
        getDateOfTask.getDate();
        Scanner myObj = new Scanner(System.in);
        System.out.print("В проект внесены изменения? ");
        String string = myObj.nextLine();
        if (Objects.equals(string, "да")) {
            File file = new File("Lab1.1.2/Lab1.2.1/Lab1.2.2/Lab2.1.1/src/1.txt");
            FileWriter fr = null;
            try {
                fr = new FileWriter(file);
                fr.write(String.valueOf(getDateOfTask));
                System.out.print(getDateOfTask);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {

            try {
                File file = new File("Lab1.1.2/Lab1.2.1/Lab1.2.2/Lab2.1.1/src/1.txt");
                Scanner myReader = new Scanner(file);
                while (myReader.hasNextLine()) {
                    String date = myReader.nextLine();
                    System.out.println("--------------------------------------\n" + "Разработал: Горский\n"+
                            "Время выдачи задания: Fri Feb 17 15:39:23 MSK 2023\n" +
                            "Время сдачи задания: " + date);
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
