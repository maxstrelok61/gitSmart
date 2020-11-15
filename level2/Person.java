package School;


import java.util.Random;

public class Person implements ActionsParticipant {
    String name;
    String gender;
    int heightJamp;
    int longRun;
    byte helth = 1;

    Person(String name, String gender){
        this.name = name;
        this.gender = gender;
        Random rn = new Random();
        this.heightJamp = rn.nextInt(20);
        this.longRun =  rn.nextInt(20);
    }
    Person(String name, String gender, int heightJamp, int longRun){
        this.name = name;
        this.gender = gender;
        this.heightJamp = heightJamp;
        this.longRun = longRun;
    }
    Person(){

        this.name = "no name";
        this.gender = "male";
        Random rn = new Random();
        this.heightJamp = rn.nextInt(20);
        this.longRun =  rn.nextInt(20);
    }

    @Override
    public void jamp(int height) {
        if(this.helth > 0) {
            String gendStr = "";
            if (this.gender.equals("male")) gendStr = "перепрыгнул";
            else if (this.gender.equals("woman")) gendStr = "перепрыгнула";
            else gendStr = "перепрыгнуло";

            if (this.heightJamp > height)
                System.out.println(this.name + " " + gendStr + " эту стену");
            else {
                System.out.println(this.name + " не" + gendStr + " эту стену");
                System.out.println("Теперь сломан нос");
                this.helth = 0;
            }
        }else System.out.println(this.name + " отдыхает");
    }

    @Override
    public void run(int lonG) {
        if(this.helth > 0) {
            String gendStr = "";
            if (this.gender.equals("male")) gendStr = "побежал";
            else if (this.gender.equals("woman")) gendStr = "побежала";
            else gendStr = "побежало";

            if (this.longRun > lonG)
                System.out.println(this.name + " " + gendStr + " дистанцию в " + lonG + "м");
            else {
                System.out.println(this.name + " не" + gendStr + " дистанцию в " + lonG + "м");
                System.out.println("Теперь у " + this.name + " отдышка шахтера");
                this.helth = 0;
            }
        }else  System.out.println(this.name + " отдыхает");
    }
}