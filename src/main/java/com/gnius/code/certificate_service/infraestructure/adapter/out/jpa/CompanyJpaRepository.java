package com.gnius.code.certificate_service.infraestructure.adapter.out.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

/**
 * Spring Data JPA repository for managing {@link CompanyJpaEntity} persistence.
 * <p>
 * This repository extends {@link JpaRepository} to provide standard CRUD operations
 * and defines custom query methods for accessing company data in the database.
 * </p>
 *
 * <p><b>Context:</b> Part of the infrastructure layer, this interface acts as the
 * JPA adapter implementation for the outbound port
 * {@link com.gnius.code.certificate_service.domain.port.out.CompanyRepositoryPort}
 * in the Hexagonal Architecture.</p>
 *
 * <p>Typical usage includes persisting new company records, updating existing ones,
 * and retrieving companies by their identifiers or tax identification numbers.</p>
 *
 * @author Igor Ramos Cruzado
 * @since 1.0
 * @version 1.0
 */
public interface CompanyJpaRepository extends JpaRepository<CompanyJpaEntity, Long> {

    /**
     * Finds a company entity by its tax identification number (Tax ID).
     *
     * @param taxId the unique tax identification number of the company
     * @return an {@link Optional} containing the matching {@link CompanyJpaEntity}
     *         if found, otherwise empty
     */
    Optional<CompanyJpaEntity> findByTaxId(String taxId);
}
