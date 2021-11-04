package Animal;

import java.util.ArrayList;
import java.util.Scanner;
import java.lang.*;

public class Animal {
    private static ArrayList<String> animals = new ArrayList<String>();
    private static String age;
    private static String name;
    private static String weight;
    private static String color;
    static String say;
    static String fly;
    static String go;
    static String drink;
    static String eat;
    private static int deleteRow=0;

    // Методы GET/SET say, go, drink, eat
     static String getSay() {
        say = "Я говорю";
        return say;
    }

     void setSay(String newsay) {
        say = newsay;
    }

    static String getGo() {
        go = "Я иду";
        return go;
    }

    static void setGo(String newgo) {
        go = newgo;
    }

    static String getDrink() {
        drink = "Я пью";
        return drink;
    }

    static void setDrink(String newdrink) {
        drink = newdrink;
    }

    static String getEat() {
        eat = "Я ем";
        return eat;
    }

    static void setEat(String neweat) {
        eat = neweat;
    }
// ----------------------------------------------------------------------//

    //Вывод меню
    public static void menuPrint() {
        System.out.println("Введите пункт меню");
        System.out.println("1 - Добавить");
        System.out.println("2 - Удалить");
        System.out.println("3 - Список");
        System.out.println("4 - Выход");
    }
//----------------------------------------------//

    //Имя
    public static void name() {
        System.out.println("Введите ваше имя");
        Scanner scanner = new Scanner(System.in);
        name = scanner.nextLine();//сделать проверку
    }
//-----------------------------------------------//

    //Возраст
    public static void years() {
        System.out.println("Введите возраст");
        Scanner scanner = new Scanner(System.in);

        int year = 0;

        if (scanner.hasNextInt()) {
            year = scanner.nextInt();

        } else {
            System.out.println("Извините, но это явно не число. Перезапустите программу и попробуйте снова!");
            System.exit(1);
        }

        if (year < 0)
            System.out.println("Количество лет не может быть отрицательным " + year + ". Возьмем число "+Math.abs(year));
        year=Math.abs(year);
        int lastDigit = year / 10;
        int previousLastDigit = year % 10;

        if (lastDigit == 1)
            age = year + " лет ";
        else if (previousLastDigit == 1)
            age = year + " год ";
        else if (previousLastDigit == 0 | previousLastDigit == 5 | previousLastDigit == 6 | previousLastDigit == 7 | previousLastDigit == 8 | previousLastDigit == 9)
            age = year + " лет ";
        else if (previousLastDigit == 2 | previousLastDigit == 3 | previousLastDigit == 4)
            age = year + " года ";
    }
//--------------------------------------------------------------------------------------

    //Вес
    public static void weight() {
        // weight = new String("");//?
        System.out.println("Введите вес");
        Scanner scanner = new Scanner(System.in);
        weight = scanner.nextLine();//сделать проверку

    }
//------------------------------------------------------

    //Цвет
    public static void color() {
        // weight = new String("");//?
        System.out.println("Введите цвет");
        Scanner scanner = new Scanner(System.in);
        color = scanner.nextLine();//сделать проверку

    }
//------------------------------------------------------

    //Вывод массива на экран
    private static void printAll(ArrayList<String> list) {
        if (animals.isEmpty())
            System.out.println("В массиве пусто");

        for (int i = 0; i < animals.size(); i++) {
            System.out.println("№ строки " + i + " Содержимое " + list.get(i));
        }}


    //-----------------------------------------------------

    @Override
    //Переопределение toString
    public String toString() {
        return "Привет! Меня зовут " + name + ", мне " + age + ", я вешу " + weight + " кг" + ", мой цвет - " + color;
    }
    //---------------------------------------------


    //------------------------------------------------------
    //Цикл меню
    public static void menuChoice(int numMenu) {


        switch (numMenu) {
            case 1:
                name();
                years();
                weight();
                color();
                Animal animal = new Animal();
                animals.add(animal.toString());

                 break;
            case  2:
                if (animals.isEmpty()) {
                    System.out.println("Нечего удалять. Массив пуст");
                    break;
                }
                else{
                printAll(animals);
                    System.out.println("Введите номер строки для удаления");}

                    Scanner scanner = new Scanner(System.in);
                    //  deleteRow = scanner.nextInt();//сделать проверку
                    if (scanner.hasNextInt()) {
                        deleteRow = scanner.nextInt();

                    } else {
                        System.out.println("Извините, но это явно не число. Перезапустите программу и попробуйте снова!");
                        System.exit(1);
                    }
                if (animals.isEmpty()) {
                   // System.out.println("Нечего удалять");
                    break;
                }
                else{
                    animals.remove(deleteRow);
                }

                break;
                 case 3:
                //System.out.println();
                printAll(animals);

                break;
            case 4:
                System.out.println("До свидания");
                System.exit(5);

            default:
                System.out.println("Нет такой команды");
        }
    }
    //-----------------------------------------------------


    // Main
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
             menuPrint();

          while (scanner.hasNext()) {  //зациклил меню
            menuChoice(scanner.nextInt());
            System.out.println();
            menuPrint();
        }

        //Duck duck =new Duck();
        //System.out.println(duck.getfly());
    }
}
