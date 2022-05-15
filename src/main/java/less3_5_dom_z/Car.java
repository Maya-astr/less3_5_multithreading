package less3_5_dom_z;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Car implements Runnable{
    private static int CARS_COUNT;
    private static boolean winnerFound;
    private static Lock win = new ReentrantLock();

    static {
        CARS_COUNT = 0;
    }

    private Race race;
    private int speed;
    private String name;
    private int count;
    private CyclicBarrier fir;
    private CountDownLatch sec;


    public String getName(){
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public int getCount() {
        return count;
    }
    public Car(Race race, int speed, CyclicBarrier fir, CountDownLatch sec) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Participant"+ CARS_COUNT;
        this.fir = fir;
        this.sec = sec;
    }


    @Override
    public void run() {
        try {
            System.out.println(this.name + "  preparing");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + "  ready");
            fir.await();
            fir.await();
            for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go(this);
            }
            checkWinner(this);

            fir.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static synchronized void checkWinner(Car c) {
        if (!winnerFound) {
            System.out.println(c.name + " - victory");
            winnerFound = true;
        }
    }
}
