package Part_1_Oops.Class_4;

public class DummyClass implements Lendable {
    @Override
    public boolean lend(User user) {
        return false;
    }

    @Override
    public void returnItem(User user) {

    }

    @Override
    public boolean isAvailable() {
        return false;
    }
}