package com.mro.quotation.quote;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * An interface for the QuoteRepository. Extends JpaRepository, which contains necessary functionality
 * for Spring Boot / Hibernate to perform database transactions.
 *
 * @author Chris Durnan
 */
public interface QuoteRepository extends JpaRepository<Quote, Long> {
}
