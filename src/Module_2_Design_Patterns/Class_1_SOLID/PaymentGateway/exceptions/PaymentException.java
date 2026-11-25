package Module_2_Design_Patterns.Class_1_SOLID.PaymentGateway.exceptions;

/**
 * Checked on purpose (Advanced Java - 4): the caller can recover --
 * fix the amount, pick another payment method, and retry.
 */
public class PaymentException extends Exception {
    public PaymentException(String message) {
        super(message);
    }
}