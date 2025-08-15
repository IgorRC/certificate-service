package com.gnius.code.certificate_service.infraestructure.adapter.out.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


/**
 * Spring Data JPA repository for managing {@link EmployeeJpaEntity} persistence.
 * <p>
 * This repository extends {@link JpaRepository} to provide standard CRUD operations
 * and defines custom query methods for accessing employee data in the database.
 * </p>
 *
 * <p><b>Context:</b> Part of the infrastructure layer, this interface acts as the
 * JPA adapter implementation for the outbound port related to employee persistence
 * in the Hexagonal Architecture.</p>
 *
 * <p>Typical usage includes persisting new employee records, updating existing ones,
 * and retrieving employees associated with a specific company.</p>
 *
 * @author Igor Ramos Cruzado
 * @since 1.0
 * @version 1.0
 */
public interface EmployeeJpaRepository extends JpaRepository<EmployeeJpaEntity, Long> {

    /**
     * Finds all employees belonging to a given company.
     *
     * @param companyId the unique identifier of the company
     * @return a list of {@link EmployeeJpaEntity} associated with the given company ID
     */
    List<EmployeeJpaEntity> findByCompanyId(Long companyId);
}
