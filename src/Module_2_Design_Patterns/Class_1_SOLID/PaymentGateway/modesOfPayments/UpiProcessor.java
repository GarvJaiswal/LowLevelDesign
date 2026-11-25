package Module_2_Design_Patterns.Class_1_SOLID.PaymentGateway.modesOfPayments;

import Module_2_Design_Patterns.Class_1_SOLID.PaymentGateway.dto.PaymentRequest;
import Module_2_Design_Patterns.Class_1_SOLID.PaymentGateway.dto.PaymentResult;
import Module_2_Design_Patterns.Class_1_SOLID.PaymentGateway.model.Transaction;

//supports payment + refund
public class UpiProcessor implements PaymentProcessor, RefundProcessor {
    @Override
    public String method() {
        return "UPI";
    }

    @Override
    public PaymentResult pay(PaymentRequest request) {

        return new PaymentResult(PaymentStatus.SUCCESS,"Payment Recieved via UPI");
    }

    @Override
    public PaymentResult refund(Transaction transaction) {
        return new PaymentResult(PaymentStatus.REFUNDED,"Refunded via UPI");
    }


}
