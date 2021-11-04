package Animal;

public class Duck extends Animal implements Flying{
     static String getSay() {
        say = "Кря";
        return say;
    }
    static String getfly() {
        fly = "Я лечу";
        return fly;
    }
}
