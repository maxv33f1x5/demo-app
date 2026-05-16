package com.example.app;

public class Transaction {

    private String type;
    private double amount;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }
}package com.example.app;

public class Transaction {

    private String type;
    private double amount;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }
}package com.example.app;

public class BankService {

    public static void deposit(BankAccount account, double amount) {

        account.setBalance(account.getBalance() + amount);

        System.out.println("\n₹" + amount + " Deposited Successfully");
        System.out.println("Updated Balance : ₹" + account.getBalance());

        TransactionService.addTransaction(
                "DEPOSIT",
                amount
        );
    }

    public static void withdraw(BankAccount account, double amount) {

        if (account.getBalance() >= amount) {

            account.setBalance(account.getBalance() - amount);

            System.out.println("\n₹" + amount + " Withdrawn Successfully");
            System.out.println("Updated Balance : ₹" + account.getBalance());

            TransactionService.addTransaction(
                    "WITHDRAW",
                    amount
            );

        } else {

            System.out.println("\nInsufficient Balance");
        }
    }

    public static void transfer(
            BankAccount sender,
            BankAccount receiver,
            double amount
    ) {

        if (sender.getBalance() >= amount) {

            sender.setBalance(sender.getBalance() - amount);

            receiver.setBalance(receiver.getBalance() + amount);

            System.out.println("\n₹" + amount + " Transfer Successful");
            System.out.println(
                    "Transferred From Account "
                            + sender.getAccountNumber()
                            + " To Account "
                            + receiver.getAccountNumber()
            );

            TransactionService.addTransaction(
                    "TRANSFER",
                    amount
            );

        } else {

            System.out.println("\nInsufficient Balance For Transfer");
        }
    }
}
