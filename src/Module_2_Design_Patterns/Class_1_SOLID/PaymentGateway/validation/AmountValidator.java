package Module_2_Design_Patterns.Class_1_SOLID.PaymentGateway.validation;

import Module_2_Design_Patterns.Class_1_SOLID.PaymentGateway.dto.PaymentRequest;
import Module_2_Design_Patterns.Class_1_SOLID.PaymentGateway.exceptions.PaymentException;

public class AmountValidator implements PaymentValidator {
    private final double maxAmount;

    public AmountValidator(double maxAmount) {
        this.maxAmount = maxAmount;
    }

    @Override
    public void validate(PaymentRequest request) throws PaymentException {
        if(request.getAmount() <= 0){
            throw new PaymentException("Amount must be postive, got " + request.getAmount());
        }
        if(request.getAmount() > maxAmount){
            throw new PaymentException("Amount " + request.getAmount() + " exceeds limit " + maxAmount);
        }
    }
}
