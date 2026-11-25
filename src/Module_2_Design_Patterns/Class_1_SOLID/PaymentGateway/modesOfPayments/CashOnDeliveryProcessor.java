package Module_2_Design_Patterns.Class_1_SOLID.PaymentGateway.modesOfPayments;

import Module_2_Design_Patterns.Class_1_SOLID.PaymentGateway.dto.PaymentRequest;
import Module_2_Design_Patterns.Class_1_SOLID.PaymentGateway.dto.PaymentResult;

//refund not supported

public class CashOnDeliveryProcessor implements PaymentProcessor {
    @Override
    public String method() {
        return "COD";
    }

    @Override
    public PaymentResult pay(PaymentRequest request) {
        return new PaymentResult(PaymentStatus.SUCCESS,"Payment via cash");
    }
}
