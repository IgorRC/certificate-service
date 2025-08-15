package com.gnius.code.certificate_service.usecase;

import com.gnius.code.certificate_service.application.usecase.RegisterCompanyService;
import com.gnius.code.certificate_service.domain.model.Company;
import com.gnius.code.certificate_service.domain.port.out.CompanyRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDateTime;
import static org.mockito.Mockito.*;

/**
 * Unit test for {@link RegisterCompanyService}.
 *
 * <p>Verifies that a new company can be registered correctly and that the expected
 * interaction with {@link CompanyRepositoryPort} occurs.</p>
 *
 * @author igor ramos cruzado
 * @since 1.0
 */
public class RegisterCompanyServiceTest {
    private CompanyRepositoryPort companyRepositoryPort;
    private RegisterCompanyService registerCompanyService;

    @BeforeEach
    public void setUp() {
        companyRepositoryPort = mock(CompanyRepositoryPort.class);
        registerCompanyService = new RegisterCompanyService(companyRepositoryPort);
    }

    /**
     * Should successfully register a company and return the saved instance.
     *
     * <p>Verifies that the correct values are passed to {@link CompanyRepositoryPort#save(Company)},
     * and that the service returns the expected {@link Company} object.</p>
     */
    @Test
    void shouldRegisterCompany() {
        String name = "Tech Innovators Inc.";
        String taxId = "TAX00112233";
        String contactEmail = "admin@techinnovators.com";

        Company saveCompany = new Company(1L,name,taxId ,contactEmail, true, LocalDateTime.now());
        when(companyRepositoryPort.save(any(Company.class))).thenReturn(saveCompany);

        Company result = registerCompanyService.registerCompany(name,taxId,contactEmail);
        ArgumentCaptor<Company> captor = ArgumentCaptor.forClass(Company.class);
        verify(companyRepositoryPort).save(captor.capture());

        Company capturedCompany = captor.getValue();
        assertThat(capturedCompany.getName()).isEqualTo(name);
        assertThat(capturedCompany.getTaxId()).isEqualTo(taxId);
        assertThat(capturedCompany.getContactEmail()).isEqualTo(contactEmail);
        assertThat(result).isEqualTo(saveCompany);
    }
}
