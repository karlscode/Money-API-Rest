package com.karlscode.algamoneyapi.model;

import com.karlscode.algamoneyapi.model.enums.TypeAccountingEntry;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "accounting_entry")
public class AccountingEntry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 3, max = 50)
	private String description;
	
	@Column(name = "due_date")
	@NotNull
	@FutureOrPresent
	private LocalDate dueDate;
	
	@Column(name = "payday")
	@FutureOrPresent
	private LocalDate payDay;
	
	@NotNull
	@Digits(integer = 10, fraction = 2)
	private BigDecimal amount;
	
	@Size(max = 100)
	private String note;
	
	@Enumerated(EnumType.STRING)
	@NotNull
	private TypeAccountingEntry type;
	
	@ManyToOne
	@JoinColumn(name = "id_category")
	@NotNull
	private Category category;
	
	@ManyToOne
	@JoinColumn(name = "id_people")
	@NotNull
	private Person person;

	public AccountingEntry() {
	}

	public AccountingEntry(Long id, @NotNull @Size(min = 3, max = 50) String description,
			@NotNull @FutureOrPresent LocalDate dueDate, @FutureOrPresent LocalDate payDay,
			@NotNull @Digits(integer = 10, fraction = 2) BigDecimal amount, @Size(max = 100) String note,
			@NotNull TypeAccountingEntry type, @NotNull Category category, @NotNull Person person) {
		this.id = id;
		this.description = description;
		this.dueDate = dueDate;
		this.payDay = payDay;
		this.amount = amount;
		this.note = note;
		this.type = type;
		this.category = category;
		this.person = person;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public LocalDate getPayDay() {
		return payDay;
	}

	public void setPayDay(LocalDate payDay) {
		this.payDay = payDay;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public TypeAccountingEntry getType() {
		return type;
	}

	public void setType(TypeAccountingEntry type) {
		this.type = type;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Person getPerson() {
		return person;
	}

	/**
	 * It only returns the person's ID.
	 * @return Person id.
	 */
	public Long getPersonId() {
		return this.person.getId();
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountingEntry other = (AccountingEntry) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
