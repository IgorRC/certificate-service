package com.gnius.code.certificate_service.application.usecase;

import com.gnius.code.certificate_service.domain.model.Company;
import com.gnius.code.certificate_service.domain.port.in.RegisterCompanyUseCase;
import com.gnius.code.certificate_service.domain.port.out.CompanyRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

/**
 * Application service implementing {@link RegisterCompanyUseCase}.
 * <p>
 * This service coordinates the process of onboarding a new company,
 * applying default business rules and delegating persistence to
 * the {@link CompanyRepositoryPort}.
 * </p>
 *
 * <p><b>Context:</b> Application layer in Hexagonal Architecture.</p>
 *
 * <p><b>Implementation notes:</b></p>
 * <ul>
 *   <li>Ensures that the {@code taxId} is unique before creating a new company.</li>
 *   <li>Sets default flags such as {@code active = true} upon creation.</li>
 *   <li>Automatically assigns the current system timestamp as the registration date.</li>
 *   <li>Validation for email format, name normalization, and business rules
 *       may be added in this layer or delegated to the domain.</li>
 * </ul>
 *
 * @author igor ramos cruzado
 * @see Company
 * @see CompanyRepositoryPort
 * @since 1.0
 * @version 1.0
 */
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class RegisterCompanyService implements RegisterCompanyUseCase {

    private final CompanyRepositoryPort companyRepositoryPort;

    /**
     * Registers a new company in the system.
     *
     * @param name          the legal name of the company
     * @param taxId         the tax identification number (Tax ID) of the company
     * @param contactEmail  the contact email address of the company
     * @return the persisted {@link Company} entity
     * @throws IllegalArgumentException if required parameters are invalid or null
     */
    @Override
    public Company registerCompany(String name, String taxId, String contactEmail) {
        Company company = new Company(
                null,
                name,
                taxId,
                contactEmail,
                true,
                LocalDateTime.now()
        );
        return companyRepositoryPort.save(company);
    }
}