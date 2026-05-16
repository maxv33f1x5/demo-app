package com.example.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AppTest {

    @Test
    public void testDeposit() {

        BankAccount account =
                new BankAccount(1001, "Aryan", 5000);

        BankService.deposit(account, 2000);

        assertEquals(
                7000,
                account.getBalance(),
                0.01
        );
    }

    @Test
    public void testWithdraw() {

        BankAccount account =
                new BankAccount(1001, "Aryan", 5000);

        BankService.withdraw(account, 1000);

        assertEquals(
                4000,
                account.getBalance(),
                0.01
        );
    }

    @Test
    public void testTransfer() {

        BankAccount sender =
                new BankAccount(1001, "Aryan", 5000);

        BankAccount receiver =
                new BankAccount(1002, "Rahul", 3000);

        BankService.transfer(sender, receiver, 1000);

        assertEquals(
                4000,
                sender.getBalance(),
                0.01
        );

        assertEquals(
                4000,
                receiver.getBalance(),
                0.01
        );
    }

    @Test
    public void testInterestCalculation() {

        double interest =
                InterestCalculator.calculateInterest(
                        5000,
                        5,
                        2
                );

        assertEquals(
                500,
                interest,
                0.01
        );
    }
}
