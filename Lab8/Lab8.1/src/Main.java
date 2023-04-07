import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
/*
    7.	Реализовать многопоточное приложение “Банк”. Имеется банковский счет.
    Сделать синхронным пополнение и снятие денежных средств на счет/со счет случайной суммой.
    При каждой операции (пополнения или снятие) вывести текущий баланс счета.
    В том случае, если денежных средств недостаточно – вывести сообщение.
 */

    public static void main(String[] args) throws InterruptedException {
        final Lock lock = new ReentrantLock(true);
        Bank bank = new Bank();
        System.out.println("счет создан");
        boolean active = true;
        Random random = new Random();
        Thread first = new Thread(new Runnable()
        {
            public void run()
            {
                while (active) {

                    lock.lock();
                    try {
                        Thread.sleep(1000);
                        bank.put(random.nextInt(0,100));
                    } catch (InterruptedException e) {
                    }
                    lock.unlock();
                    // System.out.println("First!");

                }
            }
        });


        Thread second = new Thread(new Runnable()
        {
            public void run()
            {   while (active) {
                lock.lock();
                    try {
                        Thread.sleep(1000);
                        bank.output(random.nextInt(0,100));
                    } catch (InterruptedException e) {
                    }
                lock.unlock();
                    // System.out.println("Second!");

                }
            }
        });
        first.start();
        second.start();
        //first.join();
        second.join();
    }


}


class Bank{
    private float summ;

    public Bank(float summ) {
        this.summ = summ;
    }
    public Bank() {
        this.summ = 0;
    }

    public float getSumm() {
        return summ;
    }

    public void setSumm(float summ) {
        this.summ += summ;
    }
    public void put(float summ){
        setSumm(summ);
        System.out.println("summ=" + this.getSumm());
    }
    public void output(float summ){
        if (this.getSumm()-summ>=0){
            setSumm(-summ);
            System.out.println("summ=" + this.getSumm());
        }
        else System.out.println("недостаточно денег");

    }
}