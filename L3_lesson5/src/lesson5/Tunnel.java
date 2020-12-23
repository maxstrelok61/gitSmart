package lesson5;

import static lesson5.MainClass.mon2;

public class Tunnel extends Stage {
    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }
    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                synchronized (mon2){
                    while (MainClass.cars_in_tunnel == MainClass.cars_in_tunnel_max){
                        System.out.println(c.getName() + " Ожидает когда тунель освободится");
                        mon2.wait();
                    }
                    MainClass.cars_in_tunnel++;
                }

                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);

                synchronized (mon2){
                    MainClass.cars_in_tunnel--;
                    mon2.notifyAll();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}