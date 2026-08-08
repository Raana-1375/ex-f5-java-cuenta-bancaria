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

}