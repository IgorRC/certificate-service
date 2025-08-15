package com.gnius.code.certificate_service.domain.port.in;

import com.gnius.code.certificate_service.domain.model.Company;

/**
 * Use case for registering a new company in the system.
 *
 * <p>Defines the application boundary for company onboarding. Implementations
 * must ensure business invariants (e.g., unique taxId).</p>
 *
 * @author igor ramos cruzado
 * @since 1.0
 * @version 1.0
 */
public interface RegisterCompanyUseCase {
    /**
     * Registers a new company.
     *
     * @param name         non-null company legal/commercial name
     * @param taxId        non-null unique tax identifier (per jurisdiction)
     * @param contactEmail non-null contact email for notifications/admin access
     * @return the persisted {@code Company} instance
     * @throws IllegalArgumentException if parameters are invalid
     * @implNote Implementations should check uniqueness of {@code taxId}.
     */
    Company registerCompany(String name, String taxId, String contactEmail);
}
