package Module_2_Design_Patterns.Class_1_SOLID.PaymentGateway.NotificationWays;

import Module_2_Design_Patterns.Class_1_SOLID.PaymentGateway.model.Transaction;


/** Stand-in for SMS / email / push -- each would be its own NotificationService. */
public class ConsoleNotificationService implements NotificationService {
    @Override
    public void notify(Transaction transaction) {
        System.out.println("    [notify " + transaction.getRequest().getPayerId() + "] "
                + transaction.getId() + " is " + transaction.getStatus());
    }
}