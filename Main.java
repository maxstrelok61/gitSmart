package Gedon;

import java.text.MessageFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Random rn = new Random();
        Name[] names = {
                new Name("Серега", 1),
                new Name("Андрей", 2),
                new Name("Алексей", 3),
                new Name("Кирил", 4),
                new Name("Степан", 5),
                new Name("Кирил", 6),
                new Name("Петр", 7),
                new Name("Стефан", 8),
                new Name("Стол", 9),
                new Name("Чебурек", 10),
                new Name("Диван", 11),
                new Name("Клюшка", 12),
                new Name("Стекло", 13),
                new Name("Буратино", 14),
                new Name("Ляля", 15)};
        ArrayList<Name> arrayNames = new ArrayList<>();
        Map<Name, Integer> map = new HashMap<>();


        for (int i = 0; i < 20; i++) {
            arrayNames.add(names[rn.nextInt(names.length - 1)]);
        }

        for (int i = 0; i < names.length; i++) {
            map.put(names[i], 0);
        }
        //Поиск встречающихся слов
        int tempNmae;
        for(Map.Entry<Name, Integer> entry : map.entrySet()){
            entry.setValue(findInArr(entry.getKey().name, arrayNames));
           // System.out.printf(MessageFormat.format("Слово: \"{0}\"  встречается: {1} раз \n", entry.getKey().name, entry.getValue()));

        }

        //Второе задание
        NumberList nList = new NumberList();

        //заполняем
        for (int i = 0; i < names.length; i++) {
            nList.addContact(names[i], new Telephone(names[i].id, Integer.toString(rn.nextInt(10652003) * 95 )));
        }
        //nList.print_Names();
//        nList.find_Names(4);
//        nList.print_Numbers(4);
        Scanner scanner = new Scanner(System.in);
        Scanner scannerW = new Scanner(System.in);
        String in;

        String menu = "";
        printMenu();

        while (true) {
            menu = "";
            in = scanner.next();
            if (in.equals("exit")) break;
            if (in.equals("menu"))printMenu();
            if (in.equals("find_name")) menu = in;
            if (in.equals("find_number")) menu = in;
            if (in.equals("add_name")) menu = in;
            if (in.equals("add_number")) menu = in;
            System.out.println("");


            if (menu.equals("find_name")){
                System.out.println("all - вывести все \n");
                String name;
                System.out.print("Введите имя : ");
                name = scannerW.nextLine();


                if((name.equals("all")|(name.equals("")))) nList.print_Names();
                else nList.find_Names(name);
                System.out.println("----------------------------");
            }
            if (menu.equals("find_number")){
                String number;
                System.out.print("Введите номер : ");
                number = scanner.next();

                nList.findNumber(number);

                System.out.println("----------------------------");
            }
            if (menu.equals("add_name")){
                String name;
                System.out.print("Введите имя : ");
                name = scannerW.nextLine();

                String number;
                System.out.print("Введите номер : ");
                number = scanner.next();

                nList.printNameAndNumbers(nList.addNewContact(name, number));


                System.out.println("----------------------------");
            }
            if (menu.equals("add_number")){
                String id;
                System.out.print("Введите id контакта : ");
                id = scanner.next();

                String number;
                System.out.print("Введите номер : ");
                number = scanner.next();

                nList.addNumber(Integer.parseInt(id), number);
                nList.printNameAndNumbers(Integer.parseInt(id));
                System.out.println("----------------------------");
            }
            if (menu.equals("del_name")){
                String id;
                System.out.print("Введите id контакта : ");
                id = scanner.next();

                nList.delId(Integer.parseInt(id));
                System.out.println("----------------------------");
            }
            if (menu.equals("del_namber")){
                String number;
                System.out.print("Введите номер : ");
                number = scanner.next();

                nList.delNumber(number);
                System.out.println("----------------------------");
            }
            if (isDigit(in)){
                int id = Integer.parseInt(in);
                nList.printNameAndNumbers(id);
            }

        }
    }
    public static void printMenu(){
        System.out.println("Здраствуйте, Вы находитесь в главном меню телефонного справочника");
        System.out.println("menu для вывода меню");
        System.out.println("find_name - поиск по имени");
        System.out.println("find_number - поиск по телефону");
        System.out.println("add_name - добавить контакт");
        System.out.println("add_number - добавить телефон");
        System.out.println("del_name - удалить по имени");
        System.out.println("del_namber - удалить номер");
        System.out.println("или введите id контакта");
    }
    public static int findInArr(String findStr, ArrayList<Name> arr){
        int count = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).name.equals(findStr)) count++;
        }
        return count;
    }
    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


}
