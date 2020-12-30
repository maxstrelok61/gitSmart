package lesson7;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
//        Method[] methods = RefAnno.class.getDeclaredMethods();
//        for(Method o : methods){
//            if(o.getAnnotation(Anno.class) != null){
//                System.out.println(o);
//            }
//        }
        TestClass1.start(MethodsMy.class);
    }
}
