package level2;

public class Main {

    public static void main(String[] args) {
	Object[] party = {
	        new Cat("Муся" , "белая"),
            new Cat("Мурка" , "Черная"),
            new robot("Черкаш", "X0DDF12"),
            new robot("Семёныч", "83477493D"),
            new person("Андрей", "male"),
            new person("Анжела", "woman")
	};

	Object[] barriers = {
	        new track(),
            new track(),
            new track(),
            new wall(),
            new wall(),
            new wall(),
            new wall(),
    };

	for (Object i : barriers){

	    System.out.println("");
	    if (i.getClass() == wall.class) System.out.println("Препятствие \"Стена\" " + ((wall) i).height + "м");
	    else if (i.getClass() == track.class) System.out.println("Препятствие \"Забег\" " + ((track) i).lonG + "см");

	    for (Object y : party) {
	        if (i.getClass() == wall.class) {
                if (y.getClass() == robot.class) ((robot)y).jamp(((wall) i).height);
                if (y.getClass() == Cat.class) ((Cat)y).jamp(((wall) i).height);
                if (y.getClass() == person.class) ((person)y).jamp(((wall) i).height);
            }
            if (i.getClass() == track.class) {
                if (y.getClass() == robot.class) ((robot)y).jamp(((track) i).lonG);
                if (y.getClass() == Cat.class) ((Cat)y).jamp(((track) i).lonG);
                if (y.getClass() == person.class) ((person)y).jamp(((track) i).lonG);
            }

        }
    }
    }
}
