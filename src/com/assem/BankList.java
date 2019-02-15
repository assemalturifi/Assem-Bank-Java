package com.assem;

import java.io.Serializable;
import java.util.ArrayList;

public class BankList implements Serializable {
    private ArrayList <SavingAccount>savingsArray;
    private ArrayList <CheckingAccount>checkingsArray;
    private ArrayList <BankAccount>bankAccountsArray;

    public BankList() {
        this.savingsArray = new ArrayList<SavingAccount>();
        this.checkingsArray = new ArrayList<CheckingAccount>();
        this.bankAccountsArray = new ArrayList<BankAccount>();
    }
    public void addSavingAccount(SavingAccount a){
        savingsArray.add(a);
    }
    public void addCheckingAccount(CheckingAccount a){
        checkingsArray.add(a);
    }
    public void addAccount(BankAccount account){
        bankAccountsArray.add(account);
    }
    public SavingAccount findSavings(int accountNum){
        for(int i=0;i<savingsArray.size();i++){
            SavingAccount found=savingsArray.get(i);
            if(found.getAccountNumber()==accountNum){
                return found;
            }

        }
        return null;

    }
    public CheckingAccount findChecking(int accountNum){
        for(int i=0;i<checkingsArray.size();i++){
            CheckingAccount a=  checkingsArray.get(i);
            if (a.getAccountNumber()== accountNum)
                return a;
        }
        return null;
    }
    public BankAccount findBankAccount(int accountNum){
        for(int i=0;i<bankAccountsArray.size();i++){
            BankAccount a=  bankAccountsArray.get(i);
            if (a.getAccountNumber()== accountNum)
                return a;
        }
        return null;
    }

    public ArrayList<SavingAccount> getSavingsArray() {
        return savingsArray;
    }

    public ArrayList<CheckingAccount> getCheckingsArray() {
        return checkingsArray;
    }

    public ArrayList<BankAccount> getBankAccountsArray() {
        return bankAccountsArray;
    }
}