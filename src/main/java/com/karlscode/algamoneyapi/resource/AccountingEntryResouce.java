package com.karlscode.algamoneyapi.resource;

import com.karlscode.algamoneyapi.event.ResourceCreateEvent;
import com.karlscode.algamoneyapi.model.AccountingEntry;
import com.karlscode.algamoneyapi.repository.filter.AccountingEntryFilter;
import com.karlscode.algamoneyapi.service.AccountingEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/entries")
public class AccountingEntryResouce {

	@Autowired
	AccountingEntryService accountingEntryService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public Page<AccountingEntry> find(AccountingEntryFilter accountingEntryFilter, Pageable pageable) {
		return accountingEntryService.filter(accountingEntryFilter, pageable);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AccountingEntry> findById(@PathVariable Long id) {
		AccountingEntry accountingEntry = accountingEntryService.getById(id);
		return ResponseEntity.ok(accountingEntry);
	}
	
	@PostMapping
	public ResponseEntity<AccountingEntry> saveAccountingEntry(@Valid @RequestBody AccountingEntry accountingEntry, HttpServletResponse response) {
		AccountingEntry saveAccountingEntry = accountingEntryService.save(accountingEntry);
		publisher.publishEvent(new ResourceCreateEvent(this, response, saveAccountingEntry.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(saveAccountingEntry);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AccountingEntry> updateAccountingEntry(@PathVariable Long id, @Valid @RequestBody AccountingEntry accountingEntry) {
		AccountingEntry update = accountingEntryService.update(id, accountingEntry);
		return ResponseEntity.accepted().body(update);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		accountingEntryService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
