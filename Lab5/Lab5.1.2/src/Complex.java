import java.util.Random;
import java.util.Vector;

public class Complex {
    private float re;
    private float im;

    public Complex(float real, float imag) {
        this.re = real;
        this.im = imag;
    }
    public Complex(float real) {
        this.re = real;
        this.im = 0;
    }
    public  Complex() {
        this.re = 2;
        this.im = 1;
    }
    @Override
    public String toString() {
        if (im == 0) return re + "";
        if (re == 0) return im + "i";
        if (im <  0) return re + " - " + (-im) + "i";
        return re + " + " + im + "i";
    }
    public Complex Plus(Complex b) {
        Complex a = this;
        float real = a.re + b.re;
        float imag = a.im + b.im;
        return new Complex(real, imag);
    }
    public Complex Minus(Complex b) {
        Complex a = this;
        float real = a.re - b.re;
        float imag = a.im - b.im;
        return new Complex(real, imag);
    }
    public Complex Multiply(Complex b) {
        Complex a = this;
        float real = a.re * b.re - a.im * b.im;
        float imag = a.re * b.im + a.im * b.re;
        return new Complex(real, imag);
    }

    public Complex reciprocal() throws ArithmeticException{
        float scale = re * re + im * im;
        if (scale == Float.POSITIVE_INFINITY || scale == Float.NEGATIVE_INFINITY) {
            throw new ArithmeticException("Деление на ноль");
        }
        return new Complex(re / scale, -im / scale);
    }
    public Complex Delete(Complex b) {
        Complex a = this;
        return a.Multiply(b.reciprocal());
    }
    public static Vector<Complex> Vect(Vector<Complex> v1, Vector<Complex> v2) throws IllegalArgumentException{


        try {
            for (int i=0; i< v1.capacity(); i++){
                v1.set(i,v1.get(i).Plus(v2.get(i)));
            }
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Неверный размер вектора");
        }
        return v1;
    }
    /*  Определить класс Комплекс. Класс должен содержать несколько конструкторов.
        Реализовать методы для сложения, вычитания, умножения, деления, присваивания комплексных чисел.
        Создать два вектора размерности n из комплексных координат.
        Передать их в метод, который выполнит их сложение. */
    public static void main(String[] args) {
        Random rnd = new Random();
        Complex a = new Complex(rnd.nextInt(-5, 5), rnd.nextInt(-5, 5));
        Complex b = new Complex(rnd.nextInt(-5, 5), rnd.nextInt(-5, 5));

        System.out.println("a            = " + a);
        System.out.println("b            = " + b);
        System.out.println("b + a        = " + b.Plus(a));
        System.out.println("a - b        = " + a.Minus(b));
        System.out.println("a * b        = " + a.Multiply(b));
        System.out.println("a / b        = " + a.Delete(b));

        int n=rnd.nextInt(2,7);
        Vector<Complex> v1 = new Vector<Complex>(n);
        Vector<Complex> v2 = new Vector<Complex>(n);
        try {
            for (int i = 0; i<n; i++) {
                v1.add(new Complex(rnd.nextInt(-5, 5), rnd.nextInt(-5, 5)));
                v2.add(new Complex(rnd.nextInt(-5, 5), rnd.nextInt(-5, 5)));
            }
        }catch (OutOfMemoryError e){
            throw new OutOfMemoryError("виртуальная машина Java не может выделить объект из-за нехватки памяти");
        }catch (Exception e){
            System.out.println("Что-то пошло не так");
        }
        System.out.println(v1.toString());
        System.out.println(v2.toString());
        Vect(v1,v2);
        System.out.println("new Vector");
        System.out.println(v1.toString());


    }

}
