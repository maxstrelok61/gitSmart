package level2;

import java.util.Random;

public class Cat implements runing, jamping {
    String name;
    String color;
    int heightJamp;
    int longRun;
    byte helth = 1;

    Cat (String name, String color){
        this.name = name;
        this.color = color;
        Random rn = new Random();
        this.heightJamp = rn.nextInt(30);
        this.longRun =  rn.nextInt(15);
    }
    Cat (String name, String color, int heightJamp, int longRun){
        this.name = name;
        this.color = color;
        this.heightJamp = heightJamp;
        this.longRun = longRun;
    }
    Cat (){
        this.name = "no name";
        this.color = "transparent";
        Random rn = new Random();
        this.heightJamp = rn.nextInt(30);
        this.longRun =  rn.nextInt(15);
    }

    @Override
    public void jamp(int height) {
        if(this.helth > 0) {
            if (this.heightJamp > height)
                System.out.println("Кошка " + this.name + " (" + this.color + ") перепрыгнула стену в " + height + "см");
            else {
                System.out.println("Кошка " + this.name + " (" + this.color + ") не смогла  перепрыгнуть стену в " + height + "см");
                this.helth = 0;
            }
        }else System.out.println(this.name + " отдыхает");
    }

    @Override
    public void run(int lonG) {
        if(this.helth > 0) {
            if (this.longRun > lonG)
                System.out.println("Кошка " + this.name + " (" + this.color + ") рванула вперед и без проблем преодолела " + lonG + "м");
            else {
                System.out.println("Кошка " + this.name + " (" + this.color + ") не смогла пробежать " + lonG + "м");
                this.helth = 0;
            }
        }else System.out.println(this.name + " отдыхает");
    }
}
