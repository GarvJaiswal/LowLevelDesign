package Part_3_Advance_Java.Class_2.Milestone4;

public class Order {
    private final String orderId;
    private final boolean isExpress;

    public Order(String orderId, boolean isExpress) {
        this.orderId = orderId;
        this.isExpress = isExpress;
    }

    public boolean isExpress() {
        return isExpress;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", isExpress=" + isExpress +
                '}';
    }
}