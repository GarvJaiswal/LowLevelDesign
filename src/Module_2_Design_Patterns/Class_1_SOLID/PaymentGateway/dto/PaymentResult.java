package Module_2_Design_Patterns.Class_1_SOLID.PaymentGateway.dto;

import Module_2_Design_Patterns.Class_1_SOLID.PaymentGateway.modesOfPayments.PaymentStatus;

/** What a processor reports back after talking to its provider. */
public final class PaymentResult {
    private final PaymentStatus status;
    private final String message;

    public PaymentResult(PaymentStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}