package com.company;

import java.util.Random;

public class Animals {
    protected String name;

    protected Double Sprint; // дистанция бега

    protected Double Jamp;   // высота прыжка

    protected Double Heat;   //мин дистанция заплыва

    Animals(String name, Double Sprint, Double Jamp, Double Heat){
        this.name = name;

        this.Heat = Heat;
        this.Jamp = Jamp;
        this.Sprint = Sprint;
    }

    Animals(String name, int minSprint, int maxSprint, double minJamp, int maxJamp, int minHeat, int maxHeat){
        Random rn = new Random();

        int tmpInt = (int)(maxSprint - minSprint);
        Double Sprint;
        Double Jamp;
        Double Heat;

        if ((minSprint == 0) && (maxSprint == 0)) Sprint = 0.0;
        else Sprint = (double)rn.nextInt((int)(maxSprint - minSprint)) + minSprint;
        this.Sprint = Sprint;

        if ((minJamp == 0) && (maxJamp == 0)) Jamp = 0.0;
        else Jamp = (double)rn.nextInt((int)(maxJamp - minJamp)) + minJamp;
        this.Jamp = Jamp;

        if ((minHeat == 0) && (maxHeat == 0)) Heat = 0.0;
        else Heat = (double)rn.nextInt((int)(maxHeat - minHeat)) +minHeat;
        this.Heat = Heat;

        this.name = name;
    }

}
