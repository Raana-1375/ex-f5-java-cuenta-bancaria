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

}
