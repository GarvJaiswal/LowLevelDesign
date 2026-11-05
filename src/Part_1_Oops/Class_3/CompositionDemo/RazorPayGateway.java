package Part_1_Oops.Class_3.CompositionDemo;
public class RazorPayGateway implements PaymentGateway {

    @Override
    public void pay(double amount) {
        System.out.println("RazorPay: paid Rs " + amount);
    }

    @Override
    public String getGatewayName() {
        return "RazorPay";
    }
}
