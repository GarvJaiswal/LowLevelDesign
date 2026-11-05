package Part_1_Oops.Class_4;

public interface Lendable {
    boolean lend(User user);
    void returnItem(User user);
    boolean isAvailable();
}
