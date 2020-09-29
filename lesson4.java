package project1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*
        1 - Выбор размерности поля
        2 - Выбор второго игрока AI или  человек
        3 - Ход первого игрока
            3.1 - Проверка занятости ячейки
                3.1.1 - Если занята, Вывод сообщение и вернуться
                3.1.2 - Если свободна, запись в поле
            3.2 - Проверка на победу
            3.3 - Проверка на ничью
        4 - Ход второго игрока AI (пока просто рандом)
            4.1 - Логика хода AI
                4.1 - Проверка занятости ячейки
                4.1.1 - Если занята, Вывод сообщение и вернуться
                4.1.2 - Если свободна, запись в поле
            4.2 - Проверка на ничью
            4.3 - Проверка на победу
         */

        System.out.println("Здратвуйте \n Приветствуем вас в игре: \"Крестики нолики\" ");
        System.out.println("Ваедите размер желаемого игрового поля (не меньше 3 не больше 10)");
        int lMatrix = inputInt(3, 10);  //Размер игрового поля

        //Инициализация игрового поля
        byte[][] matrix = new byte[lMatrix][lMatrix];
        classMatrix playField = new classMatrix(matrix);

        //Инициализация фишек
        classChip chipX = new classChip((char) 88, (byte) 1); // фишка X
        classChip chipO = new classChip((char) 79, (byte) 2); // фишка O

        classAI chipXAi = new classAI(chipX.getIndexChip());
        classAI chipOAi = new classAI(chipO.getIndexChip());

        //Определение второго игрока
        System.out.println("Выберите вариант игры \n" +
                            "0 - Игрок против игрока\n" +
                            "1 - Игрок против Компьютера\n" +
                            "2 - Копьютер против Компьютера");
        int inputI = inputInt(0, 2);
        if(inputI == 0){
            chipX.setAiEneble(false);
            chipO.setAiEneble(false);
        }
        if(inputI == 1) {
            //Выбор игральных фишек
            System.out.println("Выберите игровые фишки ");
            System.out.println(chipX.getIndexChip() + " - " + chipX.getChipCh());
            System.out.println(chipO.getIndexChip() + " - " + chipO.getChipCh());

            int selectChip = inputInt(chipX.getIndexChip(), chipO.getIndexChip());

            switch (selectChip) {
                case 1:
                    chipX.setAiEneble(false);
                    break;
                case 2:
                    chipO.setAiEneble(false);
                    break;
            }
        }
        if(inputI == 2){
            // У фишек по умолчанию включено управление компьютером
        }

        //Начало игры
        boolean result = false;

        while (!result) {

            // Ход человека фишками Х
            if (!chipX.getAiEneble()){
                playField.printPlayField();
                System.out.println("Ходит " + chipX.getChipCh() +":\nвведите индекс ячейки:");
                int inputPlayerIndex = inputInt(0, playField.matrix.length * playField.matrix.length - 1);
                byte playX = playField.getX(inputPlayerIndex);
                byte playY = playField.getY(inputPlayerIndex);

                //Проверка на победу
                if (playField.setChipXY(playX, playY, chipX.getIndexChip())){
                    if(playField.checkCellVictory(playX, playY)){
                        playField.printPlayField();
                        System.out.println("Фишки " + chipX.getChipCh() + " победили.");
                        System.out.println("ПОЗДРАВЛЯЕМ!!!!!!!!!!!!");
                        result = true;
                        break;
                    }
                }
                //Проверка на ничью
                if (playField.chekStandoff()){
                    playField.printPlayField();
                    System.out.println("ЭТО НИЧЬЯ");
                    System.out.println("Свободные ячейки закончились");
                    result = true;
                    break;
                }
            }

            // Ход человека фишками О
            if (!chipO.getAiEneble()){
                playField.printPlayField();
                System.out.println("Ходит " + chipO.getChipCh() +":\nвведите индекс ячейки:");
                int inputPlayerIndex = inputInt(0, playField.matrix.length * playField.matrix.length - 1);
                byte playX = playField.getX(inputPlayerIndex);
                byte playY = playField.getY(inputPlayerIndex);

                if (playField.setChipXY(playX, playY, chipO.getIndexChip())){
                    if(playField.checkCellVictory(playX, playY)){
                        playField.printPlayField();
                        System.out.println("Фишки " + chipO.getChipCh() + " победили.");
                        System.out.println("ПОЗДРАВЛЯЕМ!!!!!!!!!!!!");
                        result = true;
                        break;
                    }
                }
                //Проверка на ничью
                if (playField.chekStandoff()){
                    playField.printPlayField();
                    System.out.println("ЭТО НИЧЬЯ");
                    System.out.println("Свободные ячейки закончились");
                    result = true;
                    break;
                }
            }

            // Ход ИИ фишками Х
            if (chipX.getAiEneble()) {
                playField.printPlayField();
                System.out.println("Ходит " + chipX.getChipCh());

                chipXAi.nextStep(playField.matrix); // шаг компьютера


                //Проверка на победу
                if (playField.setChipXY(chipXAi.x, chipXAi.y, chipX.getIndexChip())){
                    if(playField.checkCellVictory(chipXAi.x, chipXAi.y)){
                        playField.printPlayField();
                        System.out.println("Фишки " + chipX.getChipCh() + " победили.");
                        System.out.println("ПОЗДРАВЛЯЕМ!!!!!!!!!!!!");
                        result = true;
                        break;
                    }
                }


                //Проверка на ничью
                if (playField.chekStandoff()){
                    playField.printPlayField();
                    System.out.println("ЭТО НИЧЬЯ");
                    System.out.println("Свободные ячейки закончились");
                    result = true;
                    break;
                }
            }

            // Ход ИИ фишками О
            if (chipO.getAiEneble()) {
                playField.printPlayField();
                System.out.println("Ходит " + chipO.getChipCh());

                chipOAi.nextStep(playField.matrix);

                //Проверка на победу
                if (playField.setChipXY(chipOAi.x, chipOAi.y, chipO.getIndexChip())){
                    if(playField.checkCellVictory(chipOAi.x, chipOAi.y)){
                        playField.printPlayField();
                        System.out.println("Фишки " + chipO.getChipCh() + " победили.");
                        System.out.println("ПОЗДРАВЛЯЕМ!!!!!!!!!!!!");
                        result = true;
                        break;
                    }
                }


                //Проверка на ничью
                if (playField.chekStandoff()){
                    playField.printPlayField();
                    System.out.println("ЭТО НИЧЬЯ");
                    System.out.println("Свободные ячейки закончились");
                    result = true;
                    break;
                }
            }

        }
    }


    //Метод ввода числа с проверкой на ввод числового значения
    public static int inputInt(){
        Scanner scan = new Scanner(System.in);
        int inpInt = 0;
        boolean result = false;

        while (!result) {
            if (scan.hasNextInt()) {
                inpInt = scan.nextInt();
                result = true;
            } else {
                System.out.println("Вы ввели не численное значение");
                scan.nextLine();
            }
        }
        return inpInt;
    }

    //Метод ввода числа с разрешенным мин. значением
    public static int inputInt(int minInt){
        boolean result = false;
        int inpInt = 0;

        while (!result) {
            inpInt = inputInt();
            if (inpInt >= minInt) {
                result = true;
                break;
            } else System.out.println("Значение не должно быть меньше " + minInt);

        }
        return inpInt;
    }

    //Метод ввода числа с разрешенным диапазонм
    public static int inputInt(int minInt,int maxInt){
        boolean result = false;
        int inpInt = 0;

        while (!result) {
            inpInt = inputInt();
            if ((inpInt <= maxInt) && (inpInt >= minInt)) {
                result = true;
                break;
            } else System.out.println("Значение не попадает в диапазон от " + minInt + " до " + maxInt);
        }
        return inpInt;
    }
}

// класс фишки
class classChip {
    /*
    0 - пробел
    88 - X
    79 - O
     */
    classChip(char ch, byte index){
        setChipCh(ch);
        setIndexChip(index);
    }
    char visualChip = 0;
    byte indexChip = 0;
    boolean aiEneble = true;

    public void setChipCh(char ch){
        this.visualChip = ch;
    }
    public void setIndexChip(byte index){
        this.indexChip = index;
    }
    public char getChipCh(){
        return this.visualChip;
    }
    public byte getIndexChip(){
        return  this.indexChip;
    }
    public void setAiEneble(boolean bol){
        this.aiEneble = bol;
    }
    public boolean getAiEneble(){
        return this.aiEneble;
    }

}
// класс игрового поля
class classMatrix {
    byte[][] matrix;

    classMatrix(byte[][] tempArr1){
        this.matrix = tempArr1;
        byte[] tempArr2 = tempArr1[0];

        // Заполнение матрицы
        for(int i1 = 0; i1 < tempArr1.length; i1++){
            for (int i2 = 0; i2 < tempArr2.length; i2++){
                this.matrix[i1][i2] = 0;
            }
        }
    }


    //Установка фишки
    public boolean setChipXY(int indexX, int indexY, byte indexChip){
        boolean result = false;
        if(checkCellChip(indexX, indexY)){
            this.matrix[indexX][indexY] = indexChip;
            result = true;
        }
        else System.out.println("Ячейка занята");
        return  result;
    }

    //Проверка ячейки на отсутсвие фишек
    private boolean checkCellChip(int indexX, int indexY){
        boolean result = true;
        if(this.matrix[indexX][indexY] != 0) result = false;
        return result;
    }

    //Проверка ячейки на победу
    public boolean checkCellVictory(int indexX, int indexY){
        boolean result = false;

        if(checkVertical(indexX, indexY)) result = true;
        if(checkHorizont(indexX, indexY)) result = true;
        if(checkDiagonal1(indexX, indexY)) result = true;
        if(checkDiagonal2(indexX, indexY)) result = true;

        return result;
    }
        //Проверка вертикали
        private boolean checkVertical(int indexX, int indexY){
            boolean result = true;
            byte ch = this.matrix[indexX][indexY];

            for (int i = 0; i < this.matrix.length; i++){
                if(ch != this.matrix[indexX][i]){
                    result = false;
                }
            }
            return result;
        }
        //Проверка горизонтали
        private boolean checkHorizont(int indexX, int indexY){
            boolean result = true;
            byte ch = this.matrix[indexX][indexY];

            for (int i = 0; i < this.matrix.length; i++){
                if(ch != this.matrix[i][indexY]){
                    result = false;
                }
            }
            return result;
        }
        //Проверка основной диоганали
        private boolean checkDiagonal1(int indexX, int indexY){
            boolean result = true;
            byte ch = this.matrix[indexX][indexY];

            for (int i = 0; i < this.matrix.length; i++){
                if(ch != this.matrix[i][i]){
                    result = false;
                }
            }
            return result;
        }
        //Проверка дополнительной диагонали
        private boolean checkDiagonal2(int indexX, int indexY){
            boolean result = true;
            byte ch = this.matrix[indexX][indexY];

            for (int i = 0; i < this.matrix.length; i++){
                if(ch != this.matrix[this.matrix.length - i - 1][i]){
                    result = false;
                }
            }
            return result;
        }
        //Вывод матрицы в консоль
    public void printPlayField(){
        String row = "";
        int count = 0;

        char ch = (char)0;
        for (int i1 = 0; i1 < this.matrix.length; i1++){
            row += "\n";
            for (int i2 = 0; i2 < this.matrix.length; i2++){
                if(count < 10) row += "  " + count;
                else row += " " + count;
                count++;
            }
            row += "         ";
            for (int i2 = 0; i2 < this.matrix.length; i2++){
                if(this.matrix[i1][i2] == 0) ch = (char)127;
                if(this.matrix[i1][i2] == 1) ch = (char)88;
                if(this.matrix[i1][i2] == 2) ch = (char)79;
                row += " " + ch;
            }
            row += "\n";
        }
        System.out.println(row);
    }
        //Перевод индекса ячейки в x
    public byte getX(int index){
        int count = 0;
        byte re = 0;

        for (byte i1 = 0; i1 < this.matrix.length; i1++){
            for (byte i2 = 0; i2 < this.matrix.length; i2++){
                if (count == index) re = i1;
                count++;
            }
        }
        return re;
    }

    //Перевод индекса ячейки в y
    public byte getY(int index){
        int count = 0;
        byte re = 0;

        for (byte i1 = 0; i1 < this.matrix.length; i1++){
            for (byte i2 = 0; i2 < this.matrix.length; i2++){
                if (count == index)
                    re = i2;
                count++;
            }
        }
        return re;
    }

    //Проверка на ничью
    public boolean chekStandoff(){
        boolean result = false;
        int count = 0;

        for (byte i1 = 0; i1 < this.matrix.length; i1++){
            for (byte i2 = 0; i2 < this.matrix.length; i2++){
                if(this.matrix[i1][i2] == 0) count++;
            }
        }
        if(count == 0) result = true;

        return  result;
    }
}
// класс ИИ
class classAI {
    byte indexChip;

    public byte x;
    public byte y;

    classAI(byte indexChip){
        this.indexChip = indexChip;
    }

    public void nextStep(byte[][] arr) {
            boolean result = false;
            Random random = new Random();
            byte x, y;
            byte [] indexXY = new byte[1];

            while (!result) {
                x = (byte) random.nextInt(arr.length);
                y = (byte) random.nextInt(arr.length);

                if (arr[x][y] == 0) {
                    result = true;

                    this.x = x;
                    this.y = y;
                }
            }
    }

}