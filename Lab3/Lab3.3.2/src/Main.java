import java.util.Objects;

/*
Создать объект класса Пианино, используя класс Клавиша.
Методы: настроить, играть на пианино, нажимать клавишу.
 */
public class Main {
    public static void main(String[] args) {
        Piano a = new Piano("Yamaha", 9);
        Piano b = new Piano();
        Button a1 = new Button();
        Button b1 = new Button(5);
        a.Set();
        a.Play();
        b.Presbut(4);
        System.out.println(b.toString());
        System.out.println(b1.toString());
        System.out.println(a.equals(b));
        System.out.println(a1.equals(b1));
        System.out.println(a.hashCode());
        System.out.println(a1.hashCode());
    }
}
class Button { //колесо
    int but;
    //пара конструкторов
    Button() {
        but = 1;
    }
    @Override
    public boolean equals(Object ob)
    {
        if (ob == this) {
            return true;
        }

        if (ob == null || ob.getClass() != getClass()) {
            return false;
        }

        Button p = (Button) ob;

        return Objects.equals(but, p.but);
    }
    @Override
    public int hashCode()
    {
        return Objects.hash(but);
    }
    @Override
    public String toString() {
        return "Button{" +
                "Button=" + but +
                '}';
    }

    Button(int num) {
        this.but = num;
    }
}

class Piano extends Button {
    String Piano;
    Piano() { //конструктор
        super();
        Piano = "Yamaha";
    }

    Piano(String Piano, int num) {
        super(num);
        this.Piano = Piano;
    }
    void Set() {
        System.out.println("Настроить");
    }
    void Play() {
        System.out.println("Играть на пианино");
    }
    void Presbut(int n) {
        System.out.println("Нажать клавишу:" + n);
        this.but = n;
    }
    @Override
    public boolean equals(Object ob)
    {
        if (ob == this) {
            return true;
        }

        if (ob == null || ob.getClass() != getClass()) {
            return false;
        }

        Piano p = (Piano) ob;

        return Objects.equals(Piano, p.Piano);
    }
    @Override
    public int hashCode()
    {
        return Objects.hash(Piano);
    }

    @Override
    public String toString() {
        return "Piano{" +
                "Piano='" + Piano + '\'' +
                ", Button=" + but +
                '}';
    }
}