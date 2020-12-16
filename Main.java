package lesson4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    static  Object mon = new Object();
    static volatile int index = 1;
    static final int count = 5;

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);

        // final int index = 0;


            service.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int i = 0; i < count; i++) {
                            synchronized (mon){
                                while (index != 1) {
                                    mon.wait();
                                }
                                    System.out.print("A");
                                    index = 2;
                                    mon.notifyAll();
                            }

                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            service.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int i = 0; i < count; i++) {
                            synchronized (mon){
                                while (index != 2) {
                                    mon.wait();
                                }
                                    System.out.print("B");
                                    index = 3;
                                    mon.notifyAll();

                            }

                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            service.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int i = 0; i < count; i++) {
                            synchronized (mon){
                                while (index != 3) {
                                    mon.wait();
                                }
                                    System.out.print("C");
                                    index = 1;
                                    mon.notifyAll();

                            }

                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
    }
}
