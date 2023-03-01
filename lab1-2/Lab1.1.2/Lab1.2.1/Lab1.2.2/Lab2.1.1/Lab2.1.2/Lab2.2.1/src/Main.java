import java.util.Random;
import java.util.Scanner;

public class Main {
    /*
    Ввести с консоли n – размерность матрицы a[n][n].
    Задать значения элементов матрицы в интервале значений от -n до n с помощью датчика случайных чисел.
    Повернуть матрицу на 90 (180, 270) градусов против часовой стрелки.
     */
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.print("Input n: ");
        int n = myObj.nextInt();
        int[][] a = new int[n][n];
        int[][] b = new int[n][n];
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                Random rnd = new Random();
                a[i][j] = rnd.nextInt(-n,n);
            }
        }
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
               System.out.print(a[i][j] + " ");
            }
            System.out.print("\n");
        }
        //поворот на 90 против часовой(270)
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                b[i][j] = a[j][n-1-i];
            }
        }
        System.out.println("Поворот на 90:");
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                System.out.print(b[i][j] + " ");
            }
            System.out.print("\n");
        }
        //поворот на 180 против часовой
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                a[i][j] = b[j][n-1-i];
            }
        }
        System.out.println("Поворот на 180:");
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.print("\n");
        }
        //поворот на 270 против часов(90)
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                b[i][j] = a[j][n-1-i];
            }
        }
        System.out.println("Поворот на 270:");
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                System.out.print(b[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}