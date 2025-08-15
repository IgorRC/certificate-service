package com.gnius.code.certificate_service.domain.model;

import lombok.*;
import java.time.LocalDateTime;

/**
 * Domain model representing a tenant company within the certificate system.
 *
 * <p>This type is part of the domain layer and MUST remain framework-agnostic.
 * Do not add persistence or web annotations here.</p>
 *
 * @apiNote In a multi-tenant design, {@code Company} acts as the ownership boundary
 * for employees and certificates. Keep invariants (e.g., unique {@code taxId}) enforced
 * by use cases and persistence adapters.
 *
 * @author igor ramos cruzado
 * @since 1.0
 * @version 1.0
 */
public class Company {
    private Long id;
    private String name;
    private String taxId;
    private String contactEmail;
    private boolean active;
    private LocalDateTime registrationDate;

    public Company() {
    }

    public Company(Long id, String name, String taxId, String contactEmail) {
        this.id = id;
        this.name = name;
        this.taxId = taxId;
        this.contactEmail = contactEmail;
    }

    public Company(Long id, String name, String taxId, String contactEmail, boolean active, LocalDateTime registrationDate) {
        this.id = id;
        this.name = name;
        this.taxId = taxId;
        this.contactEmail = contactEmail;
        this.active = active;
        this.registrationDate = registrationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }
}


