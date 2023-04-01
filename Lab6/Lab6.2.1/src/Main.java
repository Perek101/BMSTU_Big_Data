import java.util.ArrayList;
import java.util.Random;
import java.util.TreeMap;
import java.util.Vector;

/*
7.	На плоскости задано N отрезков.
    Найти точку пересечения двх отрезков, имеющую минимальную абсциссу. Использовать класс TreeMap.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        float k1,k2,b1,b2;
        int temp=0;
        TreeMap<Integer, Integer> firstOtrezok = new TreeMap<>();
        TreeMap<Integer, Integer> secondOtrezok = new TreeMap<>();
        TreeMap<Integer,Float> peresechenie = new TreeMap<>();
        Random rnd = new Random();
        firstOtrezok.put(0,rnd.nextInt(1,5));  //x1
        firstOtrezok.put(1,rnd.nextInt(1,5));  //y1
        firstOtrezok.put(2,rnd.nextInt(1,5)); //x2
        firstOtrezok.put(3,rnd.nextInt(1,5));  //y2
        secondOtrezok.put(0,rnd.nextInt(1,5));  //x3
        secondOtrezok.put(1,rnd.nextInt(1,5));  //y3
        secondOtrezok.put(2,rnd.nextInt(1,5));  //x4
        secondOtrezok.put(3,rnd.nextInt(1,5));  //y4
        System.out.println(firstOtrezok + " "+secondOtrezok);
        if (firstOtrezok.get(0)>= firstOtrezok.get(2)){
            int tempX=firstOtrezok.get(2);
            int tempY=firstOtrezok.get(3);
            firstOtrezok.put(2,firstOtrezok.get(0));
            firstOtrezok.put(0, tempX);
            firstOtrezok.put(3, firstOtrezok.get(1));
            firstOtrezok.put(1, tempY);
        }
        if (secondOtrezok.get(0)>= secondOtrezok.get(2)){
            int tempX=secondOtrezok.get(2);
            int tempY=secondOtrezok.get(3);
            secondOtrezok.put(2,secondOtrezok.get(0));
            secondOtrezok.put(0, tempX);
            secondOtrezok.put(3, secondOtrezok.get(1));
            secondOtrezok.put(1, tempY);
        }
        System.out.println(firstOtrezok + " "+secondOtrezok);
        if (firstOtrezok.get(1).equals(firstOtrezok.get(3))){
            k1=0;
        }else {
            //k1 =  ( у2 - у1 ) / ( x2 - x1 )
            k1 = (float)(firstOtrezok.get(3)-firstOtrezok.get(1)) / (firstOtrezok.get(2)- firstOtrezok.get(0));
        }
        if (secondOtrezok.get(1).equals(secondOtrezok.get(3))){
            k2=0;
        }else {
            //k2 =  ( у4 - у3 ) / ( x4 - x3 )
            k2 = (float)(secondOtrezok.get(3)-secondOtrezok.get(1)) / (secondOtrezok.get(2)- secondOtrezok.get(0));
        }
        if(k1==k2){
            System.out.println("отрезки не пересекаются");
            return;
        }
        b1 = firstOtrezok.get(1) - k1* firstOtrezok.get(0);
        b2 = secondOtrezok.get(1) - k1* secondOtrezok.get(0);
        if(firstOtrezok.get(2)>secondOtrezok.get(2)){
            temp=firstOtrezok.get(2);
        }else temp=secondOtrezok.get(2);
        for (float i=0; i<temp; i+=0.0001){
            //k1 x + b1 = k2 x + b2
            if ((k1*i+b1)==(k2*i+b2)){
                //System.out.println(i);
                peresechenie.put(0,i);  //x
                peresechenie.put(1,k1*i+b1);  //y
            }

        }
        if(peresechenie.isEmpty()){
            System.out.println("пересечения нет или недостаточная точность поиска по Х");
        }else {
            System.out.println("x=" + peresechenie.firstEntry().getValue() + " y="+ peresechenie.get(peresechenie.firstEntry().getKey()+1));
        }
    }
}