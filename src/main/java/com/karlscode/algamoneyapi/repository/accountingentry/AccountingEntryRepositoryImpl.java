package com.karlscode.algamoneyapi.repository.accountingentry;

import com.karlscode.algamoneyapi.model.AccountingEntry;
import com.karlscode.algamoneyapi.model.AccountingEntry_;
import com.karlscode.algamoneyapi.repository.filter.AccountingEntryFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class AccountingEntryRepositoryImpl implements AccountingEntryRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Page<AccountingEntry> filter(AccountingEntryFilter accountingEntryFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<AccountingEntry> criteria = builder.createQuery(AccountingEntry.class);
		Root<AccountingEntry> root = criteria.from(AccountingEntry.class);
		
		Predicate[] predicates = createRestrictions(accountingEntryFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<AccountingEntry> query = manager.createQuery(criteria);
		addPagingRestrictions(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(accountingEntryFilter));
	}

	private Predicate[] createRestrictions(AccountingEntryFilter accountingEntryFilter, CriteriaBuilder builder,
			Root<AccountingEntry> root) {
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		if (!StringUtils.isEmpty(accountingEntryFilter.getDescription())) {
			predicates.add(
					builder.like(
							builder.lower(root.get(AccountingEntry_.description)), "%" + accountingEntryFilter.getDescription().toLowerCase() + "%")
					);
		}
		
		if (accountingEntryFilter.getDateDueOf() != null) {
			predicates.add(
					builder.greaterThanOrEqualTo(root.get(AccountingEntry_.dueDate), accountingEntryFilter.getDateDueOf())
					);
		}
		
		if (accountingEntryFilter.getDateDueUpTo() != null) {
			predicates.add(
					builder.lessThanOrEqualTo(root.get(AccountingEntry_.dueDate), accountingEntryFilter.getDateDueUpTo())
					);
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}

	private void addPagingRestrictions(TypedQuery<AccountingEntry> query, Pageable pageable) {
		int currentPage = pageable.getPageNumber();
		int totalRecordsPerPage = pageable.getPageSize();
		int firstPageRegistration = currentPage * totalRecordsPerPage;
		
		query.setFirstResult(firstPageRegistration);
		query.setMaxResults(totalRecordsPerPage);
	}
	
	private Long total(AccountingEntryFilter accountingEntryFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<AccountingEntry> root = criteria.from(AccountingEntry.class);
		
		Predicate[] predicates = createRestrictions(accountingEntryFilter, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}
}
