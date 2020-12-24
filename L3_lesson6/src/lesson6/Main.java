package lesson6;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arrTest1_1 = new int[]{1,2,1,1,2,3,4,5,7,8,3,4,5,7,8,8};
        int[] arrTest1_2 = new int[]{5,8,3,4,8,2,9,6,6,6,6,7};
        int[] arrTest1_3 = new int[]{7,7,7,2,3,9,8,9,9,4,4,5,9};
        try {
            System.out.println(Arrays.toString(getArrayPart(arrTest1_1, 4)));
        }catch (RuntimeException e){
            e.printStackTrace();
        }
        try {
            System.out.println(Arrays.toString(getArrayPart(arrTest1_2, 10)));
        }catch (RuntimeException e){
            e.printStackTrace();
        }
        try {
            System.out.println(Arrays.toString(getArrayPart(arrTest1_3, 7)));
        }catch (RuntimeException e){
            e.printStackTrace();
        }

        int[] arrTest2_1 = new int[]{2,2,2,2,2,2};
        int[] arrTest2_2 = new int[]{1,1,2,1,1,2};
        int[] arrTest2_3 = new int[]{2,1,1,2,2,4};
        System.out.println(checkArr(arrTest2_1, 1,2));
        System.out.println(checkArr(arrTest2_2, 1,2));
        System.out.println(checkArr(arrTest2_3, 1,2));

	// write your code here
    }

    public static int[] getArrayPart (int[] arr, int endNumber) throws RuntimeException {
        boolean res = false;
        int[] newArr = null;
        int indexEnd = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == endNumber) {
                indexEnd = i + 1;
            }
        }
        if(indexEnd == -1) throw new RuntimeException("Искомого числа в массиве нет!");
        newArr = new int[arr.length - indexEnd];
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = arr[i + indexEnd];
        }

        return  newArr;
    }

    public static boolean checkArr (int[] checkArray, int... arr){
        boolean res = false;
        boolean[] bArr1 = new boolean[checkArray.length + arr.length];
        arrToFalse(bArr1);
        boolean temp = true;

        for (int i = 0; i < checkArray.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(checkArray[i] == arr[j]) {
                    temp = true;
                    bArr1[checkArray.length + j] = true;
                    break;
                }else{
                    temp = false;
                }
            }
            bArr1[i] = temp;
        }


        for (int i = 0; i < bArr1.length; i++) {
            if (!bArr1[i]) {
                res = false;
                break;
            }else{
                res = true;
            }
        }
        return res;
    }

    public static void arrToFalse(boolean[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = false;
        }
    }
}

