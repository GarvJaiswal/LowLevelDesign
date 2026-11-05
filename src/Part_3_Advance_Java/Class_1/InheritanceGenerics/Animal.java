package Part_3_Advance_Java.Class_1.InheritanceGenerics;
public class Animal extends Creature {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    public Animal() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
