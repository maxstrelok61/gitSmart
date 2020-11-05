package Gedon;

import java.awt.event.TextEvent;
import java.util.ArrayList;

public class NumberList {
    ArrayList<Name> names = new ArrayList<>();
    ArrayList<Telephone> numbers = new ArrayList<>();

    public void addContact(Name user, Telephone number){
        this.names.add(user);
        this.numbers.add(number);
    }
    public int addNewContact(String name, String number){
        int id = maxId_Names()+1;
        addContact(new Name(name, id), new Telephone(id, number));
        return id;
    }

    public void addNumber(int idName, String number){
        numbers.add(new Telephone(idName, number));
    }
    public int addName(String name){
        int index = maxId_Names() + 1;
        names.add(new Name(name, index));
        return index;
    }
    //масимальный id в массиве
    private int maxId_Names(){
        int index = 0;
        for (int i = 0; i < names.size(); i++) {
            if(index < names.get(i).id) index = names.get(i).id;
        }
        return index;
    }
    //Поис по массивам
    public void find_Names (String str){
        for (int i = 0; i < names.size(); i++) {
            if(names.get(i).name.indexOf(str) > -1){
             System.out.println("(id:" + names.get(i).id + ") " + names.get(i).name);
            }
        }
    }
    public void find_Names (int idName){
        for (int i = 0; i < names.size(); i++) {
            if(names.get(i).id == idName){
                System.out.println("(id:" + names.get(i).id + ") " + names.get(i).name);
            }
        }
    }
    public void print_Names (){
        for (int i = 0; i < names.size(); i++) {
                System.out.println("(id:" + names.get(i).id + ") " + names.get(i).name);
        }
    }

    public void print_Numbers(int idUser){
        for (int i = 0; i < this.numbers.size(); i++) {
            if (this.numbers.get(i).idUser == idUser){
                this.numbers.get(i).print();
            }
        }
    }
    public void findNumber(String number){
        for (int i = 0; i < this.numbers.size(); i++) {
            for (int j = 0; j < numbers.get(i).numbers.size(); j++) {
                if(numbers.get(i).numbers.get(j).equals(number)){
                   find_Names(numbers.get(i).idUser);
                }
            }
        }
    }

    public void printNameAndNumbers(int idName){
        find_Names(idName);
        print_Numbers(idName);
    }

    public void delId (int idName){
        for (int i = 0; i < names.size(); i++) {
            if(names.get(i).id == idName){
                for (int j = 0; j < numbers.size(); j++) {
                    if(numbers.get(j).idUser == idName){
                        numbers.remove(j);
                        names.remove(i);
                    }

                }
            }
        }
    }
    public void delNumber (String number){
        for (int i = 0; i < this.numbers.size(); i++) {
            for (int j = 0; j < numbers.get(i).numbers.size(); j++) {
                if(numbers.get(i).numbers.get(j).equals(number)){
                    numbers.get(i).numbers.remove(j);
                }
            }
        }
    }
}

