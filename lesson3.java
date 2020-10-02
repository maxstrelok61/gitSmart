package com.company;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) {
        guessNumber(); //Задание 1
        gameWord(); //задание 2

    }

    //задание 2
    public static void gameWord (){
        String[] words =  new String[]{"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
                          "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango",
                          "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple",
                          "pumpkin", "potato"};
        //Выбор рандомного слова из массива
        globalVariableRandomNumber.wordsArrMain[0] = words[(int)Math.floor(Math.random() * words.length)];
        globalVariableRandomNumber.wordsArrMain[1] = "###############";

        boolean result = true; // переменная для выхода из основного цикла

        System.out.println("Слово загадоно.");
        while (result) {
            //System.out.println(globalVariableRandomNumber.wordsArrMain[0]);
            System.out.println(globalVariableRandomNumber.wordsArrMain[1]); // вывод зашифрованного слова
            System.out.print("Введите вариант ответа :");
            if(InputWord()){
                if (globalVariableRandomNumber.wordsArrMain[1].indexOf(globalVariableRandomNumber.wordsArrMain[0]) != -1){
                    System.out.println("Поздравляем вы отгадали слово!!!");
                    result = false;
                    break;
                }else System.out.println("Слово частично разгадано");
            }

        }

    }

    // Метод принимает введеное слово и обрабатывает его на допустимые символы и    //задание 2
    // содержание цифр
    public static boolean InputWord(){
        Scanner inputScanner = new Scanner(System.in);
        int lengthString;
        boolean result = false;


        if(inputScanner.hasNextLine()){
            String inputString = inputScanner.next().strip();
            //поиск на недопустимые символы
            if(findCharArr(inputString)) System.out.println("Вы ввели недопустимые символы");
            else {
                if(inputString.length() < globalVariableRandomNumber.wordsArrMain[0].length()) lengthString = inputString.length();
                else lengthString = globalVariableRandomNumber.wordsArrMain[0].length();

                for (int i = 0; i < lengthString; i++)
                    //если есть совпадение символов в веднной строке и загаданной выполнить
                    if(inputString.charAt(i) == globalVariableRandomNumber.wordsArrMain[0].charAt(i)) {
                        globalVariableRandomNumber.wordsArrMain[1] = codeString(inputString.charAt(i), i);
                       result = true;
                    }
            }

        }else System.out.println("Это не является словом!!");
        return result;
    }
    //метод формирования кодированной строки    //задание 2
    public static String codeString (char inputChar, int index){
        String tempString = "";
        for (int i =0; i < globalVariableRandomNumber.wordsArrMain[1].length(); i++){
            if(i == index) tempString += inputChar;
                else tempString += globalVariableRandomNumber.wordsArrMain[1].charAt(i);
        }
        return tempString;
    }
    //метод поиска недопустимых символов в строке   //задание 2
    public static boolean findCharArr(String inputString){
        String arrChars = "1234567890!@-#$%^&*()=+?|';:,/][{}*.`~\\\"";
        boolean result = false;

        for (int i1 = 0; i1 < arrChars.length(); i1++){
            for (int i2 = 0; i2 < inputString.length(); i2++){
                if(arrChars.charAt(i1) == inputString.charAt(i2)) result = true;
            }
        }
        return result;
    }


    //Первое задание    // Задание 1
    public static void guessNumber (){

        Random rand = new Random();
        int randomNumber = rand.nextInt(10);

        Scanner inputScanner = new Scanner(System.in);
        if (inputScanner.hasNext()) {
            String inputStr = inputScanner.next();
            //--------------------------------------------------------
        }

        boolean endMainCycle = true;

        while (endMainCycle) {
            while (!inputNumber(0, 9, inputScanner))
                System.out.println("Давайте попробуем снова");
            if (randomNumber == globalVariableRandomNumber.inInteger) {
                System.out.println("Вы угадали загаданное число. ПОЗДРАВЛЯЕМ !!!!!");
                break;
            }else System.out.println("Вы не угодали");
            if(!inputEnd(inputScanner)) endMainCycle = false;
        }
    }
    //Метод ввода числа для отгадки // Задание 1
    public static boolean inputNumber (int minNumber, int maxNumber, Scanner inputScanner){
        System.out.println("Введите число от " + minNumber + " до " + maxNumber);

        if (inputScanner.hasNextInt()) {
            int number = inputScanner.nextInt();
            if((number >= minNumber) && (number < maxNumber + 1)) {
                globalVariableRandomNumber.inInteger = number;
                return true;
            }else System.out.println("Число не попадает в заданный диапазон");
        }else System.out.println("Вы ввели \"НЕ ЧИСЛО\"");
        inputScanner.nextLine();
        return false;
    }
    //Метод запроса окончания игры  // Задание 1
    public  static boolean inputEnd (Scanner inputScanner){
        boolean result = false;

        System.out.println("Желаете продолжть ? 1 - да / 0 - нет");
        int number = inputScanner.nextInt();
        if(number == 1) result = true;
        return result;
    }
}
//Глобальные переменные
class globalVariableRandomNumber {
    static int inInteger;//Введеное число // Задание 1

    /*
    основной рабочий массив              //задание 2
    1 - я строка это загаданное слово
    2 - я строка это прогресс разгадки слова
     */
    static String[] wordsArrMain = new String[2];
}