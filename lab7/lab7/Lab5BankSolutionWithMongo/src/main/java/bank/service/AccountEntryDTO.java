package bank.service;

import java.time.LocalDate;
import java.util.Date;

public class AccountEntryDTO {
	private LocalDate date;
	private double amount;
	private String description;

	
	public AccountEntryDTO() {
	}

	public AccountEntryDTO(LocalDate date, double amount, String description) {
		this.date = date;
		this.amount = amount;
		this.description = description;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
