package com.gnius.code.certificate_service.domain.model;

import java.time.LocalDate;
/**
 * Domain model representing an employee that can receive certificates.
 *
 * <p>Belongs to a {@code Company} via {@code companyId}. This type carries
 * only business data; validation and persistence concerns live elsewhere.</p>
 *
 * @apiNote Email uniqueness is typically scoped per company and should be
 * enforced at the application/persistence layers.
 *
 * @author igor ramos cruzado
 * @since 1.0
 * @version 1.0
 */
public class Employee {
    private Long id;
    private String firstName;
    private String lastName;
    Long companyId;
    private String email;
    private LocalDate dateOfBirth;
    private boolean active;

    public Employee() {}

    public Employee(Long id, Long companyId, String firstName, String lastName, String email, LocalDate dateOfBirth, boolean active) {
        this.id = id;
        this.companyId = companyId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.active = active;
    }

    public Employee(Object o, Long companyId, String firstName, String lastName, String email, LocalDate dateOfBirth) {
        this.companyId = companyId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.active = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
