package Animal;

public class Duck extends Animal implements Flying{
    public static String getSay() {
        say = "Кря";
        return say;
    }
    static String getfly() {
        fly = "Я лечу";
        return fly;
    }
}
