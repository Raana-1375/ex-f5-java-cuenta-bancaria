package com.f5.cuentabancaria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckingAccountTest {

    @Test
    void constructorShouldInitializeBalanceAndInterestRate() {
        CheckingAccount account = new CheckingAccount(1000f, 5f);

        assertEquals(1000f, account.balance);
        assertEquals(5f, account.annualInterestRate);
    }

    @Test
    void withdrawShouldDecreaseBalanceWhenAmountIsWithinBalance() {
        CheckingAccount account = new CheckingAccount(1000f, 5f);

        account.withdraw(300f);

        assertEquals(700f, account.balance);
        assertEquals(0f, account.overdraft);
    }

    @Test
    void withdrawShouldCreateOverdraftWhenAmountExceedsBalance() {
        CheckingAccount account = new CheckingAccount(500f, 5f);

        account.withdraw(800f);

        assertEquals(0f, account.balance);
        assertEquals(300f, account.overdraft);
    }

    @Test
    void withdrawShouldAccumulateOverdraftAcrossMultipleWithdrawals() {
        CheckingAccount account = new CheckingAccount(500f, 5f);
        account.withdraw(800f);

        account.withdraw(200f);

        assertEquals(0f, account.balance);
        assertEquals(500f, account.overdraft);
    }

    @Test
    void depositShouldIncreaseBalanceWhenThereIsNoOverdraft() {
        CheckingAccount account = new CheckingAccount(1000f, 5f);

        account.deposit(500f);

        assertEquals(1500f, account.balance);
        assertEquals(0f, account.overdraft);
    }

    @Test
    void depositShouldFullyRepayOverdraftAndAddRemainderToBalance() {
        CheckingAccount account = new CheckingAccount(500f, 5f);
        account.withdraw(800f);

        account.deposit(500f);

        assertEquals(200f, account.balance);
        assertEquals(0f, account.overdraft);
    }

    @Test
    void depositShouldPartiallyRepayOverdraftWhenAmountIsSmallerThanDebt() {
        CheckingAccount account = new CheckingAccount(500f, 5f);
        account.withdraw(800f);

        account.deposit(100f);

        assertEquals(0f, account.balance);
        assertEquals(200f, account.overdraft);
    }

}
