package Part_1_Oops.Class_3.ClassExplosionDemo;
/** Pigeon CAN fly AND CAN dance. Implements both interfaces. */
public class Pigeon extends Bird implements Flyable, Danceable {

    public Pigeon() { super("Pigeon"); }

    @Override
    public void fly() {
        System.out.println("Pigeon is flying");
    }

    @Override
    public void dance() {
        System.out.println("Pigeon is dancing");
    }
}
