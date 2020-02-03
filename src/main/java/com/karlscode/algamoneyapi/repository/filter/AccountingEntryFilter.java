package com.karlscode.algamoneyapi.repository.filter;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class AccountingEntryFilter {

	private String description;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateDueOf;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateDueUpTo;
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public LocalDate getDateDueOf() {
		return dateDueOf;
	}
	
	public void setDateDueOf(LocalDate dateDueOf) {
		this.dateDueOf = dateDueOf;
	}
	
	public LocalDate getDateDueUpTo() {
		return dateDueUpTo;
	}
	
	public void setDateDueUpTo(LocalDate dateDueUpTo) {
		this.dateDueUpTo = dateDueUpTo;
	}
	
	
}
