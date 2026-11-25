package Module_2_Design_Patterns.Class_1_SOLID.PaymentGateway.validation;

import Module_2_Design_Patterns.Class_1_SOLID.PaymentGateway.dto.PaymentRequest;
import Module_2_Design_Patterns.Class_1_SOLID.PaymentGateway.exceptions.PaymentException;

public class PayerValidator implements PaymentValidator {
    @Override
    public void validate(PaymentRequest request) throws PaymentException {
        if (request.getPayerId() == null || request.getPayerId().isBlank()) {
            throw new PaymentException("Payer id is required");
        }
    }
}
