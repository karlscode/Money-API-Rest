package com.karlscode.algamoneyapi.repository.accountingentry;

import com.karlscode.algamoneyapi.model.AccountingEntry;
import com.karlscode.algamoneyapi.repository.filter.AccountingEntryFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AccountingEntryRepositoryQuery {

	public Page<AccountingEntry> filter(AccountingEntryFilter accountingEntryFilter, Pageable pageable);
}
