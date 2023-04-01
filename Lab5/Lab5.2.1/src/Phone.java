import java.io.IOException;
import java.util.*;

public class Phone {
    static final int def = 10;
    int ID;
    String surname;
    String name;
    String otch;
    String address;
    int number_credit;
    int debet;
    int credit;
    int localtime;
    int globaltime;

    @Override
    public String toString() {
        return "ID=" + ID +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", otch='" + otch + '\'' +
                ", address='" + address + '\'' +
                ", number_credit=" + number_credit +
                ", debet=" + debet +
                ", credit=" + credit +
                ", localtime=" + localtime +
                ", globaltime=" + globaltime;
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOtch() {
        return otch;
    }

    public void setOtch(String otch) {
        this.otch = otch;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumber_credit() {
        return number_credit;
    }

    public void setNumber_credit(int number_credit) {
        this.number_credit = number_credit;
    }

    public int getDebet() {
        return debet;
    }

    public void setDebet(int debet) {
        this.debet = debet;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getLocaltime() {
        return localtime;
    }

    public void setLocaltime(int localtime) {
        this.localtime = localtime;
    }

    public int getGlobaltime() {
        return globaltime;
    }

    public void setGlobaltime(int globaltime) {
        this.globaltime = globaltime;
    }





    public void Show(){
        Phone a = this;
        if(a.localtime > def){
            System.out.println("a) сведения об абонентах, у которых время внутригородских разговоров превышает заданное: \n" +
                    "ID=" + ID +
                    ", surname='" + surname + '\'' +
                    ", name='" + name + '\'' +
                    ", otch='" + otch + '\'' +
                    ", localtime=" + localtime );
        }
        if(a.globaltime>0){
            System.out.println("b) сведения об абонентах, которые пользовались междугородной связью: \n" +
                    "ID=" + ID +
                    ", surname='" + surname + '\'' +
                    ", name='" + name + '\'' +
                    ", otch='" + otch + '\'' +
                    ", globaltime=" + globaltime );
        }
    }

    /* Phone: id, Фамилия, Имя, Отчество, Адрес, Номер кредитной карточки, Дебет, Кредит,
       Время городских и междугородных разговоров. Создать массив объектов.
       Вывести:
            a) сведения об абонентах, у которых время внутригородских разговоров превышает заданное;
            b) сведения об абонентах, которые пользовались междугородной связью;
            c) сведения об абонентах в алфавитном порядке.
     */
    public static void main(String[] args) throws IOException {
        Random rnd = new Random();
        Scanner myObj = new Scanner(System.in);
        //int k=rnd.nextInt(2,4);
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

        Phone[] ph = new Phone[k];
        for (int i = 0; i<k; i++){
            ph[i] = new Phone();
            ph[i].ID=i;
            System.out.println(" new user");
            myObj.nextLine();
            System.out.println("Input surname: ");
            ph[i].surname = myObj.nextLine();
            System.out.println("Input name: ");
            ph[i].name = myObj.nextLine();
            System.out.println("Input otch: ");
            ph[i].otch = myObj.nextLine();
            System.out.println("Input address: ");
            ph[i].address = myObj.nextLine();
            System.out.println("Input number credit card: ");
            try {
                ph[i].debet = myObj.nextInt();

           // ph[i].number_credit = myObj.nextInt();
                System.out.println("Input debet: ");
                ph[i].debet = myObj.nextInt();
                System.out.println("Input credit: ");
                ph[i].credit = myObj.nextInt();
                System.out.println("Input debet: ");
                ph[i].debet = myObj.nextInt();
                System.out.println("Input localtime: ");
                ph[i].localtime = myObj.nextInt();
                System.out.println("Input globaltime: ");
                ph[i].globaltime = myObj.nextInt();
            }catch (InputMismatchException e){
                throw new InputMismatchException("NAN " + myObj.next());
            }
        }
        System.out.println("-------------------------------------------");
        for (int i = 0; i<k; i++){
            System.out.println(ph[i].toString());
        }
        System.out.println("-------------------------------------------");
        for (int i = 0; i<k; i++){
            ph[i].Show();
        }
        System.out.println("-------------------------------------------");
        Arrays.sort(ph, (a, b) -> a.name.compareTo(b.name));
        for (int i = 0; i<k; i++){
            System.out.println(ph[i].toString());
        }

    }
}