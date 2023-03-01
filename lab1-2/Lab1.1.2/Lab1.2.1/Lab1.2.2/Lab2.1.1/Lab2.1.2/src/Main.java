import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    /*
     8. Ввести n слов с консоли. Среди слов, состоящих только из цифр, найти слово-палиндром.
        Если таких слов больше одного, найти второе из них.
     */
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.print("Input string: ");
        String string = myObj.nextLine();
        StringBuilder str_i0 = new StringBuilder();
        String[] str = string.split(" ");
        int i = 0;
        boolean t = false;
        for (String s : str) {
            String str2 = new StringBuilder(s).reverse().toString();
            if (s.matches("\\d+") && s.contains(str2)){
                if( i == 1){
                    System.out.println("второе число палином: " + s);
                } else if (i == 0) {
                    str_i0.append(s);
                    t = true;
                }
                i++;
            }
        }

        if (i == 1 && t){
            System.out.println("в строке всего один численный палином: " + str_i0);
        } else if(i==0){
            System.out.println("в строке нет численных палиномов");
        }
        getDateOfEndTask();
    }


    static void getDateOfEndTask() {
        Date getDateOfTask = new Date();
        getDateOfTask.getDate();
        Scanner myObj = new Scanner(System.in);
        System.out.print("В проект внесены изменения? ");
        String string = myObj.nextLine();
        if (Objects.equals(string, "да")) {
            File file = new File("Lab1.1.2/Lab1.2.1/Lab1.2.2/Lab2.1.1/Lab2.1.2/src/1.txt");
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
                File file = new File("Lab1.1.2/Lab1.2.1/Lab1.2.2/Lab2.1.1/Lab2.1.2/src/1.txt");
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