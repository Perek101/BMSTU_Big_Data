
/*
    Реализовать абстрактные классы или интерфейсы, а также наследование и полиморфизм для следующих классов
    8.	interface Корабль <- class Грузовой Корабль <- class Танкер.
 */
public class Main {
    public static void main(String[] args) {
        Ship ship = new Tanker("American");
        ship.getShip();
        Tanker tanker = new Tanker("Rus");
        tanker.getCargoShip();
    }
}
interface Ship{
    void getShip();
}

abstract class CardoShip implements Ship{
    private String name;

    public String getName() {
        return name;
    }

    public CardoShip(String name) {
        this.name = name;
    }
    abstract void getCargoShip();

    @Override
    public void getShip() {
        System.out.print("interface Корабль <- class Грузовой Корабль ");
    }
}
class Tanker extends CardoShip{


    public Tanker(String name) {
        super(name);
    }

    @Override
    void getCargoShip(){
        System.out.print("<- class Танкер.");
    }
}