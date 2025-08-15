package com.gnius.code.certificate_service.infraestructure.adapter.out.jpa;

import com.gnius.code.certificate_service.domain.model.Employee;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

/**
 * JPA entity representing the "employees" table in the database.
 * <p>
 * This entity is part of the infrastructure layer and is responsible
 * for mapping the {@link Employee} domain model to its persistent
 * database representation using JPA annotations.
 * </p>
 *
 * <p><b>Context:</b> Infrastructure layer - JPA adapter for employee persistence
 * in the Hexagonal Architecture.</p>
 *
 * <p>Includes utility methods to convert between the domain model and
 * the JPA entity representation.</p>
 *
 * @see Employee
 * @since 1.0
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "employees")
public class EmployeeJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long companyId;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate dateOfBirth;
    private boolean active;

    /**
     * Creates an {@link EmployeeJpaEntity} from an {@link Employee} domain model.
     *
     * @param employee the domain model instance
     * @return a new {@link EmployeeJpaEntity} representing the same data
     */
    public static EmployeeJpaEntity fromDomain(Employee employee) {
        EmployeeJpaEntity entity = new EmployeeJpaEntity();
        entity.id = employee.getId();
        entity.companyId = employee.getCompanyId();
        entity.firstName = employee.getFirstName();
        entity.lastName = employee.getLastName();
        entity.email = employee.getEmail();
        entity.dateOfBirth = employee.getDateOfBirth();
        entity.active = employee.isActive();
        return entity;
    }

    /**
     * Converts this JPA entity to its corresponding {@link Employee} domain model.
     *
     * @return the {@link Employee} domain model instance
     */
    public Employee toDomain() {
        return new Employee(
                id,
                companyId,
                firstName,
                lastName,
                email,
                dateOfBirth,
                active
        );
    }
}