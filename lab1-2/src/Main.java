import java.util.Scanner;

public class Main {
    /*
    1. Создать класс Hello, который будет приветствовать любого пользователя, используя командную строку.
     */
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.print("Input username: ");
        String userName = myObj.nextLine();
        Hello hello = new Hello(userName);
        hello.setName(userName);
        System.out.println("Hello, " + hello.getName() + "!");
    }
}