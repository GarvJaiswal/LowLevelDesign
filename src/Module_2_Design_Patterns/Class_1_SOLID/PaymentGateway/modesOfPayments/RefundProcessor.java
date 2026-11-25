package Module_2_Design_Patterns.Class_1_SOLID.PaymentGateway.modesOfPayments;

import Module_2_Design_Patterns.Class_1_SOLID.PaymentGateway.dto.PaymentResult;
import Module_2_Design_Patterns.Class_1_SOLID.PaymentGateway.model.Transaction;

/** ISP: optional capability -- only methods that can actually refund implement this. */
public interface RefundProcessor {
    String method();

    PaymentResult refund(Transaction transaction);
}
