package School;

public class Main {
    static final int size = 10000000;
    static final int h = size / 2;


    public static void main(String[] args) throws InterruptedException {
        method1();
        method2();

    }

    static void method1(){
        float[] arr = new float[size];

        //Заполняем этот массив единицами
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

        //Засекаем время
        long a = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Время просчета массива (Метод1) : " + (System.currentTimeMillis() - a));
    }

    static void method2() throws InterruptedException {
        var arr = new float[size];
        var a = new float[h];
        var b = new float[h];


        //Заполняем этот массив единицами
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

        // Поток 2
        var t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.arraycopy(arr, 0, a, 0, h);
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                    System.out.println(Thread.currentThread().getName());
                }
                System.arraycopy(a, 0, arr, 0, h);
            }
        });

        // Поток 3
        var t2 = new Thread(new Runnable(){
          @Override
          public void run() {
              System.arraycopy(arr, h, b, 0, h);
              for (int i = 0; i < arr.length; i++) {
                  arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                  System.out.println(Thread.currentThread().getName());
              }
              System.arraycopy(b, 0, arr, h, h);
          }
      });

        //Засекаем врем
        long time = System.currentTimeMillis();

      t1.start();
      t2.start();

      t1.join();
      t2.join();

        System.out.println("Время просчета массива (Метод2): " + (System.currentTimeMillis() - time));


    }
}
