public class Main {
    /*
    8.	Из небольшого текста удалить все символы, кроме пробелов, не являющиеся буквами.
        Между последовательностями подряд идущих букв оставить хотя бы один пробел.
     */
    public static void main(String[] args) {
        System.out.println("Hello world!".replaceAll("[^\\w\\s]", ""));
    }
}