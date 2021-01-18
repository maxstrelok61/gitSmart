package project1;

public class Main {

    public static void main(String[] args) {
        int sizeArr = 4; // Размерность массива (что бы не прописывать везде)
        String[][] arr = new String[sizeArr][sizeArr];
        //Заполняем массив
        Integer val = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                val = i + j;
                arr[i][j] = val.toString();
            }
        }


        printArr(arr); // вывод массива в консоль
        
        try {
            metod1(arr, sizeArr);
        }catch (MyArraySizeException e){
            System.out.println("Косяк размерности массива (" + e + ")");
        }catch (MyArrayDataException e){
            System.out.println("Косяк значения массива (" + e + ")");
        }
    }




    public static void metod1(String[][] arr,int sizeArr) throws MyArraySizeException, MyArrayDataException{
            //Проверка на размер массива
            if ((arr.length > sizeArr) | (arr[0].length > sizeArr)) throw new MyArraySizeException("Массив больше чем 4х4");
            if ((arr.length < sizeArr) | (arr[0].length < sizeArr)) throw new MyArraySizeException("Массив меньше чем 4х4");

            int allSum = 0 ;

            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (isDigit(arr[i][j])) allSum += Integer.parseInt(arr[i][j].trim());
                    else throw new MyArrayDataException("Неполучилось преобразовать элемент \"" + arr[i][j] + "\" по адресу [" + i + "][" + j + "]" );
                }
            }
            System.out.println("Общая сумма элементов массива = " + allSum);

    }

    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static void printArr (String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("");
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(" " + arr[i][j]);
            }
        }
        System.out.println("");

    }

}

