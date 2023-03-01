import java.util.Random;
import java.util.Scanner;

public class Main {
    /*
    Ввести с консоли n – размерность матрицы a[n][n].
    Задать значения элементов матрицы в интервале значений от -n до n с помощью датчика случайных чисел.
    Вычислить определитель матрицы.
     */
    public static void main(String[] args){
        Scanner myObj = new Scanner(System.in);
        System.out.print("Input n: ");
        int n = myObj.nextInt();
        int[][] a = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j = 0; j < n; j++) {
                Random rnd = new Random();
                a[i][j] = rnd.nextInt(-n, n);
            }
        }

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.print("\n");
        }

        System.out.println("Determinant of the matrix is : " + det(a, n));

    }
    static int det(int[][] mat, int n)
    {
        int num1 = 0;
        int num2 = 0;
        int det = 1;
        int total = 1;
        int[] temp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[j] = mat[i][j];
            }

            for (int j = i + 1; j < n; j++) {
                num1 = temp[i];
                num2 = mat[j][i];
                for (int k = 0; k < n; k++) {
                    mat[j][k] = (num1 * mat[j][k]) - (num2 * temp[k]);
                }
                total = total * num1; // Det(kA)=kDet(A);
            }
        }
        for (int i = 0; i < n; i++) {
            det = det * mat[i][i];
        }
        return (det / total); // Det(kA)/k=Det(A);
    }
}
