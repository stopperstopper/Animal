package Main;


import java.util.ArrayList;
import java.util.Scanner;


public class Main {


    static ArrayList<Animal> animalList = new ArrayList<>();

    enum menuEnum {
        add,
        list,
        exit
    }
//Вывод меню на экран
    private static void menuPrint() {
        System.out.println("Введите пункт меню");
        menuEnum[] allmenuEnum = menuEnum.values();
        for (menuEnum comandMenu :allmenuEnum){

            System.out.println(comandMenu);
        }

    }

    //----------------------------------------------//

   //Добавить животное
    private static void addAnimal() {
        System.out.println("Введите животное Dog/Cat/Duck");
        Scanner scanner = new Scanner(System.in);
        String animalType = scanner.nextLine().toLowerCase().trim();

        Animal animal;
        switch (animalType) {
            case "dog"-> animal = new Dog();
            case "cat"-> animal = new Cat();
            case "duck"-> animal = new Duck();
            default ->   animal = new Animal();

        }
        nameAnimal(animal);
        ageAnimals(animal);
        weightAnimal(animal);
        colorAnimal(animal);
        animal.getSay();
        animal.getfly();
        animalList.add(animal);
        menuChoice();
        //System.out.println(animals);
    }

    //Имя
    private static void nameAnimal(Animal animal) {
        System.out.println("Введите имя");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        animal.setNameAnimal(name);
    }
//-----------------------------------------------//

    //Возраст
    private static void ageAnimals(Animal animal) {

        System.out.println("Введите возраст");
        Scanner ageAnimal = new Scanner(System.in);
        int yearsAll = 0;
        String ageFinal="";

        //   while (ageAnimal.hasNextLine()){

         if (ageAnimal.hasNextInt()) {
           yearsAll = ageAnimal.nextInt();

        }

        if (yearsAll < 0)
            System.out.println("Количество лет не может быть отрицательным " + yearsAll + ". Возьмем число " + Math.abs(yearsAll));
        yearsAll = Math.abs(yearsAll);
        int lastDigit = yearsAll / 10;
        int previousLastDigit = yearsAll % 10;

        if (lastDigit == 1)
            ageFinal = yearsAll + " лет ";
        else if (previousLastDigit == 1)
            ageFinal = yearsAll + " год ";
        else if (previousLastDigit == 0 | previousLastDigit == 5 | previousLastDigit == 6 | previousLastDigit == 7 | previousLastDigit == 8 | previousLastDigit == 9)
            ageFinal = yearsAll + " лет ";
        else if (previousLastDigit == 2 | previousLastDigit == 3 | previousLastDigit == 4)
            ageFinal = yearsAll + " года ";
        animal.setAgeAnimal(ageFinal);
    }
//--------------------------------------------------------------------------------------

    //Вес
    private static void weightAnimal(Animal animal) {
        // weight = new String("");//?
        System.out.println("Введите вес");
        Scanner scanner = new Scanner(System.in);
        String weight = scanner.nextLine();//сделать проверку
        animal.setWeightAnimal(weight);
    }
//------------------------------------------------------

    //Цвет
    private static void colorAnimal(Animal animal) {
        // weight = new String("");//?
        System.out.println("Введите цвет");
        Scanner scanner = new Scanner(System.in);
        String color = scanner.nextLine();//сделать проверку
        animal.setColorAnimal(color);
    }
//------------------------------------------------------

    //Вывод списка на экран
    private static void printAll(ArrayList<Animal> list) {
        if (animalList.isEmpty())
            System.out.println("В списке пусто");

        for (int i = 0; i < animalList.size(); i++) {
            System.out.println(list.get(i));
        }
    menuChoice();
    }

//Выбор из меню
    private static void menuChoice() {
        menuPrint();
        Scanner scanner = new Scanner(System.in);
        String menuChoice = scanner.nextLine().toLowerCase().trim();

        switch (menuChoice) {
            case "add"-> addAnimal();

            case "list"-> printAll(animalList);

            case "exit"-> { System.out.println("До свидания");
            System.exit(1);}

            default->   System.out.println("Нет такой команды");

        }
menuChoice();

    }
//-----------------------------------------------------------



    // Main

    //-----------------------------------------------------
    public static void main(String[] args) {
        menuChoice();


    }




    //https://github.com/stopperstopper/Animal.git
    //}
}