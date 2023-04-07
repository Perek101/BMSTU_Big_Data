import java.util.Comparator;

public class Main {
    /*
    7.	Текст шифруется по следующему правилу: из исходного текста выбирается
     1, 4, 7, 10-й и т.д.(до конца текста) символы,
     затем 2, 5, 8, 11-й и т.д. (до конца текста) символы,
     затем 3, 6, 9, 12-й и т.д. Зашифровать заданный текст.
     */
    public static void main(String[] args) {
        System.out.println("Hello world!");
        StringBuilder stringBuilder1= new StringBuilder();
        StringBuilder stringBuilder2= new StringBuilder();
        StringBuilder stringBuilder3= new StringBuilder();
        String str = "Hello world!";
        for (int i=3;i<str.length()+3; i+=3){
            stringBuilder1.append(str.charAt(i-3));
            stringBuilder2.append(str.charAt(i-2));
            stringBuilder3.append(str.charAt(i-1));


        }

        System.out.println("1: "+ stringBuilder1);
        System.out.println("2: "+ stringBuilder2);
        System.out.println("3: "+ stringBuilder3);
    }
}