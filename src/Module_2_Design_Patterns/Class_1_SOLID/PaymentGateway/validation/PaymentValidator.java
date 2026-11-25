package Module_2_Design_Patterns.Class_1_SOLID.PaymentGateway.validation;

import Module_2_Design_Patterns.Class_1_SOLID.PaymentGateway.dto.PaymentRequest;
import Module_2_Design_Patterns.Class_1_SOLID.PaymentGateway.exceptions.PaymentException;

/** SRP: each validator checks exactly one rule. OCP: add a rule by adding a class. */
public interface PaymentValidator {
    void validate(PaymentRequest request) throws PaymentException;
}
