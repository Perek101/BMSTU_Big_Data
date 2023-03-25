import java.util.ArrayList;
import java.util.Date;

public class Disp_transport {

    private class Inner_Class {

        private ArrayList<String> lines;



        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public ArrayList<String> getLines() {
            return lines;
        }

        public void setLines(ArrayList<String> lines) {
            this.lines = lines;
        }

        public ArrayList<Integer> getPrice() {
            return price;
        }

        public void setPrice(ArrayList<Integer> price) {
            this.price = price;
        }

        private String date;
        private ArrayList<Integer> price;
        public void date(){

            Date getDateOfTask = new Date();
            getDateOfTask.getDate();
            this.setDate(String.valueOf(getDateOfTask));
            System.out.println(" информация о времени " + this.getDate());
        }
        public void lines(){
            ArrayList<String> line = new ArrayList<String>();
            line.add("Москва-Анапа");
            this.setLines(line);
            System.out.println(" линии маршрутов " + this.getLines());

        }
        public void price(){
            ArrayList<Integer> price = new ArrayList<Integer>();
            price.add(20);
            this.setPrice(price);
            System.out.println(" стоимость проезда " + this.getPrice());
        }
    }

    void display_Inner() {
        Inner_Class inner = new Inner_Class();
        inner.date();
        inner.lines();
        inner.price();
    }

    /*
    Создать класс Cправочная Cлужба Oбщественного Tранспорта с внутренним классом,
    с помощью объектов которого можно хранить информацию о времени, линиях маршрутов
    и стоимости проезда.
     */
    public static void main(String[] args) {

        Disp_transport dispTransport = new Disp_transport();
        dispTransport.display_Inner();
    }


}