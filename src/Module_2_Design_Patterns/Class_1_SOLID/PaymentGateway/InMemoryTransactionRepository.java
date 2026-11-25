package Module_2_Design_Patterns.Class_1_SOLID.PaymentGateway;

import Module_2_Design_Patterns.Class_1_SOLID.PaymentGateway.model.Transaction;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

/** Swap for a MySqlTransactionRepository later without touching PaymentGateway (DIP). */
public class InMemoryTransactionRepository implements TransactionRepository {
    private final Map<String, Transaction> store = new LinkedHashMap<>();

    @Override
    public void save(Transaction transaction) {
        store.put(transaction.getId(), transaction);
    }

    @Override
    public Optional<Transaction> findById(String id) {
        return Optional.ofNullable(store.get(id));
    }
}
