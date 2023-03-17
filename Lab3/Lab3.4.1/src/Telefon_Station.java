import java.util.*;

/*
    Система Телефонная станция. Абонент оплачивает Счет за разговоры и Услуги,
    может попросить Администратора сменить номер и отказаться от услуг.
    Администратор изменяет номер, Услуги и временно отключает Абонента за неуплату.
 */
public class Telefon_Station {


    public static void main(String[] args) {
        Random rnd = new Random();
        Scanner myObj = new Scanner(System.in);
        String str1 = "";
        String name_uslugi = "";
        boolean podcluchen = true;
        int ID = 0;
        int summa = 0;
        int summa1 = 0;
        Uslugi uslugi = new Uslugi();
        Chet chet1= new Chet();
        ArrayList<Chet> chets = new ArrayList<>(1);
        Abonent abonent1 = new Abonent();
        ArrayList<Abonent> abonents = new ArrayList<>(1);
        //abonents.add(new Abonent());
        Admin admin = new Admin();
        System.out.println("Добро пожаловать! Выберите действие:\n" +
                "1) Добавить услугу\n" +
                "2) Добавить счет\n" +
                "3) Добавить абонента\n" +
                "4) Пополнить счет\n" +
                "5) Добавить услугу на счет\n" +
                "6) Сменить номер\n" +
                "7) Установить неуплату\n" +
                "8) Отказкаться от услуги\n" +
                "9) Вывод данных об абоненте" +
                "0) Выход");
        while (true){
            System.out.println("Выберете действие: ");
            int tmp = myObj.nextInt();
            switch (tmp) {
                case 1:
                    System.out.print("Введите название: ");
                    name_uslugi = myObj.nextLine()+ myObj.nextLine();
                    uslugi = new Uslugi(name_uslugi, podcluchen);
                    System.out.println("услуга создана");
                    break;
                case 2:
                    //создать счет
                    int number_phone = rnd.nextInt();
                    chet1= new Chet(ID, number_phone, summa);
                    chets.add(chet1);
                    ID++;
                    System.out.println("счет создан");
                    break;
                case 3:
                    System.out.print("ФИО: ");
                    String str = myObj.nextLine()+ myObj.nextLine();
                    System.out.println("Выбере счет: " + chets.toString());
                    int str_1 = myObj.nextInt();
                    abonent1 = new Abonent(str, chets.get(str_1));
                    abonents.add(abonent1);
                    System.out.println("абонент создан");
                    break;

                case 4:
                    System.out.print("Введите сумму: ");
                    summa1 = myObj.nextInt();
                    System.out.println("Выбере абонента: " + abonents.toString());
                    int str_2 = myObj.nextInt();
                    abonents.get(str_2).pay_chet(summa1);
                    System.out.println("счет пополнен");
                    break;
                case 5:
                    System.out.print("Введите название: ");
                    name_uslugi = myObj.nextLine()+ myObj.nextLine();
                    //chet1.uslugi_chet(name_uslugi, true);
                    System.out.println("Выбере абонента: " + abonents.toString());
                    int str_3 = myObj.nextInt();
                    admin.add(abonents.get(str_3),  name_uslugi);
                    System.out.println("услуга  добавлена" + abonents.get(str_3) + " +" + name_uslugi);
                    break;
                case 6:
                    System.out.println("Выбере абонента: " + abonents.toString());
                    int str_4 = myObj.nextInt();
                    admin.change_number(abonents.get(str_4));
                    System.out.println("номер поменян");
                    break;
                case 7:
                    System.out.println("Выбере абонента: " + abonents.toString());
                    int str_5 = myObj.nextInt();
                    abonents.get(str_5).pay_chet(-summa1-2);
                    System.out.println("неуплата установлена");
                    admin.neuplata( abonents.get(str_5));
                    break;
                case 8:
                    System.out.print("Введите название: ");
                    name_uslugi = myObj.nextLine()+ myObj.nextLine();
                    System.out.println("Выбере абонента: " + abonents.toString());
                    int str_6 = myObj.nextInt();
                    admin.otkaz(abonents.get(str_6),  name_uslugi);
                    System.out.println("отказ прошел");
                    break;
                case 9:
                    System.out.println("Вывод данных абонента\n"+
                            abonents.toString());

                case 0:
                    break;

            }
            if (tmp == 0){
                break;
            }
        }
    }
}


class Abonent {
    private String FIO;
    private Chet chet;

    @Override
    public String toString() {
        return "Abonent{" +
                "FIO='" + FIO + '\'' +
                ", chet=" + chet +
                ", neuplata=" + neuplata +
                '}';
    }

    private boolean neuplata = false;

    public Abonent(String str, Chet chet) {
        this.setFIO(str);
        this.setNeuplata(false);
        this.setChet(chet);
    }
    public Abonent() {
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public Chet getChet() {
        return chet;
    }

    public void setChet(Chet chet) {
        this.chet = chet;
    }

    public boolean isNeuplata() {
        return neuplata;
    }

    public void setNeuplata(boolean neuplata) {
        this.neuplata = neuplata;
    }

    public void pay_chet(int summa){
        this.chet.setSumma(this.chet.getSumma() + summa);
        System.out.println("Сумма увелчена на " + summa + "\nCумма на счете: "+ this.chet.getSumma());
    }


}

class Admin{

    private Abonent abonent;


    public void change_number( Abonent abonent){
        Random rnd = new Random();
        this.abonent=abonent;
        this.abonent.getChet().setNumber(rnd.nextInt());
        System.out.println("номер изменет на " + this.abonent.getChet().getNumber());
    }
    public void neuplata(Abonent abonent){
        this.abonent=abonent;
        this.abonent.setNeuplata(true);
        System.out.println("неуплата");
    }
    public void otkaz(Abonent abonent, String str){
        this.abonent = abonent;
        Iterator<Uslugi> iterator = this.abonent.getChet().getUslugi().iterator();
        while (iterator.hasNext()){
            Uslugi uslugi = iterator.next();
            if (uslugi.getName_uslugi().contains(str)) {
                iterator.remove();
                System.out.println("услуга "+ str + " отключена");
            }
        }

    }

    public void add(Abonent abonent, String str){
        this.abonent = abonent;
        Uslugi uslugi = new Uslugi(str, true);
        this.abonent.getChet().setUslugi(uslugi);
    }


    public Abonent getAbonent() {
        return abonent;
    }

    public void setAbonent(Abonent abonent) {
        this.abonent = abonent;
    }


}
class Uslugi{
    private String name_uslugi;
    private boolean uslugi;

    public String getName_uslugi() {
        return name_uslugi;
    }

    public Uslugi() {

    }

    public void setName_uslugi(String name_uslugi) {
        this.name_uslugi = name_uslugi;
    }
    public boolean getUslugi() {
        return uslugi;
    }

    public void setUslugi(boolean uslugi) {
        this.uslugi = uslugi;
    }
    public Uslugi(String name_uslugi, boolean uslugi) {
        this.name_uslugi = name_uslugi;
        this.uslugi = uslugi;
    }

    @Override
    public String toString() {
        return "Uslugi{" +
                "name_uslugi='" + name_uslugi + '\'' +
                ", uslugi=" + uslugi +
                '}';
    }
}
class Chet{
    private int ID;
    private int number;
    private ArrayList<Uslugi> uslugi;
    private int summa;

    public Chet() {
    }
    public Chet(int id, int numberPhone,  int summa) {
        this.setID(id);
        this.setNumber(numberPhone);
        this.setSumma(summa);
        // System.out.println(uslugi_.getName_uslugi());
        //this.uslugi = uslugi_;
        ArrayList<Uslugi> uslugis = new ArrayList<Uslugi>(1);
       // uslugis.add(uslugi_);
        this.uslugi = uslugis;

    }

    //Добавить услуги на счёте
    public void uslugi_chet(String name_usl, boolean bool){

        Uslugi uslugi1 = new Uslugi(name_usl, bool);
        this.uslugi.add(uslugi1);



    }

    @Override
    public String toString() {
        return "Chet{" +
                "ID=" + ID +
                ", number=" + number +
                ", uslugi=" + uslugi.toString() +
                ", summa=" + summa +
                '}';
    }




    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public ArrayList<Uslugi> getUslugi() {
        return uslugi;
    }

    public void setUslugi(Uslugi uslugi) {
        this.uslugi.add(uslugi);
    }

    public int getSumma() {
        return summa;
    }

    public void setSumma(int summa) {
        this.summa = summa;
    }

}


