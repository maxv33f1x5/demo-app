package com.example.app;

public class App {
    public static void main(String[] args) {

        BankService bankService = new BankService();
        bankService.deposit(5000);
        bankService.withdraw(2000);

        TransactionService transactionService = new TransactionService();
        transactionService.addTransaction(
                new Transaction("Deposit", 5000));

        transactionService.addTransaction(
                new Transaction("Withdraw", 2000));

        transactionService.showTransactions();
    }
}
