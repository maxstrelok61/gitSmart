package level2;

import java.util.Random;

public class robot implements runing, jamping {
    String name;
    String model;
    int heightJamp;
    int longRun;
    byte helth = 1;

    robot (String name, String model){
        this.name = name;
        this.model = model;
        Random rn = new Random();
        this.heightJamp = rn.nextInt(40);
        this.longRun =  rn.nextInt(40);
    }
    robot (String name, String model, int heightJamp, int longRun){
        this.name = name;
        this.model = model;
        this.heightJamp = heightJamp;
        this.longRun = longRun;
    }
    robot (){
        this.name = "no name";
        this.model = "3PO";
        Random rn = new Random();
        this.heightJamp = rn.nextInt(40);
        this.longRun =  rn.nextInt(40);
    }

    @Override
    public void jamp(int height) {
        if(this.helth > 0) {
            if (this.heightJamp > height)
                System.out.println("Робот " + this.name + " (model:" + this.model + ") перепрыгнул эту стену");
            else {
                System.out.println("Робот " + this.name + " (model:" + this.model + ") пробил стену");
                this.helth = 0;
            }
        }else System.out.println( this.name + " на ТО");
    }

    @Override
    public void run(int lonG) {
        if(this.helth > 0) {
            if (this.longRun > lonG) {
                System.out.println("Робот " + this.name + " (model:" + this.model + ") пробежал дистанцию как заведенный");
                System.out.println("Пара винтиков потеряно но не смертельно");
            } else {
                System.out.println("Робот " + this.name + " (model:" + this.model + ") не смог пробежать дистанцию");
                System.out.println("Какая-то штуковина отвалилась, нужно на ТО");
                this.helth = 0;
            }
        }else System.out.println(this.name + " на ТО");
    }
}
