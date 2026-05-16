package com.example.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {

        logger.info("===== BANK MANAGEMENT SYSTEM STARTED =====");

        System.out.println("\n====================================");
        System.out.println("      BANK MANAGEMENT SYSTEM");
        System.out.println("====================================");

        // Create Accounts
        BankAccount account1 = new BankAccount(1001, "Aryan", 5000);
        BankAccount account2 = new BankAccount(1002, "Rahul", 3000);

        System.out.println("\nAccounts Created Successfully");

        account1.displayAccountDetails();
        account2.displayAccountDetails();

        // Deposit
        BankService.deposit(account1, 2000);

        // Withdraw
        BankService.withdraw(account1, 1500);

        // Transfer
        BankService.transfer(account1, account2, 1000);

        // Interest
        double interest = InterestCalculator.calculateInterest(
                account1.getBalance(),
                5,
                2
        );

        System.out.println("\nInterest Calculated: ₹" + interest);

        // Transaction History
        TransactionService.showTransactions();

        // Final Balance
        System.out.println("\n====================================");
        System.out.println("FINAL ACCOUNT DETAILS");
        System.out.println("====================================");

        account1.displayAccountDetails();
        account2.displayAccountDetails();

        logger.info("===== APPLICATION EXECUTED SUCCESSFULLY =====");
    }
}
