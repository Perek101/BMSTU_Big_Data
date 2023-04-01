import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Car {

    int ID;
    String mark;
    String model;
    int year;
    String color;
    int price;
    String reg_num;

    @Override
    public String toString() {
        return "Car{" +
                "ID=" + ID +
                ", mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", reg_num='" + reg_num + '\'' +
                '}';
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getReg_num() {
        return reg_num;
    }

    public void setReg_num(String reg_num) {
        this.reg_num = reg_num;
    }




    public void Show(String mark, String model, int n, int m, int price) {
        Car a = this;
        if (a.mark.contains(mark)) {
            System.out.println("a) список автомобилей заданной марки: \n" +
                    "ID=" + ID +
                    ", mark='" + a.mark + '\'' +
                    ", model='" + a.model + '\'' +
                    ", year='" + year + '\'' +
                    ", reg num=" + reg_num);
        }
        if (a.model.contains(model) && (2023 - a.year > n)){
            System.out.println("b) список автомобилей заданной модели, которые эксплуатируются больше n лет: \n" +
                    "ID=" + ID +
                    ", mark='" + a.mark + '\'' +
                    ", model='" + a.model + '\'' +
                    ", year='" + year + '\'' +
                    ", reg num=" + reg_num);
        }
        if (a.year == m && a.price > price){
            System.out.println("c) список автомобилей заданного года выпуска, цена которых больше указанной: \n" +
                    "ID=" + ID +
                    ", mark='" + a.mark + '\'' +
                    ", model='" + a.model + '\'' +
                    ", year='" + year + '\'' +
                    ", price='" + a.price + '\'' +
                    ", reg num=" + reg_num);
        }
    }
    /*  Car: id, Марка, Модель, Год выпуска, Цвет, Цена, Регистрационный номер. Создать массив объектов.
            Вывести:
                a) список автомобилей заданной марки;
                b) список автомобилей заданной модели, которые эксплуатируются больше n лет;
                c) список автомобилей заданного года выпуска, цена которых больше указанной.
         */
    public static void main(String[] args) {
        Random rnd = new Random();
        Scanner myObj = new Scanner(System.in);
        //int k=rnd.nextInt(2,4);
        //int k =2;
        int k=0;
        System.out.println("k=");
        try {
            k =myObj.nextInt();
            if (k<=0){
                throw new ExcClass("k должно быть больше 0");
            }
        }catch (ExcClass e){
            e.myOwnExceptionMsg();
        }
        Car[] ph = new Car[k];
        for (int i = 0; i<k; i++){
            ph[i] = new Car();
            ph[i].ID=i;
            System.out.println(" new car ");
            System.out.println("Input mark: ");
            ph[i].mark = myObj.nextLine() + myObj.nextLine();
            System.out.println("Input model: ");
            ph[i].model = myObj.nextLine() ;
            System.out.println("Input color: ");
            ph[i].color = myObj.nextLine() ;
            System.out.println("Input reg number: ");
            ph[i].reg_num = myObj.nextLine() ;
            try {
                System.out.println("Input year: ");
                ph[i].year = myObj.nextInt();
                System.out.println("Input price: ");
                ph[i].price = myObj.nextInt();
            }catch (InputMismatchException e){
                throw new InputMismatchException("NAN: " + myObj.next());
            }

            myObj.nextLine();
        }

        String mark = "BMW";
        String model = "3";
        int n = 7;
        int m = 2010;
        int price = 100;


        System.out.println("-------------------------------------------");
        for (int i = 0; i<k; i++){
            System.out.println(ph[i].toString());
        }
        System.out.println("-------------------------------------------");
        for (int i = 0; i<k; i++){
            ph[i].Show(mark, model, n, m, price);
        }
    }
}