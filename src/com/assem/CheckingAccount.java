package com.assem;

import java.io.Serializable;

public class CheckingAccount implements BankMethods, Serializable {
    private int transCount;
    private static final int FREETRANS=5;
    private static final int TRANSFREE=3;
    private double balance;
    private int accountNum;

    public CheckingAccount(int accountNum,double balance) {
        this.balance = balance;
        this.accountNum=accountNum;
        transCount=0;
    }

    @Override
    public void deposit(double amount) {
        if(amount<0)throw new IllegalArgumentException("No negative amount allowed!");
        transCount++;
        balance+=amount;
    }

    @Override
    public void withdraw(double amount) {
        if(amount>getBalance())throw  new IllegalArgumentException("Insufficient balance");
        transCount++;
        balance-=amount;

    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public double getAccountNumber() {
        return accountNum;
    }
    public void deductFees(){
        if(transCount>FREETRANS){
            double fees=TRANSFREE*(transCount-FREETRANS);
            withdraw(fees);
            transCount=0;
        }
    }
}
