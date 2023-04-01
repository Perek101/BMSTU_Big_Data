public class ExcClass extends Exception {
/*
Выполнить задания из варианта 2 лабораторной работы 3, реализуя собственные обработчики исключений
 и исключения ввода/вывода.
 */
    private String someString;

    public ExcClass(String string) {
        this.someString = string;
        // System.out.println("Exception ExcClass");
    }

    public void myOwnExceptionMsg() {
        System.err.println("недостаточно элементов массива: " + someString);
    }
}
