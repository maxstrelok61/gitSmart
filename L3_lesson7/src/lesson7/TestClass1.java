package lesson7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class TestClass1 {
    static void start(Class clas) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        MethodsMy m = new MethodsMy();
        ArrayList<Integer> bef = new ArrayList<>();
        ArrayList<Integer> aft = new ArrayList<>();

//        Method[] methods = MethodsMy.class.getMethods();
        Method[] methods = clas.getMethods();

        for (int i = 0; i < methods.length; i++) {
            if(methods[i].getAnnotation(BeforeSuite.class) != null){
               bef.add(i);
            }
        }
        if (bef.size() > 1 ) throw new RuntimeException ();
        else methods[bef.get(0)].invoke(m);
        ////////////////////////////////////////////////////////////////////////
        int[] temp = new int[methods.length];
        int count = 0;
        for (int i = 0; i < methods.length; i++) {
            if(methods[i].getAnnotation(Test.class) != null) {
                temp[count] = i;
                count++;
            }
        }

        for (int ii = 0; ii < count; ii++) {
            int zn = 0; int tm = 0;
            for (int i = 0; i < count; i++) {
                Test anno = methods[temp[i]].getAnnotation(Test.class);
                if (zn > anno.value()) {
                    tm = temp[i - 1];
                    temp[i - 1] = temp[i];
                    temp[i] = tm;
                }
                zn = anno.value();
            }
        }
        for (int i = 0; i < count; i++) {
            methods[temp[i]].invoke(m);
        }
//        //////////////////////////////////////////////////////////////////////////
        for (int i = 0; i < methods.length; i++) {
            if(methods[i].getAnnotation(AfterSuite.class) != null){
                aft.add(i);
            }
        }
        if (aft.size() > 1 ) throw new RuntimeException ();
        else methods[aft.get(0)].invoke(m);
    }
}
