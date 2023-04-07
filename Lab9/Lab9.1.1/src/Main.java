import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class  Main {
    //7.	Задана коллекция строк. Получить массив уникальных значений.
    //8.	Задана коллекция строк. Получить список без дубликатов с сохранением порядка.
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Collection<String> stringCollection = new ArrayList<>();
        stringCollection.add("czc");
        stringCollection.add("fsdfdsfds");
        stringCollection.add("czc");
        stringCollection.add("czcdwdwa");
        stringCollection.stream().distinct().forEach(System.out::println);







        //7.	Задана коллекция чисел. Вычесть из каждого значения 10 и получить среднее.

        Collection<Integer> intCollection = new ArrayList<>();
        Collection<Integer> tempCollection = new ArrayList<>();
        Random rnd =new Random();
        for (int i=0; i<10; i++){
            intCollection.add(rnd.nextInt(0,21));
        }
        intCollection.stream().forEach((o)-> {
                o-= 10;
                tempCollection.add(o);
        });

        System.out.println(intCollection);
        System.out.println(tempCollection);
        System.out.println(intCollection.stream().mapToInt(Integer::intValue).average());
        System.out.println(tempCollection.stream().mapToInt(Integer::intValue).average());



        //8.	Задана коллекция чисел. Получить сумму всех кратных 7.
        System.out.println(intCollection.stream().filter(x-> x%7==0).mapToInt(Integer::intValue).sum());

    }
}