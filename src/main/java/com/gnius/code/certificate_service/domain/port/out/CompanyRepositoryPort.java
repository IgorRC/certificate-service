package com.gnius.code.certificate_service.domain.port.out;

import com.gnius.code.certificate_service.domain.model.Company;
import java.util.List;
import java.util.Optional;

/**
 * Outbound port for persisting and querying {@link Company} entities.
 * <p>
 * This port defines the operations required to store, update, and retrieve
 * company information in the Certificate Management System.
 * Implementations (e.g., JPA, JDBC) will provide the specific persistence logic.
 * </p>
 *
 * <p><b>Context:</b> Hexagonal Architecture (Clean Architecture).</p>
 *
 * @author igor ramos cruzado
 * @since 1.0
 * @version 1.0
 */
public interface CompanyRepositoryPort {

    /**
     * Saves or updates a {@link Company} instance.
     *
     * @param company the company entity to be saved or updated
     * @return the persisted {@link Company} entity
     */
    Company save(Company company);

    /**
     * Finds a company by its unique identifier.
     *
     * @param id the unique identifier of the company
     * @return an {@link Optional} containing the company if found, otherwise empty
     */
    Optional<Company> findbyId(Long id);

    /**
     * Finds a company by its tax identification number (Tax ID).
     *
     * @param taxId the tax identification number of the company
     * @return an {@link Optional} containing the company if found, otherwise empty
     */
    Optional<Company> findByTaxId(String taxId);

    /**
     * Retrieves all registered companies.
     *
     * @return a list of {@link Company} entities
     */
    List<Company> findAll();
}
