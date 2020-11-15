package School;

import java.util.GregorianCalendar;

public class Main {

    public static void main(String[] args) {
        //Создаем список классов  с рандомными учениками (в конструкторе)
        AllClass allClass = new AllClass();


        //метод сортирует и распределяет по парралелям всех у чеников numberClass классов
        allClass.sortedByAverageRating_AllParallel(5);


        //Добавление ученика в класс
        //если класс переполнен:
        //   1 создается след парралель
        //   2 ученики в целевом классе сортируются по средней оценке
        //   3 переносятся в след парралель 11 худших учеников + текущий добовляемый
        allClass.addSchoolboy(5, LitterClass.А, new Schoolboy());

        //Добавление с автоматическим определением класса по возрасту и сред. оценки
        allClass.addSchoolboy(new Schoolboy("Фифин Фифан Ффифинович", 5, 2010, 10, 10 ));

        //Вывод в консоль всех классов
       // allClass.print();
    }

}
