package Module_2_Design_Patterns.Class_1_SOLID.PaymentGateway.modesOfPayments;

import Module_2_Design_Patterns.Class_1_SOLID.PaymentGateway.dto.PaymentRequest;
import Module_2_Design_Patterns.Class_1_SOLID.PaymentGateway.dto.PaymentResult;
import Module_2_Design_Patterns.Class_1_SOLID.PaymentGateway.model.Transaction;

public class WalletProcessor implements PaymentProcessor, RefundProcessor {
    private double balance;

    public WalletProcessor(double balance) {
        this.balance = balance;
    }

    @Override
    public String method() {
        return "WALLET";
    }

    @Override
    public PaymentResult pay(PaymentRequest request) {
        if(request.getAmount() > balance){
            return new PaymentResult(PaymentStatus.FAILED,"Insufficient Balance in the wallet" + balance);
        }

        return new PaymentResult(PaymentStatus.SUCCESS,"Payment done via wallet");
    }

    @Override
    public PaymentResult refund(Transaction transaction) {
        return new PaymentResult(PaymentStatus.REFUNDED,"Credited back " + transaction.getRequest().getAmount());
    }


}
