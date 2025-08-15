package com.gnius.code.certificate_service.infraestructure.adapter.out.jpa;

import com.gnius.code.certificate_service.domain.model.Company;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

/**
 * JPA entity representing the "companies" table in the database.
 * <p>
 * This entity is part of the infrastructure layer and is responsible
 * for mapping the {@link Company} domain model to a persistent
 * database representation using JPA annotations.
 * </p>
 *
 * <p><b>Context:</b> Infrastructure layer - JPA adapter for company persistence
 * in the Hexagonal Architecture.</p>
 *
 * <p>It includes utility methods to convert between the domain model
 * and the JPA entity representation.</p>
 *
 * @see Company
 * @since 1.0
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "companies")
public class CompanyJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String taxId;
    private String contactEmail;
    private boolean active;
    private LocalDateTime registrationDate;

    /**
     * Creates a {@link CompanyJpaEntity} from a {@link Company} domain model.
     *
     * @param company the domain model instance
     * @return a new {@link CompanyJpaEntity} representing the same data
     */
    public static CompanyJpaEntity fromDomain(Company company) {
        CompanyJpaEntity entity = new CompanyJpaEntity();
        entity.id = company.getId();
        entity.name = company.getName();
        entity.taxId = company.getTaxId();
        entity.contactEmail = company.getContactEmail();
        entity.active = company.isActive();
        entity.registrationDate = company.getRegistrationDate();
        return entity;
    }

    /**
     * Converts this JPA entity to its corresponding {@link Company} domain model.
     *
     * @return the {@link Company} domain model instance
     */
    public Company toDomain() {
        return new Company(
                id,
                name,
                taxId,
                contactEmail,
                active,
                registrationDate
        );
    }
}
