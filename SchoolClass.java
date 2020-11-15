package School;

import java.util.ArrayList;
import java.util.List;

public class SchoolClass implements ActionsWithSchoolClas {
    private ArrayList<Schoolboy> schoolboys = new ArrayList<Schoolboy>();
    private int numberClass;
    private LitterClass litter;

    //Конструкторы
    SchoolClass(int numberClass, LitterClass litter, int colSchoolboy){
        for (int i = 0; i < colSchoolboy; i++) {
            schoolboys.add(new Schoolboy());
        }
        this.numberClass = numberClass;
        this.litter = litter;
    }
    SchoolClass(int numberClass, LitterClass litter){
        this.numberClass = numberClass;
        this.litter = litter;
    }
    SchoolClass(int numberClass, LitterClass litter, Schoolboy schoolboy){
        this.numberClass = numberClass;
        this.litter = litter;
        this.schoolboys.add(schoolboy);
    }
    SchoolClass(int numberClass, LitterClass litter, Schoolboy... schoolboys){
        this.numberClass = numberClass;
        this.litter = litter;
        for (int i = 0; i < schoolboys.length; i++) {
            this.schoolboys.add(schoolboys[i]);
        }
    }

    //Геттеры
    public int getNumberClass() {
        return numberClass;
    }
    public LitterClass getLitter() {
        return litter;
    }
    public ArrayList<Schoolboy> getSchoolboys() {
        return schoolboys;
    }
//    public Schoolboy getSchoolboyById(int id) {
//        Schoolboy res = null;
//        for(Schoolboy item: schoolboys) {
//         if (item.getId() == id) res = item;
//        }
//        return res;
//    }
    public Schoolboy getSchoolboyByIndex(int index){
        return schoolboys.get(index);
    }
    public int size(){
        return schoolboys.size();
    }

    //Сеттеры
    public void setSchoolboys(ArrayList<Schoolboy> schoolboys) {
        this.schoolboys = schoolboys;
    }
    public void setSchoolboys(Schoolboy schoolboy) {
        this.schoolboys.add(schoolboy);
    }
    public void setNumberClass(int numberClass) {
        this.numberClass = numberClass;
    }
    public void setLitter(LitterClass litter) {
        this.litter = litter;
    }

    public void add(Schoolboy sb){
        //sb.setId(nextId());
        schoolboys.add(sb);
    }

    @Override
    public void sortedByAverageRating() {

        int tempIndex = -1;
        for (int ii = 0; ii < this.schoolboys.size(); ii++) {
            for (int i = 0; i < this.schoolboys.size(); i++) {
                tempIndex = maxAverageRating(i, schoolboys.get(i).getAverage_rating());
                if (!(tempIndex == -1)) swap(i, tempIndex);
            }
        }
    }

    @Override
    public Schoolboy[] getTheLast(int col){
        int tempCol = col - 1;
        Schoolboy[] arrSb = new Schoolboy[col];

        for (int i = schoolboys.size() - 1; i >= 0 ; i--) {
            if (tempCol == -1) break;
            arrSb[tempCol] = schoolboys.get(i);
            tempCol--;
        }
        return arrSb;
    }

    @Override
    public void removeTheLast(int col){
        int tempCol = col - 1;
        Schoolboy[] arrSb = new Schoolboy[col];

        for (int i = schoolboys.size() - 1; i >= 0 ; i--) {
            if (tempCol == -1) break;
            schoolboys.remove(i);
            tempCol--;
        }
    }

    @Override
    public void remove(){
        schoolboys.clear();
    }

    //внутренние методы
    private void swap(int index1, int index2){
        Schoolboy sb;
        sb = schoolboys.get(index1);
        schoolboys.set(index1, schoolboys.get(index2));
        schoolboys.set(index2, sb);
    }
    private int maxAverageRating(int startIndex, float averageRating){
        int ret = -1;
        for (int i = startIndex; i < schoolboys.size(); i++) {
            if (schoolboys.get(i).getAverage_rating() > averageRating){
//                System.out.println(schoolboys.get(i).getAverage_rating() + "==" + averageRating);
                ret = i;
                break;
            }

        }
        return ret;
    }
//    public int nextId(){
//        int res = -1;
//        for(Schoolboy item: schoolboys){
//            if(item.getId() > res) res = item.getId();
//        }
//        return res + 1;
//    }
    public void print (){
        System.out.println("Класс :" + this.numberClass + this.litter);
        for (Schoolboy temp: this.schoolboys){
            System.out.println(temp.getFio() + " " + temp.getAverage_rating());
        }
    }

}
