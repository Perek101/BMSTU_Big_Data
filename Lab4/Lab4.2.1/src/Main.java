/*
 Реализовать абстрактные классы или интерфейсы, а также наследование и полиморфизм для следующих классов
 7.	interface Врач <- class Хирург <- class Нейрохирург.
  */
public class Main {
    public static void main(String[] args) {
        Doctor doctor = new NeuroSurgeon("lol");
        doctor.getProfessoin();
        NeuroSurgeon neuroSurgeon = new NeuroSurgeon("lol");
        neuroSurgeon.getNapravlenie();



    }
}
interface Doctor{
    void getProfessoin();
}

abstract class Surgeon implements Doctor{
    private String name;

    public String getName() {
        return name;
    }

    public Surgeon(String name) {
        this.name = name;
    }
    abstract void getNapravlenie();

    @Override
    public void getProfessoin() {
        System.out.print("interface Врач <- class Хирург ");
    }
}
class NeuroSurgeon extends Surgeon{


    public NeuroSurgeon(String name) {
        super(name);
    }

    @Override
    void getNapravlenie() {
        System.out.print("<- Нейрохирург");
    }
}
