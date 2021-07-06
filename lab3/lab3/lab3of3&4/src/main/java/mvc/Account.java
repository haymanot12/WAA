package mvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account {
    private String accountNumber;
    private String accountHolder;
    public List<String> history;
    private double balance;

    public Account(String accountNumber, String accountHolder, double balance) {
        this.history=new ArrayList<>();
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance=balance;
    }
    public void deposit(double amount) {
        this.balance+= amount;
        history.add("Deposit amount"+amount+new Date());
    }
    public void withdraw(double amount) {

        this.balance-= amount;
        history.add("Withdraw amount"+amount+new Date());
    }

}
