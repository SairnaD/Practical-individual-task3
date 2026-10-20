package org.example.payment;

import org.example.model.PaymentResult;

public class BankTransferPayment extends PaymentMethod {
    private final String accountHolderName;
    private final String iban;

    public BankTransferPayment(String accountHolderName, String iban) {
        super("Bank Transfer");
        this.accountHolderName = accountHolderName;
        this.iban = iban;
    }

    @Override
    protected PaymentResult processPayment(double amount) {
        if (accountHolderName == null || accountHolderName.isBlank()) {
            return new PaymentResult(false, "Account holder name cannot be empty.");
        }

        if (iban == null || iban.isBlank()) {
            return new PaymentResult(false, "IBAN cannot be empty.");
        }

        return new PaymentResult(true, "Paid " + amount + " using bank transfer. Account holder: " + accountHolderName
        );
    }
}
