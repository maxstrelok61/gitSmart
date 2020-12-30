package lesson7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class MethodsMy {
    @BeforeSuite
    public void method1(){
        System.out.println("BeforeSuite = method1");
    }
    @Test(1)
    public void method2(){
        System.out.println("Test (1) = method2");
    }
    @Test(2)
    public void method3(){
        System.out.println("Test (2) = method3");
    }
    @Test(2)
    public void method4(){
        System.out.println("Test (2) = method4");
    }
    @AfterSuite
    public void method5(){
        System.out.println("AfterSuite = method5");
    }
    @Test(10)
    public void method6(){
        System.out.println("Test (10) = method6");
    }
    @Test(4)
    public void method7(){
        System.out.println("Test (4) = method7");
    }
    @Test(7)
    public void method8(){
        System.out.println("Test (7) = method8");
    }
    @Test(3)
    public void method9(){
        System.out.println("Test (3) = method9");
    }
    @Test(8)
    public void method10(){
        System.out.println("Test (8) = method10");
    }

//    static void start(Class clas) throws InvocationTargetException, IllegalAccessException {
//        Methods m = new Methods();
//        ArrayList<Integer> bef = new ArrayList<>();
//        ArrayList<Integer> aft = new ArrayList<>();
//
//        Method[] methods = clas.getClass().getDeclaredMethods();
//        for (int i = 0; i < methods.length; i++) {
//            if(methods[i].getAnnotation(BeforeSuite.class) != null){
//                bef.add(i);
//            }
//        }
//        if (bef.size() > 1 ) throw new RuntimeException ();
//        else methods[bef.get(0)].invoke(m);
//        ////////////////////////////////////////////////////////////////////////
//        int[] temp = new int[methods.length];
//        int count = 0;
//        for (int i = 0; i < methods.length; i++) {
//            if(methods[i].getAnnotation(Test.class) != null) {
//                temp[count] = i;
//                count++;
//            }
//        }
//        int zn = 0; int tm = 0;
//        for (int ii = 0; ii < count; ii++) {
//            for (int i = 0; i < count; i++) {
//                Test anno = methods[temp[i]].getAnnotation(Test.class);
//                if (zn > anno.value()) {
//                    tm = temp[i - 1];
//                    temp[i - 1] = temp[i];
//                    temp[i] = tm;
//                }
//                zn = anno.value();
//            }
//        }
//        for (int i = 0; i < count; i++) {
//            methods[temp[i]].invoke(m);
//        }
//        //////////////////////////////////////////////////////////////////////////
//        for (int i = 0; i < methods.length; i++) {
//            if(methods[i].getAnnotation(AfterSuite.class) != null){
//                aft.add(i);
//            }
//        }
//        if (aft.size() > 1 ) throw new RuntimeException ();
//        else methods[aft.get(0)].invoke(m);
//    }
}
