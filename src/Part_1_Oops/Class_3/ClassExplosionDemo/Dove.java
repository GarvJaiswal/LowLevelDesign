package Part_1_Oops.Class_3.ClassExplosionDemo;
/** Dove CAN fly but CANNOT dance. */
public class Dove extends Bird implements Flyable {

    public Dove() { super("Dove"); }

    @Override
    public void fly() {
        System.out.println("Dove is flying gracefully");
    }
}
