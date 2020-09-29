package project1;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Sotrudnik {
    String fio;         //ФИО
    String position;    //должность
    String email;       //email
    String phone;       //телефон
    double salary;      //зарплата
    GregorianCalendar  dateBeth;      //возраст


    Sotrudnik(String fio, String position, String email, String phone, double salary, GregorianCalendar dateBeth) {
        this.fio = fio;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.dateBeth = dateBeth;
    }
    void printInfo(){
        System.out.println("<<" + this.fio + ">>");
        System.out.println("Должность: " + this.position + "\n");
        System.out.println("Почта: " + this.email + "\n");
        System.out.println("Телефон: " + this.phone + "\n");
        System.out.println("Зарплата: " + this.salary + "\n");
        System.out.println("Год рождения: " + this.dateBeth.get(Calendar.YEAR) + "\n" +
                            "Месяц: " + this.dateBeth.get(Calendar.MONTH) + "\n" +
                            "День: " +   this.dateBeth.get(Calendar.DAY_OF_MONTH) + "\n\n");
    }
}
