package Module_2_Design_Patterns.Class_1_SOLID.PaymentGateway.modesOfPayments;

import Module_2_Design_Patterns.Class_1_SOLID.PaymentGateway.dto.PaymentRequest;
import Module_2_Design_Patterns.Class_1_SOLID.PaymentGateway.dto.PaymentResult;

/**
 * ISP: the minimum every payment method can honour -- take a payment.
 * Refunds are a separate capability (RefundProcessor) because not every method supports them.
 */
public interface PaymentProcessor {
    /** Key the gateway routes on, e.g. "UPI". */
    String method();

    PaymentResult pay(PaymentRequest request);
}