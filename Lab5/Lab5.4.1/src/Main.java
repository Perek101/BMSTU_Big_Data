import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/*
7.	Прочитать текст Java-программы и удалить из него все “лишние” пробелы и табуляции,
    оставив только необходимые для разделения операторов.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        StringBuilder stringBuilder = new StringBuilder();
        try {
            File myObj = new File("/Users/lol/Desktop/untitled/Lab5/Lab5.4.1/src/1.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data.replaceAll("\\s{2,}", " "));

                stringBuilder.append(data);
                stringBuilder.append("\n");

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        /*
        8.	Из текста Java-программы удалить все виды комментариев. */
        System.out.println("--------------------------------------------------");
        System.out.println("второе задание");
            int l = stringBuilder.length();
            while (l>=0) {
                if(stringBuilder.indexOf("/*")>0 && stringBuilder.indexOf("*/") >0){
                    stringBuilder.delete(stringBuilder.indexOf("/*"), stringBuilder.indexOf("*/", stringBuilder.indexOf("/*")) + 2);
                }
                if (stringBuilder.indexOf("//")>0 && stringBuilder.indexOf("\n", stringBuilder.indexOf("//"))>0){
                    stringBuilder.delete(stringBuilder.indexOf("//"), stringBuilder.indexOf("\n", stringBuilder.indexOf("//")));
                }
                l = l - stringBuilder.indexOf("\n");
            }
        System.out.println(stringBuilder);

    }
}