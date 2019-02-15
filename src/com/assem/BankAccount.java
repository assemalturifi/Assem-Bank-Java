package com.assem;

import java.io.Serializable;

public class BankAccount implements Serializable {
    private int accountNumber;
    private int pin;

    public BankAccount(int accountNumber, int pin) {
        this.accountNumber = accountNumber;
        this.pin = pin;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public int getPin() {
        return pin;
    }
}