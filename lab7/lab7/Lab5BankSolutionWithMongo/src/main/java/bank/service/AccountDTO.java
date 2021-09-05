package bank.service;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class AccountDTO {
	private int accountnumber;
	private Collection<AccountEntryDTO> entryList = new ArrayList<AccountEntryDTO>();
	private String accountHolder;
	private float balance;

	public AccountDTO(int accountnumber, String accountHolder) {
		this.accountnumber = accountnumber;
		this.accountHolder = accountHolder;
	}

	public AccountDTO() {
	}

	public void addEntry(AccountEntryDTO entryDto){
		entryList.add(entryDto);
	}

	public int getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(int accountnumber) {
		this.accountnumber = accountnumber;
	}

	public Collection<AccountEntryDTO> getEntryList() {
		return entryList;
	}

	public void setEntryList(Collection<AccountEntryDTO> entryList) {
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
