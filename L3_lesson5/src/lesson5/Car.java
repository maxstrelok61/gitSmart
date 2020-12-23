package lesson5;

import java.util.concurrent.CountDownLatch;

import static lesson5.MainClass.mon;

public class Car  implements Runnable {
    private static int CARS_COUNT;
    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");

            synchronized (mon){
                MainClass.cars_to_start++;
                mon.notifyAll();
                while (MainClass.cars_to_start < MainClass.CARS_COUNT){
                    mon.wait();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }

        synchronized (mon){
            MainClass.cars_to_finish++;
            if (MainClass.cars_to_finish == 1) System.out.println(this.name + " ПРИЕХАЛ ПЕРВЫМ");
            mon.notifyAll();
        }
    }
}