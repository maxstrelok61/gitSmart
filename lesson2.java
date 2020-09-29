package com.company;

public class Main {

    public static void main(String[] args) {
        //Задание 1
        int[] mas1 = new int[]{1,0,1,0,1,1,1,1,1,0,0,0,0,1,1,1} ;
        for (int i = 0; i < mas1.length; i++) {
            if (mas1[i] == 1) mas1[i] = 0;
                else mas1[i] = 1;
            }


        //Задание 2
        int[] mas2 = new int[8];
        int i2 = 0;
        for (int i1 = 0; i1 < mas2.length; i1++) {
            mas2[i1] = i2;
            i2 += 3;
        }

        //Задание 3
        int[] mas3 = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1} ;
        for (int i = 0; i < mas3.length; i++){
            if (mas3[i] < 6) mas3[i] *= 2;
        }

        //Задание 4
        int[][] mas4 = new int[6][6];
        for (int i1 = 0; i1 < mas4.length; i1++){
            mas4[i1][i1] = 1;
            mas4[(mas4.length - 1) - i1][i1] = 1;
        }

        //Задание 5
        int[] mas5 = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        minElArray(mas5);
        maxElArray(mas5);

        //Задание 6
        int[] mas6 = new int[]{11, 11, 11, 11, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(checkBalance(mas6));

        //Задание 7
        //int[] mas8 = new int[]{11, 11, 11, 11, 11, 4, 5, 2, 4, 8, 9, 1};
        int[] mas8 = new int[]{11, 2, 4, 8, 9, 1};
        biasArr(mas8,-655);
    }

    public static void minElArray(int[] arr) {
        int col = 1;
        int val = arr[0];
        for (int i = 1; i < arr.length; i++){
            if(val == arr[i]){
                col++;
            }else if(val > arr[i]){
                val = arr[i];
                col = 1;
            }
        }
        System.out.println("Минимальное значение в массиве " + "\"" + val + "\"");
        System.out.println("Количество элементов с мин. значением в массиве " + "\"" + col + "\"");
    }
    public static void maxElArray(int[] arr) {
        int col = 1;
        int val = arr[0];
        for (int i = 1; i < arr.length; i++){
            if(val == arr[i]){
                col++;
            }else if(val < arr[i]){
                val = arr[i];
                col = 1;
            }
        }
        System.out.println("Максимальное значение в массиве " + "\"" + val + "\"");
        System.out.println("Количество элементов с макс. значением в массиве " + "\"" + col + "\"");
    }
    public static boolean checkBalance(int[] arr){
        boolean result = false;
        int leftSum = 0;
        int rightSum = 0;
        for (int i1 = 0; i1 < arr.length - 1; i1++){
            leftSum += arr[i1];
            for (int i2 = i1 + 1; i2 < arr.length; i2++){
                rightSum += arr[i2];
            }
            if (leftSum == rightSum) {
                result = true;
                System.out.println("Есть равносторонние части массива");
                System.out.println("левая ( с 1 по " + i1 + " значение) = " + leftSum);
                System.out.println("правая ( с " + (i1 + 1) + " по " + arr.length + " значение) = " + leftSum);
                break;
            }else rightSum = 0;
        }
        return result;
    }
    public static void biasArr(int[] arr, int n){
        int tempVal1;
        int tempVal2;
        final int step = lenArrCheck(arr.length, n);
            for (int index = 0; index < step; index++) {
                tempVal1 = arr[0];
                for (int i = 0; i < arr.length; i++) {
                    tempVal2 = arr[lenArrCheck(arr.length, i + 1)];
                    arr[lenArrCheck(arr.length, i + 1)] = tempVal1;
                    tempVal1 = tempVal2;
                }
            }
    }
    /*
    lenArrCheck входные данные (Длинна массива, параметр сдвига)
    т.к. число n может быть гораздо больше или меньше длинны массива
    эта функция возвращает положительное значение сдвига массива соответствующему значению n
     */
    public static int lenArrCheck(int lengthArray, int index){
        int val = index;
        if(val >= lengthArray) val -= lengthArray;
         else if(val < 0) {
            if (Math.abs(val) < lengthArray) val = lengthArray - Math.abs(val);
            val += lengthArray;
        }
         if((Math.abs(val) >= lengthArray) | (val < 0)) return lenArrCheck(lengthArray, val);
        return val;
    }
}
