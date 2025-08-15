package com.gnius.code.certificate_service.infraestructure.adapter.out.jpa;

import com.gnius.code.certificate_service.domain.model.Company;
import com.gnius.code.certificate_service.domain.port.out.CompanyRepositoryPort;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * JPA adapter implementing {@link com.gnius.code.certificate_service.domain.port.out.CompanyRepositoryPort}.
 *
 * <p>Secondary adapter (outbound) that maps between domain models and JPA entities
 * and delegates persistence to {@code CompanyJpaRepository}.</p>
 *
 * @implSpec Mapping MUST remain lossless. Keep conversion logic deterministic and
 * avoid embedding business rules here.
 *
 * @author igor ramos cruzado
 * @since 1.0
 * @version 1.0
 */

@Component
public class CompanyJpaAdapter implements CompanyRepositoryPort {


    private final CompanyJpaRepository companyJpaRepository;

    public CompanyJpaAdapter(CompanyJpaRepository companyJpaRepository) {
        this.companyJpaRepository = companyJpaRepository;
    }

    @Override
    public Company save(Company company) {
        return companyJpaRepository.save(CompanyJpaEntity.fromDomain(company)).toDomain();
    }

    @Override
    public Optional<Company> findbyId(Long id) {
        return companyJpaRepository.findById(id).map(CompanyJpaEntity::toDomain);
    }

    @Override
    public Optional<Company> findByTaxId(String taxId) {
        return companyJpaRepository.findByTaxId(taxId).map(CompanyJpaEntity::toDomain);
    }

    @Override
    public List<Company> findAll() {
        return companyJpaRepository.findAll().stream().map(CompanyJpaEntity::toDomain).collect(Collectors.toList());
    }
}
