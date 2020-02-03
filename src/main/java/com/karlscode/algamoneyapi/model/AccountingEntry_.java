package com.karlscode.algamoneyapi.model;

import com.karlscode.algamoneyapi.model.enums.TypeAccountingEntry;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.math.BigDecimal;
import java.time.LocalDate;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AccountingEntry.class)
public abstract class AccountingEntry_ {

	public static volatile SingularAttribute<AccountingEntry, String> note;
	public static volatile SingularAttribute<AccountingEntry, BigDecimal> amount;
	public static volatile SingularAttribute<AccountingEntry, Person> person;
	public static volatile SingularAttribute<AccountingEntry, LocalDate> dueDate;
	public static volatile SingularAttribute<AccountingEntry, String> description;
	public static volatile SingularAttribute<AccountingEntry, LocalDate> payDay;
	public static volatile SingularAttribute<AccountingEntry, Long> id;
	public static volatile SingularAttribute<AccountingEntry, TypeAccountingEntry> type;
	public static volatile SingularAttribute<AccountingEntry, Category> category;

}

