package bank.domain;

import bank.service.AccountEntryDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Document
public class Account {
	@Id
	private int accountnumber;
	private Collection<AccountEntry> entryList = new ArrayList<AccountEntry>();
	private String accountHolder;
	private float balance;

	public Account(int accountnumber, String accountHolder) {
		this.accountnumber = accountnumber;
		this.accountHolder = accountHolder;
	}

	public Account() {
	}

	public void addEntry(AccountEntry entry){
		entryList.add(entry);
	}
	public void computeBalance() {
		balance=0;
		for (AccountEntry entry : entryList) {
			balance+=entry.getAmount();
		}
	}
	public void deposit(float amount){
		AccountEntry entry = new AccountEntry(LocalDate.now(), amount, "deposit");
		entryList.add(entry);
		computeBalance();
	}
	public void withdraw(float amount){
		AccountEntry entry = new AccountEntry(LocalDate.now(), -amount, "withdraw");
		entryList.add(entry);
		computeBalance();
	}

	public int getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(int accountnumber) {
		this.accountnumber = accountnumber;
	}

	public Collection<AccountEntry> getEntryList() {
		return entryList;
	}

	public void setEntryList(Collection<AccountEntry> entryList) {
		this.entryList = entryList;
	}

	public String getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public float getBalance() {
		return balance;
	}
}
