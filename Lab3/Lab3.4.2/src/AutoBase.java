import java.util.*;

/*
  Система Автобаза. Диспетчер распределяет заявки на Рейсы между Водителями и назначает для этого Автомобиль.
  Водитель может сделать заявку на ремонт. Диспетчер может отстранить Водителя от работы.
  Водитель делает отметку о выполнении Рейса и состоянии Автомобиля.
 */
public class AutoBase {


    public static void main(String[] args) {

        Scanner myObj = new Scanner(System.in);
        Driver driver = new Driver();
        ArrayList<Driver> drivers = new ArrayList<Driver>(1);
        Car car = new Car();
        ArrayList<Car> cars = new ArrayList<>(1);
        Flight flight= new Flight();
        ArrayList<Flight> flights= new ArrayList<Flight>(1);
        Disprtcher disprtcher= new Disprtcher();
        String car_name = "";
        String driver_name = "";
        String flight_name = "";
        System.out.println("Добро пожаловать! Выберите действие:\n" +
                "1) Добавить авто\n" +
                "2) Добавить водителя\n" +
                "3) Добавить рейс\n" +
                "4) Распределение заявки и авто\n" +
                "5) Заявка на ремонт\n" +
                "6) Отстронить водителя\n" +
                "7) Отметка о рейсе и состоянии авто\n" +
                "8) Вывод данных диспетчера\n" +
                "0) Выход");
        while (true){
            System.out.println("Выберете действие: ");
            int tmp = myObj.nextInt();
            switch (tmp) {
                case 1:
                    System.out.print("Введите название авто: ");
                    car_name = myObj.nextLine()+ myObj.nextLine();
                    car = new Car(car_name);
                    cars.add(car);
                    System.out.println("авто добавлено");
                    break;
                case 2:
                    System.out.print("Введите ФИО: ");
                    driver_name = myObj.nextLine()+ myObj.nextLine();
                    driver = new Driver(driver_name);
                    drivers.add(driver);
                    System.out.println("водитель создан");
                    break;
                case 3:
                    System.out.print("Введите рейс: ");
                    flight_name = myObj.nextLine()+ myObj.nextLine();
                    flight = new Flight(flight_name);
                    flights.add(flight);
                    System.out.println("рейс создан");
                    break;
                case 4:
                    System.out.print("Выберите рейс: ");
                    System.out.println(flights.toString());
                    int flight_name1 = myObj.nextInt() ;
                    System.out.print("Выберите авто: ");
                    System.out.println(cars.toString());
                    int car_name1 = myObj.nextInt();
                    System.out.print("Выберете водителя: ");
                    System.out.println(drivers.toString());
                    int driver_name1 = myObj.nextInt();
                    disprtcher.zayavka(cars.get(car_name1), flights.get(flight_name1), drivers.get(driver_name1));
                    break;
                case 5:
                    System.out.print("Выберите авто: ");
                    System.out.println(cars.toString());
                    int car_name2 = myObj.nextInt();
                    System.out.print("Выберете водителя: ");
                    System.out.println(drivers.toString());
                    int driver_name2 = myObj.nextInt();
                    disprtcher.remont(cars.get(car_name2), drivers.get(driver_name2));
                    break;
                case 6:
                    System.out.print("Выберете водителя: ");
                    System.out.println(drivers.toString());
                    int driver_name3 = myObj.nextInt();
                    disprtcher.otstran(drivers.get(driver_name3));
                    drivers.remove(driver_name3);
                    break;
                case 7:
                    System.out.print("Выберите рейс: ");
                    System.out.println(flights.toString());
                    int flight_name4 = myObj.nextInt() ;
                    System.out.print("Выберите авто: ");
                    System.out.println(cars.toString());
                    int car_name4 = myObj.nextInt();
                    System.out.print("Выберете водителя: ");
                    System.out.println(drivers.toString());
                    int driver_name4 = myObj.nextInt();
                    System.out.print("Введите состояние авто: ");
                    String sost_car = myObj.nextLine()+ myObj.nextLine();
                    System.out.print("Введите состояние рейса: ");
                    String sost_fl = myObj.nextLine()+ myObj.nextLine();
                    disprtcher.otmetka(cars.get(car_name4), drivers.get(driver_name4), flights.get(flight_name4), sost_fl, sost_car);
                    break;
                case 8:
                    System.out.println(disprtcher.toString());
                    break;

                case 0:
                    break;

            }
            if (tmp == 0){
                break;
            }
        }

    }
}


class Disprtcher {

    private ArrayList<Driver> drivers;
    private ArrayList<Car> cars;

    private ArrayList<Flight> flights;

    @Override
    public String toString() {
        return "Disprtcher{" +
                " Flight=" + flights.toString() +
                ", drivers=" + drivers.toString() +
                ", cars=" + cars.toString() +
                '}';
    }



    public Disprtcher() {
        ArrayList<Car> car1 = new ArrayList<Car>(1);
        // uslugis.add(uslugi_);
        this.cars = car1;
        ArrayList<Driver> drivers1 = new ArrayList<Driver>(1);
        // uslugis.add(uslugi_);
        this.drivers = drivers1;
        ArrayList<Flight> flights1 = new ArrayList<Flight>(1);
        // uslugis.add(uslugi_);
        this.flights = flights1;
    System.out.println("конструктор: " + drivers.toString() + cars.toString() + flights.toString());

    }

    public void zayavka(Car car, Flight flight, Driver driver){

        Driver driver1 = driver;
        this.drivers.add(driver1);
        Car car1 = car;
        this.cars.add(car1);
        Flight flight1 = flight;
        this.flights.add(flight1);
        System.out.println("Водитель " + driver + " заявлен на рейс "+ flight + " на автомобиле "+ car);
        System.out.println(drivers.toString() + cars.toString() + flights.toString());
    }
    public void remont(Car car, Driver driver){
        this.cars.remove(car);
        car.setSost("в ремонт");
        System.out.println("Водитель " + driver.getFIO() + " сделал заявку на ремонт автомобиля " +
                car.getName());
        this.cars.add(car);
    }
    public  void otstran(Driver driver){
        this.drivers.remove(driver);
        System.out.println(drivers.toString());
    }
    public  void addDriver(Driver driver){
        this.drivers.add(driver);
        System.out.println(drivers.toString());
    }
    public void otmetka(Car car, Driver driver, Flight flight, String sost_fl, String sost_cr){
        this.cars.remove(car);
        this.flights.remove(flight);
        car.setSost(sost_cr);
        flight.setSost(sost_fl);
        System.out.println("Водитель " + driver.getFIO() + "сдеал отметку о состоянии авто\n" +
                car.getName() + " "+ car.getSost()+ "\n" +
                "и состоянии маршрута: \n"+
                flight.getSost());
        this.cars.add(car);
        this.flights.add(flight);
    }



}

class Car{
    private String name;
    private String sost;

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", sost='" + sost + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSost() {
        return sost;
    }

    public void setSost(String sost) {
        this.sost = sost;
    }

    public Car() {

    }
    public Car(String name){
        this.name = name;
        this.sost = "хорошее";

    }
}
class Driver{
    private String FIO;

    public Driver(String FIO) {
        this.FIO = FIO;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "FIO='" + FIO + '\'' +
                '}';
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public Driver() {
    }
}
//рейс
class Flight{
   private String marshrut;
   private String sost;

    public String getSost() {
        return sost;
    }

    public void setSost(String sost) {
        this.sost = sost;
    }

    public Flight(String marshrut) {
        this.marshrut = marshrut;
        this.sost = "не начат";
    }
    public Flight() {
    }

    public String getMarshrut() {
        return marshrut;
    }

    public void setMarshrut(String marshrut) {
        this.marshrut = marshrut;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "marshrut='" + marshrut + '\'' +
                '}';
    }
}



