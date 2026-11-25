package Module_2_Design_Patterns.Class_1_SOLID.PaymentGateway;

import Module_2_Design_Patterns.Class_1_SOLID.PaymentGateway.model.Transaction;

import java.util.Optional;

/** DIP: the gateway depends on this abstraction, not on a specific database. */
public interface TransactionRepository {
    void save(Transaction transaction);

    Optional<Transaction> findById(String id);
}
