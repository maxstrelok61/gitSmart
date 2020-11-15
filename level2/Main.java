package School;

public class Main {

    public static void main(String[] args) {


        ActionsParticipant[] party = {
                new Cat("Муся" , "белая"),
                new Cat("Мурка" , "Черная"),
                new Robot("Черкаш", "X0DDF12"),
                new Robot("Семёныч", "83477493D"),
                new Person("Андрей", "male"),
                new Person("Анжела", "woman")
        };

        Obstacle[] barriers = {
                new Track(),
                new Track(),
                new Track(),
                new Wall(),
                new Wall(),
                new Wall(),
                new Wall(),
        };

        for (Object i : barriers){

            System.out.println("");
            if (i instanceof Wall) System.out.println("Препятствие \"Стена\" " + ((Wall) i).height + "м");
            else if (i instanceof Track) System.out.println("Препятствие \"Забег\" " + ((Track) i).lonG + "см");

            for (Object y : party) {
                if (i instanceof Wall) {
                    if (y instanceof Robot) ((Robot)y).jamp(((Wall) i).height);
                    if (y instanceof Cat) ((Cat)y).jamp(((Wall) i).height);
                    if (y instanceof Person) ((Person)y).jamp(((Wall) i).height);
                }
                if (i instanceof Track) {
                    if (y instanceof Robot) ((Robot)y).jamp(((Track) i).lonG);
                    if (y instanceof Cat) ((Cat)y).jamp(((Track) i).lonG);
                    if (y instanceof Person) ((Person)y).jamp(((Track) i).lonG);
                }

            }
        }
    }
}