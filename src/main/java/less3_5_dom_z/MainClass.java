package less3_5_dom_z;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class MainClass {
    public static final int CARS_COUNT = 4;
   
    public static void main(String[] args) {
        System.out.println("IMPORTANT ANNOUNCEMENT >>> Preparation!");
        CyclicBarrier first = new CyclicBarrier(5);
        CountDownLatch sec = new CountDownLatch(CARS_COUNT);
        Race race = new Race(new Road(60), new Tunnel(),new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i=0; i < cars.length; i++){
            cars[i] = new  Car(race,20 + (int)(Math.random()*10),first, sec);
        }
        for (int i = 0; i < cars.length; i++){
            new Thread(cars[i]).start();
        }
        try {
            first.await();
            System.out.println("IMPORTANT ANNOUNCEMENT >>> The race has started!!!");
            first.await();
            first.await();
        } catch (Exception e){
            e.printStackTrace();
        }
                System.out.println("IMPORTANT ANNOUNCEMENT >>> The race is over!!!");
    }
}
