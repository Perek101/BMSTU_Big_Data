import java.sql.SQLOutput;

public class Main {
    /*
    2. Создать приложение, которое отображает в окне консоли аргументы командной строки метода main()
    в обратном порядке.
     */
    public static void main(String[] args) {
 //       System.out.println("Hello world!");
        StringBuilder arg1 = new StringBuilder();
        for (String arg : args) {
            System.out.print(arg);
            arg1.append(arg);
        }
        String arg2 = new StringBuilder(arg1.toString()).reverse().toString();
        System.out.println("\n" + arg2);
    }
}
