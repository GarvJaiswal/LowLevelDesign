package Module_2_Design_Patterns.Class_1_SOLID.PaymentGateway.NotificationWays;

import Module_2_Design_Patterns.Class_1_SOLID.PaymentGateway.model.Transaction;

/** DIP + SRP: notifying the user is not the gateway's job; it just calls this abstraction. */
public interface NotificationService {
    void notify(Transaction transaction);
}
