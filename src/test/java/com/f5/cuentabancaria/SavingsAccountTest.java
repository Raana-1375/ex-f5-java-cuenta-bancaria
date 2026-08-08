package com.f5.cuentabancaria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SavingsAccountTest {

    @Test
    void constructorShouldSetActiveTrueWhenBalanceIsAtOrAboveThreshold() {
        SavingsAccount account = new SavingsAccount(10000f, 5f);

        assertTrue(account.active);
    }

    @Test
    void constructorShouldSetActiveFalseWhenBalanceIsBelowThreshold() {
        SavingsAccount account = new SavingsAccount(9999f, 5f);

        assertFalse(account.active);
    }

    @Test
    void depositShouldIncreaseBalanceWhenAccountIsActive() {
        SavingsAccount account = new SavingsAccount(10000f, 5f);

        account.deposit(500f);

        assertEquals(10500f, account.balance);
    }

    @Test
    void depositShouldNotChangeBalanceWhenAccountIsInactive() {
        SavingsAccount account = new SavingsAccount(5000f, 5f);

        account.deposit(500f);

        assertEquals(5000f, account.balance);
    }

    @Test
    void withdrawShouldDecreaseBalanceWhenAccountIsActive() {
        SavingsAccount account = new SavingsAccount(10000f, 5f);

        account.withdraw(500f);

        assertEquals(9500f, account.balance);
    }

    @Test
    void withdrawShouldNotChangeBalanceWhenAccountIsInactive() {
        SavingsAccount account = new SavingsAccount(5000f, 5f);

        account.withdraw(500f);

        assertEquals(5000f, account.balance);
    }

    @Test
    void generateMonthlyStatementShouldNotChargeFeeWhenWithdrawalCountIsFourOrLess() {
        SavingsAccount account = new SavingsAccount(20000f, 12f);
        account.withdraw(100f);
        account.withdraw(100f);
        account.withdraw(100f);
        account.withdraw(100f);

        account.generateMonthlyStatement();

        assertEquals(0f, account.monthlyFee);
        assertEquals(19796f, account.balance);
    }

    @Test
    void generateMonthlyStatementShouldChargeFeeWhenWithdrawalCountExceedsFour() {
        SavingsAccount account = new SavingsAccount(20000f, 12f);
        account.withdraw(100f);
        account.withdraw(100f);
        account.withdraw(100f);
        account.withdraw(100f);
        account.withdraw(100f);
        account.withdraw(100f);

        account.generateMonthlyStatement();

        assertEquals(2000f, account.monthlyFee);
        assertEquals(17574f, account.balance);
    }

}