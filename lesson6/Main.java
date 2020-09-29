package com.company;

public class Main {

    public static void main(String[] args) {
	Animals[] animals = new Animals[5];

	animals[0] = new Cat("Васька");
	animals[1] = new Cat("Черныш");
	animals[2] = new Cat("Чуча");

	animals[3] = new Dog("Бобик");
	animals[4] = new Dog("Шарик");

	for (int i = 0; i < animals.length; i++){
	    if(animals[i] instanceof Cat){
	    	((Cat) animals[i]).heat(1);
			((Cat) animals[i]).sprint(100);
			((Cat) animals[i]).jamp(0.5);
		}
        if(animals[i] instanceof Dog){
        	((Dog) animals[i]).heat(10);
			((Dog) animals[i]).sprint(100);
			((Dog) animals[i]).jamp(0.5);
		}
    }
    }
}
