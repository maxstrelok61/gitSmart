package Gedon;

import java.util.ArrayList;

public class Telephone {
    ArrayList<String> numbers = new ArrayList<>();
    int idUser;
    Telephone(int idUser, String number){
        this.idUser = idUser;
        numbers.add(number);
    }
    public void print(){
        for (int i = 0; i < this.numbers.size(); i++) {
            System.out.println("tel:" + numbers.get(i));
        }
    }
}
