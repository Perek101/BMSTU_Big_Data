import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    /*
    7. В тексте найти и напечатать все слова максимальной и все слова минимальной длины.
     */
    public static void main(String[] args) {
        System.out.println("Hello hello world!");
        List<String> strings = List.of("Hello helloasdasd world! wer wed".split("\\s"));
        System.out.println("min:");
        strings.forEach((o1) -> {
            if(o1.length()==strings.stream().min(Comparator.comparing(String::length)).get().length()){
                System.out.print(o1+" ");
            }
        });
        System.out.println("\nmax:");
        strings.forEach((o1) -> {
            if(o1.length()==strings.stream().max(Comparator.comparing(String::length)).get().length()){
                System.out.print(o1+" ");
            }
        });
    }
}