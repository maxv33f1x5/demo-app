package com.example.app;

import java.util.ArrayList;

public class TransactionService {

    private static ArrayList<Transaction> transactions =
            new ArrayList<>();

    public static void addTransaction(
            String type,
            double amount
    ) {

        transactions.add(
                new Transaction(type, amount)
        );
    }

    public static void showTransactions() {

        System.out.println("\n====================================");
        System.out.println("       TRANSACTION HISTORY");
        System.out.println("====================================");

        for (Transaction transaction : transactions) {

            System.out.println(
                    transaction.getType()
                            + " : ₹"
                            + transaction.getAmount()
            );
        }
    }
}
