import java.util.Scanner;

public class Main {
    /*
    Ввести с консоли n целых чисел и поместить их в массив. На консоль вывести:
    Наибольший общий делитель и наименьшее общее кратное этих чисел.
     */
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.print("Input n: ");
        int n = myObj.nextInt();
        int[] a = new int[n];
        int x = -100;
        int m = -1;
        int nok = 1;
        for( int i = 0; i<a.length; i++){
            a[i] = myObj.nextInt();
            nok = nok * a[i];
            if (a[i] > x){
                x= a[i];
            }
        }
        System.out.println("Array:");
        for (int j : a) {
            System.out.println(j);
        }
        int a1 = 0;
        for (int j = 1; j<=x; j++){
            a1 = 0;
            for( int i = 0; i<a.length; i++){
                if (a[i]%j == 0){
                    a1++;
               //     System.out.println("a[i]" + a[i] + j);
                }
            }
            if (a1==n && m<j){
                m=j;
            }
        }
        System.out.println("Наибольший общий делитель= " + m);
        System.out.println("Наибольший общий делитель= " + nok/m);

    }
}