import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    /*
    7.	Подсчитать, сколько слов в заданном тексте начинается с прописной буквы.
     */
    public static void main(String[] args) {
        AtomicInteger j= new AtomicInteger();
        List<String> strings = List.of("Hello helloasdasd world! gWer wed gWer".split("\\s"));
        strings.forEach((o1) -> {
            if(o1.matches("[^A-Z](.+)")){
                System.out.print(o1+" ");
                j.getAndIncrement();
            }
        });

        System.out.println("\nCлов в заданном тексте с прописной буквы: " + j);
        System.out.println("----------------------------------");
        //8.	Подсчитать, сколько раз заданное слово входит в текст.
        String word1="gWer!";  //заданное слово
        int count=0;  //количество вхождений
        for (String word : strings) {
            System.out.println(word);
            if (word1.contains(word)) {
                count++;
            }
        }
        System.out.println(word1+" : "+ count);
    }
}