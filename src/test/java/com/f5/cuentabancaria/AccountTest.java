package com.f5.cuentabancaria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {

    @Test
    void constructorShouldInitializeBalanceAndInterestRate() {
        Account account = new Account(1000f, 5f);

        assertEquals(1000f, account.balance);
        assertEquals(5f, account.annualInterestRate);
    }

    @Test
    void depositShouldIncreaseBalanceAndDepositCount() {
        Account account = new Account(1000f, 5f);

        account.deposit(500f);

        assertEquals(1500f, account.balance);
        assertEquals(1, account.depositCount);
    }

    @Test
    void withdrawShouldDecreaseBalanceAndWithdrawalCountWhenAmountIsValid() {
        Account account = new Account(1000f, 5f);

        account.withdraw(300f);

        assertEquals(700f, account.balance);
        assertEquals(1, account.withdrawalCount);
    }

    @Test
    void withdrawShouldNotChangeBalanceWhenAmountExceedsBalance() {
        Account account = new Account(1000f, 5f);

        account.withdraw(1500f);

        assertEquals(1000f, account.balance);
        assertEquals(0, account.withdrawalCount);
    }

    @Test
    void calculateInterestShouldAddMonthlyInterestToBalance() {
        Account account = new Account(12000f, 12f);

        account.calculateInterest();

        assertEquals(12120f, account.balance);
    }

}