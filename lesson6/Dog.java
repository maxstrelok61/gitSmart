package com.company;

public class Dog extends Animals{


    Dog(String name) {
        super(name, 300, 600, 0.5, 2, 2, 12);
    }

    public void sprint(double length) {
        if(Sprint == 0) System.out.println("Собака " + name + " не умеет бегать");
        else if(length >= Sprint) System.out.println("Собака " + name + " не сможет пробежать " + length + " м");
        else System.out.println("Собака " + name + " пробежала " + length + " м");
    }

    public void jamp(double height) {
        if(Jamp == 0) System.out.println("Собака " + name + " не умеет прыгать");
        else if(height >= Jamp) System.out.println("Собака " + name + " не сможет допрыгннуть на " + height + " м");
        else System.out.println("Собака " + name + " прыгнула на " + height + " м");
    }

    public void heat(double length) {
        if(Heat == 0) System.out.println("Собака " + name + " не умеет плавать");
        else if(length >= Heat) System.out.println("Собака " + name + " не сможет проплыть " + length + " м");
        else System.out.println("Собака " + name + " проплыла " + length + " м");
    }
}
