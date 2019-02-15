package com.assem;

import java.io.Serializable;

public class SavingAccount implements BankMethods, Serializable {
    private double rate;
    private double balance;
    private int accountNumber;

    public SavingAccount(int accountNumber,double balance) {
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    @Override
    public void deposit(double amount) {
        if(amount < 0) throw new IllegalArgumentException("No negative amounts allowed");
        balance=balance+amount;

    }

    @Override
    public void withdraw(double amount) {
        if(amount > getBalance()) throw new IllegalArgumentException("Insufficient funds");
        balance=balance-amount;

    }
    public void addinterest(){
        double interest=rate*getAccountNumber()/100;
        deposit(interest);
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public double getAccountNumber() {
        return accountNumber;
    }
}
