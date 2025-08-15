package com.gnius.code.certificate_service.domain.port.out;

import com.gnius.code.certificate_service.domain.model.Employee;

import java.util.List;
import java.util.Optional;

/**
 * Outbound port for persisting and querying {@link com.gnius.code.certificate_service.domain.model.Employee}.
 *
 * <p>Implementations must map between domain and storage entities.</p>
 *
 * @author igor ramos cruzado
 * @since 1.0
 * @version 1.0
 */
public interface EmployeeRepositoryPort {
    /**
     * Persists a new employee or updates an existing one.
     *
     * @param employee non-null domain employee
     * @return the persisted {@link Employee} (including generated identifiers)
     * @throws IllegalArgumentException if {@code employee} is null
     */
    Employee save(Employee employee);

    /**
     * Finds an employee by identifier.
     *
     * @param id non-null employee identifier
     * @return an {@link Optional} with the employee if found; otherwise empty
     */
    Optional<Employee> findById(Long id);

    /**
     * Lists employees belonging to a company.
     *
     * <p>Implementations SHOULD return an immutable snapshot (or defensive copy).
     * Never return {@code null}; return an empty list instead.</p>
     *
     * @param companyId non-null company identifier
     * @return non-null list of employees (possibly empty)
     */
    List<Employee> findByCompanyId(Long companyId);
}
