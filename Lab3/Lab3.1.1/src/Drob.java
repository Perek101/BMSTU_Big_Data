import java.util.Random;

public class Drob {
    private float m;
    private float n;

    Drob(){
        this.m = 2;  //числитель
        this.n = 1; // знаменатель
    }
    Drob(int m_, int n_){
        this.m=m_;
        this.n=n_;
    }
    Drob(int m_){
        this.m=m_;
        this.n = 1;
    }

    public float getM() {
        return m;
    }

    public float getN() {
        return n;
    }

    public void setM(float m) {
        this.m = m;
    }

    public void setN(float n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return "m=" + m +
                ", n=" + n;
    }

/* Определить класс Дробь в виде пары (m,n). Класс должен содержать несколько конструкторов.
   Реализовать методы для сложения, вычитания, умножения и деления дробей. Объявить массив из k дробей,
   ввести/вывести значения для массива дробей. Создать массив объектов и передать его в метод,
   который изменяет каждый элемент массива с четным индексом путем добавления следующего за ним элемента массива. */
    public static void main(String[] args) {
        Random rnd = new Random();
        Drob dr1 = new Drob(rnd.nextInt(1,5),rnd.nextInt(1,5) );
        Drob dr2 = new Drob(rnd.nextInt(1,5));
        System.out.println(dr1.toString() + "\n" + dr2.toString());
        System.out.println((Plus(dr1, dr2)));
        System.out.println((Minus(dr1, dr2)));
        System.out.println((Multiply(dr1, dr2)));
        System.out.println((Delete(dr1, dr2)));
        int k=rnd.nextInt(2,7);
        Drob[] dr3 = new Drob[k];
        for (int i = 0; i<k; i++){
            dr3[i] = new Drob(rnd.nextInt(1,5),rnd.nextInt(1,5) );
        }
        for (int i = 0; i<k; i++){
           // dr3[i] = new Drob(rnd.nextFloat(1,5),rnd.nextFloat(1,5) );
            System.out.println(dr3[i].toString());
        }
        Array_Drob(k, dr3);
        System.out.println("new array");
        for (int i = 0; i<k; i++) {
            System.out.println(dr3[i].toString());
        }
    }
    public static Drob[] Array_Drob(int k, Drob[] a){

        for (int i=0; i<k-1; i++){
            if(i%2==0){
                float tmp1=a[i].getM() + a[i+1].getM();
                float tmp2=a[i].getN() + a[i+1].getN();
                a[i].setM(tmp1);
                a[i].setN(tmp2);
            }
        }
        return a;
    }
    public static float Change(Drob a){
        float first_ch = a.getM();
        float first_zn = a.getN();
        float tmp1 =0;
        tmp1 = first_ch/first_zn;
        return tmp1;
    }
    public static float Plus(Drob a, Drob b){
        float tmp1 =Change(a);
        float tmp2 = Change(b);
        return tmp1 + tmp2;
    }
    public static float Minus(Drob a, Drob b){
        float tmp1 =Change(a);
        float tmp2 = Change(b);
        return tmp1 - tmp2;
    }
    public static float Multiply(Drob a, Drob b){
        float tmp1 =Change(a);
        float tmp2 = Change(b);
        return tmp1 * tmp2;
    }
    public static float Delete(Drob a, Drob b){
        float tmp1 =Change(a);
        float tmp2 = Change(b);
        if (tmp2 != 0) {
            return tmp1 / tmp2;
        }
        else
            System.out.println("Деление на ноль");
        return 0;
    }
}
