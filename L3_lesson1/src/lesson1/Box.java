package lesson1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box <T extends Fruit>{
    public List<T> list = new ArrayList<>();

    Box(T... array){
        list.addAll(Arrays.asList(array));
    }

    public float getWeight(){
        return (list.size()+1) * list.get(0).weight;
    }

    public boolean compare(Box<T> box){
        return comparingFloat(this.getWeight(), box.getWeight());
    }

    public void add(T... fruits){
        list.addAll(Arrays.asList(fruits));
    }

    // Внутренние методы
    private boolean comparingFloat(float param1, float param2){
        if(Math.abs(param1 - param2) < 0.0001) return true;
        else return false;
    }


}
