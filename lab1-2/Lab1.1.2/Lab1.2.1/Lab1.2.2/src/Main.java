import java.util.Scanner;

public class Main {
    /*
    Ввести с консоли n целых чисел и поместить их в массив. На консоль вывести:
    Простые числа.
     */
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.print("Input n: ");
        int n = myObj.nextInt();
        int[] a = new int[n];
        int x = -100;
        for( int i = 0; i<a.length; i++){
            a[i] = myObj.nextInt();
            if (a[i] > x){
                x= a[i];
            }
        }
        System.out.println("Array:");
        for (int j : a) {
            System.out.println(j);
        }
        int a1 = 0;
        for (int i = 0; i < a.length; i++) {
            a1 = 0;
            for (int j = 1; j<=x; j++) {
                if (a[i] % j == 0 ) {

                    a1++;
                }
            }
            if (a1==2){
                System.out.println("Простые числа" + a[i]);
            }
        }
    }
}