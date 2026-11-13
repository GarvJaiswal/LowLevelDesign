package Module_2_Design_Patterns.Class_1_SOLID;

public class Pigeon extends Bird implements Flyable{
    public Pigeon(String name, int age, String color) {
        super(name, age, color);
    }

    @Override
    public void fly() {
        System.out.println("Pigeon is Flying");
    }
}
