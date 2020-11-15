package School;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

public class Schoolboy {
    //private int id;
    private String fio;
    private GregorianCalendar dateOfBirth;
    private float average_rating;

    //Конструкторы
    Schoolboy(){
        //this.id = id;
        this.fio = randomName();
        this.dateOfBirth = new GregorianCalendar(randomYear(), randomMonth(), randomDay());
        this.average_rating = randomAverageRating();
    }
    Schoolboy(String fio,float averageRating, int yearBirth, int monthBirth, int dayBirth){
        //this.id = id;
        this.fio = fio;
        this.dateOfBirth = intToCalendar(yearBirth, monthBirth, dayBirth);
        this.average_rating = averageRating;
    }
    //Возвращает кол-во лет
    public byte getYear(){
        Calendar thisCal = Calendar.getInstance(); //Текущая дата
        int yearBith = this.dateOfBirth.get(Calendar.YEAR);
        int yearThis = thisCal.get(Calendar.YEAR);
        int year;
        year = yearThis - yearBith; // Разница в годах

        return (byte) year;
    }
    //Копировакиние значений из другого элемента
    public void copy(Schoolboy schoolboy){
     //   this.id = schoolboy.id;
        this.fio = schoolboy.fio;
        this.average_rating = schoolboy.average_rating;
        this.dateOfBirth = schoolboy.dateOfBirth;
    }

    //Переводит int в GregorianCalendar
    private GregorianCalendar intToCalendar(int year, int month, int day){
        return new GregorianCalendar(year,month,day);
    }



    // Гетеры
    public String getFio() {
        return fio;
    }
    public float getAverage_rating() {
        return average_rating;
    }
    public GregorianCalendar getDateOfBirth() {
        return dateOfBirth;
    }

    // Сетеры
    public void setFio(String fio) {
        this.fio = fio;
    }
    public void setAverage_rating(float average_rating) {
        this.average_rating = average_rating;
    }
    public void setDateOfBirth(int year, int month, int day) {
        this.dateOfBirth = intToCalendar(year, month, day);
    }

    //Рандомы
    private String randomName(){
        String[] f = {"Звыкин", "Донров", "Аркаров", "Сорокин", "Зоркин", "Алиев", "Сонов", "Лианов", "Сухаров", "Скворцов", "Мартышкин", "Мухаморов"};
        String[] i = {"Андрей", "Максим", "Виталий", "Алексей", "Виктор", "Сергей", "Семён", "Павел", "Артур", "Слава"};
        String[] o = {"Васильевич", "Витальевич", "Анатольевич", "Сергеевич", "Викторович", "Максимович", "Семёнович", "Аронович", "Кирилович"};

        Random rn = new Random();

        return f[rn.nextInt(f.length)] + " " + i[rn.nextInt(i.length)] + " " + o[rn.nextInt(o.length)];
    }
    private float randomAverageRating(){
        Random rn = new Random();

        int v1 = rn.nextInt(4) + 2;
        float v2 = rn.nextFloat();

        float res = v1 + v2;
        return res;
    }

    private int randomYear(){
        Random rn = new Random();
        return rn.nextInt(17) + 2003;
    }
    private int randomMonth(){
        Random rn = new Random();
        return rn.nextInt(11) + 1;
    }
    private int randomDay(){
        Random rn = new Random();
        return rn.nextInt(30) + 1;
    }
}
