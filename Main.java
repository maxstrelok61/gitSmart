package project1;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try {

            printArr(method1(5, 5));

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Ошибка размер массива не может быть меньше 1");
        }
    }
    public static int[] method1(int height, int width) {
        Random ran = new Random();
        if ((height < 1)|(width < 1))  {
            throw new ArrayIndexOutOfBoundsException();
        }
        int[][] arr = new int[height][width];

        //Заполняем массив
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = ran.nextInt(100);
            }
        }
        System.out.println("");
        printArr(arr);
        System.out.println(" ");

        int[] retArr = new int[height * width];
        int indexRetArr = 0;

        int heightT = height - 1;
        int widthT = width - 1;

        int per = 0;

        int shift = 0;//сдвиг спирали

        //Обход по спирали (против часовой)
        if ((height > 1) && (width > 1)) { // Для массивов двумерных
            while (indexRetArr < retArr.length){
                if ((0 + shift) > (heightT - (1 + shift))){
                    for (int i = 0 + shift; i <= heightT - shift; i++) {
                        retArr[indexRetArr] = arr[i][0 + shift] + 1;
                        //System.out.println(i + "  " + (0 + shift));
                        indexRetArr++;
                    }
                }else {
                    for (int i = 0 + shift; i <= heightT - (1 + shift); i++) {
                        retArr[indexRetArr] = arr[i][0 + shift] + 1;
                        //System.out.println(i + "  " + (0 + shift));
                        indexRetArr++;
                    }
                }

                for (int i = 0 + shift; i <= widthT - (1 + shift); i++) {
                     retArr[indexRetArr] = arr[heightT - shift][i] + 1;
                    //System.out.println((heightT - shift) + "  " + i);
                    indexRetArr++;
                }


                for (int i = heightT - shift; i > 0 + shift; i--) {
                     retArr[indexRetArr] = arr[i][widthT - shift] + 1;
                    //System.out.println(i + "  " + (widthT - shift));
                    indexRetArr++;
                }

                for (int i = widthT - shift; i > 0 + shift; i--) {
                      retArr[indexRetArr] = arr[0 + shift][i] + 1;
                    //System.out.println((0 + shift) + "  " + i);
                    indexRetArr++;
                }
                //indexRetArr++;
                //System.out.println(">" + indexRetArr + " > " + (height * width));
                shift++;
            }
        } else { // Для одномерноного массива
            if (height > 1)
                for (int i = 0; i < arr.length; i++) {
                    System.out.println(arr[i][0]);
                }
            else {
                for (int i = 0; i < arr[0].length; i++) {

                }
            }

        }
        return retArr;
    }

    public static void printArr(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println("");
        }
    }
    public static void printArr(int[] a) {
        for (int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
    }
}
