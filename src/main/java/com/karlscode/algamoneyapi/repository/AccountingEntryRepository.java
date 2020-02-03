package com.karlscode.algamoneyapi.repository;

import com.karlscode.algamoneyapi.model.AccountingEntry;
import com.karlscode.algamoneyapi.repository.accountingentry.AccountingEntryRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountingEntryRepository extends JpaRepository<AccountingEntry, Long>, AccountingEntryRepositoryQuery {

}
