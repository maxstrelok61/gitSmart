package lesson5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class MainClass {
    public static final int CARS_COUNT = 4;
    static  Object mon = new Object();
    public static volatile int cars_to_start = 0;
    public static volatile int cars_to_finish = 0;

    static  Object mon2 = new Object();
    public static volatile int cars_in_tunnel_max = (int) Math.abs(CARS_COUNT/2);
    public static volatile int cars_in_tunnel = 0;


    public static void main(String[] args) throws InterruptedException {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Cars cars = new Cars(CARS_COUNT);
//        Car[] cars = new Car[CARS_COUNT];
//        synchronized (mon) {



            Race race = new Race(new Road(60), new Tunnel(), new Road(40));




            for (int i = 0; i < cars.size(); i++) {
                cars.setItem(i, new Car(race, 20 + (int) (Math.random() * 10)));
            }

            cars.start();
//            for (int i = 0; i < cars.size(); i++) {
//                new Thread(cars[i]).start();
//            }

        synchronized (mon){
            while (cars_to_start < CARS_COUNT){
                mon.wait();
            }
        }
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");

        synchronized (mon){
            while (cars_to_finish < CARS_COUNT){
                mon.wait();
            }
        }

            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        //}
    }
}

