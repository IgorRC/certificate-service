package com.gnius.code.certificate_service.infraestructure.adapter.out.jpa;

import com.gnius.code.certificate_service.domain.model.Employee;
import com.gnius.code.certificate_service.domain.port.out.EmployeeRepositoryPort;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

/**
 * JPA adapter implementing {@link com.gnius.code.certificate_service.domain.port.out.EmployeeRepositoryPort}.
 *
 * <p>Handles mapping between {@code Employee} domain objects and {@code EmployeeJpaEntity}
 * persistence entities.</p>
 *
 * @implSpec Prefer bulk operations in the repository for listing/filtering to avoid
 * loading excessive data in memory.
 *
 * @author igor ramos cruzado
 * @since 1.0
 * @version 1.0
 */

@Component
public class EmployeeJpaAdapter implements EmployeeRepositoryPort {


    private final EmployeeJpaRepository employeeJpaRepository;

    public EmployeeJpaAdapter(EmployeeJpaRepository employeeJpaRepository) {
        this.employeeJpaRepository = employeeJpaRepository;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeJpaRepository.save(EmployeeJpaEntity.fromDomain(employee)).toDomain();
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return employeeJpaRepository.findById(id).map(EmployeeJpaEntity::toDomain);
    }

    @Override
    public List<Employee> findByCompanyId(Long companyId) {
        return employeeJpaRepository.findByCompanyId(companyId).stream().map(EmployeeJpaEntity::toDomain).toList();
    }
}
