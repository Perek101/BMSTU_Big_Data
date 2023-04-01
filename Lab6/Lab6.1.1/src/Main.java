import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/*
7.	Ввести строки из файла, записать в список ArrayList.
    Выполнить сортировку строк, используя метод sort() из класса Collections.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            File myObj = new File("/Users/lol/Desktop/untitled/Lab6/Lab6.1.1/src/1.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                //String data = myReader.nextLine();
                //System.out.println(data);

                arrayList.add(myReader.nextLine());



            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println(arrayList);
        Collections.sort(arrayList);
        System.out.println(arrayList);
    }
}