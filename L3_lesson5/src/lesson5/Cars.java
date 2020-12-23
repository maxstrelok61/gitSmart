package lesson5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Cars {
    Car[] carsList;
    Cars(int cout){
        carsList = new Car[cout];
    }

    public Car geItem(int index) {
        return carsList[index];
    }

    public void setItem(int index, Car car){
        carsList[index] = car;
    }

    public int size(){
        return carsList.length;
    }

    public void start(){
        for (int i = 0; i < carsList.length; i++) {
            new Thread(carsList[i]).start();
        }
    }
}
