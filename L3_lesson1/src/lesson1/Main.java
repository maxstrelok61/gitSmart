package lesson1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Box<Orange> o = new Box<>(new Orange(), new Orange());
        Box<Orange> o2 = new Box<>(new Orange(), new Orange());
        Box<Apple> a = new Box<>();

        aINb(o,o2);
        System.out.println(o.list.size());
    }

    // Задание 1
     private <T> boolean swap(List<T> array, int index1, int index2){
        boolean res = true;
        if (!(array.size() <= index1 & array.size() <= index2)) return false;
         var temp  = array.get(index1);
         array.set(index1, array.get(index2));
         array.set(index2, temp);
         return res;
    }

    // Задание 2
    private <T> ArrayList<T> arrayToArrayList (T[] array){
        return  new ArrayList<>(Arrays.asList(array));
    }

    // Задание 3
    static  <T extends Fruit> void aINb (Box<T> a, Box<T> b){
        b.list.addAll(a.list);
        a.list.clear();
    }
}
