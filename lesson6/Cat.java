package com.company;

public class Cat extends Animals{
    Cat(String name) {
        super(name, 100, 300,  1, 3, 0, 0);
    }
    public void sprint(double length) {
        if(Sprint == 0) System.out.println("Кошка " + name + " не умеет бегать");
        else if(Sprint >= length) System.out.println("Кошка " + name + " не сможет пробежать " + length + " м");
        else System.out.println("Кошка " + name + " пробежала " + length + " м");
    }

    public void jamp(double height) {
        if(Jamp == 0) System.out.println("Кошка " + name + " не умеет прыгать");
        else if(Jamp >= height) System.out.println("Кошка " + name + " не сможет допрыгннуть на " + height + " м");
        else System.out.println("Кошка " + name + " прыгнула на " + height + " м");
    }

    public void heat(double length) {
        if(Heat == 0) System.out.println("Кошка " + name + " не умеет плавать");
        else if(Heat >= length) System.out.println("Кошка " + name + " не сможет проплыть " + length + " м");
        else System.out.println("Кошка " + name + " проплыла " + length + " м");
    }
}
