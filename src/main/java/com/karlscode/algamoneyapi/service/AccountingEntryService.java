package com.karlscode.algamoneyapi.service;

import com.karlscode.algamoneyapi.model.AccountingEntry;
import com.karlscode.algamoneyapi.model.Person;
import com.karlscode.algamoneyapi.repository.AccountingEntryRepository;
import com.karlscode.algamoneyapi.repository.filter.AccountingEntryFilter;
import com.karlscode.algamoneyapi.service.exception.PersonInactiveOrNonexistentException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AccountingEntryService {

	@Autowired
	private AccountingEntryRepository accountingEntryRepository;
	
	@Autowired
	private PersonService personService;

	public Page<AccountingEntry> filter(AccountingEntryFilter accountingEntryFilter, Pageable pageable) {
		return accountingEntryRepository.filter(accountingEntryFilter, pageable);
	}
	
	public AccountingEntry getById(Long id) {
		return findAccountingEntryById(id);
	}
	
	/**
	 * Verify person is active for save.
	 * @param accountingEntry
	 * @return accounting entry save.
	 */
	public AccountingEntry save(AccountingEntry accountingEntry) {
		Person person = personService.findPersonById(accountingEntry.getPersonId());
		if (person.isInactive() || person == null) {
			throw new PersonInactiveOrNonexistentException();
		}
		return accountingEntryRepository.save(accountingEntry);
	}
	
	public AccountingEntry update(Long id, AccountingEntry accountingEntry) {
		AccountingEntry saveAccountingEntry = findAccountingEntryById(id);

		BeanUtils.copyProperties(accountingEntry, saveAccountingEntry, "id");
		return accountingEntryRepository.save(saveAccountingEntry); 
	}
	
	public void delete(Long id) {
		findAccountingEntryById(id);
		accountingEntryRepository.deleteById(id);
	}
	
	private AccountingEntry findAccountingEntryById(Long id) {
		return accountingEntryRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
	}
	
}
