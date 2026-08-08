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

}