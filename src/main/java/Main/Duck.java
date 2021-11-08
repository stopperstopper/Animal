package Main;

public class Duck extends Animal implements Flying{
    @Override
     void getSay() {
         System.out.println("Кря");

    }
   void getfly() {
       Flying.fly();
                }
}
