import java.util.ArrayList;

public class Computer {
    private class Inner_Class {

        private ArrayList<String> opSistem;

        public ArrayList<String> getOpSistem() {
            return opSistem;
        }

        public void setOpSistem(ArrayList<String> opSistem) {
            this.opSistem = opSistem;
        }

        public ArrayList<String> getProcessor() {
            return processor;
        }

        public void setProcessor(ArrayList<String> processor) {
            this.processor = processor;
        }
        public ArrayList<Integer> getopmemory() {
            return opmemory;
        }

        public void setopmemory(ArrayList<Integer> opmemory) {
            this.opmemory = opmemory;
        }

        private ArrayList<String> processor;
        private ArrayList<Integer> opmemory;
        public void processor(){
            ArrayList<String> proc = new ArrayList<String>();
            proc.add("Intel core i5-12400f");
            this.setProcessor(proc);
            System.out.println(" процессор " + this.getProcessor());
        }
        public void opSistem(){
            ArrayList<String> opsyst = new ArrayList<String>();
            opsyst.add("Gentoo");
            this.setOpSistem(opsyst);
            System.out.println(" операционная система " + this.getOpSistem());

        }
        public void opmemory(){
            ArrayList<Integer> opmemory = new ArrayList<Integer>();
            opmemory.add(16);
            this.setopmemory(opmemory);
            System.out.println(" память " + this.getopmemory());
        }
    }

    void display_Inner() {
        Inner_Class inner = new Inner_Class();
        inner.processor();
        inner.opSistem();
        inner.opmemory();
    }

    /*
    Создать класс Computer (компьютер) с внутренним классом,
    с помощью объектов которого можно хранить информацию об операционной системе,
    процессоре и оперативной памяти.
     */
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.display_Inner();
    }
}