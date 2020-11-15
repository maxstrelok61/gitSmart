package School;

import java.util.ArrayList;

public class AllClass {
    private ArrayList<SchoolClass> clases = new ArrayList<SchoolClass>();

    AllClass(){
        //Созание пустых классов
//        for (int i = 0; i < 10; i++) {
//            createClass(i + 1, LitterClass.А);
//        }
        //Создание классов с рандомными учениками
        for (int i = 0; i <= 10; i++) {
            for (LitterClass lit: LitterClass.values()) {
                createClass_Random(i + 1, lit, 25);
            }
            sortedByAverageRating_AllParallel(i + 1);
        }
    }

    public void createClass (int numberClass, LitterClass litter){
        clases.add(new SchoolClass(numberClass, litter));
    }
    public void createClass_Random (int numberClass, LitterClass litter, int col){
        clases.add(new SchoolClass(numberClass, litter, col));
    }
    public void add (SchoolClass sc){clases.add(sc);}

    public void sortedByAverageRating_AllParallel(int numberClass){
        SchoolClass tempClasses = new SchoolClass(0, LitterClass.А);
        int tempIndex;

        //  Все паралели в один массив
        for (LitterClass litter: LitterClass.values()){
            tempIndex = getIndexClass(numberClass, litter);

            if (tempIndex > -1){
                for (int i = 0; i < clases.get(tempIndex).size(); i++) {
                    tempClasses.add(clases.get(tempIndex).getSchoolboyByIndex(i));
                }
            }
        }
        // Сортируем по оценкам
        tempClasses.sortedByAverageRating();

        //Распределяем обратно по классам
        int tempSize;
        int tempIndex2 = 0;
        for (LitterClass litter: LitterClass.values()){
            tempIndex = getIndexClass(numberClass, litter);

            if (tempIndex > -1){
                tempSize = clases.get(tempIndex).size();
                clases.get(tempIndex).remove();

                for (int i = 0; i < tempSize; i++) {
                    clases.get(tempIndex).add(tempClasses.getSchoolboyByIndex(tempIndex2));
                    tempIndex2++;
                }
            }
        }


    }

    public void addSchoolboy (int numberClass, LitterClass liter, Schoolboy sb){
        int index = getIndexClass(numberClass, liter); //находим index класса в списке
        LitterClass nextLitter = LitterClass.А;

        if (clases.get(index).size() >= 25){ //Если список переполнен
            if(liter == LitterClass.Д){    //Если параллель последняя то добавляем в этот класс
                clases.get(index).add(sb);
                System.out.println("Ученик добавлен " + numberClass + LitterClass.Д);
                return;
            }
            //Проверка на сущетвование класса со следующим литером
            if (getIndexClass(numberClass, nextLitter(liter)) == -1) {
                clases.get(index).sortedByAverageRating();//Сортировка класса по ср.оценке
                //Создаем класс со след литером с копированием 11 учеников из текущего
                clases.add(new SchoolClass(numberClass, nextLitter(liter), clases.get(index).getTheLast(11)));
                clases.get(index).removeTheLast(11);//Удаление скопированных учеников в текущем классе
                clases.get(clases.size()-1).add(sb);//Добовляем ученика в новый класс
                System.out.println("Класс " + numberClass + liter + " переполнен. Создан класс " + numberClass + nextLitter(liter) + " в него перенесены 11 худших учеников" );
            }else{
                //Рекурсия на след параллель
                System.out.println("Класс " + numberClass + liter + " переполнен." );
                int nextIndex = getIndexClass(numberClass, nextLitter(liter));
                addSchoolboy(numberClass, nextLitter(liter), sb);
            }

        }else{
            clases.get(index).add(sb);
            System.out.println("Ученик добавлен " + numberClass + liter);
        }

    }
    public void addSchoolboy (Schoolboy sb){
        int numberClass = 0;
        if (sb.getYear() == 7) numberClass = 1;
        if (sb.getYear() == 8) numberClass = 2;
        if (sb.getYear() == 9) numberClass = 3;
        if (sb.getYear() == 10) numberClass = 4;
        if (sb.getYear() == 11) numberClass = 5;
        if (sb.getYear() == 12) numberClass = 6;
        if (sb.getYear() == 13) numberClass = 7;
        if (sb.getYear() == 14) numberClass = 8;
        if (sb.getYear() == 15) numberClass = 9;
        if (sb.getYear() == 16) numberClass = 10;
        if (sb.getYear() == 17) numberClass = 11;

        if (numberClass == 0) {
            System.out.println(sb.getFio() + " Не подходит по возрасту (" +sb.getYear() + "лет)");
            return;
        }

        LitterClass litter = LitterClass.А;
        if (sb.getAverage_rating() > 4.5) litter = LitterClass.А;
        else if (sb.getAverage_rating() > 4) litter = LitterClass.Б;
        else if (sb.getAverage_rating() > 3.5) litter = LitterClass.В;
        else if (sb.getAverage_rating() > 3) litter = LitterClass.Г;
        else if (sb.getAverage_rating() < 3) litter = LitterClass.Д;

        System.out.println(sb.getFio() + " определен в класс " + numberClass + litter);

        addSchoolboy(numberClass, litter, sb);
    }
    public int getIndexClass(int numberClass, LitterClass litter){
        int res = -1;
        for (SchoolClass clas: clases) {
            for (int i = 0; i < clases.size(); i++) {
                if((clases.get(i).getLitter() == litter)&&(clases.get(i).getNumberClass() == numberClass)){
                    res = i;
                    break;
                }
            }
        }
        return  res;
    }
    private LitterClass nextLitter (LitterClass liter){
        LitterClass nextLitter =  LitterClass.А;
        if(liter == LitterClass.А) nextLitter = LitterClass.Б;
        if(liter == LitterClass.Б) nextLitter = LitterClass.В;
        if(liter == LitterClass.В) nextLitter = LitterClass.Г;
        if(liter == LitterClass.Г) nextLitter = LitterClass.Д;
        if(liter == LitterClass.Д) nextLitter = LitterClass.Д;
        return nextLitter;
    }


    public SchoolClass getClases(int index) {
        return clases.get(index);
    }
    public void print(){
        for (SchoolClass item: clases) {
            item.print();
        }
    }
}
