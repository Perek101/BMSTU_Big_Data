public class Main {
    /*
    2.	Реализовать многопоточное приложение “Робот”. Надо написать робота, который умеет ходить.
    За движение каждой его ноги отвечает отдельный поток. Шаг выражается в выводе в консоль LEFT или RIGHT.
     */
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Object lock = new Object();
        Robot robot =new Robot("Left",lock);
        Robot robot1 = new Robot("Right",lock);
        Thread leftLegThread = new Thread(robot);
        Thread rightLegThread = new Thread(robot1);
        leftLegThread.start();
        rightLegThread.start();


    }

}

class Robot implements Runnable{
    private String Leg;
    private final Object lock;

    public void setLeg(String leg) {
        Leg = leg;
    }

    public String getLeg() {
        return Leg;
    }
    public Robot(String leg, Object lock) {
        this.lock = lock;
        this.setLeg(leg);
    }

    public void run() {
        while (true) synchronized (lock) {
            System.out.println(this.getLeg() + " step");
            lock.notify();
            try {
                lock.wait(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}